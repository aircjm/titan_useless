package com.aircjm.titan.model.params;

import com.aircjm.titan.model.blog.Article;
import com.aircjm.titan.utils.DateUtil;


/**
 * @author haseochen
 */
public class ArticleParam extends Article {

    /**
     * 创建时间
     **/
    public void setCreateTime(Long createTime) {
        super.setCreateTime(DateUtil.convertToLocalDateTimeVisLong(createTime));
    }

    /**
     * 修改时间
     **/
    public void setUpdateTime(Long updateTime) {
        super.setUpdateTime(DateUtil.convertToLocalDateTimeVisLong(updateTime));
    }
}
