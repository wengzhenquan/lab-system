package com.wzq.labsystem.service;

import com.wzq.labsystem.dto.po.Identity;
import com.wzq.labsystem.exception.ServiceException;
import com.wzq.labsystem.mapper.IdentityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdentityService {

    @Autowired
    private IdentityMapper identityMapper;

    /**
     * 获取身份列表
     * @return
     */
    public List<Identity> selectIdentityAll(){
        return identityMapper.selectAll();
    }

    /**
     * 添加身份
     * @param identity
     * @return
     */
    public Integer insertIdentity(Identity identity){
        int result = identityMapper.insert(identity);
        if(0 == result) throw new ServiceException(501, "添加失败");
        return result;
    }

    /**
     * 修改身份信息
     * @param identity
     * @return
     */
    public Integer updateIdentity(Identity identity){
        int result = identityMapper.updateByPrimaryKey(identity);
        if(0 == result) throw new ServiceException(501, "修改失败");
        return result;
    }

    /**
     * 通过ID查询
     * @param identityId
     * @return
     */
    public Identity selectIdentityById(Long identityId){
        return identityMapper.selectByPrimaryKey(identityId);
    }
}
