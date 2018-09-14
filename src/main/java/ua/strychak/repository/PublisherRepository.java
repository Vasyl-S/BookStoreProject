package ua.strychak.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.strychak.entity.Publisher;


public interface PublisherRepository extends JpaRepository<Publisher, Long> {

}
