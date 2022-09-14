package com.liucj.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.liucj.mall.mbg.mapper")
public class MyBatisConfig {
}
