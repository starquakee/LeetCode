import java.util.PriorityQueue;
import java.util.Stack;

class MinStack {
    Stack<Integer> stack;
    PriorityQueue<Integer> priorityQueue;

    public MinStack() {
        stack = new Stack<>();
        priorityQueue = new PriorityQueue<>();
    }

    public void push(int val) {
        stack.push(val);
        priorityQueue.offer(val);
    }

    public void pop() {
        int temp = stack.pop();
        priorityQueue.remove(temp);
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return priorityQueue.peek();
    }
}