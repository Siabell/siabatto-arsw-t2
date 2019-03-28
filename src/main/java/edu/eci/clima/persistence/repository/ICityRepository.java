/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.clima.persistence.repository;

import edu.eci.clima.model.WeatherCity;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 2126081
 */
@Repository
public interface ICityRepository {
    
    public WeatherCity find(String name);
    public String save(WeatherCity entity);
}
