package com.dino.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dino.domain.TestVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class) // ������ ���ؽ�Ʈ �ε��ϰ� JUnit �׽�Ʈ ����
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
@Log4j
public class SampleServiceImplTest {

	@Autowired
	private SampleService sampleService;

	@Test
	public void serviceInsert() {
		TestVO vo = TestVO.builder().title("���� ����").content("���� ����").build();

		sampleService.insert(vo);
	}

	@Test
	public void serviceGetList() {
		sampleService.getList().forEach(list -> log.info(list));
	}

	@Test
	public void testgetOne() {
		TestVO record = sampleService.getOne(3);
		log.info(">>>>>> Retrieved Record: " + record);
	}

	@Test
	public void testUpdate() {
		TestVO vo = TestVO.builder().id(2) // ������Ʈ�� ��ȣ id 2
				.title("������Ʈ�� ����1").content("������Ʈ�� ����2").build();

		int result = sampleService.update(vo);
		log.info(">>>>>> Update result: " + result);
	}

	@Test
	public void testDelete() {
		int idToDelete = 3; // ������ ��ȣ id 3
		int result = sampleService.delete(idToDelete);
		log.info(">>>>>> Delete result: " + result);
	}

}
