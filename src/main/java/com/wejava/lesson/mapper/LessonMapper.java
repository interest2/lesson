package com.wejava.lesson.mapper;

import com.wejava.lesson.model.LessonBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface LessonMapper {
    void create(LessonBean lessonBean);

    void update(LessonBean lessonBean);

    void delete(int id);

    List<LessonBean> getAll(Map<String, Object> paramMap);

    LessonBean getByCourse(String course);

}
