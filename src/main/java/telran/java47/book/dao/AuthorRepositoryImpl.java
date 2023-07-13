package telran.java47.book.dao;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import telran.java47.book.model.Author;

@Repository
public class AuthorRepositoryImpl implements AuthorRepository {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public Optional<Author> findById(String authorName) {
		return Optional.ofNullable(em.find(Author.class, authorName));
	}

	@Override
//	@Transactional
	public Author save(Author author) {
		em.persist(author);
		return author;
	}

	@Override
	public void delete(Author author) {
		Author auth = em.find(Author.class, author);
		if (auth != null) {
			em.remove(auth);
		}

	}

}
