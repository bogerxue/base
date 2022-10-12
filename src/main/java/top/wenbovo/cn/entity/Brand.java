package top.wenbovo.cn.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import org.hibernate.validator.constraints.URL;
import top.wenbovo.cn.common.valid.group.AddGroup;
import top.wenbovo.cn.common.valid.group.UpdateGroup;
import top.wenbovo.cn.entity.Base.BaseEntity;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@TableName(value = "t_brand")
@Data
public class Brand extends BaseEntity {

    @NotBlank(message = "品牌名称不能为空",groups = {AddGroup.class, UpdateGroup.class})
    private String brandName;
    @NotBlank(message = "品牌站点不能为空",groups = {AddGroup.class,UpdateGroup.class})
    @URL(message = "必须输入一个链接",groups = {AddGroup.class,UpdateGroup.class})
    private String brandSite;
    private String brandLogo;
    private String brandDesc;
}

