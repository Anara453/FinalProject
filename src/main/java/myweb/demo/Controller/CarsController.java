package myweb.demo.Controller;

import myweb.demo.Entity.Cars;
import myweb.demo.Model.CarsByAll;
import myweb.demo.Service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarsController {
       @Autowired
       private CarsService carsService;
      @PostMapping("/create")
      public Cars create(@RequestBody Cars cars){
          return carsService.create(cars);
      }
      @GetMapping("{id}")
    public Cars getById(@PathVariable Long id){
        return carsService.getById(id);
      }
      @GetMapping("/mark")
    public List<Cars> getAllByMark (@RequestHeader String mark){
          return carsService.getAllByMark(mark);
      }
      @GetMapping("/mark/year")
    public List<Cars> getAllByCarYearAndMark (@RequestBody String carYear, String mark){
     return carsService.getAllByCarYearAndMark(carYear, mark);
      }
      @GetMapping("/carYear/mark/color")
    public List<Cars> getAllByMarkByCarYearAndColor(@RequestBody String carYear, String mark, String color){
          return carsService.getAllByMArkByCarYearByColor(carYear, mark, color);
      }
      @DeleteMapping
      public Cars deleteById(@RequestParam (name = "id") Long id){
          return carsService.deleteById(id);
      }


}
