package test01917;

import java.sql.SQLException;

import connector01917.Connector;
import daoimpl01917.MySQLProduktBatchDAO;
import daointerfaces01917.DALException;
import dto01917.ProduktBatchDTO;

public class ProdBatchTest {

	public static void main(String[] args) {
		try { new Connector(); } 
		catch (InstantiationException e) { e.printStackTrace(); }
		catch (IllegalAccessException e) { e.printStackTrace(); }
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		catch (SQLException e) { e.printStackTrace(); }
		
		MySQLProduktBatchDAO prodB = new MySQLProduktBatchDAO();
		
		System.out.println("ProduktBatch number 2: ");
		try {
			System.out.println(prodB.getProduktBatch(2));
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Creating produkt batch with pb_id = 6");
		ProduktBatchDTO pBDTO = new ProduktBatchDTO(6, 1, 1);
		try {
			prodB.createProduktBatch(pBDTO);
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("ProduktBatch number 6: ");
		try {
			System.out.println(prodB.getProduktBatch(6));
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Opdatering af status for ProduktBatch nummer 4");
		pBDTO.setStatus(2);
		try { 
			prodB.updateProduktBatch(pBDTO);
		} catch (DALException e) { 
			System.out.println(e.getMessage());
		}
		
		System.out.println("ProduktBatch number 6: ");
		try {
			System.out.println(prodB.getProduktBatch(6));
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("All produktBatches: ");
		try {
			System.out.println(prodB.getProduktBatchList());
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("ProduktBatch number 7: ");
		try {
			System.out.println(prodB.getProduktBatch(7));
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}
	}

}
