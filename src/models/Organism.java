package models;

import java.util.ArrayList;

public class Organism {

	private String name;
	private ArrayList<Cluster> clusters = new ArrayList<>();
	
	public Organism(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Cluster> getClusters() {
		return clusters;
	}

	public void addCluster(Cluster cluster) {
		clusters.add(cluster);
	}
	
}
