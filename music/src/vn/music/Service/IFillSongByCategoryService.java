package vn.music.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.music.Entity.Categories;
import vn.music.Entity.Songs;

@Service
public interface IFillSongByCategoryService {
	@Autowired
	public List<Songs> GetDataSongByCategoryId(int id);
	
	@Autowired
	public Categories GetDataCategoryById(int id);
}
