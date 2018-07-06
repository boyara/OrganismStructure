package models;

public class Microbe extends Cell {

	private int virulence;
	private String microbeType;
	
	public Microbe(String id, int health, int positionRow, int positionCol, int virulence) {
		super(id, health, positionRow, positionCol);
		this.virulence = virulence;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	public int getVirulence() {
		return virulence;
	}

	public void setVirulence(int virulence) {
		this.virulence = virulence;
	}

	public String getMicrobeType() {
		return microbeType;
	}

	public void setMicrobeType(String microbeType) {
		this.microbeType = microbeType;
	}

}
