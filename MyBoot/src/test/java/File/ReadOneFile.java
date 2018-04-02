package File;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadOneFile {

    //生成文件路径
    private static String path = "d:\\file";
    //源文件夹
    private static String fileFolder="D:/Code/EnEsplise/carcn/WebRoot/WEB-INF/content";
//    private static String fileFolder="D:/fytarget";
//    private static String fileFolder="D:/Code/EnEsplise/carcn/WebRoot/resources/web/js";


    private static String TxtFile="d:/dictiontary/";
    private static List<String> sourceList=new ArrayList<>();
    static {
        sourceList.add("平台服务.txt");
        sourceList.add("平台后台.txt");
        sourceList.add("商务中心纵览.txt");
        sourceList.add("首页.txt");
        sourceList.add("首页下端链接.txt");
        sourceList.add("我要买车.txt");
        sourceList.add("寻车信息.txt");
        sourceList.add("注册页面.txt");
    }


    //private static String TestfilePath="E:\\WorkCode\\SLCode\\CarCode\\carcn\\WebRoot\\WEB-INF\\content\\web\\supplier\\item\\sel-order-list.jsp";
    //默认文件的深度
    private static int depth=1;
    //文件路径+名称
    private static String filenameTemp;
    //源的Map内容
    private static Map sourceMap=new HashMap();



    //翻译来源文件夹
    private static String fySourceFloder="D:/file/";
    private static String fyTargetFloder="C:/Users/Administrator/Desktop/备份数据库/备份页面内容/fycontent/content/";
    private static String fyToFloder="D:/fytarget/";



    public static void main(String[] args) throws  Exception {

        for(String str:sourceList){
            sourceMap= File.MyTools.getSourceMap(TxtFile+str,sourceMap);
        }

        find(fileFolder,depth);






        //翻译内容
//        findFolder(fySourceFloder,1);





//        System.out.println("D:/Code/EnEsplise/carcn/WebRoot/account-cash.jsp".replaceAll("D:/Code/EnEsplise/carcn",""));
//        buildTargetFile(TestfilePath);



    }


    //读取一个文件获取对于的Map内容
    public static void getHaveDoSourceMap(String fileAllPath){
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null; //用于包装InputStreamReader,提高处理性能。因为BufferedReader有缓冲的，而InputStreamReader没有。
        try {
            String str = "";
            String str1 = "";
            fis = new FileInputStream(fileAllPath);// FileInputStream
            // 从文件系统中的某个文件中获取字节
            isr = new InputStreamReader(fis);// InputStreamReader 是字节流通向字符流的桥梁,
            br = new BufferedReader(isr);// 从字符输入流中读取文件中的内容,封装了一个new InputStreamReader的对象
            //单页需要翻译行List
            List<Integer> lineList=new ArrayList<Integer>();
            //单页需要翻译行Map内容
            Map lineMap=new HashMap();
            while ((str = br.readLine()) != null) {
                String[] arr=str.split("   ");
                if(arr.length==2){
                    String line=arr[0],arrStr=arr[1];
                    if(arrStr.indexOf(":")>-1){
                        lineList.add(Integer.parseInt(line));
                        String[] ciArr=arrStr.split("&&");
                        for(String ci:ciArr){
                            if(ci.indexOf(":")>-1){
                                String[] fenciArr=ci.split(":");
                                lineMap.put(fenciArr[0],fenciArr[1]);
                            }
                        }
                    }
                }
            }
            System.err.println(JSON.toJSONString(lineList));
            System.err.println(JSON.toJSONString(lineMap));

            String targetFileIndex=fileAllPath.replaceAll("\\\\","/").replaceAll(fySourceFloder,""),
                        targetFile=targetFileIndex.replaceAll(".txt","");
            System.err.println(fyTargetFloder+targetFile);
            System.err.println("  --->  "+fyToFloder+targetFile);

            fis = new FileInputStream(fyTargetFloder+targetFile);
            // 从文件系统中的某个文件中获取字节
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            int size=1;
            StringBuffer finalBuffer=new StringBuffer();
            while ((str = br.readLine()) != null) {
                //需要翻译的行的内容
                if(lineList.contains(size)){
                    finalBuffer.append(getChineseByLine(str,lineMap));
                }else{
                    finalBuffer.append(str);
                }
                finalBuffer.append("\n");
                size++;
            }

//            将生成最终的文件
            File.MyTools.createFile(fyToFloder+targetFile,finalBuffer.toString());


        } catch (FileNotFoundException e) {
            System.out.println("找不到指定文件");
        } catch (IOException e) {
            System.out.println("读取文件失败");
        } finally {
            try {
                br.close();
                isr.close();
                fis.close();
                // 关闭的时候最好按照先后顺序关闭最后开的先关闭所以先关s,再关n,最后关m
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }




    //遍历对应的目录然后替换相应另外一些文件夹来进行翻译相应的内容
    public static void findFolder(String pathName,int depth)  throws IOException{
        int filecount=0;
        //获取pathName的File对象
        File dirFile = new File(pathName);
        //判断该文件或目录是否存在，不存在时在控制台输出提醒
        if (!dirFile.exists()) {
            System.out.println("do not exit");
            return ;
        }
        //判断如果不是一个目录，就判断是不是一个文件，时文件则输出文件路径
        if (!dirFile.isDirectory()) {
            if (dirFile.isFile()) {
                System.out.println(dirFile.getCanonicalFile());
            }
            return ;
        }

        for (int j = 0; j < depth; j++) {
            System.out.print("  ");
        }
        System.out.print("|--");
        System.out.println(dirFile.getName());
//        System.out.println(dirFile.getPath());
        //获取此目录下的所有文件名与目录名
        String[] fileList = dirFile.list();
        int currentDepth=depth+1;
        for (int i = 0; i < fileList.length; i++) {
            //遍历文件目录
            String string = fileList[i];
            //File("documentName","fileName")是File的另一个构造器
            File file = new File(dirFile.getPath(),string);
            String name = file.getName();
            //如果是一个目录，搜索深度depth++，输出目录名后，进行递归
            if (file.isDirectory()) {
                //递归
                findFolder(file.getCanonicalPath(),currentDepth);
            }else{
                //如果是文件，则直接输出文件名
                for (int j = 0; j < currentDepth; j++) {
                    System.out.print("   ");
                }
                System.out.print("|--");
                System.out.println(name);
                getHaveDoSourceMap(file.getPath());
            }
        }
    }


    public static void buildTargetFile(String fileAllPath,String basefloder){
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null; //用于包装InputStreamReader,提高处理性能。因为BufferedReader有缓冲的，而InputStreamReader没有。
        try {
            String str = "";
            String str1 = "";
            fis = new FileInputStream(fileAllPath);// FileInputStream
            // 从文件系统中的某个文件中获取字节
            isr = new InputStreamReader(fis);// InputStreamReader 是字节流通向字符流的桥梁,
            br = new BufferedReader(isr);// 从字符输入流中读取文件中的内容,封装了一个new InputStreamReader的对象
            int size=1;
            while ((str = br.readLine()) != null) {
                String cStr=getChinese(str);
                if(!StringUtils.isEmpty(cStr)){
                    str1 +=size+"   ";
                    str1 += getChinese(str) + "\n";
                }
                size++;
            }
            //写入文件到指定路径中
            String fName = fileAllPath.trim();
            String temp[] = fName.split("\\\\"); /**split里面必须是正则表达式，"\\"的作用是对字符串转义*/
            String fileName = basefloder+File.separator+temp[temp.length-1];
            System.out.println("fileName = " + fileName);
            createFile(fileName,str1);

        } catch (FileNotFoundException e) {
            System.out.println("找不到指定文件");
        } catch (IOException e) {
            System.out.println("读取文件失败");
        } finally {
            try {
                br.close();
                isr.close();
                fis.close();
                // 关闭的时候最好按照先后顺序关闭最后开的先关闭所以先关s,再关n,最后关m
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    //替换为中文的内容
    public static String getChineseByLine(String paramValue,Map sourceMap) {
        String regex = "([\u4e00-\u9fa5]+)";
        StringBuffer str = new StringBuffer("");
        Matcher matcher = Pattern.compile(regex).matcher(paramValue);
        while (matcher.find()) {
            String matStr=matcher.group(0);
            Object ttr=sourceMap.get(matStr);
            if(ttr!=null){
                paramValue=paramValue.replaceAll(matStr,ttr.toString());
            }
        }
        return paramValue;
    }







    //获取中文的内容
    public static String getChinese(String paramValue) {
        String regex = "([\u4e00-\u9fa5]+)";
        StringBuffer str = new StringBuffer("");
        Matcher matcher = Pattern.compile(regex).matcher(paramValue);
        while (matcher.find()) {
              String matStr=matcher.group(0);
              StringBuffer buffer=new StringBuffer();
              if(sourceMap.get(matStr)!=null){
                  buffer.append(matStr+":"+sourceMap.get(matStr));
              }else{
                  buffer.append(matStr);
              }
              buffer.append("&&");
              str.append(buffer.toString());
        }
        return (str.toString().length()>2)?str.toString().substring(0,str.toString().length()-2):str.toString();
    }


    /**
     * 创建文件
     * @param fileName  文件名称
     * @param filecontent   文件内容
     * @return  是否创建成功，成功则返回true
     */
    public static boolean createFile(String fileName,String filecontent){
        Boolean bool = false;
        filenameTemp = path+fileName+".txt";//文件路径+名称+文件类型
        File file = new File(filenameTemp);
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
        filenameTemp = path+fileName+".txt";
        File file  = new File(filenameTemp);
        try {
            if(file.exists()){
                file.delete();
                bool = true;
            }
        } catch (Exception e) {
        }
        return bool;
    }



    //查找文件夹的内容
    public static void find(String pathName,int depth) throws IOException{
        int filecount=0;
        //获取pathName的File对象
        File dirFile = new File(pathName);
        //判断该文件或目录是否存在，不存在时在控制台输出提醒
        if (!dirFile.exists()) {
            System.out.println("do not exit");
            return ;
        }
        //判断如果不是一个目录，就判断是不是一个文件，时文件则输出文件路径
        if (!dirFile.isDirectory()) {
            if (dirFile.isFile()) {
                System.out.println(dirFile.getCanonicalFile());
            }
            return ;
        }

        for (int j = 0; j < depth; j++) {
            System.out.print("  ");
        }
        System.out.print("|--");
        System.out.println(dirFile.getName());
//        System.out.println(dirFile.getPath());
        //获取此目录下的所有文件名与目录名
        String[] fileList = dirFile.list();
        int currentDepth=depth+1;
        for (int i = 0; i < fileList.length; i++) {
            //遍历文件目录
            String string = fileList[i];
            //File("documentName","fileName")是File的另一个构造器
            File file = new File(dirFile.getPath(),string);
            String name = file.getName();
            //如果是一个目录，搜索深度depth++，输出目录名后，进行递归
            if (file.isDirectory()) {
                //递归
                find(file.getCanonicalPath(),currentDepth);
            }else{
                //如果是文件，则直接输出文件名
                for (int j = 0; j < currentDepth; j++) {
                    System.out.print("   ");
                }
                System.out.print("|--");
                System.out.println(name);
                if(name.indexOf(".jsp")>-1 ||  name.indexOf(".js")>-1 || name.indexOf(".java")>-1){
                    String bastFolder=file.getPath().replaceAll("\\\\","/").replaceAll(fileFolder,"").replaceAll(file.getName(),"");
                    System.out.println("=========="+bastFolder);
                    buildTargetFile(file.getPath(),bastFolder);
                }
            }
        }
    }


}



