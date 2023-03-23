package cn.charlie.transaction;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author charlie
 * @date 3/23/2023 7:58 PM
 **/
@SpringBootApplication
@MapperScan("cn.charlie.transaction.mapper")
public class TransactionApplication {
    public static void main(String[] args) {
        SpringApplication.run(TransactionApplication.class, args);
    }
}
