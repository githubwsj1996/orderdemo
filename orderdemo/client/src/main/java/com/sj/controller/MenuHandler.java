package com.sj.controller;

import com.sj.entity.Menu;
import com.sj.entity.MenuVO;

import com.sj.feign.MenuFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/menu")
public class MenuHandler {

    @Autowired
    private MenuFeign menuFeign;

    @GetMapping("/redirect/{location}")
    public String redirect(@PathVariable("location") String location)
    {
        return location;
    }

    @GetMapping("/findAll")
    @ResponseBody
    public MenuVO findAll(@RequestParam("page") int page, @RequestParam("limit") int limit)
    {   int index=(page-1)*limit;
        return menuFeign.findAll(index,limit);
    }

    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") Integer id)
    {
        menuFeign.deleteById(id);
        return "redirect:/menu/redirect/menu_manage";
    }



    @GetMapping("/findTypes")
    public ModelAndView findTypes()
    {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("list",menuFeign.findTypes());
        modelAndView.setViewName("menu_add");
        return  modelAndView;
    }

    @PostMapping("/save")
    public String save(Menu menu)
    {
        menuFeign.save(menu);
        return "redirect:/menu/redirect/menu_manage";
    }

    @GetMapping("/findById/{id}")
    public ModelAndView findById(@PathVariable("id") Integer id)
    {
         ModelAndView modelAndView=new ModelAndView();
         modelAndView.addObject("menu",menuFeign.findById(id));
         modelAndView.addObject("list",menuFeign.findTypes());
         modelAndView.setViewName("menu_update");
         return  modelAndView;
    }

    @PostMapping("/update")
    public String update(Menu menu)
    {
        menuFeign.update(menu);
        return  "redirect:/menu/redirect/menu_manage";
    }
}
