package org.lrh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@MapperScan("org.lrh.dao")
public class StuApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(StuApp.class,args);
    }
}
