package mypack;

import java.util.Date;

public class Expense 
{
	
	
	private Long expId = System.currentTimeMillis();
	private Float amt;
	private Date date;
	private String remark;
	
	private Long categoryId;
	
	public Expense() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

	public Expense(Float amt, Date date, String remark, Long categoryId) {
		super();
		this.amt = amt;
		this.date = date;
		this.remark = remark;
		this.categoryId = categoryId;
	}






	public Long getExpId() {
		return expId;
	}

	public void setExpId(Long expId) {
		this.expId = expId;
	}

	public Float getAmt() {
		return amt;
	}

	public void setAmt(Float amt) {
		this.amt = amt;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	
	
	
	
	
	
	

}
