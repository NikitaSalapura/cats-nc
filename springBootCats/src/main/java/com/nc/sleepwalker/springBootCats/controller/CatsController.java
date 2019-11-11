package com.nc.sleepwalker.springBootCats.controller;

import com.nc.sleepwalker.springBootCats.model.Cat;
import com.nc.sleepwalker.springBootCats.model.Sex;
import com.nc.sleepwalker.springBootCats.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CatsController {

    @Autowired
    private CatService catService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getWelcomePage() {
        return "welcome";
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public String getCats(Model model) {
        model.addAttribute("cats", catService.getAll());
        return "getAll";
    }

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
        setParentsInModel(model);
        return "create";
    }

    private void setParentsInModel(Model model) {
        model.addAttribute("mothers", catService.getBySex(Sex.FEMALE));
        model.addAttribute("fathers", catService.getBySex(Sex.MALE));
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String getUpdatePage(@PathVariable("id") int id, Model model) {
//        logger.trace("come to createPage");
        model.addAttribute("cat", catService.getById(id));
        return "create";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id) {
        catService.deleteById(id);
        return "redirect:/getAll";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "hello";
    }
}
