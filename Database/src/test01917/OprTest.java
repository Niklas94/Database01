package test01917;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import connector01917.Connector;
import daoimpl01917.MySQLOperatoerDAO;
import daointerfaces01917.DALException;
import dto01917.OperatoerDTO;

public class OprTest {
	
	MySQLOperatoerDAO opr;

	@Before
	public void setUp() throws Exception {
		try { new Connector(); } 
		catch (InstantiationException e) { e.printStackTrace(); }
		catch (IllegalAccessException e) { e.printStackTrace(); }
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		catch (SQLException e) { e.printStackTrace(); }
		opr = new MySQLOperatoerDAO();
	}
	

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void getOperator(){
		int expected = 3;
		int actual = 0;
		try { actual = opr.getOperatoer(3).getOprId(); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void getOperatorList() {
		List<OperatoerDTO> list = new ArrayList<OperatoerDTO>();
		try { list = opr.getOperatoerList(); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		int actual = list.size();
		assertTrue(actual > 0);
	}

}
