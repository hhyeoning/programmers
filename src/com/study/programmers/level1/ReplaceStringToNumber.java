package com.study.programmers.level1;

/**
 * 숫자 문자열과 영단어
 * */
public class ReplaceStringToNumber {

    public static void main(String[] args) {

        String s = "1zerotwozero3";
        //solution(s);
        solution2(s);
    }

    // 내 풀이
    public static int solution(String s) {
        int answer = 0;

        s = s.replaceAll("zero","0");
        s = s.replaceAll("one","1");
        s = s.replaceAll("two","2");
        s = s.replaceAll("three","3");
        s = s.replaceAll("four","4");
        s = s.replaceAll("five","5");
        s = s.replaceAll("six","6");
        s = s.replaceAll("seven","7");
        s = s.replaceAll("eight","8");
        s = s.replaceAll("nine","9");

        answer = Integer.parseInt(s);

        System.out.println("s == " + s);

        return answer;
    }

    public static int solution2(String s){
        String[] str = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for(int i = 0 ; i < str.length ; i++){
            s = s.replaceAll(str[i],String.valueOf(i));
        }

        return Integer.valueOf(s);
    }




}
