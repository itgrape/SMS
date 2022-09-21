package com.pushihao.util;

import java.io.InputStream;
import java.util.Properties;

public class PageSupport {
    private static int maxPageNum;
    private static int totalPageNum;
    private static int totalDataNum;

    public void setTotalDataNum(int totalDataNum) {
        PageSupport.totalDataNum = totalDataNum;
        totalPageNum = totalDataNum % maxPageNum == 0? totalDataNum / maxPageNum : totalDataNum / maxPageNum + 1;
    }

    static {
        try {
            InputStream inputStream = PageSupport.class.getClassLoader().getResourceAsStream("pageNumConfig.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            maxPageNum = Integer.parseInt(properties.getProperty("maxPageNum"));

            if (inputStream != null) inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int currentPageNum;

    public void setCurrentPageNum(int currentPageNum) {
        if (currentPageNum < 1) this.currentPageNum = 1;
        else if (currentPageNum > totalPageNum) this.currentPageNum = totalPageNum;
        else this.currentPageNum = currentPageNum;
    }

    public int getTotalPageNum() {
        return totalPageNum;
    }

    public int[] getIndex() {
        int[] index = new int[2];
        index[0] = (currentPageNum - 1) * maxPageNum;
        index[1] = (currentPageNum) * maxPageNum - 1;
        return index;
    }
}
