package vn.music.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.music.Entity.Artists;
import vn.music.Entity.Categories;
import vn.music.Entity.Songs;

@Service
public interface IHomeService {
	@Autowired
	public List<Songs> GetDataSong();
	
	@Autowired
	public List<Categories> GetDataCategory();	
	
	@Autowired
	public List<Artists> GetDataArtist();
}
