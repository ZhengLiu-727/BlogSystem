package site.liuzheng.service;

import site.liuzheng.vo.Result;
import site.liuzheng.vo.params.ArticleParam;
import site.liuzheng.vo.params.PageParams;

/**
 * @author liuzheng
 */
public interface ArticleService {

    /**
     * 分页查询 文章列表
     * @param pageParams
     * @return
     */
    Result listArticle(PageParams pageParams);

    /**
     * 最热文章
     * @param limit
     * @return
     */
    Result hotArticle(int limit);

    /**
     * 最新文章
     * @param limit
     * @return
     */
    Result newArticles(int limit);

    /**
     * 文章归档
     * @return
     */
    Result listArchives();

    /**
     * 查询文章
     * @param articleId
     * @return
     */
    Result findArticleById(Long articleId);


    /**
     * 发布文章
     * @param articleParam
     * @return
     */
    Result publish(ArticleParam articleParam);
}
