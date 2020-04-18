package com.aircjm.titan.controller.admin;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.aircjm.titan.controller.BaseController;
import com.aircjm.titan.mapper.blog.ArticleMapper;
import com.aircjm.titan.model.blog.Article;
import com.aircjm.titan.model.dto.Pagination;
import com.aircjm.titan.service.blog.ArticleService;
import com.aircjm.titan.service.system.LogService;
import com.aircjm.titan.constants.DiceConsts;
import com.aircjm.titan.vo.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 自定义页面管理 Controller
 *
 * @author aircjm
 * @since 2017/10/17 12:28
 */
@RestController
@RequestMapping("/v1/api/admin/page")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class PageController extends BaseController {

    private final ArticleService articleService;
    private final ArticleMapper articleMapper;
    private final LogService logService;

    /**
     * 自定义页面列表
     *
     * @param pageNum  第几页
     * @param pageSize 每页数量
     * @return {@see Pagination<Article>}
     */
    @GetMapping
    public RestResponse index(@RequestParam(required = false, defaultValue = "1") Integer pageNum,
                              @RequestParam(required = false, defaultValue = DiceConsts.PAGE_SIZE) Integer pageSize) {
        IPage<Article> pages = articleService.getAdminPages(pageNum, pageSize);
        return RestResponse.ok(new Pagination<Article>(pages));
    }

    /**
     * 获取自定义页面信息
     *
     * @param id 自定义页面id
     * @return {@see Article}
     */
    @GetMapping("{id}")
    public RestResponse showPage(@PathVariable Integer id) {
        Article page = articleService.getAdminPage(id);
        if (null == page) {
            return this.error404();
        }
        return RestResponse.ok(page);
    }

    /**
     * 新建或修改自定义页面
     *
     * @param page 页面实体
     * @return {@see String}
     */
    @PostMapping
    public RestResponse savePage(@RequestBody Article page) {
        page.setCreator(this.user().getId());
        articleService.savePage(page);
        return RestResponse.ok("保存文章成功");
    }

    /**
     * 删除自定义页面
     *
     * @param id 自定义页面id
     * @return {@see String}
     */
    @DeleteMapping("{id}")
    public RestResponse deletePage(@PathVariable Integer id) {

        if (articleMapper.deleteById(id)>0) {
            return RestResponse.ok("删除自定义页面成功");
        } else {
            return RestResponse.fail();
        }
    }
}
