package com.sjacob.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sjacob.jdbc.util.JDBCConnentionManager;

//@Configuration
public class BoardConfiguration {
	
//	@Bean
	public JDBCConnentionManager getJDBCConnentionManager() {
		JDBCConnentionManager manager = new JDBCConnentionManager();
		manager.setDriverClass("org.h2.Driver");
		manager.setUrl("jdbc:h2:tcp://localhost/~/test");
		manager.setUsername("sa");
		manager.setPassword("");
		return manager;
	}

}
