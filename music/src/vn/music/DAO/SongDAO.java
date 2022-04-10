package vn.music.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import vn.music.Entity.SongMapper;
import vn.music.Entity.Songs;

public class SongDAO {
	@Autowired(required = false)
	JdbcTemplate _jdbcTemplate;

	String query = "SELECT c.cateName, a.artistName, s.songName, s.songId, s.songThumbnail, s.songDuration, s.artistId, s.cateId, s.songPath FROM artists a, songs s, categories c ";
	String prefixThumb = "music/thumbnails/songThumbnails/";
	String prefixPath = "music/songs/";

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this._jdbcTemplate = jdbcTemplate;
	}

	public int saveSong(Songs s) {
		String sql = "insert into songs(songName, songThumbnail, songDuration, artistId, cateId, songPath) "
				+ "values('" + s.getSongName() + "','" + prefixThumb + s.getSongThumbnail() + "','"
				+ s.getSongDuration() + "','" + s.getArtistId() + "','" + s.getCateId() + "','" + prefixPath
				+ s.getSongPath() + "')";
		return _jdbcTemplate.update(sql);
	}

	public int updateSong(Songs s) {
		String sql = "update songs set songName='" + s.getSongName() + "', songThumbnail='" + prefixThumb
				+ s.getSongThumbnail() + "', songDuration='" + s.getSongDuration() + "', artistId='" + s.getArtistId()
				+ "', cateId='" + s.getCateId() + "', songPath='" + prefixPath + s.getSongPath() + "' "
				+ " where songId=" + s.getSongId() + "";
		return _jdbcTemplate.update(sql);
	}

	public int deleteSong(int id) {
		String sql = "delete from songs where songId=" + id + "";
		return _jdbcTemplate.update(sql);
	}

	public Songs getSongById(int id) {
		String sql = query + "where songId=" + id + "";
		return _jdbcTemplate.query(sql, new SongMapper()).get(0);
	}

	String whereClause = "WHERE s.artistId = a.artistId AND s.cateId = c.cateId ";

	public List<Songs> GetDataSong() {
		List<Songs> list = new ArrayList<Songs>();
		String sql = query + whereClause;
		list = _jdbcTemplate.query(sql, new SongMapper());
		return list;
	}

	public List<Songs> GetDataSongByArtistId(int id) {
		List<Songs> list = new ArrayList<Songs>();
		String sql = query + whereClause + "AND a.artistId=" + id;
		list = _jdbcTemplate.query(sql, new SongMapper());
		return list;
	}

	public List<Songs> GetDataSongByCategoryId(int id) {
		List<Songs> list = new ArrayList<Songs>();
		String sql = query + whereClause + "AND c.cateId=" + id;
		list = _jdbcTemplate.query(sql, new SongMapper());
		return list;
	}

	public List<Songs> GetDataSongBySearchString(String keyWord) {
		List<Songs> list = new ArrayList<Songs>();
		String sql = query + whereClause + "AND MATCH(s.songName) AGAINST('" + keyWord + "')";
		list = _jdbcTemplate.query(sql, new SongMapper());
		return list;
	}
}
