package models;

public class WhiteBloodCell extends Cell {

	private int size;
	private int energy;
	
	public WhiteBloodCell(String id, int health, int positionRow, int positionCol, int size) {
		super(id, health, positionRow, positionCol);
		this.size = size;
		this.setEnergy();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		String redBloodCellToString = sb.append(super.toString()).append("--------Health: ").append(this.health).append(" | Size: ")
				.append(this.size).append(" | Energy: ").append(this.energy).toString();
		return redBloodCellToString;
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy() {
		this.energy = (this.health + this.size) * 2;
	}

}
