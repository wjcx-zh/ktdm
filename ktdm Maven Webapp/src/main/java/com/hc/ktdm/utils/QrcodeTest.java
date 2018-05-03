package com.hc.ktdm.utils;

import static org.junit.Assert.*;

import java.io.File;
import java.net.URISyntaxException;

import org.apache.struts2.ServletActionContext;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hc.ktdm.model.Teacher;

public class QrcodeTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testPath() {
		//System.out.println(ServletActionContext.getRequest().getServletPath());
		String path="imgs/sign.png";
		File imgFile = new File(path);
		System.out.println(new File(".").getAbsoluteFile().toURI().getPath());
		try {		
			System.out.println(ClassLoader.getSystemResource("").toURI().getPath());
			System.out.println(Thread.currentThread().getContextClassLoader().getResource("").toURI().getPath());
			System.out.println(Teacher.class.getResource("/").toURI().getPath().replaceFirst("/", "").replaceAll("WEB-INF/classes/", "imgs"));
			System.out.println(Teacher.class.getResource("").toURI().getPath());
			System.out.println(QrcodeTest.class.getResource("/").toURI().toString());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(System.getProperty("user.dir").toString());
	}

}
