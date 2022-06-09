package com.study.programmers.level1;

import java.util.Stack;

/**
 * 크레인 인형뽑기 게임
 *
 * */
public class CranePickUpGame {
    Stack<Integer> answerStack = new Stack<>();


    public static void main(String[] args) {

        CranePickUpGame CPG = new CranePickUpGame();

        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};

        CPG.solution(board, moves);

        // 0 0 0 0 0
        // 0 0 1 0 3
        // 0 2 5 0 1
        // 4 2 4 4 2
        // 3 5 1 3 1

        // board[0][0] = 0
        // board[1][0] = 0
        // board[2][0] = 0
        // board[3][0] = 4
        // board[4][0] = 3
    }

    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        for(int i = 0 ; i < moves.length ; i++){

            int move = moves[i];

            // board 배열에서 숫자 가져오기
            Loop1 :
            for(int j = 0 ; j < board.length ; j++){

                Loop2:
                for(int k = 0 ; k < board.length ; k++){

                    if(move == j+1 && board[k][j] != 0){

                        if(!answerStack.isEmpty() && answerStack.peek() == board[k][j]){
                            answer += 2;
                            answerStack.pop();
                        }else{
                            answerStack.push(board[k][j]);
                        }

                        // 초기화
                        board[k][j] = 0;

                        break Loop1;
                    }
                }
            }
        }

        System.out.println("answer == " + answer);

        return answer;
    }

}
