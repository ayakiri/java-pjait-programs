package jdbcdemo.dao;

import jdbcdemo.domain.IHaveId;

import java.util.List;

public interface Repository <TEntity extends IHaveId> {
    public void delete(TEntity entity);
    public void add(TEntity entity);
    public void update(TEntity entity);
    public List<TEntity> getAll();
    public void createTable();
}
