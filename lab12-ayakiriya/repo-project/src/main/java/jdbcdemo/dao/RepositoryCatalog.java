package jdbcdemo.dao;

import jdbcdemo.dao.mappers.CarResultMapper;
import jdbcdemo.dao.mappers.PersonResultMapper;
import jdbcdemo.domain.Car;
import jdbcdemo.domain.Person;

import java.sql.Connection;
import java.sql.SQLException;

public class RepositoryCatalog {
    Connection connection;

    public RepositoryCatalog(Connection connection){
        this.connection = connection;
    }

    public Repository<Person> people(){
        try {
            return new PersonRepository(connection, new PersonResultMapper());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Repository<Car> cars(){
        try {
            return new CarRepository(connection, new CarResultMapper());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
