package models;

public class Microbe extends Cell {

	private int virulence;
	private String microbeType;
	private int energy;
	
	public Microbe(String id, int health, int positionRow, int positionCol, int virulence) {
		super(id, health, positionRow, positionCol);
		this.virulence = virulence;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString()).append("--------Health: ").append(this.health).append(" | Virulence: ")
				.append(this.virulence).append(" | Energy: ").append(this.energy).toString();
		return sb.toString();
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

	public int getEnergy() {
		return energy;
	}

	public void setEnergy() {
		switch(microbeType) {
		case "Bacteria":
			this.energy = (this.health + this.virulence) / 3;
			break;
		case "Fungi":
			this.energy = (this.health + this.virulence) / 4;
			break;
		case "Virus":
			this.energy = this.health + this.virulence;
			break;
		}
	}
	
}
