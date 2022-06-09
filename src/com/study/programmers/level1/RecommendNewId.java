package com.study.programmers.level1;

import java.util.Locale;

/**
 * Lv1. 신규 아이디 추천
 *
 * */
public class RecommendNewId {

    public static void main(String[] args) {

        String new_id = "=.=";

        //solution(new_id);
        solution2(new_id);
    }

    // 첫번째 풀이
    public static String solution(String new_id) {
        String answer = "";

        // 1. new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        String firstId = new_id.toLowerCase(Locale.ROOT);

        // 2. new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        String secondId = "";
        for(int i = 0; i < firstId.length() ; i++){
            char chr = firstId.charAt(i);

            if(!(!Character.isLowerCase(chr) && !Character.isDigit(chr)
                    && chr != '-' && chr != '_' && chr != '.')){
                secondId += chr;
            }
        }

        // 빈 문자열일 경우 -> "a" 대입
        secondId = emptyReplace(secondId);

        // 3. new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        String thirdId = "";
        for(int i = 0 ; i < secondId.length(); i++){

            // 마지막글자일 경우 제외
            if(i != secondId.length()-1){
                if(!(secondId.charAt(i) == '.' && (secondId.charAt(i) == secondId.charAt(i+1)))){
                    thirdId += secondId.charAt(i);
                }
            }else{
                thirdId += secondId.charAt(i);
            }
        }

        // 4. new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        String fourthId_1 = "";
        if(thirdId.charAt(0) == '.'){
            for(int i = 1; i < thirdId.length() ; i++){
                fourthId_1 +=thirdId.charAt(i);
            }
        }else{
            fourthId_1 = thirdId;
        }

        // 빈 문자열일 경우 -> "a" 대입
        fourthId_1 = emptyReplace(fourthId_1);

        String fourthId_2 = "";
        if(fourthId_1.charAt(fourthId_1.length()-1) == '.'){
            for(int i = 0; i < fourthId_1.length()-1 ; i++){
                fourthId_2 += fourthId_1.charAt(i);
            }
        }else{
            fourthId_2 = fourthId_1;
        }

        // 5. new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        fourthId_2 = emptyReplace(fourthId_2);

        // 6. new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        //     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        String sixthId_1 = "";
        if(fourthId_2.length() >= 16){
            sixthId_1 = fourthId_2.substring(0, 15);
        }else{
            sixthId_1 = fourthId_2;
        }

        String sixthId_2 = "";
        if(sixthId_1.charAt(sixthId_1.length()-1) == '.'){
            for(int i = 0; i < sixthId_1.length()-1 ; i++){
                sixthId_2 += sixthId_1.charAt(i);
            }
        }else{
            sixthId_2 = sixthId_1;
        }

        // 7. new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        String seventhId = "";
        if(sixthId_2.length() <= 2){
            String lastStr = sixthId_2.substring(sixthId_2.length()-1,sixthId_2.length());
            while (sixthId_2.length() < 3){
                sixthId_2 += lastStr;
            }
        }
            seventhId = sixthId_2;

        answer = seventhId;

        System.out.println(" firstId => " + firstId);
        System.out.println(" secondId => " + secondId);
        System.out.println(" thirdId => " + thirdId);
        System.out.println(" fourthId_1 => " + fourthId_1);
        System.out.println(" fourthId_2 => " + fourthId_2);
        System.out.println(" sixthId_1 => " + sixthId_1);
        System.out.println(" sixthId_2 => " + sixthId_2);
        System.out.println(" seventhId => " + seventhId);

        return answer;
    }

    private static String emptyReplace(String str){
        if(str == null || str.length() <= 0 || str == ""){
            return "a";
        }
        return str;
    }



    // 두번째 풀이
    public static String solution2(String new_id){
        String answer = "";

        // 1. new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        new_id = new_id.toLowerCase();

        // 2. new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        new_id = new_id.replaceAll("[^a-z0-9._-]","");

        // 3. new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        new_id = new_id.replaceAll("[.]{2,}",".");

        // 4. new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        new_id = new_id.replaceAll("^[.]|[.]$","");

        // 5. new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if(new_id.isEmpty()){
            new_id = "a";
        }

        // 6. new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        //     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        if(new_id.length() >= 16){
            new_id = new_id.substring(0,15);
            new_id = new_id.replaceAll("[.]$","");
        }

        // 7. new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        if(new_id.length() <= 2){
            while(new_id.length() < 3){
                new_id += new_id.substring(new_id.length()-1);
            }
        }

        answer = new_id;

        return answer;
    }


}

