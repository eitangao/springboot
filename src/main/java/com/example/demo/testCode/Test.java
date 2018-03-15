package com.example.demo.testCode;



import java.util.ArrayList;
import java.util.List;


/**
 * Author: Yi-tong Gao
 * Date: Created in 22:08 2018/2/28
 * Description:
 * Modified By:
 */
public class Test {
    public static void main(String []args){
        String a[]={"1","2","3"};
        String b[]={"a","b","c","d"};
        String m[]={"5","6"};
        String n[]={"f","a"};
        String result[][]=new String[100][2];
        int count=0;
        for(int i=0;i<a.length;i++){
            for(int j=0;j<b.length;j++){
                result[count][0]=a[i];
                result[count][1]=b[j];
                count++;
            }
        }
        for(int i=0;i<m.length;i++){
            for(int j=0;j<n.length;j++){
                result[count][0]=m[i];
                result[count][1]=n[j];
                count++;
            }
        }
        for(int i=0;i<count;i++)
            System.out.println(result[i][0]+result[i][1]);

        List<Integer> listR=new ArrayList<>();//用来存储各组数据的右边数组的大小,即数组b和n的大小
        int initR=1;
        for(int i=0;i<count;i++){
            if(result[i][0].equals(result[i+1][0])){
                initR++;
            }
            else{
                listR.add(initR);
                initR=1;
            }
        }

        List<String> stringListR=new ArrayList<>();//用来存储右边字符串数组
        //遍历整个result
        int ii=0;
        for(int r:listR){
            StringBuilder sb=new StringBuilder();
            for(int j = 0; j<r; j++)
                sb.append(result[ii++][1]);
            stringListR.add(sb.toString());
        }
        //以上得到的listR数据为44422，stringListR数据为abcd，abcd，abcd，fa，fa
        
        List<Integer> listL=new ArrayList<>();//用来存储左边数组的大小，即数组a和m的大小
        int initL=1;
        for(int i=0;i<listR.size()-1;i++){
            if(listR.get(i).equals(listR.get(i+1)))
                initL++;
            else{
                listL.add(initL);
                initL=1;
            }
            if(i==listR.size()-2)
                listL.add(initL);//为防止数组越界整个循环少做了一次，所以在最后一次循环结束之前再将没加入到listL中的数据加入
        }

        
        // 将存放右边数组大小的数组去重，得到数组b和n的大小,同时去重右边数组，得到数组b和n。
        for(int i=stringListR.size()-1;i>0;i--){
            if(stringListR.get(i).equals(stringListR.get(i-1))){
                listR.remove(i);
                stringListR.remove(i);
            }
        }
        List<String> stringListL=new ArrayList<>();//用来存储左边字符串数组
        int j=0;
        for (Integer l : listL) {
            StringBuilder sb=new StringBuilder();
            for(int kk=0;j<count&&kk<l;j++){
                if(!result[j][0].equals(result[j+1][0])){
                    sb.append(result[j][0]);
                    kk++;
                }
            }
            stringListL.add(sb.toString());
        }
        listL.forEach(System.out::println);
        listR.forEach(System.out::println);
        stringListL.forEach(System.out::println);
        stringListR.forEach(System.out::println);


    }

}
