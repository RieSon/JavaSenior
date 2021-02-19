package com.atguigu.team.service;
 /**
 * @Description 关于开发团队队员的：添加，删除
 * @author Administrator  Email:ss1606531417@gmail.coms
 * @version 1.0
 * @date:2020年12月20日 下午10:01:15
 * @phone: 13253531289
 * 
 */

import com.atguigu.team.domian.Architect;
import com.atguigu.team.domian.Designer;
import com.atguigu.team.domian.Employee;
import com.atguigu.team.domian.Programmer;

public class TeamService {
	private static int  counter=1;//给memberId赋值
	private final int MAX_MENBER = 5;//限制团队的人数
	private Programmer[] team = new Programmer[MAX_MENBER];//保存开发团队成员
	private int total;//记录开发团队实际的人数
	public TeamService() {
		
	}
	/**
	 * 
	 * @Description 获取开发团队的所有成员
	 * @author Administrator
	 * @version 
	 * @date:2020年12月20日 下午10:10:10
	 * @return
	 *
	 */
	public Programmer[] getTeam() {
		Programmer[] team = new Programmer[total];
		for(int i=0;i<team.length;i++) {
			team[i]=this.team[i];
		}
		return team;
	}
	/**
	 * 
	 * @Description 将指定的员工添加到开发团队中
	 * @author Administrator
	 * @version 
	 * @date:2020年12月20日 下午10:15:10
	 * @return
	 * @throws TeamException 
	 *
	 */
	public void addMember(Employee e) throws TeamException {
		Programmer p = (Programmer) e;
		//成员已满无法添加
		if(total>=MAX_MENBER) {
			throw new TeamException("成员已满无法添加");
		}
		//该成员不是开发人员不能添加
		if(!(e instanceof Programmer)) {
			throw new TeamException("该成员不是开发人员不能添加");
		}
		//该成员已在团队中了
		if(isExist(e)) {
			throw new TeamException("判断指定的员工已经存在与团队当中");
		}
		//已经是某个队的成员
		/*if("BUSY".equalsIgnoreCase(p.getStatus().getNAME())&&"VOCATION".equalsIgnoreCase(p.getStatus().getNAME())) {
			throw new TeamException("已经是某个队的成员");
		}*/
		switch (p.getStatus()){
			case BUSY:
				throw new TeamException("该成员已是某团队的成员");
			case VOCATION:
				throw new TeamException("该成员正在休假");
		}
		//团队里面只能有一名架构师
		
		//团队中只能由两名设计师
		//团队中只能由三名开发人员
		//获取team中已有成员中的架构师，设计师，开发人员
		int numofArch =0,numofDes=0,nuofPro=0;
		for(int i=0;i<total;i++) {
			if(team[i] instanceof Architect) {
				numofArch++;
			}else if(team[i] instanceof Designer) {
				numofDes++;
			}else if(team[i] instanceof Programmer) {
				nuofPro++;
				
			}
		}
		if(p instanceof Architect) {
			if(numofArch>=1) {
				throw new TeamException("团队里面只能有一名架构师");
			}else if(numofDes>=1) {
				throw new TeamException("团队里面只能有一名设计师");
			}else if(nuofPro>=3) {
				throw new TeamException("团队中只能由三名开发人员");
			}
		}
		//将p(或e)添加到现有的 team中
		team[total++] =p;
		//p的属性值
		p.setStatus(Status.BUSY);
		p.setMemberId(counter++);
	}
	
	/**
	 * 
	 * @Description 判断指定的员工是否已经存在与团队当中
	 * @author Administrator
	 * @version 
	 * @date:2020年12月20日 下午10:26:49
	 * @return
	 *
	 */
	private boolean isExist(Employee e) {
		// TODO Auto-generated method stub
		for(int i=0;i<total;i++) {
			if(team[i].getId()==e.getId()) {
				return true;
			}
		}
		return false;
	}
	/**
	 * 
	 * @Description 删除团队里的员工
	 * @author Administrator
	 * @version 
	 * @date:2020年12月21日 下午1:12:01
	 * @return
	 *
	 */
	public void removeMenber(int menberId) throws TeamException {
		int i=0;
		for(;i<total;i++) {
			if(team[i].getMemberId()==menberId) {
				team[i].setStatus(Status.FREE);
				break;
			}
		}
		//未找到menberId的情况
		if(i==total) {
			throw new TeamException("未找到指定memberId的员工");
		}
		for(int j=i+1;j<total;j++) {
			team[j-1] = team[j];
		}
		//team[total-1] =null;
		//total--;
		team[--total]=null;
	
	}
}
