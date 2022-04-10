package vn.music.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.music.DAO.ArtistDAO;
import vn.music.Entity.Artists;

@Service
public class ArtistServiceImpl implements IArtistService{
	
	@Autowired
	ArtistDAO dao;
	
	public List<Artists> GetDataArtistByPaginate(int start, int end) {
		// TODO Auto-generated method stub
		List<Artists> artist = dao.GetDataArtistByPaginate(start, end);
		return artist;
	}
	
}
