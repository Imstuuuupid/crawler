package com.xzx.crawler.service;

import com.xzx.crawler.entity.Process;
import org.apache.commons.collections.CollectionUtils;
import org.assertj.core.util.Preconditions;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Process处理器的实现类
 * @author xzx
 * @date 2021/01/04 02/27
 */
@Service
public class ProcessHandlerImpl implements ProcessHandler {

    @Override
    public List<Process> findEdges(List<Process> processList) {
        List<Process> list = processList;
        Preconditions.checkArgument(CollectionUtils.isNotEmpty(list), "处理后的process列表为空");

//        获取url对应位置
        Map<String, Integer> urlNumberMap = list.stream()
                .collect(Collectors.toMap(Process::getUrl, Process::getCount, (a, b) -> b));

//        找到每一个网页子网页的位置，然后将他们与父网页连接形成边
        for (Process temp : list) {
            List<String> webs = temp.getWebs();
            List<Integer> nodes = new ArrayList<>();
            for (String web : webs) {
                if (urlNumberMap.containsKey(web)) {
                    nodes.add(urlNumberMap.get(web));
                } else {
                    continue;
                }
            }
            temp.setEdges(nodes);
        }

        return list;
    }
}
