package com.study.programmers.level1;

import java.util.*;

/**
 * 모의고사
 * */
public class Examination {

    int[] personA = {1, 2, 3, 4, 5}; // 5
    int[] personB = {2, 1, 2, 3, 2, 4, 2, 5}; // 8
    int[] personC = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 10

    public static void main(String[] args) {

        Examination exam = new Examination();

        int[] answers = {1,3,2,4,2};
        exam.solution(answers);

    }

    // 두번째 풀이
    public int[] solution2(int[] answers) {
        int[] answer = {};

        int[] personAArr = new int[answers.length];
        int[] personBArr = new int[answers.length];
        int[] personCArr = new int[answers.length];

        // 1. answers 길이만큼 수포자 배열 복사
        for(int i = 1 ; i <= answers.length ; i++){

            // 수포자1
            switch (i % 5){
                case 1 : personAArr[i-1] = personA[0]; break;
                case 2 : personAArr[i-1] = personA[1]; break;
                case 3 : personAArr[i-1] = personA[2]; break;
                case 4 : personAArr[i-1] = personA[3]; break;
                case 0 : personAArr[i-1] = personA[4]; break;
            }

            // 수포자2
            switch (i % 8){
                case 1 : personBArr[i-1] = personB[0]; break;
                case 2 : personBArr[i-1] = personB[1]; break;
                case 3 : personBArr[i-1] = personB[2]; break;
                case 4 : personBArr[i-1] = personB[3]; break;
                case 5 : personBArr[i-1] = personB[4]; break;
                case 6 : personBArr[i-1] = personB[5]; break;
                case 7 : personBArr[i-1] = personB[6]; break;
                case 0 : personBArr[i-1] = personB[7]; break;
            }

            // 수포자3
            switch (i % 10){
                case 1 : personCArr[i-1] = personC[0]; break;
                case 2 : personCArr[i-1] = personC[1]; break;
                case 3 : personCArr[i-1] = personC[2]; break;
                case 4 : personCArr[i-1] = personC[3]; break;
                case 5 : personCArr[i-1] = personC[4]; break;
                case 6 : personCArr[i-1] = personC[5]; break;
                case 7 : personCArr[i-1] = personC[6]; break;
                case 8 : personCArr[i-1] = personC[7]; break;
                case 9 : personCArr[i-1] = personC[8]; break;
                case 0 : personCArr[i-1] = personC[9]; break;
            }

        }

        // 2. 정답수 counting
        HashMap<Integer, Integer> answerCountMap = new HashMap<>();
        answerCountMap.put(1,0);
        answerCountMap.put(2,0);
        answerCountMap.put(3,0);

        for(int i = 0 ; i < answers.length ; i++){

            // 수포자1
            if(answers[i] == personAArr[i]){
                answerCountMap.put(1,answerCountMap.get(1)+1);
            }

            // 수포자2
            if(answers[i] == personBArr[i]){
                answerCountMap.put(2,answerCountMap.get(2)+1);
            }

            // 수포자3
            if(answers[i] == personCArr[i]){
                answerCountMap.put(3,answerCountMap.get(3)+1);
            }
        }

        // 3. answerCountMap 비교
        int [] returnArr = new int[3];
        returnArr[0] = answerCountMap.get(1);
        returnArr[1] = answerCountMap.get(2);
        returnArr[2] = answerCountMap.get(3);

        Arrays.sort(returnArr);
        int answerMaxCount = returnArr[2];

        int idx = 0;
        for(Integer key : answerCountMap.keySet()){
            if(answerCountMap.get(key) == answerMaxCount){
                idx++;
            }
        }

        if(idx != 0){
            answer = new int[idx];
            int index = 0;
            for(Integer key : answerCountMap.keySet()){
                if(answerCountMap.get(key) == answerMaxCount){
                    answer[index] = key;
                    index++;
                }
            }
        }


        return answer;
    }

    // 첫번째 풀이
    public int[] solution(int[] answers) {
        int[] answer = {};

        int[] personAArr = new int[answers.length];
        int[] personBArr = new int[answers.length];
        int[] personCArr = new int[answers.length];

        // 1. answers 길이만큼 수포자 배열 복사
        for(int i = 1 ; i <= answers.length ; i++){

            // 수포자1
            switch (i % 5){
                case 1 : personAArr[i-1] = personA[0]; break;
                case 2 : personAArr[i-1] = personA[1]; break;
                case 3 : personAArr[i-1] = personA[2]; break;
                case 4 : personAArr[i-1] = personA[3]; break;
                case 0 : personAArr[i-1] = personA[4]; break;
            }

            // 수포자2
            switch (i % 8){
                case 1 : personBArr[i-1] = personB[0]; break;
                case 2 : personBArr[i-1] = personB[1]; break;
                case 3 : personBArr[i-1] = personB[2]; break;
                case 4 : personBArr[i-1] = personB[3]; break;
                case 5 : personBArr[i-1] = personB[4]; break;
                case 6 : personBArr[i-1] = personB[5]; break;
                case 7 : personBArr[i-1] = personB[6]; break;
                case 0 : personBArr[i-1] = personB[7]; break;
            }

            // 수포자3
            switch (i % 10){
                case 1 : personCArr[i-1] = personC[0]; break;
                case 2 : personCArr[i-1] = personC[1]; break;
                case 3 : personCArr[i-1] = personC[2]; break;
                case 4 : personCArr[i-1] = personC[3]; break;
                case 5 : personCArr[i-1] = personC[4]; break;
                case 6 : personCArr[i-1] = personC[5]; break;
                case 7 : personCArr[i-1] = personC[6]; break;
                case 8 : personCArr[i-1] = personC[7]; break;
                case 9 : personCArr[i-1] = personC[8]; break;
                case 0 : personCArr[i-1] = personC[9]; break;
            }

        }

        // 2. 정답수 counting
        HashMap<Integer, Integer> answerCountMap = new HashMap<>();
        answerCountMap.put(1,0);
        answerCountMap.put(2,0);
        answerCountMap.put(3,0);

        for(int i = 0 ; i < answers.length ; i++){

            // 수포자1
            if(answers[i] == personAArr[i]){
                answerCountMap.put(1,answerCountMap.get(1)+1);
            }

            // 수포자2
            if(answers[i] == personBArr[i]){
                answerCountMap.put(2,answerCountMap.get(2)+1);
            }

            // 수포자3
            if(answers[i] == personCArr[i]){
                answerCountMap.put(3,answerCountMap.get(3)+1);
            }
        }

        // 3. answerCountMap 비교
        int [] returnArr = new int[3];
        returnArr[0] = answerCountMap.get(1);
        returnArr[1] = answerCountMap.get(2);
        returnArr[2] = answerCountMap.get(3);

        Arrays.sort(returnArr);
        int answerMaxCount = returnArr[2];

        int idx = 0;
        for(Integer key : answerCountMap.keySet()){
            if(answerCountMap.get(key) == answerMaxCount){
                idx++;
            }
        }

        if(idx != 0){
            answer = new int[idx];
            int index = 0;
            for(Integer key : answerCountMap.keySet()){
                if(answerCountMap.get(key) == answerMaxCount){
                    answer[index] = key;
                    index++;
                }
            }
        }


        return answer;
    }

}


