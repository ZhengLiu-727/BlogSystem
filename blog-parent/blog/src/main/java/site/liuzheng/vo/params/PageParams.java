package site.liuzheng.vo.params;

import lombok.Data;

/**
 * @author liuzheng
 */
@Data
public class PageParams {

    private int page = 1;

    private int pageSize = 10;
}
