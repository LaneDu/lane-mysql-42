package com.galaxy.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author lane
 * @date 2021年07月23日 下午6:05
 */
@Entity
@Table(name = "position")
public class Position implements Serializable {

    @Id
    @Column(name = "id")
    //使用sharding jdbc指定主键生成，不指定则是数据库默认auto_increment
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "salary")
    private String salary;

    @Column(name = "city")
    private String city;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
