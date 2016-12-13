package dao;

import java.util.List;

public interface ICommonDao<T> {
	public void save(T t);
	public void delete(T t);
	public T queryById(Integer id);
	public List<T> queryAll();
	public void update(T t);
	public List<T> queryByPage(int start,int max);
	public List<T> queryByCondition(int start,int max,String ... values); 
	public int totalRows();
}
