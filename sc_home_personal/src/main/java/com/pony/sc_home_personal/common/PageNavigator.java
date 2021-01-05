package com.pony.sc_home_personal.common;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Data
public class PageNavigator<T> implements Serializable {

    private List<T> content; // 分页数据列表
    private long totalElements; // 总条数
    private int totalPages; // 总页数
    private int number;   // 当前页数
    private int size;     // 每页条数
    private boolean first;  // 是否为第一页
    private boolean last;  // 是否为最后一页

    public PageNavigator() {
    }

    public PageNavigator(Page<T> page) {
        this.content = Collections.synchronizedList(page.getContent());
        this.totalElements = page.getTotalElements();
        this.totalPages = page.getTotalPages();
        this.number = page.getNumber();
        this.size = page.getSize();
        this.first = page.isFirst();
        this.last = page.isLast();
    }
}
