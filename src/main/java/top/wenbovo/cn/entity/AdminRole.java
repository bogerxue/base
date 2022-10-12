package top.wenbovo.cn.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

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
@TableName("t_admin_role")
public class AdminRole implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long roleId;

    private Long adminId;


}
