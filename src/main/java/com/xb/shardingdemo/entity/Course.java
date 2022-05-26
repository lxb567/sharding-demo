package com.xb.shardingdemo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "course")
public class Course {
    private Long cid;
    private String cname;
    private Long userId;
    private String status;
}