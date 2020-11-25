package com.firecode.app.model.repository.query;

import com.firecode.app.model.entity.CoacheeEntity;
import com.firecode.app.model.repository.filter.RepositoryFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CoacheeRepositoryQuery {

    Page<CoacheeEntity> findAllPaginator(RepositoryFilter filter, Pageable pageable);

}
