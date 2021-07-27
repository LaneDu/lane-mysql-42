package com.galaxy.id;


import org.apache.shardingsphere.core.strategy.keygen.SnowflakeShardingKeyGenerator;
import org.apache.shardingsphere.spi.keygen.ShardingKeyGenerator;

import java.util.Properties;

/**
 * 仍然选择雪花片算法
 * @author lane
 * @date 2021年07月21日 上午10:41
 */

public class MyLaneId implements ShardingKeyGenerator {

    private  SnowflakeShardingKeyGenerator snow = new SnowflakeShardingKeyGenerator();

    @Override
    public Comparable<?> generateKey() {
        System.out.println("------执行了自定义主键生成器-------");
        return snow.generateKey();
    }

    @Override
    public String getType() {
        return "LANEKEY";
    }

    @Override
    public Properties getProperties() {
        return null;
    }

    @Override
    public void setProperties(Properties properties) {

    }
}

