package top.wenbovo.cn.dto;


import lombok.Data;
import top.wenbovo.cn.dto.base.BaseDTO;

/**
 * @author wenbo
 */
@Data
public class BrandDTO extends BaseDTO {
    private String brandName;
    private String brandSite;
    private String brandLogo;
    private String brandDesc;


}
