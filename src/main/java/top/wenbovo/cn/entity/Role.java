package top.wenbovo.cn.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.wenbovo.cn.entity.Base.BaseEntity;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2022-07-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_role")
public class Role extends BaseEntity {


    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色描述
     */
    private String roleDesc;



}
