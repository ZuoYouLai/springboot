package FyFile;

import java.util.ArrayList;
import java.util.List;

public class FileDo {
    public static void main(String[] args) throws  Exception {

        List<Integer> integerList=new ArrayList<Integer>();
        integerList.add(12);
        integerList.add(11);
        integerList.add(1);
        integerList.add(3);

        System.out.println(integerList.contains(11));





        String str="253   订单编号:Order Number&&下单时间:Order Time&&商品:Product&&单价:Unit Price&&总金额:Total Amount&&收货信息:Delivery Information&&供应商:Supplier&&采购商&&状态:Status&&操作:Action";

        String[] arr=str.split("   ");
        if(arr.length==2){
            String line=arr[0],arrStr=arr[1];
            if(arrStr.indexOf(":")>-1){
                String[] ciArr=arrStr.split("&&");
                for(String ci:ciArr){
                    if(ci.indexOf(":")>-1){
                        String[] fenciArr=ci.split(":");
                        System.err.println(fenciArr[0] + "  --->   "+fenciArr[1]);
                    }
                }
            }
        }




//        String path = "d:\\file\\one.txt";
//        File file = new File(path);
//
//        if(!file.exists()){
//            file.getParentFile().mkdirs();
//        }
//        file.createNewFile();
//
//        // write
//        FileWriter fw = new FileWriter(file, true);
//        BufferedWriter bw = new BufferedWriter(fw);
//        bw.write("xxxaffdf");
//        bw.flush();
//        bw.close();
//        fw.close();
//
//        // read
//        FileReader fr = new FileReader(file);
//        BufferedReader br = new BufferedReader(fr);
//        String str = br.readLine();
//        System.out.println(str);
    }
}

