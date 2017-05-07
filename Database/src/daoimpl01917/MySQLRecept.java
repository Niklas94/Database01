package daoimpl01917;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connector01917.Connector;
import daointerfaces01917.DALException;
import dto01917.ReceptDTO;

import daointerfaces01917.ReceptDAO;

public class MySQLRecept  implements ReceptDAO {


	@Override
	public List<ReceptDTO> getReceptList() throws DALException {
		// TODO Auto-generated method stub
		List<ReceptDTO> list = new ArrayList<ReceptDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM RECEPT");
		try
		{
			while (rs.next()) 
			{
				list.add(new ReceptDTO(rs.getInt("RECEPT_ID"), 
						rs.getString("RECEPT_NAVN")));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
	}

	@Override
	public void createRecept(ReceptDTO recept) throws DALException {
		// TODO Auto-generated method stub		
		Connector.doUpdate(
				"INSTER INTO RECEPT(RECEPT_ID, RAAVARE_ID, MAENGDE) values" + 
						"(" + recept.getReceptId() + ", '" + 
						recept.getReceptNavn() + "')" 
				);						
	}

	@Override
	public void updateRecept(ReceptDTO recept) throws DALException {
		// TODO Auto-generated method stub

		Connector.doUpdate(
				"UPDATE RECEPT SET RECEPT_ID = " + 
				recept.getReceptId() + ", RECEPT_NAVN = '" + 
				recept.getReceptNavn() + "'");
	}

	@Override
	public ReceptDTO getRecept(int receptId) throws DALException {
		// TODO Auto-generated method stub

		ResultSet rs = Connector.doQuery("SETLECT * FROM RECEPT WHERE RECEPT_ID = " + receptId);
		try {	    	
			if (!rs.first()) throw new DALException("RECEPT" + receptId  + " findes ikke");
			return new ReceptDTO (rs.getInt("recept_id"), rs.getString("recept_navn"));
		}
		catch (SQLException e) {throw new DALException(e); }

	}	
}
