package test01917;

import java.sql.SQLException;

import connector01917.Connector;
import daoimpl01917.MySQLRaavareDAO;
import daointerfaces01917.DALException;
import dto01917.RaavareDTO;


public class RaavareTest {

	public static void main(String[] args) {
		try { new Connector(); } 
		catch (InstantiationException e) { e.printStackTrace(); }
		catch (IllegalAccessException e) { e.printStackTrace(); }
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		catch (SQLException e) { e.printStackTrace(); }
		
		MySQLRaavareDAO raav = new MySQLRaavareDAO();
		
		System.out.println("Raavare number 2: ");
		try {
			System.out.println(raav.getRaavare(2));
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Creating raavare with raavare_id = 8");
		RaavareDTO raavare = new RaavareDTO(8, "Pepperoni", "Something something Darkside!");
		try {
			raav.createRaavare(raavare);
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Raavare number 8: ");
		try {
			System.out.println(raav.getRaavare(8));
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Opdatering af lavandoer for raaavare nummer 8");
		raavare.setLeverandoer("Luke, I am your father!");
		try { 
			raav.updateRaavare(raavare);
		} catch (DALException e) { 
			System.out.println(e.getMessage());
		}
		
		System.out.println("Raavare number 8: ");
		try {
			System.out.println(raav.getRaavare(8));
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("All Raavarer: ");
		try {
			System.out.println(raav.getRaavareList());
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Raavare number 9: ");
		try {
			System.out.println(raav.getRaavare(9));
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}

	}

}
