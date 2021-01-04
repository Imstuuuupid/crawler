package com.xzx.crawler;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 杂七杂八的测试
 * @author xzx
 * @date 2021/01/03 17/34
 */
@SpringBootTest
public class Examples {

    @Test
    public void queuqTest(){
        BlockingQueue<String> queue = new LinkedBlockingQueue<String>();
        queue.add("a");
        System.out.println(queue.size());
        queue.add("b");
        queue.add("c");
        System.out.println(queue);
        Object o = queue.toArray()[1];
        System.out.println(o);
    }

    @Test
    public void collectionsTest(){
        Set<String> a = new HashSet<>();
        a.add("abc");
        a.add("bc");
        a.add("cdd");

        String str= "aaaabbbbdddccdddabc";
        for (String b : a ) {
            System.out.println(b);
            System.out.println(str.contains(b));
        }

    }


    @Test
    public void mapTest() {
        Map<String , Integer> map = new HashMap<>();
        map.put("a",1);
        map.put("b",2);
        map.put("a",2);
        System.out.println(map.toString());
    }
}
