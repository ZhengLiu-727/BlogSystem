package site.liuzheng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.liuzheng.service.ArticleService;
import site.liuzheng.vo.Result;
import site.liuzheng.vo.params.PageParams;

/**
 * @author liuzheng
 *
 */
@RestController
@RequestMapping("articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 首页 文章列表
     */
    @PostMapping
    public Result listArticle(@RequestBody PageParams pageParams) {
        return articleService.listArticle(pageParams);
    }

    /**
     * 首页 最热文章
     */
    @PostMapping("hot")
    public Result hotArticle() {
        int limit = 5;
        return articleService.hotArticle(limit);
    }

    /**
     * 首页 最新文章
     */
    @PostMapping("new")
    public Result newArticles() {
        int limit = 5;
        return articleService.newArticles(limit);
    }

    /**
     * 首页 文章归档
     */
    @PostMapping("listArchives")
    public Result listArchives() {
        return articleService.listArchives();
    }
}
