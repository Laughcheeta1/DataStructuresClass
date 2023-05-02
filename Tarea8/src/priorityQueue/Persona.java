package priorityQueue;

public class Persona implements Comparable<Persona>{
	private String name;
	private int age;
	private boolean pregnant;
	private boolean disabled;

	
	public Persona(String name, int age, boolean pregnant, boolean disabled)
	{
		this.name = name;
		this.age = age;
		this.pregnant = pregnant;
		this.disabled = disabled;
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
	

	public boolean isPregnant() {
		return pregnant;
	}


	public void setPregnant(boolean pregnant) {
		this.pregnant = pregnant;
	}


	public boolean isDisabled() {
		return disabled;
	}


	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}


	@Override
	public String toString() {
		return "name=" + name + ", age=" + age;
	}


	@Override
	public int compareTo(Persona o) {
		return this.age - o.getAge() ;
	}
}
