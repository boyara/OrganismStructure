package models;

public class RedBloodCell extends Cell {

	private int velocity;
	
	public RedBloodCell(String id, int health, int positionRow, int positionCol, int velocity) {
		super(id, health, positionRow, positionCol);
		this.velocity = velocity;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		String redBloodCellToString = sb.append(super.toString()).append("--------Health: ").append(this.health).append(" | Velocity: ")
				.append(this.velocity).append(" | Energy: ").append(this.)
	}

	public int getVelocity() {
		return velocity;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

}
