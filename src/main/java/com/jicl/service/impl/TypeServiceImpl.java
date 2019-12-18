package com.jicl.service.impl;

import com.jicl.entity.Type;
import com.jicl.entity.TypeExample;
import com.jicl.mapper.TypeMapper;
import com.jicl.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * 博客类型管理服务实现类
 *
 * @author : xianzilei
 * @date : 2019/12/2 18:49
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    /**
     * 功能描述: 获取所有博客类型的key和value
     *
     * @return java.util.List<com.jicl.entity.Type>
     * @author xianzilei
     * @date 2019/12/2 18:50
     **/
    @Override
    public Map<Integer, String> getAllTypes() {
        TypeExample typeExample = new TypeExample();
        typeExample.createCriteria().andDelFlagEqualTo(false);
        List<Type> types = typeMapper.selectByExample(typeExample);
        return types.stream().collect(Collectors.toMap(Type::getTypeId, Type::getTypeName,
                (key1, key2) -> key2));
    }

    /**
     * 功能描述: 返回所有类型信息列表
     *
     * @return java.util.List<com.jicl.entity.Type>
     * @author xianzilei
     * @date 2019/12/18 9:37
     **/
    @Override
    public List<Type> getAll() {
        TypeExample typeExample = new TypeExample();
        typeExample.createCriteria().andDelFlagEqualTo(false);
        return typeMapper.selectByExample(typeExample);
    }
}
