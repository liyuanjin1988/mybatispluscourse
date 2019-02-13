package com.bjlemon.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

@Data
// @TableName("sys_user")
public class User extends Model {
    // @TableId(type = IdType.UUID)
    private Integer id;
    private String name;
    private String email;
    @TableField("card")
    private String idCard;

    private String sex;
    private Integer age;
}
