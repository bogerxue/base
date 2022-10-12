package top.wenbovo.cn.service.base.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import top.wenbovo.cn.mapper.base.MyMapper;
import top.wenbovo.cn.service.base.BaseService;
import top.wenbovo.cn.utils.ReflectionUtils;

import java.util.List;
public class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    private MyMapper<T> myMapper;
    @Override
    public List<T> list() {
        return myMapper.selectList(null);
    }

    @Override
    public List<T> search(QueryWrapper<T> queryWrapper) {
        return myMapper.selectList(queryWrapper);
    }

    @Override
    public T findById(Long id) {
        return myMapper.selectById(id);
    }

    @Override
    public int add(T t) {
        ReflectionUtils.invokeMethod(t,"setData",null,null);
        return myMapper.insert(t);
    }
    @Override
    public int update(T t) {
        ReflectionUtils.invokeMethod(t,"setData",null,null);
        return myMapper.updateById(t);
    }

    @Override
    public int deleteById(Long id) {

        return myMapper.deleteById(id);
    }

    @Transactional
    @Override
    public int batchDeleteByIds(List<Long> ids) {

        return myMapper.deleteBatchIds(ids);
    }
}
