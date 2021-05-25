package ro.upt.medhelp.remote;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "remoteEntityManagerFactory",
        transactionManagerRef = "remoteTransactionManager",
        basePackages = {
                "ro.upt.medhelp.remote"
        })
public class MySQLRemoteConfiguration {


    @Bean(name = "dataSourceRemote")
    public DataSource dataSourceRemote() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://35.157.16.43:3306/sql11414385");
        dataSourceBuilder.username("sql11414385");
        dataSourceBuilder.password("rJu85hQjtS");
        return dataSourceBuilder.build();
    }


    @Bean(name = "remoteEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean remoteEntityManager(@Qualifier("dataSourceRemote") DataSource dataSourceRemote) {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSourceRemote);
        em.setPackagesToScan("ro.upt.medhelp.remote");

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalPropertiesRemote());

        return em;
    }

    @Bean(name = "remoteTransactionManager")
    @Primary
    public PlatformTransactionManager transactionManager(@Qualifier("remoteEntityManagerFactory") EntityManagerFactory localContainerEntityManagerFactoryBean) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(localContainerEntityManagerFactoryBean);

        return transactionManager;
    }


    @Bean
    Properties additionalPropertiesRemote() {
        Properties hibernateProperties = new Properties();

        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
        hibernateProperties.setProperty("hibernate.show_sql", "true");
        hibernateProperties.setProperty("hibernate.naming.physical-strategy", "org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl");
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");

        return hibernateProperties;
    }

}
