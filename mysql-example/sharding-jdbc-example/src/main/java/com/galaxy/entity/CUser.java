package com.galaxy.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author lane
 * @date 2021年07月21日 下午6:33
 */
@Entity
@Table(name = "c_user")
public class CUser implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "pwd")//逻辑列名
    private String pwd;

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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
