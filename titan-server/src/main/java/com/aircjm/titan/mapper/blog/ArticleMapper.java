package com.aircjm.titan.mapper.blog;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.aircjm.titan.enums.PostStatusEnum;
import com.aircjm.titan.model.blog.Article;
import com.aircjm.titan.model.dto.ArticleInfoDto;
import com.aircjm.titan.constants.Types;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Article Mapper
 *
 * @author aircjm
 * @since 2017/7/8 10:39
 */
public interface ArticleMapper extends BaseMapper<Article> {

    /**
     * 根据metaId获取关联的文章
     *
     * @param metaId 属性id
     * @return List<Article>
     */
    @Select("SELECT * FROM article WHERE id IN (SELECT a_id FROM middle WHERE m_id = #{metaId}) " +
            "AND article.type = '" + Types.POST + "' order by create_time desc")
    List<Article> selectByMeta(@Param("metaId") Integer metaId);

    /**
     * 根据metaId获取关联文章的数量
     *
     * @param metaId 属性id
     * @return Integer
     */
    @Select("SELECT count(*) FROM article WHERE id " +
            "IN (SELECT a_id FROM middle WHERE m_id = #{metaId}) " +
            "AND article.type = '" + Types.POST + " AND article.deleted=0")
    Integer selectCountByMeta(@Param("metaId") Integer metaId);

    /**
     * 根据metaId获取关联的已发布文章
     *
     * @param metaId 属性id
     * @return List<Article>
     */
    @Select("SELECT * FROM article WHERE id " +
            "IN (SELECT a_id FROM middle WHERE m_id = #{metaId}) " +
            "AND article.status = '" + PostStatusEnum.Constants.PUBLISHED_VALUE + "' AND article.type = '" + Types.POST + "' order by create_time desc")
    List<ArticleInfoDto> selectPublishByMeta(@Param("metaId") Integer metaId);

    /**
     * 根据metaId获取关联的已发布代码段
     *
     * @param metaId 属性id
     * @return List<Article>
     */
    @Select("SELECT * FROM article WHERE id " +
            "IN (SELECT a_id FROM middle WHERE m_id = #{metaId}) order by create_time desc")
    List<ArticleInfoDto> selectSnippetByMeta(@Param("metaId") Integer metaId);

    /**
     * 根据metaId获取关联已发布文章的数量
     *
     * @param metaId 属性id
     * @return Integer
     */
    @Select("SELECT count(*) FROM article WHERE id " +
            "IN (SELECT a_id FROM middle WHERE m_id = #{metaId}) " +
            "AND article.status = '" + PostStatusEnum.Constants.PUBLISHED_VALUE + "' AND article.type = '" + Types.POST + "'")
    Integer selectPublishCountByMeta(@Param("metaId") Integer metaId);
}
