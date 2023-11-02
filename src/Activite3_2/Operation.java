package Activite3_2;
import java.io.Serializable;
public class Operation implements Serializable{
	
	private int op1,op2,result;
	private char op ; //'+','-','+'*','/'
	
	public Operation (int op1, int op2,char op)
	{
		this.op1=op1;
		this.op2=op2;
		this.op=op;
	}
	public int getOp1()
	{
		return (op1);
	}
	public int getOp2()
	{
		return (op2);
	}
	public char getOp()
	{
		return (op);
	}
	public int getResult()
	{
		return (result);
	}
	public void setResult (int result)
	{
		 this.result=result;
	}
	
}
