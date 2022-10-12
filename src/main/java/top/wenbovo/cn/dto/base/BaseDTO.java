package top.wenbovo.cn.dto.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 统一返回给前端数据格式的基类
 */
@Data
public class BaseDTO {
    // id
    private Long id;
    // 创建者
    @JsonIgnore//表示转成json数据时，忽略这个属性
    private Long createBy;
    // 更改者
    @JsonIgnore
    private Long updateBy;
    // 创建时间
    @JsonIgnore
    private LocalDateTime createTime;

    // 更改时间
    @JsonIgnore
    private LocalDateTime updateTime;
}
