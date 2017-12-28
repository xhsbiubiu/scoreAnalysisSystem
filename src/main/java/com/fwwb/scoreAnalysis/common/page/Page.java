package com.fwwb.scoreAnalysis.common.page;

import java.util.List;

/**
 * Created by Niow on 2016/12/12.
 */
public class Page<T>{

    public final static Integer DEFAULT_PAGE = 0;

    public final static Integer DEFAULT_EACH_PAGE_SIZE = 10;

    private long total;

    private int totalPages;

    private int number = DEFAULT_PAGE;

    private int size = DEFAULT_EACH_PAGE_SIZE;

    private String sort;// 排序字段名

    private String order;// 按什么排序(asc,desc)

    private List<T> entities;

    public Page() {

    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
        this.totalPages = (int) (total / getSize());
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getNumber() {
        if (number < 0) {
            number = DEFAULT_PAGE;
        }
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getSize() {
        if (size < 0) {
            size = DEFAULT_EACH_PAGE_SIZE;
        }
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public List<T> getEntities() {
        return entities;
    }

    public void setEntities(List<T> entities) {
        this.entities = entities;
    }
}
