package com.yue.controller;

import com.yue.bean.Girl;
import com.yue.bean.Result;
import com.yue.repository.GirlRepository;
import com.yue.service.GirlService;
import com.yue.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class TestController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    @GetMapping(value = "/girls2")
    @ResponseBody
    public List<Girl> girlList(){
        System.out.println("girlList");
        return girlRepository.findAll();
    }

    @GetMapping(value = "/index1")
    public ModelAndView girlListw(){
        //System.out.println("girlList");
        ModelAndView mav=new ModelAndView();
        mav.setViewName("index.html");
        return mav;
    }

    @GetMapping(value = "/index2")
    public String girlListwe(Model model, Integer id1){
       // mav.setViewName("templates/index.html");
        System.out.println(id1+"get");
        model.addAttribute("pageHTML","yue");
        model.addAttribute("message","This is your message");
        model.addAttribute("aaa",id1);
        model.addAttribute("c", new Date());
        Girl girl=girlRepository.findOne(id1);
        model.addAttribute("g",girl);
        List<Girl> prods=girlRepository.findAll();
        model.addAttribute("prods",prods);
        model.addAttribute("url","/index3");
        return "index";
    }

    @PostMapping(value = "/index2")
    public String girlListwesubmit(Model model, Integer id1){
        // mav.setViewName("templates/index.html");
        System.out.println(id1+"post");
        model.addAttribute("pageHTML","yue");
        model.addAttribute("message","This is your message");
        model.addAttribute("aaa",id1);
        model.addAttribute("c", new Date());
        Girl girl=girlRepository.findOne(id1);
        model.addAttribute("g",girl);
        List<Girl> prods=girlRepository.findAll();
        model.addAttribute("prods",prods);
        model.addAttribute("url","/index3");
        return "index";
    }

    @GetMapping(value = "/index3")
    public String girlListwgh(){

        return "test/index2";
    }

    @GetMapping(value = "/index4")
    public String girlListwg444(Model model,Girl girl){
        System.out.println(girl);
        return "test/index2";
    }

    @GetMapping(value = "/index5")
    public String girlListwfgh(){

        return "index";
    }
}
