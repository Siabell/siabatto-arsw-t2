/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.clima.service.contracts;

import org.springframework.stereotype.Service;

/**
 *
 * @author 2126081
 */
@Service
public interface ICityWeatherService {
    
    public String get(String name);
    
}
