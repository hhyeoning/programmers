package com.study.programmers.level1;


/**
 * 음양 더하기
 * */
public class AddPlusMinus {

    public static void main(String[] args) {

        AddPlusMinus addPlusMinus = new AddPlusMinus();

        int[] absolutes = {1,2,3};
        boolean[] signs = {false,false,true};

        addPlusMinus.solution2(absolutes, signs);

    }

    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for(int i = 0 ; i < absolutes.length ; i++){

            if(signs[i]){
                answer += absolutes[i];
            }else{
                answer -= absolutes[i];
            }
        }

        System.out.println("answer == " + answer);


        return answer;
    }

    public int solution2(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for(int i = 0; i < signs.length ; i++){
            answer += absolutes[i] * (signs[i] ? 1 : -1);
        }

        return answer;
    }

}
