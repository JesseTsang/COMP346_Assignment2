package task1;
import common.UserDefinedException;
/**
 * Class BlockStack
 * Implements character block stack and operations upon it.
 *
 * $Revision: 1.4 $
 * $Last Revision Date: 2016/02/01 $
 *
 * @author Serguei A. Mokhov, mokhov@cs.concordia.ca;
 * Inspired by an earlier code by Prof. D. Probst

 */
class BlockStack
{
	/**
	 * # of letters in the English alphabet + 2
	 */
	public static final int MAX_SIZE = 28;

	/**
	 * Default stack size
	 */
	public static final int DEFAULT_SIZE = 6;

	/**
	 * Current size of the stack
	 */
	private int iSize = DEFAULT_SIZE;

	/**
	 * Current top of the stack
	 */
	private int iTop  = 3;

	/**
	 * stack[0:5] with four defined values
	 */
	private char acStack[] = new char[] {'a', 'b', 'c', 'd', '$', '$'};
	
	//Stack access counter
	private int accessCounter = 0;

	/**
	 * Empty constructor (Default)
	 */
	public BlockStack()
	{
		//Empty Constructor
	}

	/**
	 * Second Constructor: with size parameter
	 */
	public BlockStack(final int piSize)
	{
		if(piSize != DEFAULT_SIZE)
		{
			this.acStack = new char[piSize];

			// Fill in with letters of the alphabet and keep
			// 2 free blocks
			for(int i = 0; i < piSize - 2; i++)
			{
				this.acStack[i] = (char)('a' + i);				
			}
				
			this.acStack[piSize - 2] = this.acStack[piSize - 1] = '$';

			this.iTop = piSize - 3;
			this.iSize = piSize;
		}
	}

	/**
	 * Picks a value from the top without modifying the stack
	 * @return top element of the stack, char
	 * @throws UserDefinedException 
	 */
	public char pick() throws UserDefinedException
	{
		if (isEmpty()== true)
		{
			throw new UserDefinedException("Empty Stack Error.");
		}
		else
		{
			accessCounter++;
			return this.acStack[this.iTop];		
		}	
	}


	/**
	 * Returns arbitrary value from the stack array
	 * @return the element, char
	 * @throws UserDefinedException 
	 */
	public char getAt(final int piPosition) throws UserDefinedException
	{
		accessCounter++;
		if(piPosition <= iSize - 1)
		{	
			return this.acStack[piPosition];	
		}
		else
		{
			throw new UserDefinedException("Out of bound Error. Position smaller than stack size.");
		}	
	}

	/**
	 * Standard push operation
	 * @throws UserDefinedException 
	 */
	public void push(final char pcBlock) throws UserDefinedException
	{
		accessCounter++;
		if(iTop + 1 > iSize)
		{
			throw new UserDefinedException("Error: Stack is currently full. Unable to perform push operation.");	
		}
		else
		{
			this.acStack[++this.iTop] = pcBlock;			
		}
	}

	/**
	 * Standard pop operation
	 * @return ex-top element of the stack, char
	 * @throws UserDefinedException 
	 */
	public char pop() throws UserDefinedException
	{
		accessCounter++;
		if(isEmpty() == false)
		{
			char cBlock = this.acStack[this.iTop];
			this.acStack[this.iTop--] = '$'; // Leave prev. value undefined
			
			return cBlock;	
		}
		else
		{
			throw new UserDefinedException("Error: Stack is currently empty. Unable to perform pop operation.");		
		}	
	}
	
	/**
	 * Check if the stack is empty or not.
	 * @return true if empty; false otherwise
	 */
	public boolean isEmpty()
	{
		return (this.iTop == -1);
	}
	
	public int getITop()
	{
		return iTop;
	}
	
	public int getISize() 
	{
		return iSize;
	}

	public int getAccessCounter() 
	{
		return accessCounter;
	}
}
// EOF