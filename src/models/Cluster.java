package models;

import java.util.ArrayList;

public class Cluster {

	private String id;
	private int rows;
	private int cols;
	private ArrayList<Cell> cells = new ArrayList<>();
	
	public Cluster(String id, int rows, int cols) {
		this.id = id;
		this.rows = rows;
		this.cols = cols;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getCols() {
		return cols;
	}
	public void setCols(int cols) {
		this.cols = cols;
	}
	public ArrayList<Cell> getCells() {
		return cells;
	}
	public void setCells(ArrayList<Cell> cells) {
		this.cells = cells;
	}
	
}
