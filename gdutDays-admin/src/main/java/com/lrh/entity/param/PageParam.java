package com.lrh.entity.param;

import lombok.Data;

/**
 * @author lrh
 * @description
 * @date 2023/2/19
 */
@Data
public class PageParam {
    private int page=1;
    private int pageSize=10;
    private Long categoryId;

}
