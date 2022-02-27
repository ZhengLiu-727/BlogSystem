package site.liuzheng.service;

import site.liuzheng.vo.CategoryVo;
import site.liuzheng.vo.Result;

public interface CategoryService {

    CategoryVo findCategoryById(Long categoryId);

    Result findAll();

    Result findAllDetail();

    Result categoryDetailById(Long id);
}
