package com.aircjm.titan.model.dto;

import com.aircjm.titan.model.blog.Meta;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 属性 Dto
 *
 * @author aircjm
 * @since 2017/8/30 15:15
 */
@EqualsAndHashCode(callSuper = false)
@Data
@Accessors(chain = true)
public class MetaDto extends Meta {

    private Integer count;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ArticleInfoDto> articles;
}
