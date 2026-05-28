package pokemon;

public class Move {
	private String name;
	private int power;
	private Type type;
	
	public Move() {}
	
	public Move(String name,int power, Type type) {
		this.name = name;
		this.power = power;
		this.type = type;
	}
	
	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
