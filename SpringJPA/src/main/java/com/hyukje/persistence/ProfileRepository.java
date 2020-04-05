package com.hyukje.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hyukje.domain.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

}
