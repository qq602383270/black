package com.brd.test;

import java.util.ArrayList;
import java.util.List;

public class Test {
  static  int Ary=32;
  static  List<Character> ch=new ArrayList<>();
  static{
      for (int i = 0; i < Ary; i++) {
          if(i<10){
              ch.add((char)(48+i));
          }
          else{
              ch.add((char)(55+i));
          }
    }
  }
  static StringBuffer sb=new StringBuffer();
  public Test(int ary){
      Ary=ary;
      sb=new StringBuffer();
  }
     public static void main(String[] args) {
         
         System.out.println(ch);
        System.out.println(new Test(2).getString(97).reverse());
        System.out.println(new Test(8).getString(97).reverse());
        System.out.println(new Test(16).getString(97).reverse());
        System.out.println(new Test(32).getString(97).reverse());
      
    }
     public  static StringBuffer getString(int number){
         
         int irem=number%Ary;
         int iquo=number/Ary;
         
         sb.append(ch.get(irem));
         if(iquo>0){
            
             getString(iquo);
         }
         return sb;
     }
}
