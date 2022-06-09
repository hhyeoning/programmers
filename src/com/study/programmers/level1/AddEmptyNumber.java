package com.study.programmers.level1;

import java.util.ArrayList;
import java.util.List;

/**
 * 없는 숫자 더하기
 * */
public class AddEmptyNumber {

    public static void main(String[] args) {


        AddEmptyNumber addEmptyNumber = new AddEmptyNumber();

        int[] numbers = {1,2,3,4,6,7,8,0};

        addEmptyNumber.solution(numbers);
        addEmptyNumber.solution2(numbers);

    }

    // 1. List 사용
    public int solution(int[] numbers) {
        int answer = 0;

        List<Integer> intList = new ArrayList<>();
        for(int i = 0; i < 10 ; i++){
            intList.add(i);
        }

        for(Integer item : intList){
            boolean isExist = false;
            for(int itemInt : numbers){
                if(item == itemInt){
                    isExist = true;
                }
            }

            if(!isExist){
                answer += item;
            }
        }

        System.out.println("answer == " + answer);

        return answer;
    }

    public int solution2(int[] numbers) {
        int sum = 45;

        for(int num : numbers){
            sum -= num;
        }

        return sum;
    }
}
