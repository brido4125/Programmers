import java.util.LinkedList;
import java.util.Queue;

public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        Queue<Integer> required_time_queue = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> answer_list = new LinkedList<>();

        //남은 작업량 나타내는 배열로 바꾸기
        //남은 작업량 / 스피드 -> 필요한 작업일을 가지는 배열
        for(int i = 0; i < progresses.length ; i++){
            progresses[i] = 100 - progresses[i];
            if(progresses[i] % speeds[i] == 0){
                required_time_queue.add((int)(progresses[i] / speeds[i]));
            }
            else{
                required_time_queue.add((int)(progresses[i] / speeds[i] + 1));
            }
        }
        //제일 앞의 작업을 리스트에 추가
        list.add(required_time_queue.poll());
        while(required_time_queue.size() != 0){
            if(required_time_queue.peek() <= list.get(0)){
                list.add(required_time_queue.poll());
            }
            else{
                answer_list.add(list.size());
                list.clear();
                list.add(required_time_queue.poll());
            }
        }
        answer_list.add(list.size());
        answer = new int[answer_list.size()];
        for(int i = 0 ;i < answer.length; i++){
            answer[i] = answer_list.get(i);
        }

        return answer;
    }
}
