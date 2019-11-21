package com.wejava.lesson.service;

import com.wejava.lesson.model.LessonBean;

import java.util.List;

public interface LessonService {

    void createJob(LessonBean lessonBean);

    void updateJob(LessonBean lessonBean);

    List<LessonBean> findAllJob();

    LessonBean getJobByCourse(String course);
}
