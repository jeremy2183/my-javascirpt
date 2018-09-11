
import java.io.*;

public class CheckIDFinal_OK
{
   public static void main(String[] args) throws IOException
   {
      int c1,c2,total;
      String s;
      String idchk = "0123456789ABCDEFGHJKLMNPQRSTUVXYWZIO"; 
      BufferedReader keyin = new BufferedReader(
                                 new InputStreamReader(System.in));
      c1=c2=total=0;         
      System.out.print("請輸入身分證字號:");
      s = keyin.readLine();
      
      //檢查身分證的字元(使用正則表示式)
       
       s=s.toUpperCase();
       //if(!s.matches("^[A-Z]{1}(1|2)\\d{8}$"))
       if(!s.matches("[A-Z]{1}[1-2]{1}[0-9]{8}"))  
       {
         System.err.println("身分證字號格式有誤");
         System.exit(0);
       }
      
      //首字字元的加權值  
      c1 = idchk.indexOf(s.charAt(0));
      total = c1/10+(c1%10)*9;
	  
      //total=total+其他字元的加權值
	  for(int n=1; n<=8; n++)
	  {
          total += idchk.indexOf(s.charAt(n))*(9-n);
	  }
      //total=total+最末字元的加權值
       total += idchk.indexOf(s.charAt(9));
      
      if(total%10 != 0)
         System.out.println("不是身分證字號");
      else
         System.out.println("是身分證字號");
   }       
}