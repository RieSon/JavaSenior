package com.atguigu.team.domian;

public class Architect extends Designer{
	private int stock;//股票

	public Architect() {
		super();
	}



	public Architect(int id, String name, int age, double salay, Equipment equipment, double bonus, int stock) {
		super(id, name, age, salay, equipment, bonus);
		this.stock = stock;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	@Override
	public String toString() {
		
		return super.getDetails()+"\t架构师\t"+getStatus()+"\t" +getBonus()+"\t"+stock+"\t\t"+getEquipment().getDescription();
	}
	public String getDetailsForTeam() {
		return getTeamUufund()+"\t架构师\t"+getBonus()+"\t"+getStock();
		
	}
}
