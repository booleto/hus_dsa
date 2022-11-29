import java.util.Iterator;

import javax.sound.sampled.Line;

public class TestDriver {
    public static void main(String[] args) {
        StackArray<Integer> stackArray = new StackArray<Integer>();
        StackLinkedList<Integer> stackLinkedList = new StackLinkedList<Integer>();
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<Integer>();
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<Integer>();

        System.out.println("Stack arr isEmpty: " + stackArray.isEmpty());
        System.out.println("Stack ll isEmpty: " + stackLinkedList.isEmpty());
        System.out.println("Queue arr isEmpty: " + arrayQueue.isEmpty());
        System.out.println("Queue ll isEmpty: " + linkedListQueue.isEmpty());
        System.out.println();
        
        stackArray.push(10);
        stackLinkedList.push(10);
        arrayQueue.enqueue(10);
        linkedListQueue.enqueue(10);

        stackArray.push(23);
        stackLinkedList.push(23);
        arrayQueue.enqueue(23);
        linkedListQueue.enqueue(23);

        stackArray.push(1234);
        stackLinkedList.push(1234);
        arrayQueue.enqueue(1234);
        linkedListQueue.enqueue(1234);

        System.out.println("Stack arr top: " + stackArray.top());
        System.out.println("Stack ll top: " + stackLinkedList.top());
        System.out.println();

        System.out.println("Stack arr pop: " + stackArray.pop());
        System.out.println("Stack ll pop: " + stackLinkedList.pop());
        System.out.println("Queue arr pop: " + arrayQueue.dequeue());
        System.out.println("Queue ll pop: " + linkedListQueue.dequeue());
        System.out.println();

        Iterator<Integer> stackArrIter = stackArray.iterator();
        Iterator<Integer> stackLLIter = stackLinkedList.iterator();
        Iterator<Integer> queueArrIter = arrayQueue.iterator();
        Iterator<Integer> queueLLIter = linkedListQueue.iterator();

        for (int i = 0; i < 2; i++) {
            System.out.println("s arr iter: " + stackArrIter.next());
            System.out.println("s ll iter: " + stackLLIter.next());
            System.out.println("q arr iter: " + queueArrIter.next());
            System.out.println("q ll iter: " + queueLLIter.next());
            System.out.println();
        }

        System.out.println("q a iter: " + queueArrIter.next());
        System.out.println("q ll iter: " + queueLLIter.next());
    }
}
