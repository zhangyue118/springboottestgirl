package com.yue.service;

import com.yue.bean.Girl;
import com.yue.enums.ResultEnum;
import com.yue.exception.GirlException;
import com.yue.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo(){

        Girl girla=new Girl();
        girla.setCupSize("A");
        girla.setAge(20);
        girlRepository.save(girla);

        Girl girlb=new Girl();
        girlb.setCupSize("EBBB");
        girlb.setAge(21);
        girlRepository.save(girlb);

    }

    public void getAge(Integer id) throws Exception {
        Girl girl=girlRepository.findOne(id);
        Integer age=girl.getAge();
        if(age<18){
            //你还在上高中吧
            throw new GirlException(ResultEnum.GAOZHONG);
        }else if(age>=18&&age<22){
            //你还在上大学吧
            throw new GirlException(ResultEnum.DAXUE);
        }else
            throw new GirlException(ResultEnum.BIYE);
    }

    public Girl findOne(Integer id){
        return girlRepository.findOne(id);
    }
}
