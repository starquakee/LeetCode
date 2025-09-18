import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskManager {
    PriorityQueue<int[]> priorityQueue;
    Map<Integer, int[]> map;
    public TaskManager(List<List<Integer>> tasks) {
        map = new HashMap<>();
        priorityQueue = new PriorityQueue<>((a,b)->{
            if(a[2]!=b[2]){
                return b[2]-a[2];
            }
            return b[1]-a[1];
        });
        for(List<Integer> task:tasks){
            int[] temp=new int[]{task.get(0),task.get(1),task.get(2)};
            priorityQueue.add(temp);
            map.put(task.get(1),temp);
        }
    }

    public void add(int userId, int taskId, int priority) {
        int[] temp=new int[]{userId,taskId,priority};
        priorityQueue.add(temp);
        map.put(taskId,temp);
    }

    public void edit(int taskId, int newPriority) {
        int[] temp=map.get(taskId);
        int[] newTemp=new int[]{temp[0],temp[1],newPriority};
        priorityQueue.add(newTemp);
        map.put(taskId,newTemp);
    }

    public void rmv(int taskId) {
        map.remove(taskId);
    }

    public int execTop() {
        if(priorityQueue.isEmpty()){return -1;}
        int[] poll = priorityQueue.poll();
        while (poll!=map.get(poll[1])) {
            if(priorityQueue.isEmpty()){return -1;}
            poll = priorityQueue.poll();
        }
        map.remove(poll[1]);
        return poll[0];
    }
}
