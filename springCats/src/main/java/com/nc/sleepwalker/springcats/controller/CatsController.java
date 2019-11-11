package com.nc.sleepwalker.springcats.controller;

import com.nc.sleepwalker.springcats.model.Cat;
import com.nc.sleepwalker.springcats.service.CatService;
//import com.sun.org.slf4j.internal.Logger;
//import com.sun.org.slf4j.internal.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CatsController {

    //    private static final Logger logger = Logger.getLogger(HelloWorldController.class);
//    private static final Logger logger = LoggerFactory.getLogger(CatsController.class);

    @Autowired
    private CatService catService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getWelcomePage() {
//            (@RequestParam(required = false, defaultValue = "World") String name, Model model) {
//        model.addAttribute("name", name);
//        System.out.println(catService.getAll());
//        System.out.println(catService.get(1));
//        Cat cat = new Cat();
//        cat.setAge(5);
//        cat.setColor("grey");
//        cat.setNickname("Grasy");
//        cat.setSex(Sex.FEMALE);
//        catService.create(cat);
//        logger.trace("name attribute = {}" + name);
        return "welcome";
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public String getCats(Model model) {
        model.addAttribute("cats", catService.getAll());
        return "getAll";
    }

    //    @RequestMapping(value = "/create", method = RequestMethod.POST)
//    public String createCat(@ModelAttribute("cat") Cat cat) {
//        catService.create(cat);
//        logger.debug("cat was created");
//        return "redirect:/";
//    }
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createCat(@ModelAttribute("cat") Cat cat) {
        if (cat.getId() == 0) {
            catService.create(cat);
//            logger.debug("cat was created");
        } else {
            catService.update(cat);
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String getCreatePage(Model model) {
//        logger.trace("come to createPage");
        model.addAttribute("cat", new Cat());
        return "create";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String getUpdatePage(@PathVariable("id") int id, Model model) {
//        logger.trace("come to createPage");
        model.addAttribute("cat", catService.getById(id));
//        model.addAttribute("cat", new Cat());
        return "create";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id) {
        catService.deleteById(id);
        return "redirect:/getAll";
    }

//    @RequestMapping(value = "/search/{id}", method = RequestMethod.GET)
//    public String search(@PathVariable("id") int id, Model model){
//        List<Cat> cats = new ArrayList<>();
//        cats.add(catService.getById(id));
//        model.addAttribute("cats", cats);
//        return "search";
//    }

}
