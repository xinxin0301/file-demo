package com.file.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.file.demo.config.BeanUtil;
import com.file.demo.model.Demo;
import com.file.demo.util.ZipUtil;
import net.lingala.zip4j.exception.ZipException;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    /**
     * @Author zhang
     * @Description //TODO  解压加密ZIP，读取data.json文件
     * @Date 14:04 2020/8/24
     * @Param
     * @return void
     **/
    @Test
    void zip1() throws ZipException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        //读取加密zip
        File file = new File("C:\\Users\\D\\Desktop\\data.zip");
        //解压加密zip
        File[] unzip = ZipUtil.unzip(file, "C:\\uploadPath", "123");
        //获取解压地址
        /*File file1 = new File("C:\\uploadPath");
        File[] files = file1.listFiles();
        for (File file2 : files) {
            //获取JSON文件内容
            String json = FileUtils.readFileToString(file2);
            List list = objectMapper.readValue(json, List.class);
            System.out.println(list);
        }*/
        for (File file2 : unzip) {
            //获取JSON文件内容
            String json = FileUtils.readFileToString(file2);
            List list = objectMapper.readValue(json, List.class);
            System.out.println(list);
        }
    }
    //[{userName=张三, age=66, date=2020-08-04 13:46}, {userName=李四, age=77, date=2020-08-04 13:46}, {userName=王五, age=88, date=2020-08-04 13:46}]

    /**
     * @Author zhang
     * @Description //TODO 添加zip文件
     * @Date 15:01 2020/8/24
     * @return void
     **/
    @Test
    void zip2() throws Exception {
        //将C:\Users\D\Desktop\测试一层 目录里面的文件文件夹，压缩成zip 并加密
        ZipUtil.zip("C:\\Users\\D\\Desktop\\测试一层","C:\\Users\\D\\Desktop\\新建文件夹\\",true,"123");
    }







    @Test
    void test1() {
        //资源对象
        Demo source = new Demo("1", "2", null, new Date());

        //目标对象
        Demo target = new Demo("1", "2", 3, new Date());

        BeanUtils.copyProperties(
                source, target
        );
        System.out.println(target);
    }

    @Test
    void test2() {
        //资源对象
        Demo source = new Demo("1", "2", null, new Date());

        //目标对象
        Demo target = new Demo("1", "2", 3, new Date());

        BeanUtil.copyPropertiesIgnoreNull(source, target);
        System.out.println(target);
    }


    @Test
    void test3(){

    }

}
