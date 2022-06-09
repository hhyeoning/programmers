package com.study.programmers.level1;

/**
 * 소수 만들기
 * */
public class MakePrimeNumber {

    public static void main(String[] args) {

        MakePrimeNumber makePrimeNumber = new MakePrimeNumber();

        int[] nums = {1,2,7,6,4};

        makePrimeNumber.solution(nums);

    }

    public int solution(int[] nums) {
        int answer = 0;

        for(int i = 0 ; i < nums.length ; i++){
            for(int j = i+1 ; j < nums.length ; j++){
                for(int k = j+1 ; k < nums.length ; k++){

                    int sum = nums[i] + nums[j] + nums[k];

                    // 자기자신을 나눈게 아닌데 나머지가 0인 경우 -> 소수x
                    boolean isPrimeNumber = false;
                    for(int g = 2 ; g <= sum ; g++){

                        if(sum%g == 0 && g != sum){
                            isPrimeNumber = true;
                        }
                    }

                    if(!isPrimeNumber){
                        answer++;
                    }
                }
            }
        }

        System.out.println("answer == " + answer );

        return answer;
    }
}
