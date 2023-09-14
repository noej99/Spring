package com.noej.jun161sdi.snack;

import java.util.ArrayList;
import java.util.HashMap;

import com.noej.jun161sdi.company.Company;

public class Snack {
	// 기본형급
	private String name;
	private int price;
	
	// 객체급
	private Company maker;
	
	// 컬렉션급
	private String[] ingredient; // 재료 - 버터, 땅콩, ...
	private ArrayList<String> feature; // 특징 - 고온에서 ~분 구운 ...
	private HashMap<String, Double> nutrient; // 영양성분 - 탄수화물 : 10 ...
	
	public Snack() {
		// TODO Auto-generated constructor stub
	}

	public Snack(String name, int price, Company maker, String[] ingredient, ArrayList<String> feature,
			HashMap<String, Double> nutrient) {
		super();
		this.name = name;
		this.price = price;
		this.maker = maker;
		this.ingredient = ingredient;
		this.feature = feature;
		this.nutrient = nutrient;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Company getMaker() {
		return maker;
	}

	public void setMaker(Company maker) {
		this.maker = maker;
	}

	public String[] getIngredient() {
		return ingredient;
	}

	public void setIngredient(String[] ingredient) {
		this.ingredient = ingredient;
	}

	public ArrayList<String> getFeature() {
		return feature;
	}

	public void setFeature(ArrayList<String> feature) {
		this.feature = feature;
	}

	public HashMap<String, Double> getNutrient() {
		return nutrient;
	}

	public void setNutrient(HashMap<String, Double> nutrient) {
		this.nutrient = nutrient;
	}
}
