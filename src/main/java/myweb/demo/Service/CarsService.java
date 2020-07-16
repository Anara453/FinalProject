package myweb.demo.Service;

import myweb.demo.Entity.Cars;
import myweb.demo.Model.CarsModel;

import java.util.List;

public interface CarsService {
    Cars create(CarsModel carsModel, String email);
    Cars getById (Long id);
    Cars deleteById(Long id);
    List <Cars> getAllByMark(String mark);
    List<Cars> getAllByMArkByCarYearByColor(String carYear, String mark,String color);
    List<Cars> getAllByCarYearAndMark(String carYear, String mark);
}
