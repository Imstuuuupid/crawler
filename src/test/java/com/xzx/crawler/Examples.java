package com.xzx.crawler;

import com.xzx.crawler.entity.Process;
import org.junit.Test;
import org.junit.platform.commons.util.CollectionUtils;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
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
    public void queuqTest() {
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
    public void collectionsTest() {
        Set<String> a = new HashSet<>();
        a.add("abc");
        a.add("bc");
        a.add("cdd");

        String str = "aaaabbbbdddccdddabc";
        for (String b : a) {
            System.out.println(b);
            System.out.println(str.contains(b));
        }

    }


    @Test
    public void mapTest() {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("a", 2);
        System.out.println(map.toString());
    }

    @Test
    public void compare() {
        Process a = new Process();
        a.setAuthority(12d);
        a.setTitle("aaa");

        Process b = new Process();
        b.setAuthority(20d);
        b.setTitle("bbb");

        Process c = new Process();
        c.setAuthority(30d);
        c.setTitle("ccc");

        List<Process> list = new ArrayList<>();
        list.add(b);
        list.add(c);
        list.add(a);

        list.stream().forEach(qq -> System.out.println(qq.getTitle()));

        System.out.println();
        list.sort(new Comparator<Process>() {
            @Override
            public int compare(Process o1, Process o2) {
                if (o1 != null && o2 != null) {
                    if (o1.getAuthority() > o2.getAuthority()) {
                        return 1;
                    } else return -1;
                }
                return 0;
            }

        });

        list.stream().forEach(qq -> System.out.println(qq.getTitle()));



    }
}
