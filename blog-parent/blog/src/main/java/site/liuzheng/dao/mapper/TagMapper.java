package site.liuzheng.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import site.liuzheng.dao.pojo.Tag;


import java.util.List;

/**
 * @author liuzheng
 */
@Repository
public interface TagMapper extends BaseMapper<Tag> {
    /**
     * 根据文章id查询标签列表
     * @param articleId 文章id
     * @return 标签列表
     */
    List<Tag> findTagsByArticleId(Long articleId);

    /**
     * 查询前limit个最热标签
     * @param limit
     * @return
     */
    List<Long> findHotsTagsIds(int limit);

    /**
     * 根据tagId查询tag对象
     * @param tagIds
     * @return
     */
    List<Tag> findTagsByTagIds(List<Long> tagIds);
}
