package models;

import java.util.ArrayList;

public class Organism {

	private String name;
	private ArrayList<Cluster> clusters = new ArrayList<>();
	
	public Organism(String name) {
		this.name = name;
	}
	
}
