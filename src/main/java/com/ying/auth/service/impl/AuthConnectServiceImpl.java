package com.ying.auth.service.impl;

import com.ying.auth.service.AuthConnectService;
import com.ying.auth.model.Group;
import com.ying.basis.service.CompanyService;
import org.springframework.stereotype.Service;

/**
 * @author bvvy
 * @date 2018/12/16
 */
@Service
public class AuthConnectServiceImpl implements AuthConnectService {

    private final CompanyService companyService;

    public AuthConnectServiceImpl(CompanyService companyService) {
        this.companyService = companyService;
    }

    @Override
    public Group getCompany(Integer companyId) {
        return companyService.get(companyId);
    }

}
