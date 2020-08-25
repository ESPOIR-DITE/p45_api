package org.example.repository.image;

import org.example.domain.image.PartyImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartyImageRepository extends JpaRepository<PartyImage,String> {
}
