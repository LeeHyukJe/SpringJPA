package com.victolee.guestbook.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.victolee.guestbook.domain.GuestBook;
import com.victolee.guestbook.repository.GuestBookRepository;

@Service
@Transactional
public class GuestBookService {
	
	@Autowired
	private GuestBookRepository guestbookRepository;
	
	public List<GuestBook> getMessageList(){
		return guestbookRepository.findAll();
	}
	
	public void insertMessage(GuestBook guestbook) {
		guestbook.setRegDate(new Date());
		guestbookRepository.save(guestbook);
	}
	
	public void deleteMessage(GuestBook guestbook) {
		guestbookRepository.delete(guestbook);
	}

}
