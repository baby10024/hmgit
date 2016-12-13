package cn.hm.fruitshop.model;

import java.util.List;

public class PageModel<T> {
	
	private int curPage;//����ʾҳ
	
	private int perPageRows;//һҳ��ʾ�ļ�¼��
	
	private int rowCount;//��¼����
	
	private int pageCount;//��ҳ��
	
	private List<T> datas; //������

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getPerPageRows() {
		return perPageRows;
	}

	public void setPerPageRows(int perPageRows) {
		this.perPageRows = perPageRows;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	
	
	

}
