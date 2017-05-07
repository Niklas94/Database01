package test01917;

import java.sql.SQLException;

import connector01917.Connector;
import daoimpl01917.MySQLReceptKompDAO;
import daointerfaces01917.DALException;
import dto01917.ReceptKompDTO;


public class ReceptKompTest {

	public static void main(String[] args) {
		try { new Connector(); } 
		catch (InstantiationException e) { e.printStackTrace(); }
		catch (IllegalAccessException e) { e.printStackTrace(); }
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		catch (SQLException e) { e.printStackTrace(); }
		
		MySQLReceptKompDAO recKomp = new MySQLReceptKompDAO();
		
		System.out.println("ReceptBatch number 2 - 1: ");
		try {
			System.out.println(recKomp.getReceptKomp(2, 1));
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Creating ReceptKomponent with recept_id = 4 and raavare_id = 3");
		ReceptKompDTO receptKomp = new ReceptKompDTO(4, 3, 150000, 0.1);
		try {
			recKomp.createReceptKomp(receptKomp);
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("ReceptBatch number 4 - 3: ");
		try {
			System.out.println(recKomp.getReceptKomp(4, 3));
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Opdatering af nom_netto for ReceptBatch nummer 4 - 3");
		receptKomp.setNomNetto(10000);
		try { 
			recKomp.updateReceptKomp(receptKomp);
		} catch (DALException e) { 
			System.out.println(e.getMessage());
		}
		
		System.out.println("ReceptBatch number 4 - 3: ");
		try {
			System.out.println(recKomp.getReceptKomp(4, 3));
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("All receptBatches: ");
		try {
			System.out.println(recKomp.getReceptKompList());
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("ReceptBatch number 7 - 2: ");
		try {
			System.out.println(recKomp.getReceptKomp(7, 2));
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}
	}

	

}
