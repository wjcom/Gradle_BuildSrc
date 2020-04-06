package com.wj.plugin;

/**
 * Created by WJ at 20-4-3 15:31
 */
public class Person {
	private String name;
	private int age;
	private boolean isMan;

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

	public boolean isMan() {
		return isMan;
	}

	public void setMan(boolean man) {
		isMan = man;
	}

	@Override public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", age=" + age +
				", isMan=" + isMan +
				'}';
	}
}
