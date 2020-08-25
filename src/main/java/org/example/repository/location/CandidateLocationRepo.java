package org.example.repository.location;

import org.example.domain.location.CandidateLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateLocationRepo extends JpaRepository<CandidateLocation,String> {
}
