package com.sj.controller;

import com.sj.entity.Menu;
import com.sj.entity.MenuVO;
import com.sj.entity.Type;
import com.sj.repository.MenuRepository;
import com.sj.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/menu")
public class MenuHandler {

    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private TypeRepository typeRepository;

    @GetMapping("/findAll/{index}/{limit}")
    public MenuVO findAll(@PathVariable("index") int index,@PathVariable("limit") int limit)
    {
        return  new MenuVO(0,"",menuRepository.count(),menuRepository.findAll(index,limit));
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id)
    {
        menuRepository.deleteById(id);
    }

    @GetMapping("/findTypes")
    public List<Type> findTypes()
    {
        return typeRepository.findAll();
    }

    @PostMapping("/save")
    public void save(@RequestBody Menu menu)
    {
        menuRepository.save(menu);
    }

    @GetMapping("/findById/{id}")
    public Menu findById(@PathVariable("id") Integer id)
    {
        return menuRepository.findById(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody Menu menu)
    {
        menuRepository.update(menu);
    }
}
