package com.drebander.regular.match;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Processor {

    private static final List<String> l = new ArrayList<String>() {{
        add("([a-z]+)(\\d+)");
        add("(www.baidu.com=)(\\d{8})");
        add("(\\d{11})");
    }};


    public static void main(String[] args) {
        String input = "12345678901";
        boolean isMatch = false;
        for (String r : l) {
            Pattern p = Pattern.compile(r);
            Matcher m = p.matcher(input);
            if (m.find()) {
                if (m.groupCount() == 1) {
//                    m.groupCount(); //返回2,因为有2组
//                    m.start(1); //返回0 返回第一组匹配到的子字符串在字符串中的索引号
//                    m.start(2); //返回3
//                    m.end(1); //返回3 返回第一组匹配到的子字符串的最后一个字符在字符串中的索引位置.
//                    m.end(2); //返回7
//                    m.group(1); //返回aaa,返回第一组匹配到的子字符串
                    System.out.println(m.group(0)); //返回2223,返回第二组匹配到的子字符串
                    isMatch = true;
                    break;
                } else if (m.groupCount() == 2) {
                    System.out.println(m.group(2));
                    isMatch = true;
                    break;
                }
            }
        }
        if (!isMatch) {
            System.out.println("Cannot find match info ~!");
        }
    }
}
