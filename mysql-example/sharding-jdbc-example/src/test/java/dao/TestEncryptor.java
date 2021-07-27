package dao;

import com.galaxy.RunBootApplication;
import com.galaxy.entity.CUser;
import com.galaxy.repository.CUserRepository;
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
 * @date 2021年07月21日 下午6:41
 */
@SpringBootTest(classes = RunBootApplication.class)
@RunWith(SpringRunner.class)
public class TestEncryptor {

    @Autowired
    private CUserRepository userRepository;

    @Test
    @Repeat(20)
    public void testAdd(){
        CUser user = new CUser();
       int i =  new Random().nextInt(20);
        user.setName("tiger"+ i);
        user.setPwd("abc"+i);
        userRepository.save(user);
    }

    @Test
    public void testFind(){
        List<CUser> list = userRepository.findByPwd("abc17");
        list.forEach(cUser -> {
            System.out.println(cUser.getId()+" "+cUser.getName()+" "+cUser.getPwd());
        });
    }

    
}
