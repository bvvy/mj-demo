package com.ying.basis.service.impl;

import com.ying.auth.model.Group;
import com.ying.basis.service.CompanyService;
import com.ying.core.basic.service.impl.SimpleBasicServiceImpl;
import com.ying.basis.repo.CompanyRepository;
import org.springframework.stereotype.Service;

/**
 * @author bvvy
 * @date 2018/12/16
 */
@Service
public class CompanyServiceImpl extends SimpleBasicServiceImpl<Group,Integer, CompanyRepository> implements CompanyService {
}
