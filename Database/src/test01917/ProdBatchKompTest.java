package test01917;

import java.sql.SQLException;

import connector01917.Connector;
import daoimpl01917.MySQLProduktBatchKompDAO;
import daointerfaces01917.DALException;
import dto01917.ProduktBatchKompDTO;

public class ProdBatchKompTest {

	public static void main(String[] args) {
		try { new Connector(); } 
		catch (InstantiationException e) { e.printStackTrace(); }
		catch (IllegalAccessException e) { e.printStackTrace(); }
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		catch (SQLException e) { e.printStackTrace(); }
		
		MySQLProduktBatchKompDAO prodBK = new MySQLProduktBatchKompDAO();
		
		System.out.println("ProduktBatchKomp number 2 - 2: ");
		try {
			System.out.println(prodBK.getProduktBatchKomp(2, 2));
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Creating ProduktBatchKomp number 5 - 1");
		ProduktBatchKompDTO pBKDTO = new ProduktBatchKompDTO(5, 1, 0.5, 10.01, 3);
		try {
			prodBK.createProduktBatchKomp(pBKDTO);;
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("ProduktBatchKomp number 5 - 1: ");
		try {
			System.out.println(prodBK.getProduktBatchKomp(5, 1));
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Updating ProduktBatchKomp number 5 - 1 opr_id");
		pBKDTO.setOprId(2);
		try { 
			prodBK.updateProduktBatchKomp(pBKDTO); 
		} catch (DALException e) { 
			System.out.println(e.getMessage());
		}
		
		System.out.println("ProduktBatchKomp number 5 - 1: ");
		try {
			System.out.println(prodBK.getProduktBatchKomp(5, 1));
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("All produktBatches: ");
		try {
			System.out.println(prodBK.getProduktBatchKompList());
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("ProduktBatchKomp number 6 - 1: ");
		try {
			System.out.println(prodBK.getProduktBatchKomp(6, 1));
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}

	}

}
