package com.study.programmers.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Lv1. 로또의 최고 순위와 최저 순위
 *
 * */
public class LottoWins {

    public static void main(String[] args) {

        int[] lottos =  {44, 1, 0, 0, 31, 25};
        int[] win_nums =  {31, 10, 45, 1, 6, 19};

        solution(lottos, win_nums);

    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int lowRank = 0; // 최저 순위
        int highRank = 0; // 최고 순위
        int lottosZeroCount = 0; // 민우 로또번호 중 0의 개수


        // 1. 로또 당첨 순위 Map 생성 -> Map<당첨개수, 순위>
        Map<Integer, Integer> win_rank = new HashMap<>();
        for(int i = 0 ; i < 6 ; i++){
            win_rank.put(6-i,i+1);
        }
        win_rank.put(0,6);

        win_rank.forEach((key,value) -> {System.out.println("key : " + key + " -> " + value);});

        // 2. 민우 로또번호 중에서 0을 제외한 것들 중 당첨번호가 몇개 있는지 확인 -> 최저 순위번호
        int sameCount = 0;
        for(int i = 0 ; i < win_nums.length ; i++){
            for(int j = 0; j <lottos.length ; j++){
                if(lottos[j] > 0 && win_nums[i] == lottos[j]){
                    sameCount++;
                }
            }
        }

        // 2-1. 민우 로또번호에 0이 몇개 들어있는지
        for(int j = 0; j <lottos.length ; j++){
            if(lottos[j] == 0){
                lottosZeroCount++;
            }
        }

        lowRank = win_rank.get(sameCount);

        // 3. 민우 로또번호에 있는 0개수 + 당첨번호 일치개수 -> 최고 순위번호
        highRank = win_rank.get(lottosZeroCount + sameCount);

        answer[0] = highRank;
        answer[1] = lowRank;


        Arrays.stream(answer)
                .boxed()
                .collect(Collectors.toList())
                .forEach(i -> System.out.println(i));

        return answer;
    }

    private int cal_rank(int num){
        switch (num){
            case 6 : return 1;
            case 5 : return 2;
            case 4 : return 3;
            case 3 : return 4;
            case 2 : return 5;
            default : return 6;
        }
    }
}
