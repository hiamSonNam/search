package vn.music.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.music.Entity.Artists;
import vn.music.Entity.Songs;

@Service
public interface IFillSongByArtistService {
	@Autowired
	public List<Songs> GetDataSongByArtistId(int id);
	
	@Autowired
	public Artists GetDataArtistById(int id);
}
