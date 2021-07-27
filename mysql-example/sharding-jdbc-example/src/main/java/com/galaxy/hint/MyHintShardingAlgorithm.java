package com.galaxy.hint;

import org.apache.shardingsphere.api.sharding.hint.HintShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.hint.HintShardingValue;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author lane
 * @date 2021年07月21日 下午4:50
 */
public class MyHintShardingAlgorithm implements HintShardingAlgorithm<Long> {
    @Override
    public Collection<String> doSharding(
            Collection<String> availableTargetNames,
            HintShardingValue<Long> shardingValue) {
        Collection<String> result = new ArrayList<>();
        //each是数据源ds0和ds1
        for (String each : availableTargetNames){
            for (Long value : shardingValue.getValues()){
                //value是自己传入的值，根据传入的值来匹配数据源
                if(each.endsWith(String.valueOf(value % 2))){
                    result.add(each);
                }
            }
        }
        return result;
    }
}
