import com.galaxy.ProxyApplication;
import com.galaxy.entity.Position;
import com.galaxy.repository.PositionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Random;

/**
 * @author lane
 * @date 2021年07月23日 下午6:16
 */
@SpringBootTest(classes = ProxyApplication.class)
@RunWith(SpringRunner.class)
public class TestProxy {

    @Autowired
    PositionRepository positionRepository;

    @Test
    public void test1(){

        List<Position> positionList = positionRepository.findAll();
        positionList.forEach((position)->{
            System.out.println(position.getName());
        });

    }

    @Test
    @Repeat(2)
    public void test2(){
        Position position =new Position();
        position.setName("sky"+new Random().nextInt(12));
        position.setSalary("100000");
        position.setCity("guangzhou");
        positionRepository.save(position);
    }
}
