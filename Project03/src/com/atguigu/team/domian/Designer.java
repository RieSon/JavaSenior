package com.atguigu.team.domian;

public class Designer extends Programmer{
	private double bonus;//奖金

	public Designer() {
		super();
	}


	public Designer(int id, String name, int age, double salay, Equipment equipment, double bonus) {
		super(id, name, age, salay, equipment);
		this.bonus = bonus;
	}


	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		
		return super.getDetails()+"\t设计师\t"+getStatus()+"\t"+getBonus() +"\t\t"+getEquipment().getDescription();
	}
	public String getDetailsForTeam() {
		return getTeamUufund()+"\t设计师\t"+getBonus();
		
	}
}
