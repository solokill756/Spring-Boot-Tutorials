package com.springtutorial.springdemo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springtutorial.springdemo.model.Alien;
import com.springtutorial.springdemo.repository.AlenRepo;

@Controller
public class HomeController {

    @Autowired
    AlenRepo repo;

    // @RequestMapping("/")
    // public ModelAndView home() {
    //     ModelAndView mv = new ModelAndView();
    //     mv.setViewName("home");
    //     return mv;
    // }
    // @RequestMapping("/addAlien")
    // public String addAlen(Alien alien) {
    //     repo.save(alien);
    //     System.out.println(1);
    //     return "home";
    // }
    // @RequestMapping("/getAlien")
    // public ModelAndView getAlien(@RequestParam String tech) {
    //     ModelAndView mv = new ModelAndView();
    //     mv.setViewName("home");
    //     List<Alien> aliens = repo.findByTechSorted(tech);
    //     System.out.println(aliens);
    //     return mv;
    // }
    @RequestMapping("/aliens")
    @ResponseBody
    public List<Alien> getAllAlien() {
        return repo.findAll();
    }

    @RequestMapping("/aliens/{aid}")
    @ResponseBody
    public Optional<Alien> getAllAlien(@PathVariable("aid") int aid) {
        return repo.findById(aid);
    }

}
