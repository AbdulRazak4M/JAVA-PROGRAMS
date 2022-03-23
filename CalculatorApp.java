abstract class Value
{
    int a,b;
    void setValue(int x, int y)
    {
        a = x;
        b = y;
    }
    abstract void performCalculation();
}
class Add extends Value{
    void performCalculation()
    {
        System.out.println("Addition:" +  (a+b));
    }
}
public class CalculatorApp
{
    public static void main(String args[])
    {
        Value v = new Add();
        v.setValue(10,20);
        v.performCalculation();
    }
}