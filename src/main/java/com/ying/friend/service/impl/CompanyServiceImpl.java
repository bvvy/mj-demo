package com.ying.friend.service.impl;

import com.ying.basis.model.Company;
import com.ying.basis.service.CompanyService;
import com.ying.core.basic.service.impl.SimpleBasicServiceImpl;
import com.ying.friend.repo.CompanyRepository;
import org.springframework.stereotype.Service;

/**
 * @author bvvy
 * @date 2018/12/16
 */
@Service
public class CompanyServiceImpl extends SimpleBasicServiceImpl<Company,Integer, CompanyRepository> implements CompanyService {
}
