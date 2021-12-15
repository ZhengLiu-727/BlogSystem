package site.liuzheng.service;

import site.liuzheng.vo.Result;
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
}