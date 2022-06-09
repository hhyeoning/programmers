package com.study.programmers.level1;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Lv1. 신고 결과 받기
 *
 * */
public class ReceiveReportResult {

    public static void main(String[] args) {

        String[] id_list = {"muzi", "frodo", "apeach", "neo"}; // {"con", "ryan"}	;
        String[] report =  {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}; // {"ryan con", "ryan con", "ryan con", "ryan con"}	;
        int k = 2;

        solution3(id_list, report, k);
        //solution2(id_list, report, k);
        //solution(id_list, report, k);

    }

    public static int[] solution3(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];




        return answer;
    }

    public static int[] solution2(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        // Map<정지Id, 신고한사람set>
        Map<String, HashSet<String>> singoMap = new HashMap<>();
        // Map<유저Id, index>
        Map<String, Integer> idxMap = new HashMap<>();

        // singoMap초기화, idxMap에 id_list 순서 맞춰 세팅
        for(int i = 0; i < id_list.length ; i++){
            idxMap.put(id_list[i],i);
            singoMap.put(id_list[i],new HashSet<>());
        }

        for(String str : report){
            String userId = str.split(" ")[0];
            String stopId = str.split(" ")[1];

            singoMap.get(stopId).add(userId);
        }

        for(int i = 0; i < id_list.length ; i++){
            HashSet<String> send = singoMap.get(id_list[i]);
            if(send.size() >= k){
                for(String name: send){
                    answer[idxMap.get(name)]++;
                }
            }
        }

        return answer;
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        // 1. 정지ID 리스트 만들기
        // 1-1. 중복제거
        List<String> removeIdList = Arrays.asList(report).stream().distinct().collect(Collectors.toList());
        List<String> removeStopIdList = removeIdList.stream().map(m -> m.split(" ")[1]).collect(Collectors.toList());

        // 1-2. 중복제거 리스트에서 신고당한 ID만 중복없이 추출
        List<String> stopIdList = removeStopIdList.stream().distinct().collect(Collectors.toList());

        // 1-3. 신고당한 ID 리스트에서 정지될 ID 추출
        List<String> finalStopIdList = stopIdList.stream()
                .filter(item -> Collections.frequency(removeStopIdList,item) >= k)
                .collect(Collectors.toList());

        // 2. 신고메일 발송한 유저 리스트 만들기
        for(int i = 0; i < id_list.length ; i++){
            String id = id_list[i];
            List<String> resultList =  removeIdList.stream()
                    .filter(item -> item.split(" ")[0].equals(id) && finalStopIdList.contains(item.split(" ")[1]))
                    .collect(Collectors.toList());
            answer[i] = resultList.size();
        }

        return answer;
    }

}
