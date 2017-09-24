package cn.com.user.pojo;

public class PagetionVo {
	private int pagesize;//每页数目
	private int pagetatle;//总页数
	private int startcount;//开始位置
	private int endcount;//结束位置
	private int thispage;//当前页数
	public int getPagesize() {
		return pagesize;
	}
	public int getPagetatle() {
		return pagetatle;
	}
	public void setPagetatle(int pagetatle) {
		int num=pagetatle/this.pagesize;
		int num1=pagetatle%this.pagesize;
		if(num1>0){
			num++;
		}
		this.pagetatle = num;
	}
	public String getStartcount() {
		this.startcount=(this.thispage-1)*this.pagesize+1;
		return String.valueOf(startcount);
	}
	public void setStartcount(int startcount) {
		this.startcount = startcount;
	}
	public String getEndcount() {
		this.endcount=this.thispage*this.pagesize;
		return String.valueOf(endcount);
	}
	public void setEndcount(int endcount) {
		this.endcount = endcount;
	}
	public int getThispage() {
		return thispage;
	}
	public void setThispage(int thispage) {
		if(thispage<1){
			this.thispage = 1;
		}
		if(thispage>this.pagetatle){
			this.thispage = this.pagetatle;
		}
		this.thispage=thispage;
	}
	public PagetionVo() {
		super();
		// TODO Auto-generated constructor stub
		this.pagesize=10;
		this.thispage=1;
	}
//	获取页面分页参数
	public void setpage(String page){
		switch (page) {
//		上一页
		case "上":
			this.setThispage(this.thispage-1);
			break;
//			下一页
		case "下":
			this.setThispage(this.thispage+1);
			break;
//		其他页面参数
		default:
			this.setThispage(Integer.valueOf(page));
			break;
		}
	}
	
	
}
