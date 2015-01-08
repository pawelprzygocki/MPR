
package repositories.impl;

import domain.Auto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import repositories.IRepository;


public class AutoRepository implements IRepository<Auto> {
    
    private Connection connection;
    
    private String insertSql=
                    "INSERT INTO auto(marka,model,przebieg) VALUES (?,?,?)";
    private String selectByModelSql=
                    "SELECT * FROM auto WHERE model=?";
    private String selectByIdSql=
                    "SELECT * FROM auto WHERE id=?";
    private String updateSql=
                    "UPDATE auto SET model=? WHERE id=?";
    private String selectAllSql=
                    "SELECT * FROM auto";
    private String deleteSql=
			"DELETE FROM auto WHERE id=?";

    private PreparedStatement insert;
    private PreparedStatement selectById;
    private PreparedStatement selectByModel;
    private PreparedStatement update;
    private PreparedStatement selectAll;
    private PreparedStatement delete;

    public AutoRepository(Connection connection) {

            this.connection = connection;
            try 
            {
                    insert = connection.prepareStatement(insertSql);
                    selectById=connection.prepareStatement(selectByIdSql);
                    update=connection.prepareStatement(updateSql);
                    delete=connection.prepareStatement(deleteSql);
                    selectAll=connection.prepareStatement(selectAllSql);
                    selectByModel=connection.prepareStatement(selectByModelSql);

            } catch (Exception e) {
                e.printStackTrace();
            }
    }
        
    @Override
	public List<Auto> getAll() {

		List<Auto> result = new ArrayList<Auto>();
		try {
			ResultSet rs = selectAll.executeQuery();
			while(rs.next())
			{
				Auto auto = new Auto();
				auto.setId(rs.getInt("id"));
				auto.setMarka(rs.getString("marka"));
				auto.setModel(rs.getString("model"));
                                auto.setPrzebieg(rs.getInt("przebieg"));
				result.add(auto);
			}	
		} catch (SQLException e) {
                        System.out.println("wystapil blad");
			e.printStackTrace();
		}
		return result;
	}
    
   
    public List<Auto> get_model(String nazwa) {
        
            ArrayList<Auto> result = new ArrayList<Auto>();
            try {

                    ResultSet rs = selectAll.executeQuery();
                    
                    
                    while(rs.next())
                    {
                            Auto auto = new Auto();
                            auto.setId(rs.getInt("id"));
                            auto.setMarka(rs.getString("marka"));
                            auto.setPrzebieg(rs.getInt("przebieg"));
                            auto.setModel(rs.getString("model"));
                            
                            if(auto.getModel().equals(nazwa))  {
                                result.add(auto);
                        }
                    }    
                            return result;                       
            } catch (SQLException e) {
                    System.out.println("wystapil blad");
                    e.printStackTrace();
            }
            return null;
    }
    
    public List<Auto> get_przebieg(int przebieg) {
            
            ArrayList<Auto> result = new ArrayList<Auto>();
            try {
                    ResultSet rs = selectAll.executeQuery();
                    while(rs.next())
                    {
                            Auto auto = new Auto();
                            auto.setId(rs.getInt("id"));
                            auto.setMarka(rs.getString("marka"));
                            auto.setModel(rs.getString("model"));
                            auto.setPrzebieg(rs.getInt("przebieg"));
                            if (auto.getPrzebieg() < przebieg) {
                                result.add(auto);
                            }
                            return result;
                    }
            } catch (SQLException e) {
                System.out.println("wystapil blad");
                e.printStackTrace();
            }
            return null;
    }
    
    @Override
	public void add(Auto entity) {
		
		try {
			insert.setString(2, entity.getMarka());
                        insert.setString(3, entity.getModel());
			insert.setInt(4, entity.getPrzebieg());
			insert.executeUpdate();
		} catch (SQLException e) {
                        System.out.println("wystapil blad");
			e.printStackTrace();
		}
	}

	@Override
	public void update(Auto entity) {

		try {
			update.setString(1, entity.getModel());
                        update.setInt(2, entity.getId());
			update.executeUpdate();
		} catch (SQLException e) {
                        System.out.println("wystapil blad");
			e.printStackTrace();
                }	
	}

	@Override
	public void delete(Auto entity) {
		try {
			delete.setInt(1, entity.getId());
			delete.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public Auto get(int id) {

		try {
			selectById.setInt(1, id);
			ResultSet rs = selectById.executeQuery();
			while(rs.next())
			{
				Auto auto = new Auto();
                                auto.setId(rs.getInt("id"));
                                auto.setMarka(rs.getString("marka"));
                                auto.setModel(rs.getString("model"));
                                auto.setPrzebieg(rs.getInt("przebieg"));
				return auto;
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	} 
}
