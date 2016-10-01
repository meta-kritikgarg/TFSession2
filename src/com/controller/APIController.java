package com.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.facade.CarFacade;
import com.facade.FacadeFactory;
import com.model.vo.CarVO;
import com.model.vo.Response;


/**
 * 
 * @author Kritik Garg
 *
 */
@RestController
@RequestMapping("/api/v1/")
public class APIController {
	
	ApplicationContext appcoApplicationContext = new AnnotationConfigApplicationContext(FacadeFactory.class);
	CarFacade carfacade = appcoApplicationContext.getBean(CarFacade.class);

	
    @RequestMapping(value = "get/carlist", method = RequestMethod.GET)
    public @ResponseBody Response getCarList() {
        return new Response(carfacade.findAll());
    }
    
    @RequestMapping(value = "get/carlist/{carid}", method = RequestMethod.GET)
    public @ResponseBody Response getCarList(@PathVariable("carid") int carid) {
        return new Response(carfacade.findById(carid));
    }
    
    @RequestMapping(value = "post/carlist", method = RequestMethod.POST)
    public Response createCar(@RequestBody CarVO carvo) {
    	System.out.println(carvo);
    	carvo.setId(-1);
    	boolean x =carfacade.save(carvo);
    	if(x) {
    		return new Response(200,"Created Successfull");
    	} else {
    		return new Response(409, "Some error occor");
    	}    	
    }
    
    @RequestMapping(value = "put/carlist/{carid}", method = RequestMethod.PUT)
    public Response updateCar(@RequestBody CarVO carvo, @PathVariable("carid") int carid) {
    	System.out.println(carvo);
    	carvo.setId(carid);
    	boolean x =carfacade.save(carvo);
    	if(x) {
    		return new Response(200,"Updated Successfull");
    	} else {
    		return new Response(409, "Some error occor ");
    	}    	
    }
    
    @RequestMapping(value = "delete/carlist/{carid}", method = RequestMethod.DELETE)
    public Response updateCar(@PathVariable("carid") int carid) {
    
    	boolean x =carfacade.removeById(carid);
    	if(x) {
    		return new Response(200,"Delete Successfull");
    	} else {
    		return new Response(409, "Some error occor ");
    	}    	
    }
    
 

}
