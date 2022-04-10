package vn.music.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.music.DAO.ArtistDAO;
import vn.music.DAO.CategoryDAO;
import vn.music.DAO.SongDAO;
import vn.music.Entity.Artists;
import vn.music.Entity.Categories;
import vn.music.Entity.Songs;

@Service
public class HomeServiceImpl implements IHomeService{
	@Autowired(required = true)
	SongDAO songDao;
	public List<Songs> GetDataSong(){
		return songDao.GetDataSong();
	}
	
	@Autowired(required = true)
	CategoryDAO cateDao;
	public List<Categories> GetDataCategory(){
		return cateDao.GetDataCategory();
	}
	
	@Autowired(required = true)
	ArtistDAO artistDao;
	public List<Artists> GetDataArtist(){
		return artistDao.GetDataArtist();
	}
}
