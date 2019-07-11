package ank.hao.scheduler.core.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "ank.hao.scheduler.mapper")
public class DataConfig {
}
