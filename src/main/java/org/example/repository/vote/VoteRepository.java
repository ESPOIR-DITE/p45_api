package org.example.repository.vote;

import org.example.domain.vote.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends JpaRepository<Vote,String> {
    long countByCandidateId(String candidateId);

}
