package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class ProgramMain {

	public static void main(String args[]) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner ler = new Scanner(System.in);
		
		System.out.print("Enter department's name: ");
		String departName = ler.nextLine();
		
		System.out.println("Enter worker data: ");
		
		System.out.println("Name: ");
		String workerName = ler.nextLine();
		
		System.out.println("Level: ");
		String workerLevel = ler.nextLine();
		
		System.out.println("Base Salary: ");
		double baseSalary = ler.nextDouble();
		
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departName));
		
		System.out.println("How many contracts to this worker? ");
		int ctt = ler.nextInt();
		
		SimpleDateFormat sidate = new SimpleDateFormat("dd/MM/yyyy");
		
		for (int i = 1; i <= ctt; i++)
		{
			System.out.println("Enter contract #"+i+" data:");
			System.out.println("Data (DD/MM/YYYY): ");
			ler.nextLine();
			Date date = sidate.parse(ler.nextLine());
			
			System.out.println("Value per hour: ");
			double vph = ler.nextDouble();
			
			System.out.println("Duration: ");
			int h = ler.nextInt();
			HourContract contract = new HourContract(date, vph, h);
			worker.addContract(contract);
		}
		
		System.out.println();
		System.out.println("Enter month and year to calculate income: ");
		String my = ler.next();
		
		int month = Integer.parseInt(my.substring(0, 2));
		
		int year = Integer.parseInt(my.substring(3));
		
		System.out.println("name: "+ worker.getName());
		System.out.println("department: "+ worker.getDepartment().getName());
		System.out.println("Income for: "+ my + ": "+ worker.income(year, month));
		
		
		ler.close();
	}

}
