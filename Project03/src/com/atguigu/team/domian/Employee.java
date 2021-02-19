package com.atguigu.team.domian;

public class Employee {
	private int id;
	private String name;
	private int age;
	private double salay;
	
	
	public Employee() {
		super();
	}
	public Employee(int id, String name, int age, double salay) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.salay = salay;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalay() {
		return salay;
	}
	public void setSalay(double salay) {
		this.salay = salay;
	}
	public String getDetails() {
		return id +"\t"+name+"\t"+age+"\t"+salay;
	}
		@Override
		public String toString() {
			return id +"\t"+name+"\t"+age+"\t"+salay;
		}
}
