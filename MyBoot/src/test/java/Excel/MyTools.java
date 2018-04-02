package Excel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class MyTools {


    //获取文件后缀名称
    public static String getFinalName(String fileAllPath){
        String fName = fileAllPath.trim();
        String temp[] = fName.split("\\\\"); /**split里面必须是正则表达式，"\\"的作用是对字符串转义*/
        return temp[temp.length-1];
    }


    /**
     * 创建文件
     * @param fileName  文件名称
     * @param filecontent   文件内容
     * @return  是否创建成功，成功则返回true
     */
    public static boolean createFile(String fileName,String filecontent){
        Boolean bool = false;
        File file = new File(fileName);
        try {
            //如果文件不存在，则创建新的文件
            if(file.exists())
                delFile(fileName);
            System.out.println();
            if(!file.exists()){
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
            bool =true;
            // write
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(filecontent);
            bw.flush();
            bw.close();
            fw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return bool;
    }




    /**
     * 删除文件
     * @param fileName 文件名称
     * @return
     */
    public static boolean delFile(String fileName){
        Boolean bool = false;
        File file  = new File(fileName);
        try {
            if(file.exists()){
                file.delete();
                bool = true;
            }
        } catch (Exception e) {
        }
        return bool;
    }


}
