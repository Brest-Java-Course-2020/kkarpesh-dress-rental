package com.epam.brest.courses.rest_app.config;

import com.epam.brest.courses.dao.DressDao;
import com.epam.brest.courses.dao.DressDaoJdbc;
import com.epam.brest.courses.dao.RentDao;
import com.epam.brest.courses.dao.RentDaoJdbc;
import com.epam.brest.courses.dao.dto.DressDtoDao;
import com.epam.brest.courses.dao.dto.DressDtoDaoJdbc;
import com.epam.brest.courses.dao.dto.RentDtoDao;
import com.epam.brest.courses.dao.dto.RentDtoDaoJdbc;
import org.springframework.context.annotation.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.epam.brest.courses.*")
@PropertySource("classpath:dao.properties")
public class RestConfig {

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
        return new NamedParameterJdbcTemplate(dataSource());
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:test_db;MODE=MySQL;DB_CLOSE_DELAY=-1");
        dataSource.setUsername("sa");
        dataSource.setPassword("");

        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
        databasePopulator.addScript(new ClassPathResource("create-db.sql"));
        databasePopulator.addScript(new ClassPathResource("populate-db.sql"));
        DatabasePopulatorUtils.execute(databasePopulator, dataSource);
        return dataSource;
    }

    @Bean
    public DressDao dressDao() {
        return new DressDaoJdbc(namedParameterJdbcTemplate());
    }

    @Bean
    public RentDao rentDao() {
        return new RentDaoJdbc(namedParameterJdbcTemplate());
    }

    @Bean
    public DressDtoDao dressDtoDao() {
        return new DressDtoDaoJdbc(namedParameterJdbcTemplate());
    }

    @Bean
    public RentDtoDao rentDtoDao() {
        return new RentDtoDaoJdbc(namedParameterJdbcTemplate());
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource());
        return transactionManager;
    }

}
