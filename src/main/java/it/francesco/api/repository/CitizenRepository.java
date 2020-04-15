package it.francesco.api.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.francesco.api.model.Citizen;

@Repository
public interface CitizenRepository extends PagingAndSortingRepository<Citizen, Long> {

	@Query("SELECT c FROM Citizen c WHERE c.fiscalCode LIKE :fiscalCode%")
	public List<Citizen> findCitizensByFiscalCode(@Param("fiscalCode") String fiscalCode, Pageable pageable);
	
	@Query("SELECT COUNT(c) FROM Citizen c WHERE c.fiscalCode LIKE :fiscalCode% ")
	public int getCount(@Param("fiscalCode") String fiscalCode);
}
