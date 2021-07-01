package com.dell.training.hibernateimpl.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dell.training.hibernateimpl.entity.Review;

@Repository
@Transactional
public class ReviewRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	private Logger logger = LoggerFactory.getLogger(ReviewRepository.class);
	
	public void fetchReview() {
		Review review = this.entityManager.find(Review.class, 1);
		this.logger.info("Review : {}", review);
	}
}
