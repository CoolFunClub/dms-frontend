package com.coolfunclub.dms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.coolfunclub.dms.model.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase,Long>{

}
