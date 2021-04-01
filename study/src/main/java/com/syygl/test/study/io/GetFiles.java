package com.syygl.test.study.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GetFiles {

    static List<String> fileNameList = new ArrayList<String>();
    public static List<String> getAllFileNames(String filePath){
        File file = new File(filePath);
        File[] files = file.listFiles();
        for (File file1: files) {

            if(file1.isDirectory()){
                getAllFileNames(file1.getAbsolutePath());
            }else{
                fileNameList.add(file1.getAbsolutePath());
            }
        }
        return fileNameList;
    }

    public static void checkFile(String filePath) throws IOException {

        FileReader fileReader = new FileReader(filePath);

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String oneLine = "";

        while ((oneLine = bufferedReader.readLine()) != null){
            System.out.println(oneLine);
        }



    }






    public static void main(String[] args) {
        List<String> allFileNames = getAllFileNames("D:\\syygl");
        allFileNames.forEach(fileName ->{
            try {
                checkFile(fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

}
