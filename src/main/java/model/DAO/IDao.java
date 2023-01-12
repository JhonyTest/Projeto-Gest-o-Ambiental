
package model.DAO;

import java.util.List;

public interface IDao {

    public void save(Object obj);

    public void delete(Object obj);

    public Object find(int id);


}
