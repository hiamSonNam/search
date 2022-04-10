package vn.music.Controller.User;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vn.music.DAO.SongDAO;
import vn.music.DTO.PaginateDTO;
import vn.music.DTO.SearchStringDTO;
import vn.music.Service.ArtistServiceImpl;
import vn.music.Service.HomeServiceImpl;
import vn.music.Service.PaginateServiceImpl;

@Controller
public class HomeController {

	@Autowired
	private HomeServiceImpl service;
	
	@Autowired
	SongDAO dao;
	
	@Autowired
	ArtistServiceImpl aService;
	
	@Autowired
	PaginateServiceImpl pService;

	@RequestMapping(value = { "/", "home" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("/user/index");
		mv.addObject("Songs", service.GetDataSong());
		return mv;
	}

	/*@RequestMapping(value = { "/artist" })
	public ModelAndView artist() {
		ModelAndView mv = new ModelAndView("/user/artist");
		//mv.addObject("Artists", service.GetDataArtist());
		int totalData = service.GetDataArtist().size();
		PaginateDTO p = pService.getInfoPaginate(totalData, 6, 1);
		mv.addObject("p",p);
		mv.addObject("Artists", aService.GetDataArtistByPaginate(p.getStart(), p.getEnd()));
		return mv;
	}*/

	@RequestMapping(value = { "/genre" })
	public ModelAndView genre() {
		ModelAndView mv = new ModelAndView("/user/genre");
		mv.addObject("Categories", service.GetDataCategory());
		return mv;
	}
	
	@RequestMapping(value="/search")
	public ModelAndView Search(SearchStringDTO s) {
	    ModelAndView mav = new ModelAndView("/user/index");
	    return mav;
	}
}
