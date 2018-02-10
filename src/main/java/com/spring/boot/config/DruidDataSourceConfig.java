package com.spring.boot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DatabaseDriver;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

/**
 * druid数据源配置
 * @author wang_donggang
 */
@Configuration
@ConditionalOnClass(DruidDataSource.class)
@ConditionalOnProperty(name = "spring.datasource.type",
				havingValue = "com.alibaba.druid.pool.DruidDataSource",
			 matchIfMissing = true)
public class DruidDataSourceConfig {

	/**
	 * @see org.springframework.boot.autoconfigure.jdbc.DataSourceConfiguration.Tomcat
	 * @param properties
	 * @return DruidDataSource
	 */
	@Bean
	@ConfigurationProperties("spring.datasource.druid")
	public DruidDataSource dataSource(DataSourceProperties properties) {
		
		DruidDataSource dataSource = (DruidDataSource) properties
											.initializeDataSourceBuilder()
											.type(DruidDataSource.class)
											.build();

		DatabaseDriver databaseDriver = DatabaseDriver.fromJdbcUrl(properties.determineUrl());

		String validationQuery = databaseDriver.getValidationQuery();
		
		if (validationQuery != null) {
			dataSource.setTestOnBorrow(true);
			dataSource.setValidationQuery(validationQuery);
		}

		return dataSource;
	}

	/**
	 * 注册一个StatViewServlet
	 */
	@Value("${druid.view.allow}")
    private String allow;
	@Value("${druid.view.deny}")
	private String deny;
	@Value("${druid.view.username}")
	private String username;
	@Value("${druid.view.password}")
	private String password;
	@Bean
	public ServletRegistrationBean druidStatViewServlet() {
		// org.springframework.boot.context.embedded.ServletRegistrationBean提供类的进行注册.
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(
											new StatViewServlet(), "/druid/*");
		// 添加初始化参数：initParams
		// IP白名单：一般为localhost(127.0.0.1)
		servletRegistrationBean.addInitParameter("allow", allow);
		// IP黑名单：一般为本机外网IP
		// 存在共同时，deny优先于allow: 如果满足deny的话
		// 提示:Sorry, you are not permitted to view this page.
		servletRegistrationBean.addInitParameter("deny", deny);
		// 登录查看信息的账号密码.
		servletRegistrationBean.addInitParameter("loginUsername", username);
		servletRegistrationBean.addInitParameter("loginPassword", password);
		// 是否能够重置数据.
		// 禁用HTML页面上的“Reset All”功能
		servletRegistrationBean.addInitParameter("resetEnable", "false");
		
		return servletRegistrationBean;
	}

	/**
	 * 注册一个：filterRegistrationBean
	 */
	@Bean
	public FilterRegistrationBean druidStatFilter() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
		filterRegistrationBean.setName("druidWebStatFilter");
		// 添加过滤规则.
		filterRegistrationBean.addUrlPatterns("/*");
		// 添加忽略的格式信息.
		filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
		return filterRegistrationBean;
	}

}