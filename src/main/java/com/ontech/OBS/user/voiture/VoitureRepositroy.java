package com.ontech.OBS.user.voiture;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VoitureRepositroy extends JpaRepository<Voiture, Integer> {
    Voiture save(Voiture car);
}
