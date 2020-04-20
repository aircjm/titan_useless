package com.aircjm.titan.controller.admin;

import com.aircjm.titan.controller.BaseController;
import com.aircjm.titan.model.blog.Article;
import com.aircjm.titan.model.dto.Pagination;
import com.aircjm.titan.model.params.ArticleParam;
import com.aircjm.titan.service.blog.ArticleService;
import com.aircjm.titan.constants.DiceConsts;
import com.aircjm.titan.vo.RestResponse;
import com.aircjm.titan.constants.Types;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 后台文章管理 Controller
 *
 * @author aircjm
 * @since 2017/7/11 19:52
 */
@RestController
@RequestMapping("/v1/api/admin/article")
public class ArticleController extends BaseController {

    @Resource
    private ArticleService articleService;

    /**
     * 文章信息列表
     *
     * @param pageNum  第几页
     * @param pageSize 每页数量
     * @return {@see Pagination<Article>}
     */
    @GetMapping
    public RestResponse index(@RequestParam(required = false, defaultValue = "1") Integer pageNum,
                              @RequestParam(required = false, defaultValue = DiceConsts.PAGE_SIZE) Integer pageSize, Article articleParam) {
        IPage<Article> articles = articleService.getAdminArticles(pageNum, pageSize, articleParam);
        return RestResponse.ok(new Pagination<Article>(articles));
    }

    /**
     * 单个文章信息
     *
     * @param id 文章id
     * @return {@see Article}
     */
    @GetMapping("{id}")
    public RestResponse showArticle(@PathVariable Integer id) {
        Article article = articleService.getAdminArticle(id);
        if (null == article) {
            return this.error404();
        }
        return RestResponse.ok(article);
    }

    /**
     * 新建或修改文章
     */
    @PostMapping
    public RestResponse saveArticle(@RequestBody ArticleParam articleParam) {
        // todo 粗暴处理报错
//        articleParam.setCreator(this.user().getId());
        Integer articleId = articleService.saveArticle(articleParam);
        return RestResponse.ok(articleId);
    }

    /**
     * 删除文章
     *
     * @param id 文章id
     * @return {@see RestResponse.ok()}
     */
    @DeleteMapping("{id}")
    public RestResponse deleteArticle(@PathVariable Integer id) {
        if (articleService.deleteArticle(id)) {
            return RestResponse.ok("删除文章成功");
        } else {
            return RestResponse.fail();
        }
    }

    /**
     * 已发布文章数量
     *
     * @return {@see Integer}
     */
    @GetMapping("count")
    public RestResponse count() {
        return RestResponse.ok(articleService.count(new QueryWrapper<Article>().lambda()
                .eq(Article::getType, Types.POST)
        ));
    }
}
