package vn.music.API.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vn.music.DAO.SongDAO;
import vn.music.Entity.Songs;
import vn.music.Service.FillSongByArtistServiceImpl;
import vn.music.Service.FillSongByCategoryServiceImpl;
import vn.music.Service.HomeServiceImpl;

@RestController
public class SongAPI {
	
	@Autowired
	SongDAO dao;
	
	@Autowired
	private HomeServiceImpl service;

	SongAPI(HomeServiceImpl service) {
	    this.service = service;
	}
	
	@Autowired
	private FillSongByArtistServiceImpl artistService;
	
	@Autowired
	private FillSongByCategoryServiceImpl categoryService;
	
	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
    public ResponseEntity<List<Songs>> listAllSongs() {
        List<Songs> list = service.GetDataSong();
        if(list.isEmpty()){
            return new ResponseEntity<List<Songs>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Songs>>(list, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/nghe-sy={id}", method = RequestMethod.GET)
	public ResponseEntity<List<Songs>> getSongByArtistId(@PathVariable int id) {
        List<Songs> list = artistService.GetDataSongByArtistId(id);
        if(list.isEmpty()){
            return new ResponseEntity<List<Songs>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Songs>>(list, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/the-loai={id}", method = RequestMethod.GET)
	public ResponseEntity<List<Songs>> getSongByCategoryId(@PathVariable int id) {
        List<Songs> list = categoryService.GetDataSongByCategoryId(id);
        if(list.isEmpty()){
            return new ResponseEntity<List<Songs>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Songs>>(list, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/tim-kiem={keyWord}", method = RequestMethod.GET)
	public ResponseEntity<List<Songs>> getSongBySearchString(@PathVariable String keyWord) {
        List<Songs> list = dao.GetDataSongBySearchString(keyWord);
        if(list.isEmpty()){
            return new ResponseEntity<List<Songs>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Songs>>(list, HttpStatus.OK);
    }
}
