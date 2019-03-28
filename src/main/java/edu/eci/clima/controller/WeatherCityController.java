/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.clima.controller;

import edu.eci.clima.service.contracts.ICityWeatherService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
/**
 *
 * @author 2126081
 */
@RestController
@RequestMapping("/weather")
public class WeatherCityController {
    
    @Autowired
    private ICityWeatherService cityWeatherService;
    
    @GetMapping("/{name}")
    public ResponseEntity<?> getCityWeather(@PathVariable("name") String name){
        System.out.println("namehola");
        try{
            return new ResponseEntity<>(cityWeatherService.get(name), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getStackTrace(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
}
