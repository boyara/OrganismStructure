package models;

import java.util.ArrayList;

public class Cluster {

	private String id;
	private int rows;
	private int cols;
	private ArrayList<Cell> cells = new ArrayList<>();
	private int currentCellId = 0;
	Cell currentCell = cells.get(currentCellId);
	
	public Cluster(String id, int rows, int cols) {
		this.id = id;
		this.rows = rows;
		this.cols = cols;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("----Cluster ").append(this.id).append("\n").toString();
		for (Cell cell : cells) {
			sb.append(cell.toString()).append("\n").toString();
		}
		return sb.toString();
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
	public void addCell(Cell cell) {
		this.cells.add(cell);	
	}

	private void setCurrentCell() {
		
		Cell tempCurrentCell = cells.get(0);
		int cellId = 0;
		int tempId = 0;
		
		for (Cell cell : cells) {
			if(cell.getPositionRow() <= tempCurrentCell.getPositionRow()) {
				if(cell.getPositionCol() < tempCurrentCell.getPositionCol()) {
					tempCurrentCell = cell;
					cellId = tempId;
				}
			}
			
			tempId++;
		}
		
		currentCellId = cellId;
	}
	
	private void cellBattle(Cell attacker, Cell target) {
		if(currentCell.getId() == "WhiteBloodCell" || currentCell.getId() == "RedBloodCell") {
			currentCell.health += target.getHealth();
			for (Cell cell : cells) {
				if(cell.equals(target)) {
					cells.remove(cell);
				}
			}
		}
		
		else if(currentCell.getId() == "Virus" || currentCell.getId() == "Fungi" || currentCell.getId() == "Bacteria") {
			while(attacker.getHealth() > 0 && target.getHealth() > 0) {
				target.setHealth(target.getHealth() - attacker.getEnergy());
				target.setEnergy();
				attacker.setHealth(attacker.getHealth() - target.getEnergy());
				attacker.setEnergy();
			}
			if(attacker.getHealth() <= 0) {
				cells.remove(attacker);
			} else {
				cells.remove(target);
			}
		}
		
	}
	
	public void activateCluster() {
		
		setCurrentCell();
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				
				if(cells.size() == 1) {
					return;
				}
				
				for (Cell cell : cells) {
					if(cell.getPositionCol() == cells.get(currentCellId).getPositionCol() 
							&& cell.getPositionRow() == cells.get(currentCellId).getPositionRow()
							&& !cell.equals(cells.get(currentCellId))) {
						Cell attacker = cells.get(currentCellId);
						Cell target = cell;
						cellBattle(attacker, target);
						if(cells.size() == 1) {
							return;
						} else {
							setCurrentCell();
						}
					} else {
						if(cells.size() == 1) {
							return;
						}
						while((cell.getPositionCol() != cells.get(currentCellId).getPositionCol() 
							|| cell.getPositionRow() != cells.get(currentCellId).getPositionRow())
								&& !cell.equals(cells.get(currentCellId))) {
							if(currentCell.getPositionCol() < cols - 1) {
								currentCell.setPositionCol(currentCell.getPositionCol() + 1);
							}
							else {
								if(currentCell.getPositionRow() < rows - 1) {
									currentCell.setPositionRow(currentCell.getPositionRow() + 1);
								} else {
									currentCell.setPositionRow(0);
								}
							}
						}
						
					}
				}
			}
		}
	}
}
