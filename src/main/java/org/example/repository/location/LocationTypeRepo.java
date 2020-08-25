package org.example.repository.location;

import org.example.domain.location.LocationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationTypeRepo extends JpaRepository<LocationType,String> {
}
