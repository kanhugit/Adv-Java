package demo;

public class demo {
	 public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Heloo");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
	}
}
