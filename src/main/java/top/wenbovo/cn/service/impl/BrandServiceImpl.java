package top.wenbovo.cn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import top.wenbovo.cn.common.page.PageBean;
import top.wenbovo.cn.dto.BrandDTO;
import top.wenbovo.cn.entity.Brand;
import top.wenbovo.cn.mapper.BrandMapper;
import top.wenbovo.cn.query.BrandQuery;
import top.wenbovo.cn.service.BrandService;
import top.wenbovo.cn.service.base.impl.BaseServiceImpl;
import top.wenbovo.cn.transfer.BrandTransfer;

import java.util.List;
import java.util.Objects;


@Service
@Transactional
public class BrandServiceImpl extends BaseServiceImpl<Brand> implements BrandService {

    private final BrandMapper brandMapper;
    private final BrandTransfer brandTransfer;

    public BrandServiceImpl(BrandMapper brandMapper, BrandTransfer brandTransfer) {
        this.brandMapper = brandMapper;
        this.brandTransfer = brandTransfer;
    }

    // 根据查询条件去查询
    @Override
    public PageBean<BrandDTO> searchPage(BrandQuery brandQuery) {
        LambdaQueryWrapper<Brand> lambda = new QueryWrapper<Brand>().lambda();
        // 如果有条件，就按照条件查询
        if (!StringUtils.isEmpty(brandQuery.getBrandName())){
            lambda.like(Brand::getBrandName,brandQuery.getBrandName());
        }

        if (!StringUtils.isEmpty(brandQuery.getBrandDesc())){
            lambda.like(Brand::getBrandDesc,brandQuery.getBrandDesc());
        }

        if (Objects.nonNull(brandQuery.getStartTime()) && Objects.nonNull(brandQuery)){
            lambda.between(Brand::getCreateTime,brandQuery.getStartTime(),brandQuery.getEndTime());
        }

        // 排序(倒序)
        lambda.orderByDesc(Brand::getId);

        // 没有条件，就查询全部
        List<Brand> brands = brandMapper.selectList(lambda);

        PageInfo<Brand> pageInfo = new PageInfo<>(brands);


        List<BrandDTO> brandDTOS = brandTransfer.toDTO(brands);

        return PageBean.initData(pageInfo.getTotal(),brandDTOS);
    }
}