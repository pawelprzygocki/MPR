package repositories;

import domain.Auto;

import java.util.*;

public interface IAutoRepository extends IRepository<Auto> {
    
    public List<Auto> pokaz_model(String model);
    public List<Auto> pokaz_przebieg(int przebieg);
    
}
