package com.noej.jul072rac.coffee;

import java.util.List;

public class Coffees {
	private List<Coffee> coffees;
	public Coffees() {
		// TODO Auto-generated constructor stub
	}
	public Coffees(List<Coffee> coffees) {
		super();
		this.coffees = coffees;
	}
	public List<Coffee> getCoffees() {
		return coffees;
	}
	public void setCoffees(List<Coffee> coffees) {
		this.coffees = coffees;
	}
	
}
