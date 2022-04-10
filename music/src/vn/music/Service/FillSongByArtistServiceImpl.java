package vn.music.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.music.DAO.ArtistDAO;
import vn.music.DAO.SongDAO;
import vn.music.Entity.Artists;
import vn.music.Entity.Songs;

@Service
public class FillSongByArtistServiceImpl implements IFillSongByArtistService{
	@Autowired(required = true)
	SongDAO songDao;
	public List<Songs> GetDataSongByArtistId(int id){
		return songDao.GetDataSongByArtistId(id);
	}
	
	@Autowired(required = true)
	ArtistDAO artistDao;
	public Artists GetDataArtistById(int id){
		Artists artist = artistDao.GetDataArtistById(id);
		return artist;
	}
}
