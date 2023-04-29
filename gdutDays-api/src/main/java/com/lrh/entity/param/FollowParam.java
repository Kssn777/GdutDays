package com.lrh.entity.param;

import lombok.Data;

/**
 * @author lrh
 * @description
 * @date 2023/4/7
 */
@Data
public class FollowParam {
    private Long targetId;

    private int op;//1为关注 0为取关
}
