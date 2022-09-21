package com.pushihao.service.systemManager;

import com.pushihao.pojo.SystemManager;

public interface SystemManagerService {

    /**检查管理员登录信息是否正确
     * @return 返回null代表登录失败，返回管理员实体代表登录成功
     * */
    public SystemManager systemManagerLogin(String email, String password);
}
