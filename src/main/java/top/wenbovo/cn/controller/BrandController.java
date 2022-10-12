package top.wenbovo.cn.controller;

import com.github.pagehelper.PageHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.wenbovo.cn.common.http.AxiosResult;
import top.wenbovo.cn.common.page.PageBean;
import top.wenbovo.cn.common.valid.group.AddGroup;
import top.wenbovo.cn.common.valid.group.UpdateGroup;
import top.wenbovo.cn.controller.base.BaseController;
import top.wenbovo.cn.dto.BrandDTO;
import top.wenbovo.cn.entity.Brand;
import top.wenbovo.cn.query.BrandQuery;
import top.wenbovo.cn.service.BrandService;
import top.wenbovo.cn.transfer.BrandTransfer;


import java.util.List;

/**
 * @author wenbo
 */
@RestController
@RequestMapping("brand")
public class BrandController extends BaseController {
    @Autowired
    private BrandService brandService;
    @Autowired
    private BrandTransfer brandTransfer;

    /**
     * 条件分页查询
     * @param brandQuery  分页查询的对象
     * @return
     */
    @GetMapping("searchPage")
    public AxiosResult<PageBean<BrandDTO>> searchPage(BrandQuery brandQuery){
        // 开启分页查询
        PageHelper.startPage(brandQuery.getCurrentPage(),brandQuery.getPageSize());
        // 根据查询条件去查询
        PageBean<BrandDTO> pageBean = brandService.searchPage(brandQuery);
        // 返回给前端结果
        return AxiosResult.success(pageBean);
    }

    /**
     * 查询所有
     */
    @GetMapping
    public AxiosResult<List<BrandDTO>> list(){
        return AxiosResult.success(brandTransfer.toDTO(brandService.list()));
    }

    /**
     * 根据id查询一条数据
     */
    @GetMapping("{id}")
    public  AxiosResult<BrandDTO> findById(@PathVariable Long id){
        return AxiosResult.success(brandTransfer.toDTO(brandService.findById(id)));
    }

    /**
     * 添加品牌数据
     * 针对swagger接口文档的注解:
     * @ApiOperation(value = “接口说明”, httpMethod = “接口请求方式”, response =
     * “接口返回参数类型”, notes = “接口发布说明”
     */
    @PostMapping
    public AxiosResult add(@Validated(AddGroup.class) @RequestBody Brand brand){
        return toAxios(brandService.add(brand));
    }

    /**
     * 修改品牌数据
     */
    @PutMapping
    public AxiosResult<Void> update(@RequestBody @Validated(UpdateGroup.class) Brand brand){
        return toAxios(brandService.update(brand));
    }

    /**
     * 删除一条数据
     */
    @DeleteMapping("{id}")
    public AxiosResult<Void> deleteById(@PathVariable Long id){
        return toAxios(brandService.deleteById(id));
    }

    /**
     * 删除多条数据
     */
    @DeleteMapping("batch/{ids}")
    public AxiosResult<Void> batchDeleteByIds(@PathVariable List<Long> ids){
        return toAxios(brandService.batchDeleteByIds(ids));
    }
}
