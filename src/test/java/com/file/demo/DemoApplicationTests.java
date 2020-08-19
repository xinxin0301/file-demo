package com.file.demo;

import com.file.demo.config.BeanUtil;
import com.file.demo.model.Demo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class DemoApplicationTests {

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
