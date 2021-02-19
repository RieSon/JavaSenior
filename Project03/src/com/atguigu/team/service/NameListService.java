package com.atguigu.team.service;

import com.atguigu.team.domian.Architect;
import com.atguigu.team.domian.Designer;
import com.atguigu.team.domian.Employee;
import com.atguigu.team.domian.Equipment;
import com.atguigu.team.domian.NoteBook;
import com.atguigu.team.domian.PC;
import com.atguigu.team.domian.Printer;
import com.atguigu.team.domian.Programmer;

import static com.atguigu.team.service.Data.*;

/**
 * 
 * @Description 负责将Data中的数据封装到Employee[]数组中，同时提供相关操作Employee[]的方法。
 * @author Administrator
 * @version
 * @date:2020年12月20日 下午3:07:02
 * 
 *
 */
public class NameListService {
	private Employee[] employees;

	/**
	 * 给employee及数组元素进行初始化
	 */
	public NameListService() {
		employees = new Employee[EMPLYEES.length];
		for (int i = 0; i < employees.length; i++) {
			Equipment equipment;
			double bonus;
			int stock;
			//通过第0个下标来确定每条信息返回的那几个字段数据
			int type = Integer.parseInt(EMPLYEES[i][0]);
			// 获取Employee的4个信息
			int id = Integer.parseInt(EMPLYEES[i][1]);
			String name = (EMPLYEES[i][2]);
			int age = Integer.parseInt(EMPLYEES[i][3]);
			double salary = Double.parseDouble(EMPLYEES[i][4]);
			
			switch (type) {
			case EMPLYEE:
				employees[i] = new Employee(id, name, age, salary);
				break;
			case PROGRAMMER:
				equipment = createEquipment(i);
				employees[i] = new Programmer(id, name, age, salary, equipment);
				break;
			case DESIGNER:
				equipment = createEquipment(i);
				bonus = Double.parseDouble(EMPLYEES[i][5]);
				employees[i] = new Designer(id, name, age, salary, equipment, bonus);
				break;
			case ARCHITECT:
				equipment = createEquipment(i);
				bonus = Double.parseDouble(EMPLYEES[i][5]);
				stock = Integer.parseInt(EMPLYEES[i][6]);
				employees[i] = new Architect(id, name, age, salary, equipment,bonus,stock);
				break;
			}
		}
	}

	private Equipment createEquipment(int index) {
		int type = Integer.parseInt(EQUIPMENTS[index][0]);
		String modelOrname = EQUIPMENTS[index][1];
		switch (type) {
		case PC:// 21

			String display = EQUIPMENTS[index][2];
			return new PC(modelOrname, display);
		case NOTEBOOK:// 22
			double price = Double.parseDouble(EQUIPMENTS[index][2]);
			return new NoteBook(modelOrname, price);
		case PRINTER:// 23
			return new Printer(modelOrname, EQUIPMENTS[index][2]);
		}
		return null;
	}

	/**
	 * 
	 * @Description 获取当前所有
	 * @author Administrator
	 * @version
	 * @date:2020年12月20日 下午4:06:54
	 * @return
	 *
	 */
	public Employee[] getAllEmployee() {

		return employees;

	}

	/**
	 * 
	 * @Description 获取指定id的对象
	 * @author Administrator
	 * @version
	 * @date:2020年12月20日 下午4:08:22
	 * @return
	 * @throws TeamException
	 *
	 */
	public Employee getEmployee(int id) throws TeamException {
		for (int i = 0; i < employees.length; i++) {
			if (employees[i].getId() == id) {
				return employees[i];
			}
		}
		throw new TeamException("找不到指定的员工");

	}
}
