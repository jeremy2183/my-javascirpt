
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
      System.out.print("�п�J�����Ҧr��:");
      s = keyin.readLine();
      
      //�ˬd�����Ҫ��r��(�ϥΥ��h��ܦ�)
       
       s=s.toUpperCase();
       //if(!s.matches("^[A-Z]{1}(1|2)\\d{8}$"))
       if(!s.matches("[A-Z]{1}[1-2]{1}[0-9]{8}"))  
       {
         System.err.println("�����Ҧr���榡���~");
         System.exit(0);
       }
      
      //���r�r�����[�v��  
      c1 = idchk.indexOf(s.charAt(0));
      total = c1/10+(c1%10)*9;
	  
      //total=total+��L�r�����[�v��
	  for(int n=1; n<=8; n++)
	  {
          total += idchk.indexOf(s.charAt(n))*(9-n);
	  }
      //total=total+�̥��r�����[�v��
       total += idchk.indexOf(s.charAt(9));
      
      if(total%10 != 0)
         System.out.println("���O�����Ҧr��");
      else
         System.out.println("�O�����Ҧr��");
   }       
}