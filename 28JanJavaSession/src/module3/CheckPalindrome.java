package module3;

public class CheckPalindrome 
{
	public static void main(String[] args) 
	{
		String st = "abba";
		String rst ="";
		int length = st.length();
		for (int i=length-1;i>=0;i--)
		{
			rst = rst + st.charAt(i);
		}
		
		if (st.equals(rst))
		{
			System.out.println("String is palindrome");
		}
	
		else 
		{
			System.out.println("String is not palindrome");
		}
	}
}
