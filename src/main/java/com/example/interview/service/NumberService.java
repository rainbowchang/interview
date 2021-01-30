package com.example.interview.service;

import com.example.interview.kit.DesignatedNumber;
import com.example.interview.kit.MyNumberException;
import com.example.interview.kit.NumberResultItem;
import com.example.interview.kit.NumberTools;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NumberService {

    /**
     * 循环分析每个数，把结果转换为json字符串带出去。
     * @param input 人数
     * @return 全部的报数结果，按照json pretty格式输出
     * @throws MyNumberException
     */
    public String getSpeak(String input) throws MyNumberException, JsonProcessingException {
        List<NumberResultItem> numberResultItemList = new ArrayList<>();
        int max = NumberTools.stringToInteger(input);
        for(int i = 1; i<=max; i++){
            numberResultItemList.add(getSpeakProc(i));
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String ss= gson.toJson(numberResultItemList);
        System.out.println(ss);
        return ss;
    }

    /**
     * 对单个输入的整数按照规则进行处理。
     * @param input 要报的数
     * @return 报数的结果
     */
    public NumberResultItem getSpeakProc(int input){
        NumberResultItem resultItem = new NumberResultItem();
        resultItem.setNumber(input);

        //先判断规则4、5，满足条件直接退出
        String include = NumberTools.include(input, DesignatedNumber.Three);
        if(include != null && include.length() > 0){
            resultItem.setSpeak(include);
            return resultItem;
        }

        //依次判断3、5、7
        String resultString = "";
        String out = "";
        out = NumberTools.divide(input, DesignatedNumber.Three);
        resultString += out;
        out = NumberTools.divide(input, DesignatedNumber.Five);
        resultString += out;
        out = NumberTools.divide(input, DesignatedNumber.Seven);
        resultString += out;
        if(resultString.length() == 0){
            resultItem.setSpeak(String.valueOf(input));
        } else {
            resultItem.setSpeak(resultString);
        }
        return resultItem;
    }

}
