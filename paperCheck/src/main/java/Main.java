import java.text.DecimalFormat;

public class Main {
    // 从命令行输入的路径名读取对应的文件，将文件的内容转化为对应的字符串

    public static void main(String[] args){
        String path0=args[0];
        String path1=args[1];
        String path2=args[2];
//        System.out.println(path0);
//        System.out.println(path1);
//        System.out.println(path2);
        String content0 = TxtIO.readTxt(path0);
        String content1 = TxtIO.readTxt(path1);
//        System.out.println(content0);
//        System.out.println(content1);

        //控制输出的数值为一位整数和两位小数
        DecimalFormat df = new DecimalFormat("0.00");

        double result = CalSimilarity.calSimilarity(content0,content1);
//        System.out.println(content0.length());
//        System.out.println(content1.length());
//        System.out.println(df.format(result));

        String resultStirng="文件相似度："+df.format(result);
        TxtIO.wirteTxt(path2,resultStirng);
    }

}
