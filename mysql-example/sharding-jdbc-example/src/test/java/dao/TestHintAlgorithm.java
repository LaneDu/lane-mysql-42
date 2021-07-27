package dao;

import com.galaxy.RunBootApplication;
import com.galaxy.entity.City;
import com.galaxy.repository.CityRepository;
import org.apache.shardingsphere.api.hint.HintManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lane
 * @date 2021年07月21日 下午4:52
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RunBootApplication.class)
public class TestHintAlgorithm {

    @Resource
    private CityRepository cityRepository;

    @Test
    public void test1(){
        HintManager hintManager = HintManager.getInstance();
        //强制路由到ds${xx%2}既是 ds2%2 = ds0
        hintManager.setDatabaseShardingValue(2L);
        List<City> list = cityRepository.findAll();
        list.forEach(city->{
            System.out.println(city.getId()+" "+city.getName()+" "+city.getProvince());
        });
    }

}
