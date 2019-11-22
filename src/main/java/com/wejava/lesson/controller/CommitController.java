
package com.wejava.lesson.controller;

import com.wejava.lesson.model.LessonBean;
import com.wejava.lesson.utils.GetParamUtil;
import com.wejava.lesson.service.LessonService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CommitController {
    @Value("${wx.appid}")
    private String appid;

    @Value("${wx.secret}")
    private String secret;

    @Autowired
    private LessonService lessonService;

    @RequestMapping("/getList")
    @ResponseBody
    public List<LessonBean> getList() {
        List<LessonBean> lessonList = lessonService.getAll();
        return lessonList;
    }

    @RequestMapping("/addLesson")
    @ResponseBody
    public String addLesson(@RequestBody LessonBean lessonBean) {
        lessonBean.setCreateDate(new Date());
        System.out.println(lessonBean.toString());
        lessonService.create(lessonBean);
        return "success";
    }

    @RequestMapping("/updateLesson")
    @ResponseBody
    public String updateLesson(@RequestBody LessonBean lessonBean) {
        lessonBean.setCreateDate(new Date());
        lessonService.update(lessonBean);
        return "success";
    }

    @RequestMapping("/deleteLesson")
    @ResponseBody
    public String deleteLesson(int id) {
        lessonService.delete(id);
        return "success";
    }

    @RequestMapping("/give")
    @ResponseBody
    public String give(@RequestBody(required = false) Map<String, String> params) {
        String code = params.get("code");
        String category = params.get("category");
        System.out.println("category: " + category);

        String openidUrl = "https://api.weixin.qq.com/sns/jscode2session?appid="
                + appid + "&secret=" + secret + "&js_code=" + code + "&grant_type=authorization_code";
//	    获取course
        String jsonId = GetParamUtil.getParam(openidUrl);
        JSONObject jsonObject = JSONObject.fromObject(jsonId);
        String course = jsonObject.getString("course");
        System.out.println("course: " + course);

        return null;
    }
}
