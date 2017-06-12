package com.dream.mentor.bean.company;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

/**
 * Created by Administrator on 2017/5/8.
 */
@Document(indexName = "qdjk", type = "company",shards = 3, replicas = 1, refreshInterval = "2s")
public class CompanyBaseInfo {
    @Id
    private Long id;
    @Field
    private String companyName;
    @Field
    private String address;
    @Field
    private int minNumPeople;
    @Field
    private int maxNunPeople;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getMinNumPeople() {
        return minNumPeople;
    }

    public void setMinNumPeople(int minNumPeople) {
        this.minNumPeople = minNumPeople;
    }

    public int getMaxNunPeople() {
        return maxNunPeople;
    }

    public void setMaxNunPeople(int maxNunPeople) {
        this.maxNunPeople = maxNunPeople;
    }
}
