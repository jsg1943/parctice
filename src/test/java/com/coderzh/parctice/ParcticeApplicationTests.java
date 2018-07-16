package com.coderzh.parctice;

import com.coderzh.parctice.myAnnotation.AnnotationTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.lang.annotation.Annotation;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParcticeApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private AnnotationTest annotationTest;

	@Test
	public void testAnnotation(){
		Annotation[] annotations = annotationTest.getClass().getAnnotations();
		System.out.println("-----------------------");
		for (Annotation an : annotations) {
			System.out.println(an.getClass().toString());
		}
		System.out.println("-----------------------");
	}

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		File file = new File("D:\\renameTest.txt");
		file.renameTo(new File("D:\\renameTest1.txt"));
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}

}
