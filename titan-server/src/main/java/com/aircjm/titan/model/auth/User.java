package com.aircjm.titan.model.auth;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;


/**
 * 用户 Model
 *
 * @author aircjm
 * @since 2017/7/9 22:09
 */

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class User extends Model<User> {


    @TableId
    private Integer id;

    /**
     * 账号
     */
    private String username;

    /**
     * 用户密码 md5存储
     */
    private String passwordMd5;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 用户显示名称
     */
    private String screenName;

    /**
     * 用户创建时间
     */
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime created;

    /**
     * 最后登陆时间
     */
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime logged;

    @TableField(exist = false)
    private List<Integer> roleIds;

}
