package com.slp.util;

import java.util.List;

public class Pager {

	private long offset;	//本页从记录的第几条开始
	private long total;		//总记录条数
	private List list;		//返回的数据队列
	private long pageTotal;	//总页数
	
	public long getOffset() {
		return offset;
	}
	public void setOffset(long offset) {
		this.offset = offset;
	} 
	public long getTotal(){
		return total;
	}
	public void setTotal(long total){
		this.total=total;
	}
	public List getList(){
		return list;
	}
	public void setList(List list){
		this.list=list;
	}
	public long getPageTotal(){
		return pageTotal;
	}
	public void setPageTotal(long pageTotal){
		this.pageTotal=pageTotal;
	}
}