package com.atguigu.team.domian;

import com.atguigu.team.service.Status;

public class Programmer extends Employee{
	private int memberId;//开发团队中的id
	private Status status= Status.FREE;//状态类
	private Equipment equipment;
	
	
	public Programmer() {
		super();
	}


	public Programmer(int id, String name, int age, double salay, Equipment equipment) {
		super(id, name, age, salay);
		this.equipment = equipment;
	}


	public int getMemberId() {
		return memberId;
	}


	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public Equipment getEquipment() {
		return equipment;
	}


	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	@Override
	public String toString() {
		return super.toString() + "\t程序员\t"+getStatus()+"\t\t\t" +equipment.getDescription();
	}
	public String getTeamUufund() {
		return memberId+"/" +getId()+"\t"+getName()+"\t"+getAge()+"\t"+getSalay();
		
	}
	public String getDetailsForTeam() {
		return getTeamUufund()+"\t程序员";
		
	}
	
}
