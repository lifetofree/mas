package com.dev.mas.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.mas.config.SpringMongoConfig;
import com.dev.mas.model.TestData;

@Controller
public class TestController {

	@RequestMapping(value = "/test")
	public String test(Model model) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
		
		BasicQuery queryTest = new BasicQuery("{ age : { $lt : 40 }, name : 'cat' }");
//		Query queryTest = new Query();
		TestData testData = mongoOperation.findOne(queryTest, TestData.class);
		
		model.addAttribute("id", testData.toString());
//		model.addAttribute("id", "123456");
		
//		List<TestData> testDatas = new ArrayList<TestData>();
//		TestData testData1 = new TestData("1001", "ant", 10);
//		testDatas.add(testData1);
//		
//		mongoOperation.insert(testDatas, TestData.class);
		
		return "test";
		
	}
}
