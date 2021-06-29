package com.ashish.example.springmanydemo.embedded.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Customer {
    @EmbeddedId
    private LoginId loginId;
    private String cname;
    private String gender;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street",column =@Column(name ="home_street" )),
            @AttributeOverride(name = "state",column =@Column(name ="home_state" )),
            @AttributeOverride(name = "country",column =@Column(name ="home_country" ))
    })
    private Address homeaddress;
    @Embedded
    private Address officeAddress;
    
    @Override
    public String toString() {
        return "Customer{" +
                "loginId=" + loginId +
                ", cname='" + cname + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
