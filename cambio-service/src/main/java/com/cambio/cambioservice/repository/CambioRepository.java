package com.cambio.cambioservice.repository;

import com.cambio.cambioservice.Model.CambioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CambioRepository extends JpaRepository<CambioModel,Long> {

    CambioModel findByFromAndTo(String from,String to);
}
