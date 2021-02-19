package com.atguigu.team.view;
import com.atguigu.team.domian.Employee;
import com.atguigu.team.domian.Programmer;
import com.atguigu.team.service.NameListService;
import com.atguigu.team.service.TeamException;
import com.atguigu.team.service.TeamService;
/**
* @Description
* @author: Administrator  Email:ss1606531417@gmail.com
* @version: 1.0
* @date:2020年12月21日 下午1:12:54
* @phone: 13253531289
* 
*/

public class TeamView {

	private NameListService listSvc = new NameListService();
	private TeamService teamSvc = new TeamService();

	/**
	 * 
	 * @Description
	 * @author Administrator
	 * @version 
	 * @date:2020年12月21日 下午2:19:53
	 * @return
	 *
	 */
	public void enterMainMenu() {
		boolean loopFlag = true;
		char mune=0;
	
		while(loopFlag) {
		
			
			if(mune!='1') {
				listAllEmployees();
			}
		System.err.println("1-团队列表  2-添加团队成员  3-删除团队成员  4-退出  请选择（1-4）：");
		
		 mune = TSUyility.readMenuSelection();
	
		switch(mune) {
		case'1':
			getTeam();
			
			break;
		case'2':
			addMember();
			break;
		case'3':
			deletemember();
			break;
		case'4':
			System.err.println("确定是否退出(Y/N)：");
			char isExit = TSUyility.readConfirmSelection();
			if(isExit=='Y') {
				loopFlag= false;
			}
			break;
		}
		}
	}
	
	/**
	 * 显示所有的员工的信息
	 * @Description
	 * @author Administrator
	 * @version 
	 * @date:2020年12月21日 下午1:20:26
	 * @return
	 *
	 */
	public void listAllEmployees() {
		System.err.println("-----------------------------开发团队调度软件--------------------------/n");
		Employee[] employees= listSvc.getAllEmployee();
		if(employees==null|| employees.length==0) {
			System.err.println("公司里没有员工");
		}else {
			System.err.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备");
			for(int i =0;i<employees.length;i++) {
				System.err.println(employees[i]);
			}
		}
		System.err.println("------------------------------------------------------------------/n");
	}

	public void getTeam() {
		System.err.println("-----------------团队列表-----------------\n");
		Programmer[] team = teamSvc.getTeam();
		if(team==null|| team.length==0) {
			System.err.println("开发团队里没有队员");
		}else {
			System.err.println("TID/ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票");
			for(int i =0;i<team.length;i++) {
				System.err.println(team[i].getDetailsForTeam());
			}
		}
		System.err.println("----------------------------------------");
	}

	public void addMember() {
		System.err.println("------------------添加员工----------------");
		System.err.println("选择添加的员工id:");
		int readInt = TSUyility.readInt();
		
		
		try {
			Employee employee = listSvc.getEmployee(readInt);
			teamSvc.addMember(employee);
			System.out.println("添加成功");
			TSUyility.readReturn();
		} catch (TeamException e) {
			// TODO Auto-generated catch block
			System.err.println("添加失败，原因："+e.getMessage());
		}
	}

	public void deletemember() {
		
		System.err.println("------------------------删除成员-----------------");
		System.err.println("请输入删除员工的TID：");
		int memberId = TSUyility.readInt();
		System.err.println("确定是否删除(Y/N)：");
		char readConfirmSelection = TSUyility.readConfirmSelection();
		if(readConfirmSelection=='N') {
			return;
		}
		try {
			teamSvc.removeMenber(memberId);
			System.err.println("删除成功");
			TSUyility.readReturn();
		} catch (TeamException e) {
			// TODO Auto-generated catch block
			System.err.println("删除失败，原因："+e.getMessage());
		}
	}
	public static void main(String[] args) {
		TeamView view = new TeamView();
		view.enterMainMenu();
	}
}
