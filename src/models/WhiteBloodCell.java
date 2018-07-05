package models;

public class WhiteBloodCell extends Cell {

	private int size;
	
	public WhiteBloodCell(String id, int health, int positionRow, int positionCol, int size) {
		super(id, health, positionRow, positionCol);
		this.size = size;
	}
	
	
}
