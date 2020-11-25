package com.firecode.app.controller.rule;

import com.firecode.app.controller.util.AppUtil;
import com.firecode.app.model.repository.filter.RepositoryFilter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class FilterRule {

    public String filter(RepositoryFilter filter) {

        String url = "";

        if (!StringUtils.isEmpty(filter.getFilter())) {
            url = "?filter=" + this.formatURL(filter.getFilter());
        }

        return url;

    }

    private String formatURL(String value) {
        String url = AppUtil.removeDuplicateSpace(AppUtil.convertAllLowercaseCharacters(value));
        return url.replaceAll(" ", "_");
    }

}
