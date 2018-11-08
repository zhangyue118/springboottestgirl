package com.yue.controller;

import com.yue.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/girl")
public class HelloController {

//    @Value("${girl.cupSize}")
//    private String cupSize;
//
//    @Value("${girl.age}")
//    private Integer age;

//    @Value("${content}")
//    private String content;

    @Autowired
    private GirlProperties girlProperties;

//    @RequestMapping(value="/hello",method = RequestMethod.GET)
    @GetMapping(value = "/hello")
    public String say(@RequestParam(value = "id",required = false,defaultValue = "38") Integer myid){
       // return "hello spring boot!";
        return myid+girlProperties.getCupSize();
    }
}
