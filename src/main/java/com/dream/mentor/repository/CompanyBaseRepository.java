package com.dream.mentor.repository;

import com.dream.mentor.bean.company.CompanyBaseInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/5/9.
 */
@Service("companyBaseInfoRepository")
public interface CompanyBaseRepository extends ElasticsearchRepository<CompanyBaseInfo,Long> {
    CompanyBaseInfo findByCompanyName(String companyName);

}
