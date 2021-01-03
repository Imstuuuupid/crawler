package com.xzx.crawler.service;

import com.xzx.crawler.entity.Process;

import java.util.List;

/**
 * 处理Process类中的一些属性
 * 例如提取出编号和子网站然后使用hits算法
 * @author xzx
 * @date 2021/01/04 02/25
 */
public interface ProcessHandler {

    /**
     * 遍历列表中的所有实例，找到他们的子节点，形成边
     * @author xzx
     * @date 2021/01/04 02:28
     * @param processList
     * @return void
     */
    List<Process> findEdges(List<Process> processList);


}
