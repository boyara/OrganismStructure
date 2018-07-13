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
			if(organism.getName().equals(organismName)) {
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
					.append("\n").append("--Cells: ").append(cellCount).append("\n").append(currentOrganism.toString()).toString();
			return checkString;
		}
		
		return null;
	}
	public String createOrganism(String name) {
		Organism newOrganism = new Organism(name);

		StringBuilder sb = new StringBuilder();
		if(!checkIfOrganismExists(name)) {
			organismList.add(newOrganism);
			sb.append("Created organism ").append(name).toString();
			return sb.toString();
		}
		else {
			sb.append("Organism ").append(name).append(" already exists").toString();
			return sb.toString();
		}
	}
	public String addCluster(String organismName, String id, int rows, int cols) {

		StringBuilder sb = new StringBuilder();

		if(!checkIfOrganismExists(organismName)) {
			return sb.toString();
		}
		
		for (Organism organism : organismList) {
			if(organism.getName().equals(organismName)) {
				for (Cluster cluster : organism.getClusters()) {
					if(cluster.getId().equals(id)) {
						return sb.toString();
					}
				}
				Cluster newCluster = new Cluster(id, rows, cols);
				organism.addCluster(newCluster);
			}
		}
		
		sb.append("Organism ").append(organismName).append(": Created cluster ").append(id).append("\n").toString();
		return sb.toString();
	}
	
	public String addCell(String organismName, String clusterId, String cellType,
			String cellId, int health, int positionRow, int positionCol, int additionalProperty) {

		StringBuilder sb = new StringBuilder();
		
		if(!checkIfOrganismExists(organismName)) {
			return sb.toString();
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
			microbe.setEnergy();
			newCell = microbe;
			break;
		}
		for (Organism organism : organismList) {
			for (Cluster cluster : organism.getClusters()) {
				if(cluster.getId().equals(clusterId)) {
					for (Cell cell : cluster.getCells()) {
						if(cell.getId().equals(cellId)) {
							return sb.toString();
						}
					}
					cluster.addCell(newCell);
					sb.append("Organism ").append(organismName).append(": Created cell ").append(cellId)
							.append(" in cluster ").append(clusterId).append("\n").toString();
					return sb.toString();
				}
			}
		}
		return null;
	}
	
	public String activateCluster(String organismName) {

		StringBuilder sb = new StringBuilder();
		
		if(!checkIfOrganismExists(organismName)) {
			return sb.toString();
		}
		
		Cluster currentCluster = null;
		int cellCount = 0;
		
		for (Organism organism : organismList) {
			if(organism.getName().equals(organismName)) {
				organism.activateNextCluster();
				currentCluster = organism.getNextCluster();
				cellCount = currentCluster.getCells().size();
			}
		}
		
		sb.append("Organism ").append(organismName).append(": Activated cluster ")
				.append(currentCluster.getId()).append(". Cells left: ").append(cellCount).append("\n").toString();
		
		return sb.toString();
	}
	
	public boolean checkIfOrganismExists(String organismName) {
		for (Organism organism : organismList) {
			if(organism.getName().equals(organismName)) {
				return true;
			}
		}
		return false;
	}
}
