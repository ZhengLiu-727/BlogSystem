package site.liuzheng.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("site.liuzheng.dao.mapper")
public class MybatisPlusConfig {
}
