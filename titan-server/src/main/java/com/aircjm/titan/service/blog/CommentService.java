package com.aircjm.titan.service.blog;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.aircjm.titan.model.blog.Comment;
import com.aircjm.titan.model.dto.CommentDto;
import com.aircjm.titan.constants.Types;

/**
 * 评论 Service 接口
 *
 * @author aircjm
 * @since 2018/1/19 16:56
 */
public interface CommentService {
    /**
     * 保存评论
     *
     * @param comments 评论entity
     */
    void save(Comment comments);

    /**
     * 获取文章下的评论
     *
     * @param limit     每页数量
     * @param articleId 文章id
     * @return Page<Comment>
     */
    IPage<Comment> getCommentsByArticleId(Integer current, Integer limit, Integer articleId);

    /**
     * 获取文章下的评论
     *
     * @param limit 每页数量
     * @return Page<Comment>
     */
    IPage<Comment> getAdminComments(Integer current, Integer limit);

    /**
     * 获取评论详情
     *
     * @param id 评论id
     * @return CommentDto
     */
    CommentDto getCommentDetail(Integer id);

    /**
     * 删除评论
     *
     * @param id 评论id
     * @return 删除是否成功
     */
    boolean deleteComment(Integer id);

    /**
     * 顶或踩评论
     *
     * @param commentId 评论给id
     * @param assess    {@link Types#AGREE},{@link Types#DISAGREE}
     */
    void assessComment(Integer commentId, String assess);

    /**
     * 评论数量
     *
     * @return 数量
     */
    Integer count();
}
