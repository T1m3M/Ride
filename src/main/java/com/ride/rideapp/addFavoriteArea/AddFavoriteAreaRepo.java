package com.ride.rideapp.addFavoriteArea;

import com.ride.rideapp.mappers.FavoriteAreaRowMapper;
import com.ride.rideapp.models.FavoriteArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddFavoriteAreaRepo {

    @Autowired
    private JdbcTemplate conn;

    public FavoriteArea addArea(int driver_id, String area_name) {
        String sql = "SELECT * FROM favorite_areas WHERE area_name='" + area_name + "' AND driver_id=" + driver_id;
        List<FavoriteArea> result = conn.query(sql, new FavoriteAreaRowMapper());

        if (result.isEmpty()) {
            // getting last favorite area id
            sql = "SELECT * FROM favorite_areas ORDER BY id DESC LIMIT 1";
            result = conn.query(sql, new FavoriteAreaRowMapper());

            int lastId = 0;
            if (!result.isEmpty()) lastId = result.get(0).getId();

            // saving area object
            FavoriteArea area = new FavoriteArea();
            area.setId(lastId + 1);
            area.setArea_name(area_name);
            area.setDriver_id(driver_id);

            sql = "INSERT INTO favorite_areas(id, area_name, driver_id) VALUES(?, ?, ?)";
            conn.update(
                    sql,
                    area.getId(),
                    area.getArea_name(),
                    area.getDriver_id()
            );

            return area;

        }

        return null;
    }
}
