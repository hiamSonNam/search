package vn.music.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.music.DAO.CategoryDAO;
import vn.music.DAO.SongDAO;
import vn.music.Entity.Categories;
import vn.music.Entity.Songs;

@Service
public class FillSongByCategoryServiceImpl implements IFillSongByCategoryService{
	@Autowired(required = true)
	SongDAO songDao;
	public List<Songs> GetDataSongByCategoryId(int id){
		return songDao.GetDataSongByCategoryId(id);
	}
	
	@Autowired(required = true)
	CategoryDAO cateDao;
	public Categories GetDataCategoryById(int id){
		Categories category = cateDao.GetDataCategoryById(id);
		return category;
	}
}
