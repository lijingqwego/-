package cn.com.user.mapper;

import java.util.List;
import java.util.Map;

import cn.com.user.pojo.PUmAuthority;
import cn.com.user.pojo.RoleAndAuthority;

public interface PUmAuthorityMapper {
    
    int deleteByPrimaryKey(String authorityid);    
    int insertSelective(PUmAuthority record);   
    PUmAuthority selectByPrimaryKey(String authorityid);
    int updateByPrimaryKeySelective(PUmAuthority record);
    List<PUmAuthority> findBySearch(Map<String,String> map);
    List<RoleAndAuthority> roleAndAuthority(String roleid);
}