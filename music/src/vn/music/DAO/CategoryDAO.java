package vn.music.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import vn.music.Entity.Categories;
import vn.music.Entity.CategoryMapper;

public class CategoryDAO {
	@Autowired(required = false)
	JdbcTemplate _jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {    
	    this._jdbcTemplate = jdbcTemplate;    
	}   
	
	public int saveCate(Categories c){    
	    String sql="insert into categories(cateName) "
	    		+ "values('"+c.getCateName()+"')";    
	    return _jdbcTemplate.update(sql);    
	}    
	
	public int updateCate(Categories c){    
	    String sql="update categories set cateName='"+c.getCateName()+"' "
	    		+ " where cateId="+c.getCateId()+"";    
	    return _jdbcTemplate.update(sql);    
	}    
	
	public int deleteCate(int id){    
	    String sql="delete from categories where cateId="+id+"";    
	    return _jdbcTemplate.update(sql);    
	}
	
	public List<Categories> GetDataCategory(){
		List<Categories> list = new ArrayList<Categories>();
		String sql = "SELECT * FROM categories";
		list = _jdbcTemplate.query(sql, new CategoryMapper());
		return list;
	}
	
	public Categories GetDataCategoryById(int id) {
		String sql= "SELECT * FROM categories where cateId=" + id;    
	    return _jdbcTemplate.query(sql, new CategoryMapper()).get(0);
	}
}
