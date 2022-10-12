package top.wenbovo.cn.query;


import lombok.Data;
import top.wenbovo.cn.query.base.BaseQuery;

/**
 * @author wenbo
 */
@Data
public class BrandQuery extends BaseQuery {

    private String brandName;
    private String brandDesc;
}
