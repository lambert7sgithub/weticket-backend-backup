package com.thoughtworks.training.repository;

import com.thoughtworks.training.entity.SocialForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialFormRepository extends JpaRepository<SocialForm, Integer> {
}
