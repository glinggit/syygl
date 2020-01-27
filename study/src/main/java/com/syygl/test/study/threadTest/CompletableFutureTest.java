package com.syygl.test.study.threadTest;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Created by sunyy on 2020/1/7.
 */
public class CompletableFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        testAnyofMethod();
    }


    public static void testCompletableFuture(){
        CompletableFuture.runAsync(new TestRun1());
        CompletableFuture.supplyAsync(new TestRun3());
    }

    public static void testAllofMethod() throws ExecutionException, InterruptedException {
        List<String> webPageLinks = Arrays.asList("a", "b");    // A list of 100 web page links

        List<CompletableFuture<String>> pageContentFutures = webPageLinks.stream()
                .map(webPageLink -> downloadWebPage(webPageLink))
                .collect(Collectors.toList());

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(
                pageContentFutures.toArray(new CompletableFuture[pageContentFutures.size()])
        );

        CompletableFuture<List<String>> allPageContentsFuture = allFutures.thenApply(v -> {
            return pageContentFutures.stream()
                    .map(pageContentFuture -> pageContentFuture.join())
                    .collect(Collectors.toList());
        });

        //花一些时间理解下以上代码片段。当所有future完成的时候，我们调用了future.join()，因此我们不会在任何地方阻塞。
        //join()方法和get()方法非常类似，这唯一不同的地方是如果最顶层的CompletableFuture完成的时候发生了异常，
        // 它会抛出一个未经检查的异常。

        CompletableFuture<Long> countFuture = allPageContentsFuture.thenApply(pageContents -> {
            return pageContents.stream()
                    .filter(pageContent -> pageContent.contains("CompletableFuture"))
                    .count();
        });

        System.out.println("Number of Web Pages having CompletableFuture keyword - " +
                countFuture.get());


    }

    public static CompletableFuture<String> downloadWebPage(String pageLink) {
        return CompletableFuture.supplyAsync(() -> {
            return "ok" + pageLink;
        });
    }



    public static void testAnyofMethod() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Result of Future 1";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return null;
        });

        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Result of Future 3";
        });

        CompletableFuture<Object> anyOfFuture = CompletableFuture.anyOf(future1, future2, future3);

        System.out.println(anyOfFuture.get()); // Result of Future 2
    }

    static class TestRun1 implements Runnable{
        @Override
        public void run() {

        }
    }

    class TestRun2 implements Callable<String> {
        @Override
        public String call() throws Exception {
            return null;
        }
    }

    static class TestRun3 implements Supplier<String> {
        @Override
        public String get() {
            return null;
        }
    }

}
