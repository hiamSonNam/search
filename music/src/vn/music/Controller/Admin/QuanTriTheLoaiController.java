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

import vn.music.DAO.CategoryDAO;
import vn.music.Entity.Categories;
import vn.music.Service.HomeServiceImpl;

@Controller
public class QuanTriTheLoaiController {
	@Autowired
	CategoryDAO ADMIN;

	@Autowired
	HomeServiceImpl service;

//	render list song
	@RequestMapping("/quan-tri/danhSachTheLoai")
	public String listCate(Model m) {
		m.addAttribute("listCate", ADMIN.GetDataCategory());
		return "/admin/theLoai/danhSachTheLoai";
	}

//	them moi du lieu
	@RequestMapping("/quan-tri/taoMoiTheLoai")
	public String addNewCate(@ModelAttribute Categories c, ModelMap m) {
		m.addAttribute("command", c);
		m.addAttribute("cateList", service.GetDataCategory());
		return "/admin/theLoai/taoMoiTheLoai";
	}

//	Luu du lieu
	@RequestMapping(value = "/quan-tri/luuTheLoai", method = RequestMethod.POST)
	public String save(@ModelAttribute("c") Categories c) {
		ADMIN.saveCate(c);
		return "redirect:/quan-tri/danhSachTheLoai";
	}

//	chinh su du lieu
	@RequestMapping(value = {
			"/quan-tri/chinhSuaTheLoai/{id}" }, method = RequestMethod.GET, produces = "application/json")
	public ModelAndView editCate(@PathVariable int id) {
		Categories cate = ADMIN.GetDataCategoryById(id);
		ModelAndView mv = new ModelAndView("/admin/theLoai/chinhSuaTheLoai");
		mv.addObject("command", cate);
		mv.addObject("cateList", service.GetDataCategory());
		return mv;
	}

//	cap nhat du lieu
	@RequestMapping(value = "/quan-tri/chinhSuaTheLoai/editsave", method = { RequestMethod.GET, RequestMethod.POST })
	public String editsave(@ModelAttribute("c") Categories c) {
		ADMIN.updateCate(c);
		return "redirect:/quan-tri/danhSachTheLoai";
	}

//	xoa du lieu
	@RequestMapping(value = "/quan-tri/xoaTheLoai/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {
		ADMIN.deleteCate(id);
		return "redirect:/quan-tri/danhSachTheLoai";
	}
}
