/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.clima.persistence;

import edu.eci.clima.model.WeatherCity;
import edu.eci.clima.persistence.repository.ICityRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

/**
 *
 * @author 2126081
 */
@Component
public class CityRepository implements ICityRepository{
    
    public static List<WeatherCity> cityContainer;

    public static List<WeatherCity> getContainer(){
        if(CityRepository.cityContainer == null)
        CityRepository.cityContainer = new ArrayList<>();
        return CityRepository.cityContainer;
    }
    
    public WeatherCity find(String name) {
        Optional<WeatherCity> answer = CityRepository.getContainer()
            .stream().filter(u -> name.equals(u.getName())).findFirst();
        return answer.isPresent() ? answer.get() : null;
    }
    
    public String save(WeatherCity entity) {
       CityRepository.getContainer().add(entity);
       return entity.getName();
    }
    
}
