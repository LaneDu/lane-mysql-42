package com.galaxy.test;

import com.galaxy.ShardingBootRunApplication;
import com.galaxy.entity.Order;
import com.galaxy.repository.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * @author lane
 * @date 2021年07月27日 下午7:16
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShardingBootRunApplication.class)
public class ShardingTest {

    @Autowired
    private OrderRepository orderRepository;

    @org.junit.Test
    public void test(){
        for (int idx = 0; idx < 4; ++idx) {
            Order order = new Order();
            order.setCompanyId(1);

            order.setCreateTime(new Date());
            order.setDel(false);
            order.setPositionId(1);

            order.setStatus("WAITING");
            order.setPublishUserId(1);
            order.setResumeType(1);

            order.setUpdateTime(new Date());
            order.setUserId(idx);

            orderRepository.save(order);
        }



    }

    @Test
    public void testSlave(){
        List<Order> all = orderRepository.findAll();

        System.out.println(all);
    }
}
