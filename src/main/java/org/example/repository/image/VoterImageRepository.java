package org.example.repository.image;

import org.example.domain.image.VoterImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoterImageRepository extends JpaRepository<VoterImage,String> {
}
