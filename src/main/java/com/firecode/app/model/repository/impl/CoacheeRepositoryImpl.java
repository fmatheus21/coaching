package com.firecode.app.model.repository.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import com.firecode.app.model.entity.CoacheeEntity;
import com.firecode.app.model.repository.filter.RepositoryFilter;
import com.firecode.app.model.repository.query.CoacheeRepositoryQuery;

public class CoacheeRepositoryImpl implements CoacheeRepositoryQuery {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<CoacheeEntity> findAllPaginator(RepositoryFilter filter, Pageable pageable) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<CoacheeEntity> criteriaQuery = builder.createQuery(CoacheeEntity.class);
        Root<CoacheeEntity> root = criteriaQuery.from(CoacheeEntity.class);

        Predicate[] predicates = createRestrictions(filter, builder, root);
        criteriaQuery.where(predicates);

        TypedQuery<CoacheeEntity> typedQuery = manager.createQuery(criteriaQuery);

        addPageRestrictions(typedQuery, pageable);

        return new PageImpl<>(typedQuery.getResultList(), pageable, total(filter));
    }

    private Predicate[] createRestrictions(RepositoryFilter filter, CriteriaBuilder builder, Root<CoacheeEntity> root) {
        List<Predicate> predicates = new ArrayList();

        if (!StringUtils.isEmpty(filter.getFilter())) {
            predicates.add(builder.like(builder.lower(root.<String>get("search")), "%" + filter.getFilter().replaceAll("_", " ").toLowerCase() + "%"));
        }

        return predicates.toArray(new Predicate[predicates.size()]);
    }

    private void addPageRestrictions(TypedQuery<CoacheeEntity> typedQuery, Pageable pageable) {
        int currentPage = pageable.getPageNumber();
        int totalRecordsPerPage = pageable.getPageSize();
        int firstPageRecord = currentPage * totalRecordsPerPage;

        typedQuery.setFirstResult(firstPageRecord);
        typedQuery.setMaxResults(totalRecordsPerPage);
    }

    private Long total(RepositoryFilter filter) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = builder.createQuery(Long.class);
        Root<CoacheeEntity> root = criteriaQuery.from(CoacheeEntity.class);

        Predicate[] predicates = createRestrictions(filter, builder, root);
        criteriaQuery.where(predicates);

        criteriaQuery.select(builder.count(root));

        return manager.createQuery(criteriaQuery).getSingleResult();
    }

}
