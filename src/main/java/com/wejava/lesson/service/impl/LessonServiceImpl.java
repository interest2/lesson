
package com.wejava.lesson.service.impl;

import com.wejava.lesson.mapper.LessonMapper;
import com.wejava.lesson.service.LessonService;
import com.wejava.lesson.model.LessonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LessonServiceImpl implements LessonService {
    @Autowired
    private LessonMapper lessonMapper;

    @Override
    public void create(LessonBean lessonBean){
        lessonMapper.create(lessonBean);
    }

    @Override
    public void update(LessonBean lessonBean){
        lessonMapper.update(lessonBean);
    }

    @Override
    public void delete(int id){
        lessonMapper.delete(id);
    }

    @Override
    public List<LessonBean> getAll() {
        Map<String, Object> paramMap = new HashMap<>();
        return lessonMapper.getAll(paramMap);
    }

    @Override
    public LessonBean getJobByCourse(String course) {
        return lessonMapper.getByCourse(course);
    };

}
