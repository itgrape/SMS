package com.pushihao.service.systemManager.impl;

import com.pushihao.dao.systemManager.SystemManagerDao;
import com.pushihao.dao.systemManager.impl.SystemManagerDaoImpl;
import com.pushihao.pojo.SystemManager;
import com.pushihao.service.systemManager.SystemManagerService;

public class SystemManagerServiceImpl implements SystemManagerService {
    @Override
    public SystemManager systemManagerLogin(String email, String password) {
        SystemManagerDao managerDao = new SystemManagerDaoImpl();
        SystemManager manager = managerDao.getSystemManager();

        if(manager.getEmail().equals(email) && manager.getPassword().equals(password)) {
            return manager;
        } else {
            return null;
        }
    }
}
