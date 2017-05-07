package daoimpl01917;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connector01917.Connector;
import daointerfaces01917.DALException;
import daointerfaces01917.ProduktBatchDAO;
import dto01917.OperatoerDTO;
import dto01917.ProduktBatchDTO;

public class MySQLProduktBatchDAO implements ProduktBatchDAO{

	@Override
	public ProduktBatchDTO getProduktBatch(int pbId) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM PRODUKTBATCH WHERE PB_ID = " + pbId);
	    try {
	    	if (!rs.first()) throw new DALException("Produktbatch " + pbId + " findes ikke");
	    	return new ProduktBatchDTO (rs.getInt("PB_ID"), rs.getInt("RECEPT_ID"), rs.getInt("STATUS"));
	    }
	    catch (SQLException e) {throw new DALException(e); }
	}

	@Override
	public List<ProduktBatchDTO> getProduktBatchList() throws DALException {
		List<ProduktBatchDTO> list = new ArrayList<ProduktBatchDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM produktbatch");
		try
		{
			while (rs.next()) 
			{
				list.add(new ProduktBatchDTO(rs.getInt("PB_ID"), rs.getInt("RECEPT_ID"), rs.getInt("STATUS")));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
	}

	@Override
	public void createProduktBatch(ProduktBatchDTO produktbatch) throws DALException {
		Connector.doUpdate(
				"INSERT INTO PRODUKTBATCH(PB_ID, RECEPT_ID, STATUS) VALUES " +
						"(" + produktbatch.getPbId() + ", " + produktbatch.getReceptId() + ", " + produktbatch.getStatus() + ")"
				);
	}

	@Override
	public void updateProduktBatch(ProduktBatchDTO produktbatch) throws DALException {
		// TODO Auto-generated method stub
		Connector.doUpdate(
				"UPDATE PRODUKTBATCH SET PB_ID = " + produktbatch.getPbId() + ", RECEPT_ID =  " + produktbatch.getReceptId() + 
				", STATUS = " + produktbatch.getStatus() + " WHERE PB_ID = " +
				produktbatch.getPbId() + ")"
		);
	}

}
