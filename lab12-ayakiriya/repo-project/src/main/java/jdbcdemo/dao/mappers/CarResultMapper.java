package jdbcdemo.dao.mappers;

import jdbcdemo.domain.Car;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarResultMapper implements ResultSetMapper<Car>{

    @Override
    public Car map(ResultSet rs) throws SQLException {
        Car c = new Car();
        c.setId(rs.getInt("id"));
        c.setBrand(rs.getString("brand"));
        c.setRegistration(rs.getString("registation"));
        return c;
    }
}
