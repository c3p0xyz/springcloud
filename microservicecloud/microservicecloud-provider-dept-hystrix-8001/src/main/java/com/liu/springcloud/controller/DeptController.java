package com.liu.springcloud.controller;

import com.liu.springcloud.domain.Dept;
import com.liu.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService service;

    /*@PostMapping("/dept/add")
    public boolean add(@RequestBody Dept dept) {
        return service.add(dept);
    }

    @GetMapping("/dept/list")
    public List<Dept> list() {
        return service.list();
    }
    */

    @GetMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept get(@PathVariable("id") Long id) {
        Dept dept = service.get(id);
        if (dept == null) {
            throw new RuntimeException("没有对应的信息");
        }
        return dept;
    }

    public Dept processHystrix_Get(Long id) {
        Dept dept = new Dept();
        dept.setDeptno(id);
        dept.setDname("该ID: "+id+" 数据库中没有对应信息");
        dept.setDb_source("no this data in mysql");
        return dept;
    }
}
