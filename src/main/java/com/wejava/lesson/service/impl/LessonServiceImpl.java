
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
    public void createJob(LessonBean lessonBean){
        lessonMapper.create(lessonBean);
    }

    @Override
    public void updateJob(LessonBean lessonBean){
        lessonMapper.update(lessonBean);
    }

    @Override
    public List<LessonBean> findAllJob() {
        Map<String, Object> paramMap = new HashMap<>();
        return lessonMapper.findAll(paramMap);
    }

    @Override
    public LessonBean getJobByCourse(String course) {
        return lessonMapper.getByCourse(course);
    };

}
