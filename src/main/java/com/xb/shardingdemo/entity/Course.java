package com.xb.shardingdemo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "course")
public class Course {
    @TableId
    private Long cid;
    private String cname;
    private Long userId;
    private String status;
}