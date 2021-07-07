package midtermreview;

public class MidtermReview {

    public static void main(String[] args) {
        System.out.println("Cipher for: Eric");
        String result = cipher("Eric");
        
        System.out.println(result);
        
        result = " " + result;
        
        String newResult = cipher(result);
        System.out.println(newResult.substring(1));
    }

    public static String cipher(String word) {
        String result = "";
        for (int index = 0; index < word.length(); index++) {
            if (index % 2 == 0) {
                result += (char)(word.charAt(index) + 1);
            } else {
                result += (char)(word.charAt(index) - 1);
            }
        }
        
        return result;
    }

}
