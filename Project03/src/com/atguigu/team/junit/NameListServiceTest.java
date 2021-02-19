package com.atguigu.team.junit;

import org.junit.Test;

import com.atguigu.team.domian.Employee;
import com.atguigu.team.service.NameListService;
import com.atguigu.team.service.TeamException;

/**
 * Description 对NameService类的测试
 * @author Administrator
 * @version 
 * @date：2020年12月20日 下午4:31:14
 * 
 */
public class NameListServiceTest {
	@Test
	public void testGetAllEmployees() {
		NameListService  n = new NameListService();
		Employee[] employees = n.getAllEmployee();
		for(int i=0;i<employees.length;i++) {
			System.err.println(employees[i]);
		}
	}
	@Test
	public void testGetEmployee() {
		NameListService  n = new NameListService();
		int id =6;
		try {
			Employee employee = n.getEmployee(id);
			System.err.println(employee);
		} catch (TeamException e) {
			System.err.println(e.getMessage());
		}
	
	}
}
