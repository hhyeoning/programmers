package com.study.programmers.level1;

/**
 * 내적
 * */
public class InnerProduct {

    public static void main(String[] args) {

        InnerProduct innerProduct = new InnerProduct();

        int[] a = {-1,0,1};
        int[] b = {1,0,-1};

        innerProduct.solution(a,b);

    }

    public int solution(int[] a, int[] b) {
        int answer = 0;

        for(int i = 0 ; i < a.length ; i++){
            answer += a[i] * b[i];
        }

        System.out.println("answer == " + answer );

        return answer;
    }
}
