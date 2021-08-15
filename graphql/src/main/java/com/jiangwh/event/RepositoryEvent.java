package com.jiangwh.event;

import com.jiangwh.domain.Book;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeDelete;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

@RepositoryEventHandler
@Component
public class RepositoryEvent {

	@HandleBeforeSave
	public void handleBookSave(Book book) {
		System.out.println("save " + book);
	}


	@HandleBeforeCreate
	public void handleBookCreate(Book book){
		System.out.println("create "+ book);
	}

	@HandleBeforeDelete
	public void handleBookDelete(Book book) {
		System.out.println("del " + book);
	}

}
