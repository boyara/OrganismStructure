package run;

import java.util.Scanner;

import controllers.HealthManager;

public class Run {

	public static void main(String[] args) {

		HealthManager healthManager = new HealthManager();

		Scanner scanner = new Scanner(System.in);

		String input = scanner.nextLine();
		while (!input.equals("BEER IS COMING")) {
			String[] inputString = input.split(" ");

			switch (inputString[0]) {

			case "checkCondition":
				System.out.print(healthManager.checkCondition(inputString[1]));
				break;
			case "createOrganism":
				System.out.println(healthManager.createOrganism(inputString[1]));
				break;
			case "addCluster":
				System.out.print(healthManager.addCluster(inputString[1], inputString[2],
						Integer.parseInt(inputString[3]), Integer.parseInt(inputString[4])));
				break;
			case "addCell":
				System.out.print(healthManager.addCell(inputString[1], inputString[2], inputString[3], inputString[4],
						Integer.parseInt(inputString[5]), Integer.parseInt(inputString[6]),
						Integer.parseInt(inputString[7]), Integer.parseInt(inputString[8])));
				break;
			case "activateCluster":
				System.out.println(healthManager.activateCluster(inputString[1]));
				break; 
			}

			input = scanner.nextLine();
		}

		scanner.close();
	}
}
