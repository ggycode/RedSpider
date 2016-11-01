package com.spider.user.model;

import java.util.List;

public class PageSource {
	private long totalRows = 0; // ��¼����

    private long totalPages = 0; // ��ҳ��

    private int pageSize = 0; // ÿҳ��ʾ����������Ĭ��Ϊ10����¼

    private int currentPage = 0; // ��ǰҳ��

    private boolean hasPrevious = false; // �Ƿ�����һҳ

    private boolean hasNext = false; // �Ƿ�����һҳ
    
    private List list;

	public long getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(long totalRows) {
		this.totalRows = totalRows;
	}

	public long getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(long totalPages) {
		this.totalPages = totalPages;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public boolean isHasPrevious() {
		return hasPrevious;
	}

	public void setHasPrevious(boolean hasPrevious) {
		this.hasPrevious = hasPrevious;
	}

	public boolean isHasNext() {
		return hasNext;
	}

	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}
	
}
