/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.clima.service;

import edu.eci.clima.connection.HTTPConnection;
import edu.eci.clima.model.WeatherCity;
import edu.eci.clima.persistence.repository.ICityRepository;
import edu.eci.clima.service.contracts.ICityWeatherService;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author 2126081
 */
@Component
public class CityWeatherService implements ICityWeatherService {
    
    @Autowired
    ICityRepository cityRepository;
    
    @Autowired
    HTTPConnection httpConnection;
    
    
    public String get(String name) {
        String resp = null;
        if (cityRepository.find(name)==null){
            httpConnection.setCity(name);
            try {
                resp = httpConnection.getCityWeather();
                WeatherCity city = new WeatherCity();
                city.setName(name);
                city.setDescription(resp);
                cityRepository.save(city);
            } catch (IOException ex) {
                Logger.getLogger(CityWeatherService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            resp = cityRepository.find(name).getDescription();
        }
        
        return resp;
    }
    
}
