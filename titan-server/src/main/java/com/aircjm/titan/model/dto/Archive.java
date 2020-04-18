package com.aircjm.titan.model.dto;

import com.aircjm.titan.model.blog.Article;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 归档 Dto
 *
 * @author aircjm
 * @since 2017/9/21 11:24
 */
@Data
@Accessors(chain = true)
public class Archive {

    private String dateStr;

    private LocalDateTime date;

    private Integer count;

    private List<Article> articles;
}
