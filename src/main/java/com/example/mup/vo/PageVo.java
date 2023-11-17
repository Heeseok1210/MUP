package com.example.mup.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class PageVo {
    private int startPage;
    private int pageCount;
    private int endPage;
    private int realEnd;
    private boolean prev;
    private boolean next;
    private int total;
    private Criteria criteria;

    public PageVo() {}

    public PageVo(Criteria criteria, int total){
        this(criteria, total, 5);
    }

    public PageVo(Criteria criteria, int total, int pageCount){
        this.criteria = criteria;
        this.total = total;
        this.pageCount = pageCount;

//        현재 페이지를 기분으로 세트의 마지막 번호, 시작 번호를 구함
        this.endPage = (int)(Math.ceil(criteria.getPage() / (double)pageCount)) * pageCount;
        this.startPage = endPage - pageCount + 1;

//        선수 전체 개수로 실제 마지막 페이지를 구함
        this.realEnd = (int)(Math.ceil((double)total/criteria.getAmount()));

//        세트의 마지막 번호보다 실제 마지막 페이지가 작다면
        if(realEnd < endPage){
            this.endPage = realEnd == 0? 1 : realEnd;
        }

        this.prev = startPage > 1;
        this.next = endPage < realEnd;
    }
}
