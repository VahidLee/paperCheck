import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TxtIO {
    public static String readTxt(String filePath) {
        System.out.println(filePath);
        String html = null;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"));
            String line;
            while ((line = br.readLine()) != null) {
                // 处理每一行的内容
                html =html+line;
            }
            br.close();

        } catch (UnsupportedEncodingException e) {
            System.out.println("文件编码异常");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("文件输入异常");
            throw new RuntimeException(e);
        }

        String result=delHTMLTag(html);
        return result;

    }

    public static String delHTMLTag(String htmlStr){
        String regEx_script="<script[^>]*?>[\\s\\S]*?</script>"; //定义script的正则表达式
        String regEx_style="<style[^>]*?>[\\s\\S]*?</style>"; //定义style的正则表达式
        String regEx_html="<[^>]+>"; //定义HTML标签的正则表达式

        Pattern p_script= Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE);
        Matcher m_script=p_script.matcher(htmlStr);
        htmlStr=m_script.replaceAll(""); //过滤script标签

        Pattern p_style=Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE);
        Matcher m_style=p_style.matcher(htmlStr);
        htmlStr=m_style.replaceAll(""); //过滤style标签

        Pattern p_html=Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE);
        Matcher m_html=p_html.matcher(htmlStr);
        htmlStr=m_html.replaceAll(""); //过滤html标签

        return htmlStr.trim(); //返回文本字符串
    }


    public static void wirteTxt(String fileName,String content){

        try {
            System.out.println(content);
            FileWriter writer = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(content,0,content.length());

            bufferedWriter.close();;
            writer.close();
        }catch (Exception e){
            System.out.println("答案文件写入异常");
        }
    }
}
