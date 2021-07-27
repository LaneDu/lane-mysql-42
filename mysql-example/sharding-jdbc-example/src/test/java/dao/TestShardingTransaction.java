package dao;

import com.galaxy.RunBootApplication;
import com.galaxy.entity.Position;
import com.galaxy.entity.PositionDetail;
import com.galaxy.repository.PositionDetailRepository;
import com.galaxy.repository.PositionRepository;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.apache.shardingsphere.transaction.core.TransactionTypeHolder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * @author lane
 * @date 2021年07月22日 下午4:43
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RunBootApplication.class)
public class TestShardingTransaction {

    @Resource
    private PositionRepository positionRepository;

    @Resource
    private PositionDetailRepository positionDetailRepository;

    @Test
    @Transactional
//    @ShardingTransactionType(TransactionType.XA)
    public void test1(){
        TransactionTypeHolder.set(TransactionType.XA);
//        TransactionTypeHolder.set(TransactionType.BASE);
//        for (int i=1;i<=5;i++){
        int i=2;
            Position position = new Position();
            position.setName("root"+i);
            position.setSalary("1000000");
            position.setCity("beijing");
            positionRepository.save(position);
            if (i==2){
                throw new RuntimeException("人为制造异常");
            }

            PositionDetail positionDetail = new PositionDetail();
            positionDetail.setPid(position.getId());
            positionDetail.setDescription("this is a root "+i);
            positionDetailRepository.save(positionDetail);

    }
}
