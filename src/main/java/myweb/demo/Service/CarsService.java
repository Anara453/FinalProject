package myweb.demo.Service;

import myweb.demo.Entity.Cars;
import myweb.demo.Model.CarsModel;
import myweb.demo.Model.Model1;
import myweb.demo.Model.Model2;


import java.util.List;

public interface CarsService {
    Cars create(CarsModel carsModel);
    Cars getById (Long id);
    Cars deleteById(Long id);
    List <Cars> getAllByMark(String mark);
    List<Cars> getAllByMArkByCarYearByColor(String carYear, String mark,String color);
    List<Cars> getAllByCarYearAndMark(String carYear, String mark);
}
