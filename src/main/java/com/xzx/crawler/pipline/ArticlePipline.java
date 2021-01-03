package com.xzx.crawler.pipline;

import com.xzx.crawler.entity.Process;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 保存数据到库
 * @author xzx
 * @date 2021/01/02 18/12
 */
@Slf4j
@Component
public class ArticlePipline implements Pipeline {

//    @Autowired
//    private ArticleMapper articleMapper;

    private List<Process> res = new ArrayList<>();

    public List<Process> getRes() {
        return res;
    }

    private static final Long ID = null;

    @Value("${processor.number}")
    private String number;

    @Value("${processor.process}")
    private String process;

    @Override
    public void process(ResultItems resultItems, Task task) {
        Map<String, Object> resultMap = resultItems.getAll();

        if(MapUtils.isNotEmpty(resultMap)) {
            Process temp = resultItems.get(process);
            log.info("{}",temp);
            res.add(temp);
//            articleMapper.insert(article);
        }


    }
}
