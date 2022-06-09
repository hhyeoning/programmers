package com.study.programmers.level1;

import java.util.Arrays;

/**
 * K번째수
 * */
public class KNumber {

    public static void main(String[] args) {

        KNumber kNumber = new KNumber();

        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        //kNumber.solution(array,commands);
        kNumber.solution2(array,commands);

    }

    // 두번째 풀이
    public int[] solution2(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        // 배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수
        for(int i = 0 ; i < commands.length ; i++){
            int[] commandArr = commands[i];

            int startIdx = commandArr[0]-1;
            int endIdx = commandArr[1]-1;
            int count = commandArr[2]-1;

            // 1. 배열 array의 i번째 숫자부터 j번째 숫자까지 자르기
            int[] defaultArr = new int[endIdx - startIdx + 1];
            int idx = 0;
            for(int j = 0; j < array.length ; j++){
                if(startIdx <= j && endIdx >= j){
                    defaultArr[idx] = array[j];
                    idx++;
                }
            }

            // 2. 정렬
            Arrays.sort(defaultArr);

            // 3. k번째 수
            answer[i] = defaultArr[count];

        }


        for(int tmp : answer){
            System.out.println(tmp);
        }

        return answer;
    }

    // 첫번째 풀이
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        // 배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수
        for(int i = 0 ; i < commands.length ; i++){
            int[] commandArr = commands[i];

            int startIdx = commandArr[0]-1;
            int endIdx = commandArr[1]-1;
            int count = commandArr[2]-1;

            // 1. 배열 array의 i번째 숫자부터 j번째 숫자까지 자르기
            int[] defaultArr = new int[endIdx - startIdx + 1];
            int idx = 0;
            for(int j = 0; j < array.length ; j++){
                if(startIdx <= j && endIdx >= j){
                    defaultArr[idx] = array[j];
                    idx++;
                }
            }

            // 2. 정렬
            Arrays.sort(defaultArr);

            // 3. k번째 수
            answer[i] = defaultArr[count];

        }

        for(int tmp : answer){
            System.out.println(tmp);
        }

        return answer;
    }

}
