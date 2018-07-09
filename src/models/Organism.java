package models;

import java.util.ArrayList;

public class Organism {

	private String name;
	private ArrayList<Cluster> clusters = new ArrayList<>();
	private int nextClusterId = 0;
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Cluster cluster : clusters) {
			sb.append(cluster.toString()).append("\n").toString();
		}
		return sb.toString();
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
		clusters.get(nextClusterId).activateCluster();
		nextClusterId++;
	}
	
	public Cluster getNextCluster() {
		Cluster nextCluster = clusters.get(nextClusterId);
		return nextCluster;
	}
}
