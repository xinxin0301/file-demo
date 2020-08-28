package com.file.util;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @ClassName WordUtil
 * @Description TODO 导出Word工具类
 * @Author zxx
 * @Version 1.0
 */
public class WordUtil {

    public static void main1(String[] args) throws FileNotFoundException {
        File file = ResourceUtils.getFile("classpath:template");
        File[] files = file.listFiles();
        for (File file1 : files) {
            System.out.println(file1);
        }
    }
}
