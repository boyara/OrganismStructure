package controllers;

import java.util.ArrayList;

import models.Cell;
import models.Cluster;
import models.Microbe;
import models.Organism;
import models.RedBloodCell;
import models.WhiteBloodCell;

public class HealthManager {
	
	private ArrayList<Organism> organismList = new ArrayList<>();

	public String checkCondition(String organismName) {
		
		int clusterCount = 0;
		int cellCount = 0;
		Organism currentOrganism = null;
		boolean organismExists = false;
		
		for (Organism organism : organismList) {
			if(organism.getName() == organismName) {
				organismExists = true;
				clusterCount += organism.getClusters().size();
				for (Cluster cluster : organism.getClusters()) {
					cellCount += cluster.getCells().size();
				}
				currentOrganism = organism;
			}
		}
		
		if(organismExists) {
			StringBuilder sb = new StringBuilder();
			String checkString = sb.append("Organism - ").append(organismName).append("\n").append("--Clusters: ").append(clusterCount)
					.append("\n").append("--Cells: ").append(cellCount).append("\n").append(currentOrganism.toString()).append("\n").toString();
			return checkString;
		}
		
		return null;
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
			StringBuilder sb = new StringBuilder();
			String createdOrganism = sb.append("Created organism ").append(name).append("\n").toString();
			return createdOrganism;
		}
		else {
			StringBuilder sb = new StringBuilder();
			String organismExists = sb.append("Organism ").append(name).append(" already exists").append("\n").toString();
			return organismExists;
		}
	}
	public String addCluster(String organismName, String id, int rows, int cols) {
		
		if(!checkIfOrganismExists(organismName)) {
			return null;
		}
		
		for (Organism organism : organismList) {
			if(organism.getName() == organismName) {
				for (Cluster cluster : organism.getClusters()) {
					if(cluster.getId() == id) {
						return null;
					}
				}
				Cluster newCluster = new Cluster(id, rows, cols);
				organism.addCluster(newCluster);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		String createdCluster = sb.append("Organism ").append(organismName).append(": Created cluster ").append(id).append("\n").toString();
		return createdCluster;
	}
	
	public String addCell(String organismName, String clusterId, String cellType,
			String cellId, int health, int positionRow, int positionCol, int additionalProperty) {
		
		if(!checkIfOrganismExists(organismName)) {
			return null;
		}
		
		Cell newCell = null;
		switch(cellType) {
		case "WhiteBloodCell":
			WhiteBloodCell whiteBloodCell = new WhiteBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
			newCell = whiteBloodCell;
			break;
		case "RedBloodCell":
			RedBloodCell redBloodCell = new RedBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
			newCell = redBloodCell;
			break;
		case "Virus":
		case "Fungi":
		case "Bacteria":
			Microbe microbe = new Microbe(cellId, health, positionRow, positionCol, additionalProperty);
			microbe.setMicrobeType(cellType);
			break;
		}
		for (Organism organism : organismList) {
			for (Cluster cluster : organism.getClusters()) {
				if(cluster.getId() == clusterId) {
					for (Cell cell : cluster.getCells()) {
						if(cell.getId() == cellId) {
							return null;
						}
					}
					cluster.addCell(newCell);
					StringBuilder sb = new StringBuilder();
					String createdCell = sb.append("Organism ").append(organismName).append(": Created cell ").append(cellId)
							.append(" in cluster ").append(clusterId).append("\n").toString();
					return createdCell;
				}
			}
		}
		return null;
	}
	
	public String activateCluster(String organismName) {
		
		if(!checkIfOrganismExists(organismName)) {
			return null;
		}
		
		Cluster currentCluster = null;
		int cellCount = 0;
		
		for (Organism organism : organismList) {
			if(organism.getName() == organismName) {
				organism.activateNextCluster();
				currentCluster = organism.getNextCluster();
				cellCount = currentCluster.getCells().size();
			}
		}
		
		StringBuilder sb = new StringBuilder();
		String activatedCluster = sb.append("Organism ").append(organismName).append(": Activated cluster ")
				.append(currentCluster.getId()).append(". Cells left: ").append(cellCount).append("\n").toString();
		
		return activatedCluster;
	}
	
	public boolean checkIfOrganismExists(String organismName) {
		for (Organism organism : organismList) {
			if(organism.getName() == organismName) {
				return true;
			}
		}
		return false;
	}
}
