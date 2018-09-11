
import java.io.*;

public class CheckID_AD_OK
{
   public static void main(String[] args) throws IOException
   {
      int c1,c2,total;
      String s;
      String chkid = "0123456789ABCDEFGHJKLMNPQRSTUVXYWZIO"; 
      BufferedReader keyin = new BufferedReader(
                                 new InputStreamReader(System.in));
                                 
      c1=c2=total=0;         
      System.out.print("請輸入身分證字號:");
      s = keyin.readLine();

      if(s.length()!=10)
      {
          System.err.println("長度不正確！");
	      System.exit(0);
   	  }
   	  
      s = s.toUpperCase();
      c1 = chkid.indexOf(s.charAt(0));
      c2 = chkid.indexOf(s.charAt(1));
           
      if(c1<10)
      {
          System.err.println("首字字元不正確！");
          System.exit(0);
      }
      
      if(c2<1 || c2>2)
      {
          System.err.println("性別欄不正確！");
          System.exit(0);
      }
      
      //檢查第3~第10個字元 
      int c;
      for(int n=2; n<=9; n++)
      {
          c=chkid.indexOf(s.charAt(n));
          if(c>9 || c<0)
          {
              System.err.println("字元不正確");
              System.exit(0);
          }
      }        

      
      total = c1/10 + (c1%10)*9;//首字字元的加權值
	  
      //total=total+其他字元的加權值
      for(int n=1; n<9; n++)
      {
        total+=chkid.indexOf(s.charAt(n))*(9-n);     
      }
      total+=chkid.indexOf(s.charAt(9));
      
      if(total%10 != 0)
         System.out.println("不是身分證字號");
      else
         System.out.println("是身分證字號");
   }       
}