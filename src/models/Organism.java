package models;

import java.util.ArrayList;

public class Organism {

	private String name;
	private ArrayList<Cluster> clusters = new ArrayList<>();
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		String organismToString = null;
		for (Cluster cluster : clusters) {
			organismToString = sb.append(cluster.toString()).append("\n").toString();
		}
		return organismToString;
	}
	
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
	
	public void activateNextCluster() {
		
	}
	
	public Cluster getNextCluster() {
		Cluster nextCluster = null;
		return nextCluster;
	}
}
