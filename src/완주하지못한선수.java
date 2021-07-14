import java.util.HashMap;
import java.util.Map;

public class 완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String,Integer> hash_map = new HashMap<String,Integer>();
        //참가자 해쉬맵 초기화
        for(int i = 0; i < participant.length; i ++){
            if(hash_map.containsKey(participant[i])){
                int cnt = hash_map.get(participant[i]);
                cnt++;
                hash_map.put(participant[i],cnt);
            }
            else{
                hash_map.put(participant[i],1);
            }
        }
		/*
		Completion 배열에 존재하는 키값들이 해쉬맵에 존재하면
		해당 키값의 밸류값들을 -1 하면서 완주 여부를 체크한다.
		*/
        for(int i = 0 ; i < completion.length ; i++){
            if(hash_map.containsKey(completion[i])){
                int value = hash_map.get(completion[i]);
                value -= 1;
                hash_map.put(completion[i],value);
            }
        }
        for(Map.Entry<String,Integer> entry : hash_map.entrySet()){
            if(entry.getValue() != 0){
                answer = entry.getKey();
            }
        }
        return answer;
    }
}
