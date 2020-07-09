package myweb.demo.Service;

import myweb.demo.Entity.Cars;
import myweb.demo.Entity.User;
import myweb.demo.Model.CarsModel;
import myweb.demo.Model.Model1;
import myweb.demo.Model.Model2;
import myweb.demo.Repository.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarsServiceImpl implements CarsService {
    @Autowired
    private CarsRepository carsRepository;
    @Autowired
    private UserService userService;

    @Override
    public Cars create(CarsModel carsModel) {
        Cars cars = new Cars();
        User user = userService.getById(carsModel.getUserId());
        cars.setCarYear(carsModel.getCarYear());
        cars.setColor(carsModel.getColor());
        cars.setMark(carsModel.getMark());
        cars.setKorobkaPeredach(carsModel.getKorobkaPeredach());
        cars.setKuzov(carsModel.getKuzov());
        cars.setPrivod(carsModel.getPrivod());
        cars.setRul(carsModel.getRul());
        cars.setVolume(carsModel.getVolume());
        cars.setPrice(carsModel.getPrice());
        cars.setUser(user);
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
    public List<Cars> getAllByMArkByCarYearByColor(String carYear, String mark,String color) {

        return carsRepository.findAllByCarYearAndMarkAndColor(carYear, mark, color);
    }

    @Override
    public List<Cars> getAllByCarYearAndMark(String carYear, String mark) {
        return carsRepository.findAllByCarYearAndMark(carYear, mark);
    }
}
