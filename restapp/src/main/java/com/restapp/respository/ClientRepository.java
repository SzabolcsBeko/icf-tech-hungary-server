package com.restapp.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.restapp.entity.Client;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface ClientRepository extends JpaRepository<Client, Long> {

	@Query(value = "SELECT * FROM Client c WHERE c.id = :id", nativeQuery = true)
	Client findClientById(@Param("id") Long id);
	
	/*@Query(value = "SELECT * FROM CLIENT WHERE ID = ?1", nativeQuery = true)
	Client findClientById(String id);*/
	
	@Query(value = "SELECT * FROM Client c WHERE c.name = :name AND c.password = :password", nativeQuery = true)
	List<Client> findClinetByNameAndPassword(@Param("name") String name, @Param("password") String password);
	
	/*@Query(value = "SELECT * FROM CLIENT WHERE NAME=?1 AND PASWORD=?2", nativeQuery = true)
	Client findClientByNameAndPassword(String name, String password);*/
	
	@Query(value = "SELECT * FROM Client ORDER BY id", nativeQuery = true)
	List<Client> findAllClients(String id);
	
	@Modifying
	@Query(
	  value = 
	    "INSERT INTO Client (name, passwrd, lastLogin, roles) VALUES (:name, :passwrd, :lastLogin, :roles)", nativeQuery = true)
	void insertClient(@Param("name") String name, @Param("passwrd") String passwrd, @Param("lastLogin") String lastLogin, @Param("roles") String roles);
	

}
