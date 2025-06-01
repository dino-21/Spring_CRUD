package com.dino.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dino.domain.TestVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TestMapperTest {

	@Autowired
	private TestMapper testMapper;

//	@Test
//	public void testgetTime() {
//		log.info(">>>>" + testMapper.getTime());
//	}

	@Test
	public void testInsert() {
		TestVO vo = TestVO.builder().title("�׽�Ʈ ����").content("�׽�Ʈ ����").build();

		int result = testMapper.insert(vo);
		log.info(">>>>>>" + result);
	}

	@Test
	public void testGetList() { // List<TestVO> lists = testMapper.getList();
		// for (TestVO testVO : lists)
		// log.info(testVO.toString());
		log.info(">>>> List: " + testMapper.getList());
	}

	@Test
	public void testgetOne() {
		TestVO record = testMapper.getOne(3);
		log.info(">>>>>> Retrieved Record: " + record);
	}

	@Test
	public void testUpdate() {
		TestVO vo = TestVO.builder().id(1) // ������Ʈ�� ��ȣ id 1
				.title("������Ʈ�� ����1").content("������Ʈ�� ����1").build();

		int result = testMapper.update(vo);
		log.info(">>>>>> Update result: " + result);
	}

	@Test
	public void testDelete() {
		int idToDelete = 1; // ������ ��ȣ id 1
		int result = testMapper.delete(idToDelete);
		log.info(">>>>>> Delete result: " + result);
	}
}
