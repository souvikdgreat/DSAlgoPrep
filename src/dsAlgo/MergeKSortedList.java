package dsAlgo;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedList {
    static class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(int data) {
            this.data = data;
        }

        public Node add(int data) {
            Node newNode = new Node(data);
            this.next = newNode;
            return newNode;
        }
    }

    public static void main(String[] args) {
        //1->2->3->4->5
        //1->7->8
        //3->4->6
        //1->9
        //1->1->1->2->3->3->4->4->5->6->7->8->9


        List<Node> lists = setup();
        Node sortedNodeHead = getSortedList(lists);
        Node temp = sortedNodeHead;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static List<Node> setup() {
        Node l1 = new Node(1);
        l1.add(2).add(3).add(4).add(5);

        Node l2 = new Node(1);
        l2.add(7).add(8);

        Node l3 = new Node(3);
        l3.add(4).add(6);

        Node l4 = new Node(1);
        l4.add(9);

        return List.of(l1, l2, l3, l4);
    }


    public static Node getSortedList(List<Node> sortedLists) {
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;
        PriorityQueue<Node> heap = new PriorityQueue<>(
                Comparator.comparingInt(a -> a.data)
        );
        heap.addAll(sortedLists);

        while (!heap.isEmpty()) {
            Node polledNode = heap.poll();
            temp.next = polledNode;
            temp = temp.next;

            if (polledNode.next != null) {
                heap.add(polledNode.next);
            }
        }
        return dummyNode.next;
    }

}
