package com.gamerhouse.beans;

public class Payee{
	private String name;
	private double total;
	private double rent;
	private double utils;
	private double expenses;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getRent() {
		return rent;
	}
	public void setRent(double rent) {
		this.rent = rent;
	}
	public double getUtils() {
		return utils;
	}
	public void setUtils(double utils) {
		this.utils = utils;
	}
	public double getExpences() {
		return expenses;
	}
	public void setExpenses(double expenses) {
		this.expenses= expenses;
	}
	public double getTotal() {
		total = expenses + utils + rent;
		return total;
	}
	@Override
	public String toString() {
		return "payee [name=" + name + ", total=" + getTotal() + ", rent=" + rent + ", util=" + utils + ", expenses="
				+ expenses + "]";
	}
}
