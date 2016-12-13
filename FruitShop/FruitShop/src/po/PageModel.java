package po;

import java.util.List;

public class PageModel<T> {
	
	private int curPage;//待显示页
	
	private int perPageRows;//一页显示的记录数
	
	private int rowCount;//记录总数
	
	private int pageCount;//总页数
	
	private List<T> datas; //总数据

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
