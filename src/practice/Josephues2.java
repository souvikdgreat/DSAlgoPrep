package practice;

public class Josephues2 {
    public static void main(String[] args) {
        System.out.println(josh(14,2));
    }


    public static int josh(int n, int k){
        if(n==1){
            return 0;
        }
        return (josh(n-1,k) + k) % n;

    }
}
