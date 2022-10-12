package top.wenbovo.cn.service;


import top.wenbovo.cn.common.page.PageBean;
import top.wenbovo.cn.dto.BrandDTO;
import top.wenbovo.cn.entity.Brand;
import top.wenbovo.cn.query.BrandQuery;
import top.wenbovo.cn.service.base.BaseService;

public interface BrandService extends BaseService<Brand> {

    PageBean<BrandDTO> searchPage(BrandQuery brandQuery);

}
