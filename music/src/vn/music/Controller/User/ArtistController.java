package vn.music.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vn.music.DAO.SongDAO;
import vn.music.DTO.PaginateDTO;
import vn.music.Service.ArtistServiceImpl;
import vn.music.Service.FillSongByArtistServiceImpl;
import vn.music.Service.HomeServiceImpl;
import vn.music.Service.PaginateServiceImpl;
@Controller
public class ArtistController {
	@Autowired
	private FillSongByArtistServiceImpl artistService;
	
	@Autowired
	private HomeServiceImpl service;
	
	@Autowired
	ArtistServiceImpl aService;
	
	@Autowired
	PaginateServiceImpl pService;
	
	@RequestMapping(value = {"/artist/{currentPage}/{id}"}, method = RequestMethod.GET, produces = "application/json")
	public ModelAndView detailsArtist(@PathVariable int id, @PathVariable String currentPage) {
		ModelAndView mv = new ModelAndView("/user/detailsArtist");
		mv.addObject("artistId", id);
		mv.addObject("artistInfo", artistService.GetDataArtistById(id));
		mv.addObject("SongByArtist", artistService.GetDataSongByArtistId(id));
		return mv;
	}
	
	@RequestMapping(value = { "/artist/{currentPage}" })
	public ModelAndView artist(@PathVariable String currentPage) {
		ModelAndView mv = new ModelAndView("/user/artist");
		int totalData = service.GetDataArtist().size();
		PaginateDTO p = pService.getInfoPaginate(totalData, 6, Integer.parseInt(currentPage));
		mv.addObject("p",p);
		mv.addObject("Artists", aService.GetDataArtistByPaginate(p.getStart(), p.getEnd()));
		return mv;
	}
	
	
}
