package com.maha.ecommerce.repository;

import com.maha.ecommerce.model.Watch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchRepository extends JpaRepository<Watch, String> {

}
