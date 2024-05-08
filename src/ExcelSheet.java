public class ExcelSheet {
    public static void main(String[] args) {
        int columnNumber = 701;
        System.out.println(convertToTitle(columnNumber));
    }

    public static String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();

        while (n > 0) {
            n--;
            char ch = (char) ('A' + n % 26);
            result.insert(0, ch);
            n /= 26;
        }

        return result.toString();
    }
}
