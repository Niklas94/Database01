package daoimpl01917;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connector01917.Connector;
import daointerfaces01917.DALException;
import daointerfaces01917.ReceptKompDAO;
import dto01917.ReceptKompDTO;

public class MySQLReceptkomponent implements ReceptKompDAO {

	@Override
	public List<ReceptKompDTO> getReceptKompList(int receptId) throws DALException {
		// TODO Auto-generated method stub
		
		List<ReceptKompDTO> list = new ArrayList<ReceptKompDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FORM RECEPTKOMPONENT WHERE RECEPT_ID = " + receptId);
		try
		{
			while (rs.next()) 
			{
				list.add(new ReceptKompDTO(rs.getInt("RECEPT_ID"), 
						rs.getInt("RAAVARE_ID"), 
						rs.getInt("NOM_NETTO"), 
						rs.getInt("TOLERANCE")));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;

	}
	
	@Override
	public ReceptKompDTO getReceptKomp(int receptId, int raavareId) throws DALException {
		// TODO Auto-generated method stub
		ResultSet rs = Connector.doQuery("SELECT * FROM RECEPTKOMPONENT WHERE RECEPT_ID = " + receptId + "AND RAAVARE_ID = " + raavareId);
		
		try {	    	
			if (!rs.first()) throw new DALException("RECEPTKOMPONENT " + receptId  + " findes ikke");
			return new ReceptKompDTO (rs.getInt("RECEPT_ID"), 
					rs.getInt("RAAVARE_ID"), 
					rs.getDouble("NOM_NETTO"), 
					rs.getDouble("TOLERANCE"));
		}
		catch (SQLException e) {throw new DALException(e); }
	}

	@Override
	public List<ReceptKompDTO> getReceptKompList() throws DALException {
		// TODO Auto-generated method stub
		
		List<ReceptKompDTO> list = new ArrayList<ReceptKompDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FORM RECEPTKOMPONENT" );
		try
		{
			while (rs.next()) 
			{
				list.add(new ReceptKompDTO(rs.getInt("RECEPT_ID"), 
						rs.getInt("RAAVARE_ID"), 
						rs.getDouble("NOM_NETTO"), 
						rs.getDouble("TOLERANCE")));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
	}

	@Override
	public void createReceptKomp(ReceptKompDTO receptkomponent) throws DALException {
		// TODO Auto-generated method stub
		
		Connector.doUpdate(
				"INSERT INTO RECEPTKOMPONENT(RECEPT_ID, RAAVARE_ID, NOM_NETTO, TOLERANCE" +
				"(" + receptkomponent.getReceptId() + ", " + 
				receptkomponent.getRaavareId() + ", " + 
				receptkomponent.getNomNetto() + ", " +
				receptkomponent.getTolerance() + ")");						
	}

	@Override
	public void updateReceptKomp(ReceptKompDTO receptkomponent) throws DALException {
		// TODO Auto-generated method stub
		Connector.doUpdate("UPDATE RECEPTKOMPONENT SET RECEPT_ID = " + 
		receptkomponent.getReceptId() + ", RAAVARE_ID = " + 
		receptkomponent.getRaavareId() + ", NOM_NETTO  = " + 
		receptkomponent.getNomNetto() + ", TOLLERANCE = " + 
		receptkomponent.getTolerance() );
	}

}
