package myweb.demo.Repository;

import myweb.demo.Entity.Cars;
import myweb.demo.Model.Model1;
import myweb.demo.Model.Model2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarsRepository extends JpaRepository <Cars,Long> {
    List<Cars> findAllByCarYearAndMarkAndColor(String carYear, String mark,String color);
    List<Cars> findAllByCarYearAndMark(String carYear, String mark);
    List<Cars> findAllByMarkIgnoringCase(String mark);
}
