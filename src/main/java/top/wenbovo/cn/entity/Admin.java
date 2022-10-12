package top.wenbovo.cn.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.wenbovo.cn.entity.Base.BaseEntity;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author jobob
 * @since 2022-07-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_admin")
public class Admin extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 管理员id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户账户登录时的用户名
     */
    private String adminAccount;

    /**
     * 管理员姓名
     */
    private String adminName;

    /**
     * 0:表示男  1:表示女
     */
    private Integer gender;

    /**
     * 手机号码
     */
    private String adminPhone;

    /**
     * 管理员邮箱
     */
    private String adminEmail;

    /**
     * 管理员头像
     */
    private String adminAvatar;

    /**
     * 员工登录密码
     */
    private String adminPassword;

    /**
     * 是否激活
     */
    private Boolean isActive;

    /**
     * 是否是超级管理员
     */
    private Boolean isAdmin;

    /**
     * 管理员薪资
     */
    private Double adminSalary;

    /**
     * 创建者
     */
    private Long createBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改者
     */
    private Long updateBy;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;


}
