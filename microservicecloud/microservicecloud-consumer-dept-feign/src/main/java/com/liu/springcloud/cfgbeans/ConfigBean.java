package com.liu.springcloud.cfgbeans;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public IRule myRule() {
      //  return new RoundRobinRule(); // 轮询算法
      //  return new RandomRule();  // 目的是重新选择随机算法替代默认的轮询算法
        return new RetryRule();  // 先按照轮询的策略获取服务，如某个服务挂掉，三次重试后，跳过挂掉的服务
    }
}
