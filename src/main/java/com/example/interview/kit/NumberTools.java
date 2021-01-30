package com.example.interview.kit;

/**
 * 工具类
 */
public class NumberTools {

    private static final String TIP_1 = "哥哥，你要有数啊！";
    private static final String TIP_2 = "麻烦输入一个整数，在1到3000之间。";
    private static final String Empty="";

    /**
     * 输入一个字符串，如果不在正整数范围内，或者超过3000，报个错误出来。
     * @param input
     * @return
     * @throws NumberFormatException
     */
    public static int stringToInteger(String input) throws MyNumberException {
        if(input == null || input.length() == 0){
            throw new MyNumberException(TIP_1);
        }
        int result = 200;
        try {
            result = Integer.parseInt(input.trim());
        }catch(NumberFormatException e){
            throw new MyNumberException(TIP_2);
        }
        if(result<= 0 || result>3000){
            throw new MyNumberException(TIP_2);
        }
        return result;
    }

    /**
     * 判断是否存在指定的数字
     * @param input
     * @param number
     * @return
     */
    public static String include(int input, DesignatedNumber number){
        String numberString = String.valueOf(input);
        if(numberString.contains(number.getIndex().toString())){
            return number.getName();
        }
        return Empty;
    }

    public static String divide(Integer input, DesignatedNumber designatedNumber){
        int remainder = input%designatedNumber.getIndex();
        if(remainder == 0){
            return designatedNumber.getName();
        }
        return Empty;
    }



}
