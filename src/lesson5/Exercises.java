package lesson5;

public class Exercises {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Human	h = new Human();
		// call dialog
		System.err.println("family: "+h.family);
	}

}


class Human {
	String 	family;
	String 	name;
	String 	patroname;
	int		age;
	@Override
	public String toString() {
		return "Human [family=" + family + ", name=" + name + ", patroname=" + patroname + ", age=" + age + "]";
	}
	
}
