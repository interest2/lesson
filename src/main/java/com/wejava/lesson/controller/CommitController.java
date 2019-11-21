
package com.wejava.lesson.controller;

import com.wejava.lesson.utils.OpenIdUtil;
import com.wejava.lesson.service.LessonService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class CommitController {
    @Value("${wx.appid}")
    private String appid;

    @Value("${wx.secret}")
    private String secret;

    @Autowired
    private LessonService lessonService;

    @RequestMapping("/give")
    @ResponseBody
    public String give(@RequestBody(required=false) Map<String,String> params ) {
        String code=params.get("code");
        String category=params.get("category");
        System.out.println("category: "+category);
//	    获取course
        String jsonId= OpenIdUtil.getCourse(appid,code,secret);
        JSONObject jsonObject = JSONObject.fromObject(jsonId);
        String course=jsonObject.getString("course");
        System.out.println("course: "+course);

        return null;
    }
}
