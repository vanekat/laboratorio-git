package com.manning.gia.todo.web;

import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ToDoTest {

	FirefoxDriver driver;
	@Before
	public void begin(){
		driver=new FirefoxDriver();
	}
	
	@Test
	public void newTodo() throws Exception{
		String url=getBaseUrl();
		driver.get(url);
		driver.findElement(By.id("new-todo")).sendKeys("Practice Test Automation");
		driver.findElement(By.id("new-todo")).sendKeys(Keys.RETURN);

		String newTodo=driver.findElement(By.xpath("//ul[@id='todo-list']//label")).getText();

		assertEquals("Practice Test Automation",newTodo);
		Thread.sleep(2000);
	}
	
	private String getBaseUrl(){
		String systemUrl=System.getProperty("selenium.baseUrl");
		String defaultUrl="http://localhost:9090/todo";
		String baseUrl=(systemUrl!= null) ? systemUrl : defaultUrl;
		return baseUrl;
	}

	@After
	public void after(){
		driver.quit();
	}

}
