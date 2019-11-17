package com.liu.springcloud.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Dept implements Serializable {

    private Long deptno;

    private String dname;

    private String db_source;
}
