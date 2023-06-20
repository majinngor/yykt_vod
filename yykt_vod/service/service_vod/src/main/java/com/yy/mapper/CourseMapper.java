package com.yy.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yy.model.vod.Course;
import com.yy.vo.vod.CoursePublishVo;
import com.yy.vo.vod.CourseVo;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author abc
 * @since 2023-06-08
 */
@Repository
public interface CourseMapper extends BaseMapper<Course> {
    //根据id获取课程发布信息
    CoursePublishVo selectCoursePublishVoById(Long id);

    CourseVo selectCourseVoById(Long id);
}
