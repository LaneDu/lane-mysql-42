package dao;

import com.galaxy.RunBootApplication;
import com.galaxy.entity.BOrder;
import com.galaxy.entity.City;
import com.galaxy.entity.Position;
import com.galaxy.entity.PositionDetail;
import com.galaxy.repository.BOrderRepository;
import com.galaxy.repository.CityRepository;
import com.galaxy.repository.PositionDetailRepository;
import com.galaxy.repository.PositionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Random;

/**
 * @author lane
 * @date 2021年07月20日 下午7:31
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RunBootApplication.class)
public class TestShardingDatabase {
    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private PositionDetailRepository positionDetailRepository;

    @Autowired
    BOrderRepository orderRepository;

    @Autowired

    private CityRepository cityRepository;

    @Test
    public void test1(){
        for (int i=1;i<=20;i++){
            Position position =new Position();
//            position.setId(i);
            position.setCity("beijing");
            position.setName("zhangsan"+i);
            position.setSalary("20000");
            positionRepository.save(position);
        }

    }

    @Test
    public void testAdd2(){
        for (int i=1;i<=20;i++){
            Position position = new Position();
            position.setName("lisi"+i);
            position.setSalary("1000000");
            position.setCity("shanghai");
            positionRepository.save(position);

            PositionDetail positionDetail = new PositionDetail();
            positionDetail.setPid(position.getId());
            positionDetail.setDescription("this is a message "+i);
            positionDetailRepository.save(positionDetail);
        }
    }

    @Test
    public void testLoad(){
        Object object = positionRepository.findPositionsById(624565543113850880L);
        Object[] position = (Object[])object;
        System.out.println(position[0]+" "+position[1]+" "+position[2]+" "+position[3]+" "+position[4]);
    }


    @Test
    public void testBroadCast(){
        City city = new City();
        city.setName("beijing");
        city.setProvince("beijing");
        cityRepository.save(city);
    }

    @Test
    @Repeat(100)
    public void testShardingBOrder(){
        Random random = new Random();
        int companyId = random.nextInt(100);
        BOrder order = new BOrder();
        order.setDel(false);
        order.setCompanyId(companyId);
        order.setPositionId(3242342);
        order.setUserId(2222);
        order.setPublishUserId(1111);
        order.setResumeType(1);
        order.setStatus("AUTO");
        order.setCreateTime(new Date());
        order.setOperateTime(new Date());
        order.setWorkYear("2");
        order.setName("lg");
        order.setPositionName("Java");
        order.setResumeId(23233);
        orderRepository.save(order);
    }
}
