package org.gso.brinder.match.repository;

import org.gso.brinder.match.model.Coordonnee;
import org.gso.brinder.match.model.User;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.awt.*;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    GeoResults<User> findByLocationNear(Coordonnee location, Distance distance);
}
