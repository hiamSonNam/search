package vn.music.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vn.music.Service.FillSongByCategoryServiceImpl;

@Controller
public class GenreController {
	@Autowired
	private FillSongByCategoryServiceImpl categoryService;
	
	@RequestMapping(value = {"/genre/{id}"}, method = RequestMethod.GET, produces = "application/json")
	public ModelAndView detailsArtist(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("/user/detailsGenre");
		mv.addObject("genre", categoryService.GetDataCategoryById(id));
		mv.addObject("SongByCategory", categoryService.GetDataSongByCategoryId(id));
		return mv;
	}
}
