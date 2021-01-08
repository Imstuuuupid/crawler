package com.xzx.crawler.algorithm;

import com.xzx.crawler.entity.Process;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 网页链接分析hits算法
 * @author xzx
 * @date 2021/01/03 16/19
 */
@Slf4j
public class Hits {
    /**
     *  网页个数
     */
    private int pageNum;
    /**
     * 网页Authority权威值
     */
    private double[] authority;
    /**
     * 网页hub中枢值
     */
    private double[] hub;
    /**
     * 归一化后，网页Authority权威值
     */
    double[] rAuthority;
    /**
     * 归一化后，网页hub中枢值
     */
    double[] rHub;
    /**
     * 网页节点
     */
    private Object[] vertices;
    /**
     * 链接矩阵关系
     */
    private int[][] linkMatrix;


    /**
     * Hits构造方法，构建一个网页数为n的网络
     */
    public Hits(int n) {
        pageNum = n;
        vertices = new Object[pageNum];
        linkMatrix = new int[pageNum][pageNum];
        authority = new double[pageNum];
        hub = new double[pageNum];
        rHub = new double[pageNum];
        rAuthority = new double[pageNum];

        for (int i = 0; i < pageNum; i++) {
            for (int j = 0; j < pageNum; j++) {
                //初始化，网页之间没有连边
                linkMatrix[i][j] = 0;
            }
        }

        for (int k = 0; k < pageNum; k++) {
            //初始时默认权威值和中心值都为1
            authority[k] = 1;
            hub[k] = 1;
            //初始时默认归一化后的权威值和中心值都为0.25
            rAuthority[k] = 0.25;
            rHub[k] = 0.25;
        }
    }

    public void addVertex(Object[] obj) {
        //插入节点
        this.vertices = obj;
    }

    public void addEdge(int i, int j) {
        //添加网页i到网页j的有向连边
        if (i == j) {
            return;
        }
        linkMatrix[i][j] = 1;
    }

    /**
     * 输出循环结束后，各网页的权威值和中枢值
     */
    public List<Process> printResultPage(List<Process> processList) {
        //网页Hub和Authority值的总和，用于后面的归一化计算
        double newSumHub = 0;
        double newSumAuthority = 0;

        //误差值，用于收敛判断
        double error = Integer.MAX_VALUE;
        double[] newHub = new double[pageNum];
        double[] newAuthority = new double[pageNum];
        double[] newRHub = new double[pageNum];
        double[] newRAuthority = new double[pageNum];

        //记录循环次数
        int t = 0;
        while (error > 0.01 * pageNum) {
            t++;
            //新一轮循环开始，将部分变量清零，避免重复计算
            for (int k = 0; k < pageNum; k++) {
                newHub[k] = 0;
                newAuthority[k] = 0;
                newSumHub = 0;
                newSumAuthority = 0;
            }

            //authority值的更新计算
            for (int i = 0; i < pageNum; i++) {
                for (int j = 0; j < pageNum; j++) {
                    if (linkMatrix[i][j] == 1) {
                        newAuthority[j] += hub[i];
                    }
                }
            }

            //hub值的更新计算
            for (int i = 0; i < pageNum; i++) {
                for (int j = 0; j < pageNum; j++) {
                    if (linkMatrix[i][j] == 1) {
                        newHub[i] += newAuthority[j];
                    }
                }
            }

            log.info("第" + t + "次循环");
            for (int k = 0; k < pageNum; k++) {
                log.info("网页" + vertices[k] + "：权威值:" + newAuthority[k] + ", 中枢值：" + newHub[k]);
            }

            for (int k = 0; k < pageNum; k++) {
                //计算新的一次各网页hub和authority值得总和
                newSumHub += newHub[k];
                newSumAuthority += newAuthority[k];
            }

            log.info("归一化后");
            error = 0;
            //归一化处理
            for (int k = 0; k < pageNum; k++) {
                //值与总和的比值
                newRHub[k] = newHub[k] / newSumHub;
                newRAuthority[k] = newAuthority[k] / newSumAuthority;
                //计算g个网页新的Hub和Authority值与上一次值得总误差
                error += Math.abs(newRHub[k] - rHub[k]) + Math.abs(newRAuthority[k] - rAuthority[k]);
                log.info("网页" + vertices[k] + ":权威值：" + newRAuthority[k] + ", 中枢值:" + newRHub[k]);

                hub[k] = newHub[k];
                authority[k] = newAuthority[k];
                rHub[k] = newRHub[k];
                rAuthority[k] = newRAuthority[k];
            }
            log.info("---------");
        }

        log.info("****最终收敛的网页的权威值和中心值****");
        for (int k = 0; k < pageNum; k++) {
            Process tempProcess = processList.get(k);
            tempProcess.setAuthority(authority[k]);
            tempProcess.setHub(hub[k]);
            log.info("网页" + vertices[k] + ":权威值:" + authority[k] + ", 中枢值:" + hub[k]);
        }

        log.info("归一化处理后");
//        保存到process列表中，便于存储入数据库
        for (int k = 0; k < pageNum; k++) {
            log.info("网页{}:权威值:{}, 中枢值:{}", vertices[k], rAuthority[k], rHub[k]);
        }
        log.info("=====================================================");

        return processList;
    }

}
