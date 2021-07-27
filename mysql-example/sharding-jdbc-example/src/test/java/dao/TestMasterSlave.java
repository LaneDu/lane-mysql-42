package dao;

import com.galaxy.RunBootApplication;
import com.galaxy.entity.City;
import com.galaxy.repository.CityRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author lane
 * @date 2021年07月21日 下午3:35
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RunBootApplication.class)
public class TestMasterSlave {

    @Autowired
   private  CityRepository cityRepository;

    @Test
    public void testAdd(){
        City city = new City();
        city.setName("shanghai1");
        city.setProvince("shanghai1");
        cityRepository.save(city);
    }

    @Test
    public void testFind(){
        List<City> list = cityRepository.findAll();
        list.forEach(city->{
            System.out.println(city.getId()+" "+city.getName()+" "+city.getProvince());
        });
    }

}
