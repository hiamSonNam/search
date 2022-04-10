package vn.music.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.music.Entity.Artists;

@Service
public interface IArtistService {
	public List<Artists> GetDataArtistByPaginate(int start, int end);
}
