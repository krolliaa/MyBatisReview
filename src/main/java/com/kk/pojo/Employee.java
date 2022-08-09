package com.kk.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Integer eId;
    private String empName;
    private Integer age;
    private String sex;
    private String email;
}
