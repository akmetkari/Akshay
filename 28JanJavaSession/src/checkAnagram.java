import java.util.Arrays;
import java.util.Scanner;

public class checkAnagram 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		
		char temp1[] = str1.toCharArray();
		char temp2[] = str2.toCharArray();
		
		Arrays.sort(temp1);
		Arrays.sort(temp2);
		
		boolean b = Arrays.equals(temp1, temp2);
		if(b==true)
		{
			System.out.println("Strings are anagram");
		}
		else
		{
			System.out.println("String are not anagram");
			
		}
		sc.close();
	}
}
