package com.study.programmers.level1;

/**
 * 키패드 누르기
 * */
public class PushKeyPad {

    int[] leftNow = {3,0};    // 왼손 현재 위치 좌표
    int[] rightNow = {3,2};   // 오른손 현재 위치 좌표

    // 키패드 좌표 생성
    int[][] keyPadArr = new int[][]{
            {3,1},               // 0
            {0,0},{0,1},{0,2},   // 1,2,3
            {1,0},{1,1},{1,2},   // 4,5,6
            {2,0},{2,1},{2,2}    // 7,8,9
    };

    String hand;

    public String solution(int[] numbers, String hand) {
        String answer = "";

        this.hand = hand.equals("right") ? "R" : "L";

        for(int i = 0 ; i < numbers.length ; i++){

            String useHand = getUseHand(numbers[i]);
            answer += useHand;

            if(useHand.equals("L")) leftNow = keyPadArr[numbers[i]];
            if(useHand.equals("R")) rightNow = keyPadArr[numbers[i]];

        }
        return answer;
    }

    public String getUseHand(int pushKeyNum){
        if(pushKeyNum == 1 || pushKeyNum == 4 || pushKeyNum == 7) return "L";
        if(pushKeyNum == 3 || pushKeyNum == 6 || pushKeyNum == 9) return "R";

        if (getDistance(leftNow,keyPadArr[pushKeyNum]) > getDistance(rightNow,keyPadArr[pushKeyNum])) return "R";
        if (getDistance(leftNow,keyPadArr[pushKeyNum]) < getDistance(rightNow,keyPadArr[pushKeyNum])) return "L";

        return this.hand;
    }

    public int getDistance(int[] handArr, int[] keyPadArr){
        return Math.abs(handArr[0] - keyPadArr[0]) + Math.abs(handArr[1] - keyPadArr[1]);
    }

}

