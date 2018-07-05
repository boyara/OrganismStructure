package managers;

import java.util.ArrayList;

import models.Cell;
import models.Cluster;
import models.Organism;

public class HealthManager {
	
	private ArrayList<Organism> organismList = new ArrayList<>();

	public String checkCondition(String organismName) {
		
	}
	public String createOrganism(String name) {
		Organism newOrganism = new Organism(name);
		boolean exists = false;
		for (Organism organism : organismList) {
			if(organism.getName() == name) {
				exists = true;
			}
		}
		if(!exists) {
			organismList.add(newOrganism);	
			return "Created organism " + name;
		}
		else {
			return "Organism " + name + " already exists";
		}
	}
	public String addCluster(String organismName, String id, int rows, int cols) {
		for (Organism organism : organismList) {
			boolean clusterExists = false;
			if(organism.getName() == organismName) {
				for (Cluster cluster : organism.getClusters()) {
					if(cluster.getId() == id) {
						clusterExists = true;
						return null;
					}
				}
				Cluster newCluster = new Cluster(id, rows, cols);
				organism.addCluster(newCluster);
			}
		}
		return "Organism " + organismName + ": Created cluster " + id;
	}
	public String addCell(String organismName, String clusterId, String cellType,
			String cellId, int health, int positionRow, int positionCol, int additionalProperty) {
		Cell newCell = new Cell(cellId, health, positionRow, positionCol, additionalProperty);
	}
	public String activateCluster(String organismName) {
		
	}

}
