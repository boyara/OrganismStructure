package models;

public class RedBloodCell extends Cell {

	private int velocity;
	
	public RedBloodCell(String id, int health, int positionRow, int positionCol, int velocity) {
		super(id, health, positionRow, positionCol);
		this.velocity = velocity;
		this.setEnergy();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString()).append("--------Health: ").append(this.health).append(" | Velocity: ")
				.append(this.velocity).append(" | Energy: ").append(this.energy).toString();
		return sb.toString();
	}

	public int getVelocity() {
		return velocity;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy() {
		this.energy = this.velocity + this.health;
	}

}
