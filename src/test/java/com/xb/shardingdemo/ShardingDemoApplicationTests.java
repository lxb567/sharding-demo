package com.xb.shardingdemo;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xb.shardingdemo.entity.Course;
import com.xb.shardingdemo.mapper.CourseMapper;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class ShardingDemoApplicationTests {

    @Resource
    private CourseMapper courseMapper;

    @Test
    void contextLoads() {
    }

    @Test
    public void addCourse() {
        for(long i=0;i<10;i++){
            Course course = new Course();
            course.setCname(i+"-xxx");
            course.setStatus(i+"--ss");
            course.setUserId(i);
            courseMapper.insert(course);
        }
    }

    @Test
    public void selectAll(){
        LambdaQueryWrapper<Course> wrapper = new LambdaQueryWrapper<>();
        LambdaQueryWrapper<Course> eq = wrapper.eq(Course::getCid, 2);
        List<Course> courses = courseMapper.selectList(eq);
        System.out.println(courses);
    }
}
