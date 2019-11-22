package com.wejava.lesson.service;

import com.wejava.lesson.model.LessonBean;

import java.util.List;

public interface LessonService {

    void create(LessonBean lessonBean);

    void update(LessonBean lessonBean);

    void delete(int id);

    List<LessonBean> getAll();

    LessonBean getJobByCourse(String course);
}
