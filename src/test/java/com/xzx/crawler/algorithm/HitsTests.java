package com.xzx.crawler.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xzx
 * @date 2021/01/03 16/51
 */
@Slf4j
@SpringBootTest
public class HitsTests {

    @Test
    public void hitTest() {
        Hits hits = new Hits(4);
        List<String> a = new ArrayList<>();
        a.add("a");
        a.add("b");
        a.add("c");
        a.add("d");
        hits.addVertex(a.toArray());
        hits.addEdge(1,2);
        hits.addEdge(1,0);
        hits.addEdge(0,1);
        hits.addEdge(2,1);
        hits.addEdge(3,1);
        hits.addEdge(3,2);
        hits.addEdge(3,0);
    }
}
