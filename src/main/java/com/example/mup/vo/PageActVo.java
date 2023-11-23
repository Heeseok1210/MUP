package com.example.mup.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class PageActVo {
    private int startPage;
    private int pageCount;
    private int endPage;
    private int realEnd;
    private boolean prev;
    private boolean next;
    private int total;
    private CriteriaAct criteriaAct;

    public PageActVo() {}

    public PageActVo(CriteriaAct criteriaAct, int total){
        this(criteriaAct, total, 5);
    }

    public PageActVo(CriteriaAct criteriaAct, int total, int pageCount){
        this.criteriaAct = criteriaAct;
        this.total = total;
        this.pageCount = pageCount;

//        현재 페이지를 기분으로 세트의 마지막 번호, 시작 번호를 구함
        this.endPage = (int)(Math.ceil(criteriaAct.getPage() / (double)pageCount)) * pageCount;
        this.startPage = endPage - pageCount + 1;

//        선수 전체 개수로 실제 마지막 페이지를 구함
        this.realEnd = (int)(Math.ceil((double)total/criteriaAct.getAmount()));

//        세트의 마지막 번호보다 실제 마지막 페이지가 작다면
        if(realEnd < endPage){
            this.endPage = realEnd == 0? 1 : realEnd;
        }

        this.prev = startPage > 1;
        this.next = endPage < realEnd;
    }
}
