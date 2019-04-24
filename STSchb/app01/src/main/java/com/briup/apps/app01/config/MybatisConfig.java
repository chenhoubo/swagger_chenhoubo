package com.briup.apps.app01.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.briup.apps.app01.mapper")
public class MybatisConfig {

}
