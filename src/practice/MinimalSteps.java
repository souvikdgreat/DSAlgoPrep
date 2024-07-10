package practice;
public class MinimalSteps {
    private static String minimalStep(String str) {
        if (str.length() < 2) return str;
        int ind = 1, maxInd = 0;
        while (2 * ind <= str.length()) {
            if (str.substring(0, ind).equals(str.substring(ind, 2 * ind))) {
                maxInd = ind;
            }
            ind++;
        }
        //System.out.println(str.substring(0,maxInd)+"*"+str.substring(2*maxInd));
        System.out.println("Str "+ str+" maxIndex "+maxInd+" "+str.substring(2 * maxInd));
        String result = minimalStep(str.substring(0, maxInd)) + "*" + str.substring(2 * maxInd);
        System.out.println("result "+ result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(minimalStep("ABABCABABCE"));
//        System.out.println(minimalStep("ABABC"));
//        System.out.println(minimalStep("AB"));
    }

    public static String magicPotion(String str){
        if(str.length()<2){
            return str;
        }
        int index = 1;
        int maxIndex = 0;

        while(2*index <= str.length()){
            if(str.substring(0,index).equals(str.substring(index,2*index))){
                maxIndex = index;
            }
            index ++;
        }

        String result = magicPotion(str.substring(0,maxIndex))+ "*"+  str.substring(2*maxIndex);
        return  result;
    }

}
