package test01917;

import java.sql.SQLException;

import connector01917.Connector;
import daoimpl01917.MySQLRaavareBatchDAO;
import daointerfaces01917.DALException;
import dto01917.RaavareBatchDTO;

public class RaavareBatchTest {

	public static void main(String[] args) {
		try { new Connector(); } 
		catch (InstantiationException e) { e.printStackTrace(); }
		catch (IllegalAccessException e) { e.printStackTrace(); }
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		catch (SQLException e) { e.printStackTrace(); }
		
		MySQLRaavareBatchDAO raavB = new MySQLRaavareBatchDAO();
		
		System.out.println("RaavareBatch number 2: ");
		try {
			System.out.println(raavB.getRaavareBatch(2));
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Creating raavare batch with rb_id = 8");
		RaavareBatchDTO rb = new RaavareBatchDTO(8, 2, 15000);
		try {
			raavB.createRaavareBatch(rb);
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("RaavareBatch number 8: ");
		try {
			System.out.println(raavB.getRaavareBatch(8));
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Opdatering af mængde for RaavareBatch nummer 8");
		rb.setMaengde(10000);
		try { 
			raavB.updateRaavareBatch(rb);;
		} catch (DALException e) { 
			System.out.println(e.getMessage());
		}
		
		System.out.println("RaavareBatch number 8: ");
		try {
			System.out.println(raavB.getRaavareBatch(8));
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("All RaavareBatches: ");
		try {
			System.out.println(raavB.getRaavareBatchList());
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("RaavareBatch number 9: ");
		try {
			System.out.println(raavB.getRaavareBatch(9));
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}

	}

}
