package com.uca.capas.controller;

import java.util.List;
import java.util.logging.Logger;
import com.uca.capas.domain.Film;
import com.uca.capas.service.FilmService;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CinemaController {
	static Logger log = Logger.getLogger(MainController.class.getName());
	
	@Autowired
	private FilmService filmService;
	
	@RequestMapping(value = "/dashboard-client", method = RequestMethod.GET)
	public ModelAndView dashboard () {
		ModelAndView dashboard = new ModelAndView();
		
		List<Film> filmList = this.filmService.findAll(0);
		dashboard.addObject("films", filmList);
		dashboard.setViewName("client/client-dashboard");
		
		return dashboard;
	}
	
	@RequestMapping(value = "/film-detail", method = RequestMethod.GET)
	public ModelAndView filmDetail (@RequestParam("id") int id) {
		ModelAndView filmDetail = new ModelAndView();
		
		Film film = this.filmService.findOne(id);
		
		filmDetail.addObject("film", film);
		filmDetail.setViewName("client/film-detail");
		
		return filmDetail;
	}
	
	@RequestMapping(value="/transaction/{id}", method = RequestMethod.GET)
	public ModelAndView transaction (HttpSession session, @PathVariable(value="id") int id, @ModelAttribute(name="transaction") Transaction tran) {
		if(session.getAttribute("user") == null || session.getAttribute("role") == null || session.getAttribute("account_id") == null || (Integer) session.getAttribute("role") != 1) {
			return new ModelAndView("redirect:/");
		}
		
		ModelAndView transaction = new ModelAndView();
		
		transaction.addObject("function", functionService.findAllByFilmId(id));
		transaction.setViewName("client/transaction");
		
		return transaction;
	}
}
