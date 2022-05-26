package com.xb.shardingdemo.controller;

import com.xb.shardingdemo.entity.Course;
import com.xb.shardingdemo.mapper.CourseMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {
    @Resource
    private CourseMapper courseMapper;

    @RequestMapping("/test")
    public String test(){
        Course course = new Course();
        //cid由我们设置的策略，雪花算法进行生成
        course.setCname("Java");
        course.setUserId(100L);
        course.setStatus("Normal");

        Course course2 = new Course();
        course2.setCname("Java");
        course2.setUserId(101L);
        course2.setStatus("Normal");


        courseMapper.insert(course);
        courseMapper.insert(course2);
        return "ok";
    }
}
