package models;

public class Cell {

	protected String id;
	protected int health;
	protected int positionRow;
	protected int positionCol;
	
	public Cell(String id, int health, int positionRow, int positionCol) {
		this.id = id;
		this.health = health;
		this.positionRow = positionRow;
		this.positionCol = positionCol;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		String cellToString = sb.append("------Cell ").append(this.id).append("[").append(this.positionRow)
				.append(",").append(this.positionCol).append("]").append("\n").toString();
		return cellToString;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getPositionRow() {
		return positionRow;
	}

	public void setPositionRow(int positionRow) {
		this.positionRow = positionRow;
	}

	public int getPositionCol() {
		return positionCol;
	}

	public void setPositionCol(int positionCol) {
		this.positionCol = positionCol;
	}
	
}
