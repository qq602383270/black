/**
 * Project Name:black File Name:Remove.java Package Name:com.brd.test Date:2016年6月19日下午10:22:54
 * Copyright (c) 2016, ehking All Rights Reserved.
 *
 */

package com.brd.test;

/**
 * 给定字符串S，删除字符串中的ac和b。
 * 
 * 例如：输入: “acdb” 输出: “d”
 * 
 * 去掉ac>bd 去掉b>d 输入: “abcd” 输出: “d”
 * 
 * 去掉b>acd 去掉ac>d
 * 
 * 
 * 请实现public String trimACB(String str),输入一个字符串，得到处理之后的字符串。
 * 
 * 特别要求：字符串只能遍历一次（即不能用replace等方法）
 * 
 * 
 */
import java.util.Scanner;

public class Remove {

    private static Scanner sc;

    public static void main(String[] args) {

        sc = new Scanner(System.in);
        System.out.println("请您输入:");
        String str = sc.nextLine();
        int b_index = 0;
        int ac_index = 0;
        while (str.contains("ac") || str.contains("b")) {
            b_index = str.indexOf("b");
            ac_index = str.indexOf("ac");
            if (b_index > -1) {
                str = str.substring(0, b_index) + (b_index + 1 >= str.length() ? "" : str.substring(b_index + 1));
            }
            if (ac_index > -1) {
                str = str.substring(0, ac_index) + (ac_index + 2 >= str.length() ? "" : str.substring(ac_index + 2));
            }
        }
        System.out.println("输出:" + str);

    }
}
