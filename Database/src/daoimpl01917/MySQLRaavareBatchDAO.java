package daoimpl01917;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connector01917.Connector;
import daointerfaces01917.DALException;
import daointerfaces01917.RaavareBatchDAO;
import daointerfaces01917.RaavareDAO;
import dto01917.ProduktBatchKompDTO;
import dto01917.RaavareBatchDTO;

public class MySQLRaavareBatchDAO implements RaavareBatchDAO {

	@Override
	public RaavareBatchDTO getRaavareBatch(int rbId) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM RAAVAREBATCH WHERE RB_ID = " + rbId);
	    try {
	    	if (!rs.first()) throw new DALException("Raavarebatch " + rbId + " findes ikke");
	    	return new RaavareBatchDTO(rs.getInt("RB_ID"), rs.getInt("RAAVARE_ID"), rs.getDouble("MAENGDE"));
	    }
	    catch (SQLException e) {throw new DALException(e); }
	}

	@Override
	public List<RaavareBatchDTO> getRaavareBatchList() throws DALException {
		List<RaavareBatchDTO> list = new ArrayList<RaavareBatchDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM PRODUKTBATCHKOMPONENT");
		try
		{
			while (rs.next()) 
			{
				list.add(new RaavareBatchDTO(rs.getInt("RB_ID"), rs.getInt("RAAVARE_ID"), rs.getDouble("MAENGDE")));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
	}

	@Override
	public List<RaavareBatchDTO> getRaavareBatchList(int raavareId) throws DALException {
		//TODO Same as MySQLProduktBatchKomp... return all RaavareBatches containing the specific raavareId???
		List<RaavareBatchDTO> list = new ArrayList<RaavareBatchDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM PRODUKTBATCHKOMPONENT WHERE RAAVARE_ID = " + raavareId);
		try
		{
			while (rs.next()) 
			{
				list.add(new RaavareBatchDTO(rs.getInt("RB_ID"), rs.getInt("RAAVARE_ID"), rs.getDouble("MAENGDE")));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
	}

	@Override
	public void createRaavareBatch(RaavareBatchDTO raavarebatch) throws DALException {
		Connector.doUpdate(
				"INSERT INTO RAAVAREBATCH(RB_ID, RAAVARE_ID, MAENGDE) VALUES " +
						"(" + raavarebatch.getRbId() + ", " + raavarebatch.getRaavareId() + ", " + raavarebatch.getMaengde() + ")"
						);
	}

	@Override
	public void updateRaavareBatch(RaavareBatchDTO raavarebatch) throws DALException {
		Connector.doUpdate(
				"UPDATE RAAVAREBATCH SET RB_ID = " + raavarebatch.getRbId() + ", RAAVARE_ID =  " + raavarebatch.getRaavareId() + 
				", MAENGDE = " + raavarebatch.getMaengde() + "  WHERE RB_ID = " + raavarebatch.getRbId()
		);
	}



}
