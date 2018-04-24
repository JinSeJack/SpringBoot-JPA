package com.ibike.operator.controller;

import com.ibike.operator.domain.Place;
import com.ibike.operator.domain.Operator;
import com.ibike.operator.service.PlaceService;
import com.ibike.operator.service.OperatorService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/place")
public class PlaceController {

    @Autowired
    PlaceService placeService;
    @Autowired
    OperatorService operatorService;

    @RequestMapping(value = "/getOpPlaces/{operatorId}")
    public List<Place> getContract(@PathVariable int operatorId){

        List<Place> places = null;
        try {
            places = placeService.findAllPlacesByOperatorId(operatorId);
        }catch (Exception e){

        }
        return places;
    }

    @RequestMapping(value = "/addPlace/{name}/{phone}/{id}/{role}/{lat}/{lng}")
    public String save(@PathVariable String name, @PathVariable String phone, @PathVariable int id, @PathVariable String role,@PathVariable double lat, @PathVariable double lng){
        try{
            Operator operator = operatorService.findById(id);
            Place place = new Place(name, LocalDateTime.now(), LocalDateTime.now(), 0, role, operator, lat, lng);
            placeService.save(place);
        }catch (Exception e){
            return e.toString();
        }
        return "add successfully";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable int id){
        try{
            placeService.delete(id);
        }catch (Exception e){
            return e.toString();
        }
        return "add successfully";
    }

    @RequestMapping(value = "/check/{id}")
    public String check(@PathVariable int id){
        try{
            Place c = placeService.getById(id);
            c.setIsChecked(1);
            placeService.save(c);
        }catch (Exception e){
            return e.toString();
        }
        return "add successfully";
    }
}
