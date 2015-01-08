import domain.Auto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import repositories.IRepository;
import repositories.impl.AutoRepository;

public class Main {

	public static void main(String[] args) {
            
            Auto auto1 = new Auto();
            auto1.setMarka("BMW");
            auto1.setModel("E36");
            auto1.setPrzebieg(10);

            String url="jdbc:hsqldb:hsql://localhost/workdb";
            try {

                Connection connection = DriverManager.getConnection(url);
                    
                    IRepository<Auto> auta = new AutoRepository(connection);
                    auta.add(auto1);
                    List<Auto> autaZBazy = auta.getAll();
                    
                    for(Auto zBazy : autaZBazy)
                            System.out.println("Marka: "+zBazy.getMarka()+"\nModel: "
                                +zBazy.getModel()+"\nCzas trwania: "+zBazy.getPrzebieg());
                   
                    Auto auto2 = auta.get(2);
                    
                    String model = "Punto";
                    String marka = "Fiat";
                    
                  
                    auto2.setMarka(marka);
                    auto2.setModel(model);
                    auta.update(auto2);
                    
                     for(Auto zBazy : autaZBazy) {
                         if (zBazy.getModel().equals(model) && zBazy.getMarka().equals(marka)) {
                             System.out.println("Po aktualizacji:\nMarka:"+zBazy.getMarka()+"\nModel: "
                                +zBazy.getModel()+"\n.Przebieg: "+zBazy.getPrzebieg());
                             
                         }
                     }
                
            } catch (SQLException e) {
                System.out.println("Wystapil blad");
                e.printStackTrace();
            }    
	}
}
