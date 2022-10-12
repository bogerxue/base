package top.wenbovo.cn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author wenbo
 * 2022/10/4
 */

@SpringBootApplication
/**Spring Boot开启事务非常简单top/wenbovo/cn/mapper/base/MyMapper.java*/
@EnableTransactionManagement
@MapperScan(value = {"top.wenbovo.cn.mapper"})
public class MyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
}
