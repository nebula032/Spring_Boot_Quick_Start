package com.sjacob.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	protected void configure(HttpSecurity security) throws Exception {
//		security.authorizeRequests().antMatchers("/").permitAll();
//		security.authorizeRequests().antMatchers("/member/**").authenticated();
//		security.authorizeRequests().antMatchers("/manager/**").hasRole("MANAGER");
//		security.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");
		
		security.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/member/**").authenticated()
				.antMatchers("/manager/**").hasRole("MANAGER")
				.antMatchers("/admin/**").hasRole("ADMIN");
		
		security.csrf().disable();
		
		security.formLogin().loginPage("/login").defaultSuccessUrl("/loginSuccess", true);
		security.exceptionHandling().accessDeniedPage("/accessDenied");
		security.logout().invalidateHttpSession(true).logoutSuccessUrl("/login");
	}
	
	@Autowired
	public void authenticate(AuthenticationManagerBuilder auth) throws Exception {
		/* 
		 * 사용자 정보 메모리 저장
		 */
//		auth.inMemoryAuthentication()
//			.withUser("manager")
//			.password("{noop}manager123")
//			.roles("MANAGER");
//		
//		auth.inMemoryAuthentication()
//			.withUser("admin")
//			.password("{noop}admin123")
//			.roles("ADMIN");
		
		/* 
		 * DB 연동
		 */
		// 사용자 정보 조회 쿼리
		String query1 = "select id as username, concat('{noop}', password) as password, "
					+ "true as enabled from member where id=?";
		// 사용자 권한 조회 쿼리
		String query2 = "select id, role from member where id=?";
		
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery(query1)
		.authoritiesByUsernameQuery(query2);
	}
}
