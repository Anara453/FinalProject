package myweb.demo.Service;

import myweb.demo.Entity.Cars;
import myweb.demo.Repository.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarsServiceImpl implements CarsService {
    @Autowired
    private CarsRepository carsRepository;

    @Override
    public Cars create(Cars cars) {
        return carsRepository.save(cars);
    }

    @Override
    public Cars getById(Long id) {
        return carsRepository.findById(id).orElse(null);
    }

    @Override
    public Cars deleteById(Long id) {
        Cars cars = getById(id);
        if (cars != null){
            carsRepository.deleteById(id);
        }
        return null;
    }

    @Override
    public List<Cars> getAllByMark(String mark) {
        return carsRepository.findAllByMarkIgnoringCase(mark);
    }

    @Override
    public List<Cars> getAllByMArkByCarYearByColor(String carYear, String mark, String color) {
        return carsRepository.findAllByCarYearAndMarkAndColor(carYear, mark, color);
    }

    @Override
    public List<Cars> getAllByCarYearAndMark(String carYear, String mark) {
        return carsRepository.findAllByCarYearAndMark(carYear, mark);
    }
}
