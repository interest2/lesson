
package com.wejava.lesson.model;

import java.util.Date;

public class LessonBean {
    private int id;
    private String course;
    private String category;
    private String level;
    private int credit;
    private Date createDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Lesson {" +
                "course=" + course +
                ", category='" + category + '\'' +
                ", level=" + level +
                ", credit=" + credit +
                ", createDate=" + createDate +
                '}';
    }
}
