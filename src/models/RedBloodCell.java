package models;

public class RedBloodCell extends Cell {

	private int velocity;
	
	public RedBloodCell(String id, int health, int positionRow, int positionCol, int velocity) {
		super(id, health, positionRow, positionCol);
		this.velocity = velocity;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public int getVelocity() {
		return velocity;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

}
