package com.kdg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@Component
public class PostgreSQLRunner implements ApplicationRunner {
    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try (Connection connection = dataSource.getConnection()){
            System.out.println(dataSource.getClass());
            System.out.println("접속정보 : " +connection.getMetaData().getURL());
            System.out.println("접속유저 : " +connection.getMetaData().getUserName());

            Statement statement = connection.createStatement();
        }
        jdbcTemplate.execute("INSERT INTO kdh.kdh_login VALUES ((select max(SEQ)+1 FROM kdh.kdh_login), now() )");
    }
}