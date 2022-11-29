import java.util.*;
import java.io.*;
public class Unformatted{

    static Scanner s;
    public static void main(String[]a){
        try{
            s=new Scanner(new File("input.txt"));
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        int[]c=new int[300];
        int t=s.nextInt();n();
        for(int i=0;i<t;i++) {
            char[]d=n().toCharArray();
            for(int j=0;j<d.length;j++)c[d[j]]=(char)j;
            
            Vector<String>v = new Vector<String>();
            int e=s.nextInt();n();
            for(int j=0;j<e;j++) {
                v.add(n());
            }
            Collections.sort(v,new Comparator<String>(){
                public int compare(String a,String b){
                    int l=a.length();int k=b.length();
                    for(int i=0;i<l&&i<k;i++) {
                    int r=c[a.charAt(i)]-c[b.charAt(i)];
                    if(r!=0)return r;
                    }
                    return l-k;
                }
            });
            for(String r:v)System.out.println(r);
            System.out.println();
            n();
        }
    }
    static String n(){return s.nextLine();}
}