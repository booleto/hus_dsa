import java.util.*;public class Main{static String d;static Scanner s=new Scanner(System.in);public static void main(String[]args){int t=s.nextInt();n();for(int i=0;i<t;i++){d=n();Vector<String>v=new Vector<String>();int e=s.nextInt();n();for(int j=0;j<e;j++)v.add(n());Collections.sort(v,new Comparator<String>(){public int compare(String a,String b){int l=a.length();int k=b.length();for(int i=0;i<l&&i<k;i++){int r=c(a.charAt(i))-c(b.charAt(i));if(r!=0)return r;}return l-k;}});for(String r:v)System.out.println(r);System.out.println();n();}}static int c(char a){for(int i=0;i<d.length();i++)if(a==d.charAt(i))return i;return 0;}static String n(){return s.nextLine();}}