package vn.music.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import vn.music.Entity.ArtistMapper;
import vn.music.Entity.Artists;

public class ArtistDAO {
	@Autowired(required = false)
	JdbcTemplate _jdbcTemplate;
	
	String prefixAvatar = "music/thumbnails/artistThumbnails/";
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {    
	    this._jdbcTemplate = jdbcTemplate;    
	}   
	
	public int saveArtist(Artists a){    
	    String sql="insert into artists(artistName, artistAvatar, artistDoB, artistCountry) "
	    		+ "values('"+a.getArtistName()+"','"+prefixAvatar+a.getArtistAvatar()+"','"+a.getArtistDoB()+"','"+a.getArtistCountry()+"')";    
	    return _jdbcTemplate.update(sql);    
	}    
	
	public int updateArtist(Artists a){    
	    String sql="update artists set artistName='"+a.getArtistName()+"', artistAvatar='"+prefixAvatar+a.getArtistAvatar()+"', artistDoB='"+a.getArtistDoB()+"', artistCountry='"+a.getArtistCountry()+"' "
	    		+ " where artistId="+a.getArtistId()+"";    
	    return _jdbcTemplate.update(sql);    
	}    
	
	public int deleteArtist(int id){    
	    String sql="delete from artists where artistId="+id+"";    
	    return _jdbcTemplate.update(sql);    
	}    
	
	public List<Artists> GetDataArtist() {
		List<Artists> list = new ArrayList<Artists>();
		String sql = "SELECT * FROM artists";
		list = _jdbcTemplate.query(sql, new ArtistMapper());
		return list;
	}
		
	public Artists GetDataArtistById(int id){    
	    String sql= "SELECT * FROM artists where artistId=" + id;    
	    return _jdbcTemplate.query(sql, new ArtistMapper()).get(0);
	}
	
	public List<Artists> GetDataArtistByPaginate(int start, int end){ 
		List<Artists> list = new ArrayList<Artists>();
	    String sql= "SELECT * FROM artists LIMIT " + start + ", " + end;    
	    list = _jdbcTemplate.query(sql, new ArtistMapper());
		return list;
	}
}
