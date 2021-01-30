package com.example.interview.service;

import com.example.interview.kit.MyNumberException;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class NumberController {

    @Autowired
    private NumberService numberService;

    @GetMapping(value = "number")
    @ResponseBody
    public String getSpeakDefault() {
        return "result: " + "请输入数字";
    }

    /**
     * 将报数结果按照html特性转换后输出
     * @param prop URL传入的总数
     * @return 符合页面特性的json排版字符串
     */
    @GetMapping(value = "number/{prop}")
    @ResponseBody
    public String getSpeak(@PathVariable String prop) {
        String result = "";
        try {
            result = numberService.getSpeak(prop);
        } catch (MyNumberException e) {
            e.printStackTrace();
            result = e.getMessage();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            result = "Json 转换出错。";
        }
        result = result.replace("\n", "<br>");
        result = result.replace(" ", "&nbsp;");

        return result;
    }

}
