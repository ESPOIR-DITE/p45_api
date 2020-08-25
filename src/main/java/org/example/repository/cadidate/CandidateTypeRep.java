package org.example.repository.cadidate;

import org.example.domain.user.CandidateType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateTypeRep extends JpaRepository<CandidateType,String> {
}
