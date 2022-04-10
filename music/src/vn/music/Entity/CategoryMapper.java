package vn.music.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CategoryMapper implements RowMapper<Categories>{
	public Categories mapRow(ResultSet rs, int row) throws SQLException {
		Categories cate = new Categories();
		cate.setCateId(rs.getInt("cateId"));
		cate.setCateName(rs.getString("cateName"));
		return cate;
	}
}
