package mypack;



public class Category 
{
	
	private Long categoryId = System.currentTimeMillis();
	private String catName;
	
	public Category() {
		// TODO Auto-generated constructor stub
	}
	
	
	

	public Category(String catName) {
		super();
		this.catName = catName;
	}




	public Category(Long categoryId, String catName) {
		super();
		this.categoryId = categoryId;
		this.catName = catName;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}
	
	
	
	
	
	

}
