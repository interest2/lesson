
package com.wejava.lesson.controller;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.bean.WxMaTemplateData;
import cn.binarywang.wx.miniapp.config.WxMaInMemoryConfig;
import com.wejava.lesson.service.LessonService;
import com.wejava.lesson.model.LessonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
@EnableScheduling
public class PushController {
    @Value("${wx.appid}")
    private String appid;

    @Value("${wx.secret}")
    private String secret;

    @Value("${wx.templateId}")
    private String templateId;

    @Autowired
    private LessonService lessonService;

//    推送消息
    public String push(String result, List<LessonBean> list, Integer flag){
        //1,配置小程序信息
        WxMaInMemoryConfig wxConfig = new WxMaInMemoryConfig();
        wxConfig.setAppid(appid);
        wxConfig.setSecret(secret);

        WxMaService wxMaService = new WxMaServiceImpl();
        wxMaService.setWxMaConfig(wxConfig);

        //2,设置模版信息,两个keyword
        List<WxMaTemplateData> templateDataList = new ArrayList<>(2);
        WxMaTemplateData data1 = new WxMaTemplateData("keyword1", "iot-rsk");
        WxMaTemplateData data2 = new WxMaTemplateData("keyword2", result+"(需进入详查)");
        templateDataList.add(data1);
        templateDataList.add(data2);

        return "推送成功";
    }
}

