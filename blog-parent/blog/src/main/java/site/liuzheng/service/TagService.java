package site.liuzheng.service;

import site.liuzheng.vo.Result;
import site.liuzheng.vo.TagVo;

import java.util.List;

/**
 * @author liuzheng
 */
public interface TagService {
    /**
     *
     * @param articleId
     * @return
     */
    List<TagVo> findTagsByArticleId(Long articleId);

    Result hots(int limit);
}
