package com.sboard.dto;

import com.sboard.entity.Article;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageResponseDTO {

    private List<ArticleDTO> dtoList;

    private String cate;
    private int pg;
    private int size;
    private int total;
    private int startNo;
    private int start, end;
    private boolean prev, next;

}
