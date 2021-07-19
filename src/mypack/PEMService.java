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

}
