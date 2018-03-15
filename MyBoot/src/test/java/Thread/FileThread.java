package Thread;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Random;

public class FileThread {

    public static void main(String[] args){

        Long start = System.currentTimeMillis();

        int count = 1000000;//生成数量

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");

        String baseStr = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ;.%$@!()-+?/<>{}[] ";

        //生成文件地址
        File f = new File("D:\\TestFile\\" + formatter.format(System.currentTimeMillis()) + ".txt");

        OutputStreamWriter writer = null;
        BufferedWriter bw = null;

        Random random = new Random();
        try {
            OutputStream os = new FileOutputStream(f);
            writer = new OutputStreamWriter(os);
            bw = new BufferedWriter(writer);
            int i=0;
            while(i<count){
                String str = "";
                StringBuffer buffer=new StringBuffer();
                //每行生成随机个数 max = 50
                int lineSize=random.nextInt(50)+100;
                for (int j = 0; j < lineSize; j++) {
                    int number = random.nextInt(baseStr.length());
//                    char[] charsArr=baseStr.toCharArray();
                    buffer.append(baseStr.charAt(number));
                }
                try {
                    bw.write(buffer.toString()+"\r\n");
                } catch (Exception e) {
                    i--;
                }
                i++;
            }
            bw.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Long end = System.currentTimeMillis();
        System.out.println("bufferedWrite And FileWriterTest's time---------" + (start - end)/1000d);
    }

}
