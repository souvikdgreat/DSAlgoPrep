import java.util.LinkedList;

public class DqueueWithDLL {
    public static void main(String[] args) {
        CustomDqueue customDqueue = new CustomDqueue();
        customDqueue.insertFront(5);


    }
}

class CustomDqueue {
    public LinkedList<Integer> linkedList;

    public void insertFront(int data) {
        linkedList.addFirst(data);
    }

    public void insertRear(int data) {
        linkedList.addLast(data);
    }

    public int deleteFront() {
        return linkedList.removeFirst();
    }

    public int deleteRear() {
        return linkedList.removeLast();
    }

    public int size() {
        return this.linkedList.size();
    }

    public boolean isEmpty() {
        return this.linkedList.isEmpty();
    }

    public void display() {
        System.out.println(linkedList);
    }
}