package site.liuzheng.vo.params;


import lombok.Data;
import site.liuzheng.vo.CategoryVo;
import site.liuzheng.vo.TagVo;

import java.util.List;

@Data
public class ArticleParam {

    private Long id;

    private ArticleBodyParam body;

    private CategoryVo category;

    private String summary;

    private List<TagVo> tags;

    private String title;
}
