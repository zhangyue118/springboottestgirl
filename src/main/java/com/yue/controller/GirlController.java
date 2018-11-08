package com.yue.controller;

import com.yue.bean.Girl;
import com.yue.bean.Result;
import com.yue.repository.GirlRepository;
import com.yue.service.GirlService;
import com.yue.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        System.out.println("girlList");
        return girlRepository.findAll();
    }

    @PostMapping(value = "girladd")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            //return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        return ResultUtil.success(girlRepository.save(girl));
    }

    @GetMapping(value = "girlget/{id}")
    public Girl girlgGet(@PathVariable("id") Integer id){
        return girlRepository.findOne(id);
    }

    @PutMapping(value = "girlupdate/{id}")
    public Girl girlgUpdate(@PathVariable("id") Integer id,
                            @RequestParam("cupSize") String cupSize,
                            @RequestParam("age") Integer age){
        Girl girl=new Girl(cupSize,age);
        girl.setId(id);
        return girlRepository.save(girl);
    }

    @DeleteMapping(value = "girldelete/{id}")
    public void girlgDelete(@PathVariable("id") Integer id){
        girlRepository.delete(id);
    }

    @GetMapping(value = "girls/age")
    public List<Girl> girlListbyage(Integer age){
        return girlRepository.findByAge(age);
    }

    @PostMapping(value = "girl/addtwo")
    public void girlTwo(){
        girlService.insertTwo();
    }

    @GetMapping(value = "girl/getage/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        girlService.getAge(id);
    }

    @GetMapping(value = "/index")
    public ModelAndView girlListw(Integer id1){
        ModelAndView mv = new ModelAndView("test/index2");
        mv.addObject("name",id1);
        return mv;
        //return "index";
    }
}
