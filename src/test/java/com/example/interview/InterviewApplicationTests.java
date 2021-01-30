package com.example.interview;

import com.example.interview.kit.DesignatedNumber;
import com.example.interview.kit.MyNumberException;
import com.example.interview.kit.NumberTools;
import com.example.interview.service.NumberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class InterviewApplicationTests {
    @Autowired
    private NumberService numberService;

    @Test
    void contextLoads() {
    }

    @Test
    void testInputCheck() {
        inputCheck(null);
        inputCheck("");
        inputCheck("-2");
        inputCheck("5.64");
        inputCheck("5.ae4");
        inputCheck("4000");
        inputCheck("5.00");
        inputCheck("0");
        inputCheck(Integer.valueOf(Integer.MAX_VALUE).toString());
        inputCheck("200");
        inputCheck("1234 ");
        inputCheck("-1234 ");
    }

    void inputCheck(String input) {
        try {
            int result = NumberTools.stringToInteger(input);
            System.out.println("result = " + result);
        } catch (MyNumberException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testDivide() {
        System.out.println(NumberTools.divide(23, DesignatedNumber.Five));
        System.out.println(NumberTools.divide(25, DesignatedNumber.Five));
        System.out.println(NumberTools.divide(34, DesignatedNumber.Three));
        System.out.println(NumberTools.divide(33, DesignatedNumber.Three));
        System.out.println(NumberTools.divide(56, DesignatedNumber.Seven));
        System.out.println(NumberTools.divide(83, DesignatedNumber.Seven));
    }

    @Test
    void testInclude() {
        System.out.println(NumberTools.include(23, DesignatedNumber.Five));
        System.out.println(NumberTools.include(25, DesignatedNumber.Five));
        System.out.println(NumberTools.include(34, DesignatedNumber.Three));
        System.out.println(NumberTools.include(42, DesignatedNumber.Three));
        System.out.println(NumberTools.include(56, DesignatedNumber.Seven));
        System.out.println(NumberTools.include(837, DesignatedNumber.Seven));
    }

    @Test
    void testSpeak() {
        System.out.println(numberService.getSpeakProc(1));
        System.out.println(numberService.getSpeakProc(2));
        System.out.println(numberService.getSpeakProc(3));
        System.out.println(numberService.getSpeakProc(4));
        System.out.println(numberService.getSpeakProc(5));
        System.out.println(numberService.getSpeakProc(6));
        System.out.println(numberService.getSpeakProc(7));
        System.out.println(numberService.getSpeakProc(8));
        System.out.println(numberService.getSpeakProc(9));
        System.out.println(numberService.getSpeakProc(10));
        System.out.println(numberService.getSpeakProc(15));
        System.out.println(numberService.getSpeakProc(21));
        System.out.println(numberService.getSpeakProc(35));
        System.out.println(numberService.getSpeakProc(70));
        System.out.println(numberService.getSpeakProc(105));
        System.out.println(numberService.getSpeakProc(133));
        System.out.println(numberService.getSpeakProc(63));
        System.out.println(numberService.getSpeakProc(56));
    }

}
