package com.restapi.crawling.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.restapi.crawling.domain.CrawlingData;


@Repository
@Transactional(readOnly = true)
public class CrawlingDataRepository implements CrawlingDataRepositoryInterface{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<CrawlingData> findByUserId(String userId){
		return em.createQuery("select d from data d where d.user_id = userid", CrawlingData.class)
				.setParameter("userid", userId)
				.getResultList();
	}

	@Override
	public List<CrawlingData> findBySiteName(String siteName){
		return em.createQuery("select d from data d where d.sitename = :sitename", CrawlingData.class)
				.setParameter("sitename", siteName)
				.getResultList();
	}

	
	@Override
	@Transactional
	public void save(CrawlingData crawlingData) {
		em.persist(crawlingData);
	}

	@Override
	public Optional<CrawlingData> findById(Long idx) {
		CrawlingData data = em.find(CrawlingData.class, idx);
		return Optional.ofNullable(data);
	}

	@Override
	public List<CrawlingData> findAll() {
		return em.createQuery("select d from data d", CrawlingData.class)
				.getResultList();
	}
}
