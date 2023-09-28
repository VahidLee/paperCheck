import java.util.HashSet;
import java.util.Set;

public class CalSimilarity {
    public static double calSimilarity(String content1,String content2){
        //统计相同文本里相同个数的字符
        double count = 0;
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < content1.length(); i++) {
            set.add(content1.charAt(i));
        }
        for (int i = 0; i < content2.length(); i++) {
            if (set.contains(content2.charAt(i))) {
                count++;
            }
        }

        if (content1.length() >= content2.length()) {
            return count / content1.length();
        } else {
            return count/content2.length();
        }

    }

}
