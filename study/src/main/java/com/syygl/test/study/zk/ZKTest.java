package com.syygl.test.study.zk;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;

public class ZKTest {

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {

        //zk有session的概念   没有连接池的概念

        //
        //session超时时间
        //watch  观察  回调

        CountDownLatch countDownLatch = new CountDownLatch(1);


        ZooKeeper zooKeeper = new ZooKeeper("192.168.1.1:2181,192.168.1.1:2181",
                3000,
                new Watcher() {
                    //watch 的回调方法
                    @Override
                    public void process(WatchedEvent watchedEvent) {
                        Event.EventType type = watchedEvent.getType();
                        String path = watchedEvent.getPath();
                        Event.KeeperState state = watchedEvent.getState();

                        switch (state) {
                            case Unknown:
                                break;
                            case Disconnected:
                                break;
                            case NoSyncConnected:
                                break;
                            case SyncConnected:
                                //连接成功
                                countDownLatch.countDown();
                                break;
                            case AuthFailed:
                                break;
                            case ConnectedReadOnly:
                                break;
                            case SaslAuthenticated:
                                break;
                            case Expired:
                                break;
                        }

                        switch (type) {
                            case None:
                                break;
                            case NodeCreated:
                                break;
                            case NodeDeleted:
                                break;
                            case NodeDataChanged:
                                break;
                            case NodeChildrenChanged:
                                break;
                        }


                    }
                });

        countDownLatch.wait();
        ZooKeeper.States state = zooKeeper.getState();

        switch (state) {
            case CONNECTING:
                break;
            case ASSOCIATING:
                break;
            case CONNECTED:
                break;
            case CONNECTEDREADONLY:
                break;
            case CLOSED:
                break;
            case AUTH_FAILED:
                break;
            case NOT_CONNECTED:
                break;
        }



        zooKeeper.create("/syy","os".getBytes(StandardCharsets.UTF_8), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
    }



}
