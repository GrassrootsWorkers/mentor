package com.dream.mentor.service.company;

import com.dream.mentor.bean.company.CompanyBaseInfo;
import com.dream.mentor.interfaces.company.ICompanyBaseInfoService;
import com.dream.mentor.repository.CompanyBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/5/9.
 */
@Service
public class CompanyBaseInfoServiceImpl implements ICompanyBaseInfoService {
    @Autowired
    CompanyBaseRepository companyBaseInfoRepository;
    @Override
    public CompanyBaseInfo queryCompanyBaseInfoById(Long id) {
        return companyBaseInfoRepository.findOne(id);
    }

    @Override
    public CompanyBaseInfo queryCompanyBaseInfoByName(String companyName) {
        return companyBaseInfoRepository.findByCompanyName(companyName);
    }

    @Override
    public void save(CompanyBaseInfo baseInfo) {
        companyBaseInfoRepository.save(baseInfo);
    }
}
