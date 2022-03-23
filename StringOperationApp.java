abstract class StringOperation
{
    abstract void performOperation(String x);
}
class ConvertToUpper extends StringOperation
{
    public void performOperation(String x)
    {
        char ch[] = x.toCharArray();
        for(int i = 0; i < ch.length; i++)
        {
            if(ch[i] >= 'a' && ch[i] <= 'z')
            {
                // type casting to perform operation in integer and convert to string
                ch[i] = (char) ((int) ch[i]-32);
            }
        }
        x = new String(ch);
        System.out.println("New String is: "+ x);
 
    }
}

class WordReverse extends StringOperation
{
    public void performOperation(String x)
    {
        char ch[] = x.toCharArray();
        int end = ch.length-1;
        for(int  start = 0; start <= end; start++)
        {
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            end--;
        }
        x = new String(ch);
        System.out.println("New String is: "+ x);
    }
}

public class StringOperationApp
{
    public static void main(String args[])
    {
        String x = "This is String";
        StringOperation a = new ConvertToUpper();
        a.performOperation(x);
        a = new WordReverse();
        a.performOperation(x);
    }
}