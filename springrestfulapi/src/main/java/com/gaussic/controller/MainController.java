package com.gaussic.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

@RestController
public class MainController {


    @RequestMapping(value = "/messages",method = RequestMethod.GET)
    public ResponseEntity<ArrayList<String>> GetAll() {
        ArrayList<String> result = new ArrayList<String>(){{
           add("message1");
           add("message2");
           add("message1");
        }};

        return new ResponseEntity<ArrayList<String>>(result,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String Get(){
        return "value";
    }

    @RequestMapping(method = RequestMethod.POST)
    public void Post(String value){

    }

    @RequestMapping(method = RequestMethod.PUT)
    public void Put(Integer id,String value){

    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void Delete(Integer id){

    }


}
