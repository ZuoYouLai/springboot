package Excel;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadOneExcel {


    private static String buildFile="d:/dictiontary/";
    private static String sourceFile="C:\\Users\\Administrator\\Desktop\\source\\";
    private static List<String> sourceList=new ArrayList<>();

    static {
        sourceList.add("平台服务.xls");
        sourceList.add("平台后台.xls");
        sourceList.add("商务中心纵览.xls");
        sourceList.add("首页.xls");
        sourceList.add("首页下端链接.xls");
        sourceList.add("我要买车.xls");
        sourceList.add("寻车信息.xls");
        sourceList.add("注册页面.xls");
    }


    private static String path = "E:\\WorkCode\\SLCode\\车网文档\\项目管理\\CAR2CN\\翻译：对应英文\\商务中心.xls";


    public static void main(String[] args) throws  Exception{


        ReadOneExcel obj = new ReadOneExcel();
        for(String str:sourceList){
            File file = new File(sourceFile+str);
            List<String> excelList = obj.readExcelList(file);
            System.out.println(str+"----->"+excelList.size());
            StringBuffer buffer=new StringBuffer();
            for(String sk:excelList){
                buffer.append(sk);
                buffer.append("\n");
            }
            String fstr=MyTools.getFinalName(str).replaceAll(".xls","")+".txt";
            fstr=buildFile+fstr;
            MyTools.createFile(fstr,buffer.toString());
        }
//        File file = new File(path);
//        List excelList = obj.readExcelList(file);
//        System.out.println("list中的数据打印出来");
//        System.out.println(excelList.size());
//        System.out.println(JSON.toJSONString(excelList));


        int k=100;
        //sdasdas






    }
















    // 去读Excel的方法readExcel，该方法的入口参数为一个File对象
    public List<String> readExcelList(File file)  throws  Exception{
        try {
            // 创建输入流，读取Excel
            InputStream is = new FileInputStream(file.getAbsolutePath());
            // jxl提供的Workbook类
            Workbook wb = Workbook.getWorkbook(is);
            // Excel的页签数量
            int sheet_size = wb.getNumberOfSheets();
            List<String> outerList=new ArrayList<String>();
            for (int index = 0; index < sheet_size; index++) {
                // 每个页签创建一个Sheet对象
                Sheet sheet = wb.getSheet(index);
                // sheet.getRows()返回该页的总行数
                for (int i = 0; i < sheet.getRows(); i++) {
                    if(sheet.getColumns()>1 ){
                        String one = sheet.getCell(0, i).getContents(),
                               two = sheet.getCell(1, i).getContents();
                        if(StringUtils.isNotEmpty(one) && StringUtils.isNotEmpty(two))
                                outerList.add(one+"##"+two);
                    }
                }
            }
            return outerList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



}
