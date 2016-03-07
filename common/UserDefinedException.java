package common;

//A simple user defined exception class that will print out a customed error message.
public class UserDefinedException extends Exception 
{
	public UserDefinedException (String msg)
	{
		super(msg);
	}

}
