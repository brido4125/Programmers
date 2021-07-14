import java.util.PriorityQueue;

public class 더맵게 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        int new_dish = 0;
        int first_dish,second_dish;
        //우선순위 큐에 스코빌 배열 새롭게 할당
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0 ;i < scoville.length; i++){
            pq.add(scoville[i]);
        }
        //가장 적은 디쉬가 K보다 작으면 while 루프 반복
        while(pq.peek() < K){
            //모든 디쉬를 다 더해도 K보다 작은경우 -1 리턴 예외처리
            if(pq.size() == 1){
                return -1;
            }
            first_dish = pq.poll();//가장 작은 첫번째 디쉬
            second_dish = pq.poll();//두번째로 작은 디쉬
            new_dish = first_dish + 2*second_dish;
            answer += 1; // 카운팅
            pq.add(new_dish);
        }
        return answer;
    }
}
