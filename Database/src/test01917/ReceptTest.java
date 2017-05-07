package test01917;

import java.sql.SQLException;

import connector01917.Connector;
import daoimpl01917.MySQLReceptDAO;
import daointerfaces01917.DALException;
import dto01917.ReceptDTO;

public class ReceptTest {

	public static void main(String[] args) {
		try { new Connector(); } 
		catch (InstantiationException e) { e.printStackTrace(); }
		catch (IllegalAccessException e) { e.printStackTrace(); }
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		catch (SQLException e) { e.printStackTrace(); }
		
		MySQLReceptDAO receptDAO = new MySQLReceptDAO();
		
		System.out.println("Recept number 2: ");
		try {
			System.out.println(receptDAO.getRecept(2));
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Creating recept with recept_id = 4");
		ReceptDTO recept = new ReceptDTO(4, "Death Star");
		try {
			receptDAO.createRecept(recept);
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Recept number 4: ");
		try {
			System.out.println(receptDAO.getRecept(4));
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Opdatering af navn for recept nummer 4");
		recept.setReceptNavn("Millenium Falcon");
		try { 
			receptDAO.updateRecept(recept);
		} catch (DALException e) { 
			System.out.println(e.getMessage());
		}
		
		System.out.println("Recept number 4: ");
		try {
			System.out.println(receptDAO.getRecept(4));
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("All recepts: ");
		try {
			System.out.println(receptDAO.getReceptList());
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("ProduktBatch number 5: ");
		try {
			System.out.println(receptDAO.getRecept(5));
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}

	}

}
