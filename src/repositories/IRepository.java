package repositories;
import java.util.List;

public interface IRepository<TEntity>{
    public void add(TEntity entity);
    public void update(TEntity entity);
    public void delete(TEntity entity); 
    public TEntity get(int id);
    public List<TEntity> getAll();
    
}
