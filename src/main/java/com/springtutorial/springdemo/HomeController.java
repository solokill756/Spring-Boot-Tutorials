package com.springtutorial.springdemo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springtutorial.springdemo.model.Alien;
import com.springtutorial.springdemo.repository.AlenRepo;

@RestController
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
    @GetMapping("/aliens")
    public List<Alien> getAllAlien() {
        return repo.findAll();
    }

    @PostMapping("/addalien")
    public Alien addAlien(@RequestBody Alien alien) {
        //TODO: process POST request
        repo.save(alien);
        return alien;
    }

    @GetMapping("/aliens/{aid}")
    public Optional<Alien> getAllAlien(@PathVariable("aid") int aid) {
        return repo.findById(aid);
    }

    @DeleteMapping("/DeleteAlien/{aid}")
    public String deletAlien(@PathVariable("aid") int aid) {
        repo.deleteById(aid);
        return "Delete Success";
    }

    @PutMapping("/alien")
    public Alien SaveOrUppdateAlien(@RequestBody Alien alien) {
        //TODO: process PUT request
        repo.save(alien);
        return alien;
    }

}
