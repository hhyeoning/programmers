package com.study.programmers.level1;

import java.util.*;

/**
 * 완주하지 못한 선수
 * */
public class IncompletePlayer {

    public static void main(String[] args) {

        IncompletePlayer incompletePlayer = new IncompletePlayer();

        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        incompletePlayer.solution(participant, completion);

    }

    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> hashMap = new HashMap<>();
        for(String str : participant){
            int count = 1;
            if(hashMap.containsKey(str)) {
                count = hashMap.get(str) + 1;
            }
            hashMap.put(str,count);
        }

        for(String str : completion){
            if(hashMap.containsKey(str)){
                hashMap.put(str,hashMap.get(str)-1);
            }
        }

        for(String key : hashMap.keySet()){
            if(hashMap.get(key) > 0){
                answer = key;
                break;
            }
        }

        System.out.println("answer == " + answer);

        return answer;
    }


}
