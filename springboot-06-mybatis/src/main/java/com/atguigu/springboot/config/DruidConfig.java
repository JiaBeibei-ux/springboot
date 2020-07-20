package com.atguigu.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Druid配置类
@Configuration
public class DruidConfig {
    @ConfigurationProperties(prefix ="spring.datasource")
    @Bean
    public DataSource dataSource(){
        return new DruidDataSource();
    }
    //配置druid监控
     //配置监控服务器
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        //添加ip访问名单
        Map<String,String> initParams = new HashMap<>();
        initParams.put("allow","");
        initParams.put("deny","192.168.49.129");
        initParams.put("loginUsername","admin");
        initParams.put("loginPassword","123456");
        //是否能够重置数据
        initParams.put("resetEnable","false");
        servletRegistrationBean.setInitParameters(initParams);
        return servletRegistrationBean;
    }
    //配置服务过滤器
    @Bean
    public FilterRegistrationBean statFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        //添加web过滤器
        filterRegistrationBean.setFilter(new WebStatFilter());
        Map<String,String> initParams = new HashMap<>();
        //忽略过滤格式
        initParams.put("exclusions","*.js,*.gif,*.css,/druid/*");
        filterRegistrationBean.setInitParameters(initParams);
        //过滤规则
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        return filterRegistrationBean;
    }
}
