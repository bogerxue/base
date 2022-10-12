package top.wenbovo.cn.entity.Base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import top.wenbovo.cn.common.valid.group.AddGroup;
import top.wenbovo.cn.common.valid.group.UpdateGroup;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author wenbo
 * 2022/10/4
 */

@Data
public class BaseEntity implements Serializable {
    @TableId(type = IdType.AUTO)
    @Null(message = "添加时id必须为空", groups = {AddGroup.class})//当添加时，id必须是null
    @NotNull(message = "修改时id不能为空", groups = {UpdateGroup.class})//当修改时，id必须不是null
    private Long id;
    private Long createBy;
    private LocalDateTime createTime;
    private Long updateBy;
    private LocalDateTime updateTime;

    public void setData() {
        if (id == null) {
            // 如果没有id就是添加
            this.createBy = 1L;
            this.createTime = LocalDateTime.now();
        } else {
            // 如果有id就是修改
            this.updateBy = 2L;
            this.updateTime = LocalDateTime.now();
        }
    }
}

