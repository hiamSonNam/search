package vn.music.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class SongMapper implements RowMapper<Songs>{
	public Songs mapRow(ResultSet rs, int row) throws SQLException {
		Songs song = new Songs();
		song.setSongId(rs.getInt("songId"));
		song.setSongName(rs.getString("songName"));
		song.setSongThumbnail(rs.getString("songThumbnail"));
		song.setSongDuration(rs.getString("songDuration"));
		song.setArtistId(rs.getInt("artistId"));
		song.setCateId(rs.getInt("cateId"));
		song.setSongPath(rs.getString("songPath"));
		song.setArtistName(rs.getString("artistName"));
		song.setCateName(rs.getString("cateName"));
		return song;
	}
}
