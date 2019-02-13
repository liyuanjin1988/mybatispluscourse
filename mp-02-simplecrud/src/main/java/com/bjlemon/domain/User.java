package com.bjlemon.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
// @TableName("sys_user")
public class User {
    // @TableId(type = IdType.UUID)
    private String id;
    private String name;
    private String email;
    @TableField("card")
    private String idCard;
}
