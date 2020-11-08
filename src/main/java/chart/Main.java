package chart;
import java.util.Scanner;

import java.awt.EventQueue;


public class Main {
	
	public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
        	
        	Scanner keyboard = new Scanner(System.in);
        	System.out.println("Enter a function:\n");
        	System.out.print("y=");
        	String function= keyboard.nextLine();
        	
        	System.out.print("From: ");
        	double from = keyboard.nextDouble();
        	System.out.print("\nTo: ");
        	double to = keyboard.nextDouble();
        	System.out.print("\nWith a step of: ");
        	double step = keyboard.nextDouble();
        	
        	
        	FunctionHandler.setFunction(function);
            var ex = new LineChart(FunctionHandler.createDataset(from, to, step));
            ex.setVisible(true);
            keyboard.close();
        	
        });
	}
}