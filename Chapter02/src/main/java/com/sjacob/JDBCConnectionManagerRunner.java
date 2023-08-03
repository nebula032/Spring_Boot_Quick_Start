package com.sjacob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import com.sjacob.jdbc.util.JDBCConnentionManager;

@Service
public class JDBCConnectionManagerRunner implements ApplicationRunner{
	@Autowired
	private JDBCConnentionManager connentionManager;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("커넥션 매니저 : " + connentionManager.toString());
		
	}
	
	

}
