package daoimpl01917;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connector01917.Connector;
import daointerfaces01917.DALException;
import daointerfaces01917.RaavareDAO;
import dto01917.RaavareBatchDTO;
import dto01917.RaavareDTO;

public class MySQLRaavareDAO implements RaavareDAO {

	@Override
	public RaavareDTO getRaavare(int raavareId) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM RAAVARE WHERE RB_ID = " + raavareId);
	    try {
	    	if (!rs.first()) throw new DALException("Raavare " + raavareId + " findes ikke");
	    	return new RaavareDTO(rs.getInt("RAAVARE_ID"), rs.getString("RAAVARE_NAVN"), rs.getString("LEVERANDOER"));
	    }
	    catch (SQLException e) {throw new DALException(e); }
	}

	@Override
	public List<RaavareDTO> getRaavareList() throws DALException {
		List<RaavareDTO> list = new ArrayList<RaavareDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM RAAVARE");
		try
		{
			while (rs.next()) 
			{
				list.add(new RaavareDTO(rs.getInt("RAAVARE_ID"), rs.getString("RAAVARE_NAVN"), rs.getString("LEVERANDOER")));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
	}

	@Override
	public void createRaavare(RaavareDTO raavare) throws DALException {
		Connector.doUpdate(
				"INSERT INTO RAAVARE(RAAVARE_ID, RAAVARE_NAVN, LEVERANDOER) VALUES " +
						"(" + raavare.getRaavareId() + ", '" + raavare.getRaavareNavn() + "', '" + raavare.getLeverandoer() + "')"
						);
	}

	@Override
	public void updateRaavare(RaavareDTO raavare) throws DALException {
		Connector.doUpdate(
				"UPDATE RAAVARE SET RAAVARE_ID = '" + raavare.getRaavareId() + "', RAAVARE_NAVN =  '" + raavare.getRaavareNavn() + 
				"', LEVERANDOER = '" + raavare.getLeverandoer() + "'  WHERE RAAVARE_ID = " + raavare.getRaavareId()
		);
	}

}
