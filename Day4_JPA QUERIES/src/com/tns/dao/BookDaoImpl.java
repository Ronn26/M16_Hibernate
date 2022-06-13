package com.tns.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.tns.entities.Book;

public class BookDaoImpl implements BookDao  {

	private EntityManager entityManager;
	
	public BookDaoImpl() {
		entityManager=JPAUtil.getEntityManager();
	}

	public Book getBookById(int id) {
		Book book=entityManager.find(Book.class,id);
		return book;
	}

	public List<Book> getBookByTitle(String title) 
	{
		String qstr="SELECT book FROM Book book WHERE book.title LIKE :ptitle";
		TypedQuery<Book> query= entityManager.createQuery(qstr,Book.class); 
		query.setParameter("ptitle","%"+title+"%");	
		return query.getResultList();
	}

	public Long getBookCount() 
	{
		String qstr="SELECT COUNT (book.id) from Book book";
		TypedQuery<Long> query= entityManager.createQuery(qstr,Long.class);
		Long count=query.getSingleResult();
		return count; 
		
	}

	public List<Book> getAuthorBooks(String author) 
	{
		String qstr="SELECT book FROM Book book WHERE book.author LIKE :pAuthor";
		TypedQuery<Book> query= entityManager.createQuery(qstr,Book.class); 
		query.setParameter("pAuthor",author);	
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Book> getAllBooks() {
		Query query=entityManager.createNamedQuery("getAllBookS");
		return query.getResultList();
	}

	public List<Book> getBooksInPriceRange(double low, double high)
	{
		String qstr="SELECT book FROM Book book WHERE book.title BETWEEN :low and:high";
		TypedQuery<Book> query= entityManager.createQuery(qstr,Book.class); 
		query.setParameter("low",low);
		query.setParameter("high",high);
		return query.getResultList();
	}

}
