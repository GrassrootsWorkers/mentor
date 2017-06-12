package com.dream.mentor.interfaces.company;

import com.dream.mentor.bean.company.CompanyBaseInfo;

/**
 * Created by Administrator on 2017/5/9.
 */
public interface ICompanyBaseInfoService {
    /**
     *
     * @param id
     * @return
     */
    CompanyBaseInfo queryCompanyBaseInfoById(Long id);

    /**
     *
     * @param companyName
     * @return
     */
    CompanyBaseInfo queryCompanyBaseInfoByName(String companyName);

    /**
     *
     * @param baseInfo
     */
    void save(CompanyBaseInfo baseInfo);
}
