package models;

public class Cell {
	
	private String id;
	private int health;
	private int positionRow;
	private int positionCol;
	
	public Cell(String id, int health, int positionRow, int positionCol) {
		this.id = id;
		this.health = health;
		this.positionRow = positionRow;
		this.positionCol = positionCol;
	}
	
}
