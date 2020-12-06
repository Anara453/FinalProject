package myweb.demo.Controller;

import myweb.demo.Entity.Cars;
import myweb.demo.Model.CarsModel;
import myweb.demo.Model.Model1;
import myweb.demo.Model.Model2;
import myweb.demo.Service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarsController {
       @Autowired
       private CarsService carsService;
      @PostMapping("/create")
      public Cars create(@RequestBody CarsModel cars, Principal principal){
          String login = principal.getName();
          return carsService.create(cars, login);
      }
      @GetMapping("{id}")
    public Cars getById(@PathVariable Long id){
        return carsService.getById(id);
      }
      @GetMapping("/{mark}")
    public List<Cars> getAllByMark (@PathVariable String mark){
          return carsService.getAllByMark(mark);
      }
      @GetMapping("/mark/year")
    public List<Cars> getAllByCarYearAndMark (@RequestBody Model2 model2){
     return carsService.getAllByCarYearAndMark(model2.getCarYear(), model2.getMark());
      }
      @PostMapping("/carYear/mark/color")
    public List<Cars> getAllByMarkByCarYearAndColor(@RequestBody Model1 model){
        return carsService.getAllByMArkByCarYearByColor(model.getCarYear(), model.getMark(), model.getColor());
    }
    @DeleteMapping("{id}")
    public Cars deleteById (@PathVariable Long id){
        return carsService.deleteById(id);
    }

}
