package mypack;

import java.util.ArrayList;
import java.util.List;

/*
 * 
 * 
 * used as database repository
 */

public class Repository 
{
	
	
	public List<Expense> expList = new ArrayList<>();
	
	public List<Category> catList  = new ArrayList<>();
	
	private static Repository repo;
	
	
	private Repository(){}
	
	
	//singleton class
	public static Repository getInstance()
	{
		if(repo == null)
		{
		  return new Repository();
		}
		return repo;
		
	}

}
