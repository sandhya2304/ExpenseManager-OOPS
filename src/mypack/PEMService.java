package mypack;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.SliderUI;

public class PEMService 
{
	
	Repository repo = Repository.getInstance();
	
	Scanner sc = new Scanner(System.in);
	
	private int choice ;
	
	public PEMService() {
		sampleData();
	}
	
	
	public void showMenu()
	{
		
		while(true)
		{
			 menuPrint();
			 
			 switch (choice) {
			case 1:				
				addCategory();
				 pressanyKey();
				break;
			case 2:
				categoryList();
				 pressanyKey();
				break;
			case 3:
				expentry();
				 pressanyKey();
				break;
			case 4:
				expList();
				 pressanyKey();
				break;
			case 5:
				mothlyExpList();
				 pressanyKey();
				break;
			case 6:
				yearlyExpList();
				 pressanyKey();
				break;
			case 7:
				categoryExpList();
				 pressanyKey();
				break;
			case 0:
				System.exit(0);
				break;

			default:
				break;
			}
		}
		
	}
	



	public void menuPrint()
	{
		
		System.out.println("------------ PEM MENU---------------- ");
		System.out.println("1. Add Catgeory ");
		System.out.println("2. Category List ");
		System.out.println("3. Expense Entry ");
		System.out.println("4. Expense List ");
		System.out.println("5. Expense List - Monthly ");
		System.out.println("6. Expense List - Yearly");
		System.out.println("7. Catgeory Expense List ");
		System.out.println("8. Exit ");
		
		System.out.println("---------------------------- ");
		
		System.out.print("Enter your choice: ");
		
		choice = sc.nextInt();
		
		
		
	}
	
	public void addCategory()
	{
		sc.nextLine();
		System.out.print("Enter catgeory name...");		
		String catName = sc.next();
		Category cat = new Category(catName);
		repo.catList.add(cat);
		System.out.println("Catgeory added ");
		
	}
	
	
	public void categoryList()
	{
		System.out.println("Enter  catgeory List...");	
		List<Category> cat = repo.catList;
		
		for(int i=0;i<cat.size();i++)
		{
			Category c = cat.get(i);
			System.out.println((i+1)+" . "+c.getCatName() +" : "+c.getCategoryId());
		}
		
	}
	
	
	public void expList()
	{
		System.out.println("exp List...");	
		List<Expense> exp = repo.expList;
		
		for(int i=0;i<exp.size();i++)
		{
			Expense expense = exp.get(i);
			
			String name = catNameById(expense.getCategoryId());
			
			//String dd = DateUtility.dateToString(expense.getDate());
			
			System.out.println((i+1)+" . "+ name +" : "
			             +expense.getAmt()+" : "+expense.getRemark()+" : "+expense.getDate());
		}
		
		
	}
	
	public String catNameById(Long CatId)
	{
		
		for(Category cat : repo.catList)
		{
			if(cat.getCategoryId().equals(CatId))
			{
				return cat.getCatName();
			}
		}
		return null;
		
	}
	
	
	
	public void expentry()
	{
		System.out.println("Enter category exp entry...");		
		
		//getting category List 
		categoryExpList();
		
		System.out.println("chooes category choice you want to enter expnense ...");
		int catChoice = sc.nextInt();
		
		Category selectCat = repo.catList.get(catChoice-1);
		System.out.println("cat select :"+selectCat.getCatName());
		
		
		System.out.print("Enter Amount :");
		Float amt =sc.nextFloat();
		System.out.println("Enter remark: ");
		
		sc.nextLine();
		String remark = sc.next();
		
		Date date = new Date();
		
		//System.out.println("Enter date .....");
		//String date = sc.nextLine();
		
		//Date dat = DateUtility.stringToDate(date);

		
		//add expense detail in exp object
		Expense exp = new Expense(amt, date, remark, selectCat.getCategoryId());
		
		
		//store exp object in repo
		
		repo.expList.add(exp);
		
		System.out.println("Expense added... ) ");
		
		
	}
	
	
	private void yearlyExpList() {
		// TODO Auto-generated method stub
		
	}


	private void mothlyExpList() {
		// TODO Auto-generated method stub
		
	}
	


	private void categoryExpList() {
		// TODO Auto-generated method stub
		
	}


	
	public void pressanyKey()
	{
		System.out.println("Press any key... to continue....");
		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delay()
	{
		try
		{
			Thread.sleep(10);
		}catch(Exception e)
		{
			
		}
	}
	
	
	public void sampleData()
	{
		Category cat1= new Category("party");
		delay();
		Category cat2= new Category("school");
		delay();
		Category cat3= new Category("tution");
		
		
		repo.catList.add(cat1);
		repo.catList.add(cat2);
		repo.catList.add(cat3);
		
		
		
		//month wise
		Expense exp1 = new Expense(90.0f,DateUtility.stringToDate("12/2/2016"),"party expense", cat1.getCategoryId());
		delay();
		
		Expense exp2 = new Expense(1.0f,DateUtility.stringToDate("1/12/2017"),"school expense", cat2.getCategoryId());
		delay();
		
		Expense exp3 = new Expense(170.0f,DateUtility.stringToDate("1/1/2016"),"party expense", cat1.getCategoryId());
		delay();
		
		Expense exp4 = new Expense(4.0f,DateUtility.stringToDate("6/2/2019"),"tution expense", cat3.getCategoryId());
		delay();
		
		repo.expList.add(exp1);
		repo.expList.add(exp2);
		repo.expList.add(exp3);
		repo.expList.add(exp4);
		
	}

}
