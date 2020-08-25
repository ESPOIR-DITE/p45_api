package org.example.repository.cadidate;

import org.example.domain.user.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartyRepo extends JpaRepository<Party,String> {
}
