package com.liu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 自定义 ribbon 算法
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule() {
       // return new RoundRobinRule();
       // return new RandomRule();
        return new RandomRule_LTH();
    }
}
