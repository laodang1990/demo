package com.jcloud.cms.common.model;
import java.util.List;

/**
 * @author dyc
 * @date 2015年5月6日下午3:08:09 		
 * @version 1.0
 * @category 分页实体类
 */
public class Paging<T> {

private Integer currentPageNo = 1;
	
	private Integer pageSize = 10;
	
	private Integer totalSize;   //总记录数
	
	private Integer size;		 //当前页记录数
	
	private Integer totalPages;  //总页数
	
	private boolean hasNextPage; //是否有下页
	
	private boolean hasPrevPage; //是否有上页
	
	private List<T> pageList;

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public List<T> getPageList() {
		return pageList;
	}

	public void setPageList(List<T> pageList) {
		this.pageList = pageList;
	}

	public boolean isHasNextPage() {
		this.hasNextPage = (this.getCurrentPageNo() < this.getTotalPages());
	    return this.hasNextPage;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	public boolean isHasPrevPage() {
		this.hasPrevPage = (this.getCurrentPageNo() > 1);
	    return this.hasPrevPage;
	}

	public void setHasPrevPage(boolean hasPrevPage) {
		this.hasPrevPage = hasPrevPage;
	}

	public Integer getCurrentPageNo() {
		return currentPageNo;
	}

	public void setCurrentPageNo(Integer currentPageNo) {
		this.currentPageNo = currentPageNo;
	}

	public Integer getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(Integer totalSize) {
		this.totalSize = totalSize;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}
}
