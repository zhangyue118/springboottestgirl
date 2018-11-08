package com.yue.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GirlControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void girlList() throws Exception {
    }

    @Test
    public void girlAdd() throws Exception {
    }

    @Test
    public void girlgGet() throws Exception {
    }

    @Test
    public void girlgUpdate() throws Exception {
    }

    @Test
    public void girlgDelete() throws Exception {
    }

    @Test
    public void girlListbyage() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/girls/age?age=20"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("zhang"));
    }

    @Test
    public void girlTwo() throws Exception {
    }

    @Test
    public void getAge() throws Exception {
    }

}