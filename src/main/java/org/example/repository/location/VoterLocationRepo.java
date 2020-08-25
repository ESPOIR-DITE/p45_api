package org.example.repository.location;

import org.example.domain.location.VoterLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoterLocationRepo extends JpaRepository<VoterLocation,String> {
}
