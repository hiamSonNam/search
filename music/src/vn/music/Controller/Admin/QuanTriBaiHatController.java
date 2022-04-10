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

import vn.music.DAO.SongDAO;
import vn.music.Entity.Songs;
import vn.music.Service.HomeServiceImpl;

@Controller
public class QuanTriBaiHatController {
	@Autowired
	SongDAO ADMIN;

	@Autowired
	HomeServiceImpl service;

//	render index
	@RequestMapping("/quan-tri/")
	public String showindex() {
		return "/admin/index";
	}

//	render list song
	@RequestMapping("/quan-tri/danhSachBaiHat")
	public String listSong(Model m) {
		m.addAttribute("listSong", ADMIN.GetDataSong());
		return "/admin/baiHat/danhSachBaiHat";
	}

//	them moi du lieu
	@RequestMapping("/quan-tri/taoMoiBaiHat")
	public String addNewSong(@ModelAttribute Songs s, ModelMap m) {
		m.addAttribute("command", s);
		m.addAttribute("artistList", service.GetDataArtist());
		m.addAttribute("cateList", service.GetDataCategory());
		return "/admin/baiHat/taoMoiBaiHat";
	}

//	Luu du lieu
	@RequestMapping(value = "/quan-tri/luuBaiHat", method = RequestMethod.POST)
	public String save(@ModelAttribute("s") Songs s) {
		ADMIN.saveSong(s);
		return "redirect:/quan-tri/danhSachBaiHat";
	}

//	chinh su du lieu
	@RequestMapping(value = {"/quan-tri/chinhSuaBaiHat/{id}"}, method = RequestMethod.GET, produces = "application/json")
	public ModelAndView editSong(@PathVariable int id) {
		Songs song = ADMIN.getSongById(id);
		ModelAndView mv = new ModelAndView("/admin/baiHat/chinhSuaBaiHat");
		mv.addObject("command", song);
		mv.addObject("artistList", service.GetDataArtist());
		mv.addObject("cateList", service.GetDataCategory());
		return mv;
	}

//	cap nhat du lieu
	@RequestMapping(value = "/quan-tri/chinhSuaBaiHat/editsave", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("s") Songs s) {
		ADMIN.updateSong(s);
		return "redirect:/quan-tri/danhSachBaiHat";
	}

//	xoa du lieu
	@RequestMapping(value = "/quan-tri/xoaBaiHat/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {
		ADMIN.deleteSong(id);
		return "redirect:/quan-tri/danhSachBaiHat";
	}
}
