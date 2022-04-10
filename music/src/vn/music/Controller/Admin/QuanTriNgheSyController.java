package vn.music.Controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vn.music.DAO.ArtistDAO;
import vn.music.Entity.Artists;
import vn.music.Service.HomeServiceImpl;

@Controller
public class QuanTriNgheSyController {
	@Autowired
	ArtistDAO ADMIN;
	
	@Autowired
	HomeServiceImpl service;

//	render list song
	@RequestMapping("/quan-tri/danhSachNgheSy")
	public String listẢtist(Model m) {
		m.addAttribute("listArtist", ADMIN.GetDataArtist());
		return "/admin/ngheSy/danhSachNgheSy";
	}

//	them moi du lieu
	@RequestMapping("/quan-tri/taoMoiNgheSy")
	public String addNewArtist(@ModelAttribute Artists a, ModelMap m) {
		m.addAttribute("command", a);
		m.addAttribute("artistList", service.GetDataArtist());
		return "/admin/ngheSy/taoMoiNgheSy";
	}

//	Luu du lieu
	@RequestMapping(value = "/quan-tri/luuNgheSy", method = RequestMethod.POST)
	public String save(@ModelAttribute("a") Artists a) {
		ADMIN.saveArtist(a);
		return "redirect:/quan-tri/danhSachNgheSy";
	}

//	chinh su du lieu
	@RequestMapping(value = {"/quan-tri/chinhSuaNgheSy/{id}"}, method = RequestMethod.GET, produces = "application/json")
	public ModelAndView editArtist(@PathVariable int id) {
		Artists artist = ADMIN.GetDataArtistById(id);
		ModelAndView mv = new ModelAndView("/admin/ngheSy/chinhSuaNgheSy");
		mv.addObject("command", artist);
		mv.addObject("artistList", service.GetDataArtist());
		return mv;
	}

//	cap nhat du lieu
	@RequestMapping(value = "/quan-tri/chinhSuaNgheSy/editsave", method = {RequestMethod.GET,RequestMethod.POST})
	public String editsave(@ModelAttribute("a") Artists a) {
		ADMIN.updateArtist(a);
		return "redirect:/quan-tri/danhSachNgheSy";
	}

//	xoa du lieu
	@RequestMapping(value = "/quan-tri/xoaNgheSy/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {
		ADMIN.deleteArtist(id);
		return "redirect:/quan-tri/danhSachNgheSy";
	}
}
