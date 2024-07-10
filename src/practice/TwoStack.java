package practice;

public class TwoStack {
    int[] arr;
    int size;
    int top1;
    int top2;

    public TwoStack(int size) {
        this.size = size;
        arr = new int[size];
        top1 = size / 2;
        top2 = size - 1;
    }

    public void push1(int data) {
        if (top1 > -1) {
            arr[top1] = data;
            top1--;
        } else {
            System.out.println("stack overflow");
        }
    }

    public void push2(int data) {
        if (top2 > size / 2) {
            arr[top2] = data;
            top2--;
        } else System.out.println("overflow");
    }

    public int pop1() {
        if (top1 + 1 <= size / 2) {
            int temp = arr[top1 + 1];
            arr[top1 + 1] = 0;
            top1++;
            return temp;
        }
        System.out.println("underflow");
        return -1;
    }

    public int pop2() {
        if (top2 + 1 < size) {
            int temp = arr[top2 + 1];
            arr[top2 + 1] = 0;
            return temp;
        } else {
            System.out.println("underflow");
            return -1;
        }

    }

    public void display() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TwoStack twoStack = new TwoStack(5);
        //   twoStack.push1(2);
        // twoStack.push1(1);
        // twoStack.push1(3);

//        twoStack.display();
//        System.out.println("top1 "+twoStack.top1+" top2 "+twoStack.top2);
//        twoStack.push2(2);
//        twoStack.display();
//        System.out.println("top1 "+twoStack.top1+" top2 "+twoStack.top2);
//
//        twoStack.push2(3);
//        twoStack.display();
//        System.out.println("top1 "+twoStack.top1+" top2 "+twoStack.top2);
//
//        twoStack.push2(4);
//        twoStack.display();
//        System.out.println("top1 "+twoStack.top1+" top2 "+twoStack.top2);

//        System.out.println("popped "+twoStack.pop1());
//        System.out.println("popped "+twoStack.pop1());

        System.out.println(twoStack.pop2());
        twoStack.push2(2);
        twoStack.display();
        System.out.println(twoStack.pop2());
        twoStack.display();
    }

}
