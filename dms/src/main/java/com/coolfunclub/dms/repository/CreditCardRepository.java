package com.coolfunclub.dms.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.coolfunclub.dms.model.CreditCard;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long>{

}
