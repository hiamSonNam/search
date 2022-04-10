package vn.music.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ArtistMapper  implements RowMapper<Artists>{
	public Artists mapRow(ResultSet rs, int row) throws SQLException {
		Artists artist = new Artists();
		artist.setArtistId(rs.getInt("artistId"));
		artist.setArtistName(rs.getString("artistName"));
		artist.setArtistAvatar(rs.getString("artistAvatar"));
		artist.setArtistDoB(rs.getString("artistDoB"));
		artist.setArtistCountry(rs.getString("artistCountry"));
		return artist;
	}
}
