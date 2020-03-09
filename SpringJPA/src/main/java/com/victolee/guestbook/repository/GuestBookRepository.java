package com.victolee.guestbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victolee.guestbook.domain.GuestBook;


public interface GuestBookRepository extends JpaRepository<GuestBook, Integer>{

}
