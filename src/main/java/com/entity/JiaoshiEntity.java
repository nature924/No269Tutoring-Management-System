package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 教师
 *
 * @author 
 * @email
 */
@TableName("jiaoshi")
public class JiaoshiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiaoshiEntity() {

	}

	public JiaoshiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 账户
     */
    @ColumnInfo(comment="账户",type="varchar(200)")
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @ColumnInfo(comment="密码",type="varchar(200)")
    @TableField(value = "password")

    private String password;


    /**
     * 教师名称
     */
    @ColumnInfo(comment="教师名称",type="varchar(200)")
    @TableField(value = "jiaoshi_name")

    private String jiaoshiName;


    /**
     * 教师手机号
     */
    @ColumnInfo(comment="教师手机号",type="varchar(200)")
    @TableField(value = "jiaoshi_phone")

    private String jiaoshiPhone;


    /**
     * 教师头像
     */
    @ColumnInfo(comment="教师头像",type="varchar(200)")
    @TableField(value = "jiaoshi_photo")

    private String jiaoshiPhoto;


    /**
     * 性别
     */
    @ColumnInfo(comment="性别",type="int(11)")
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 教师邮箱
     */
    @ColumnInfo(comment="教师邮箱",type="varchar(200)")
    @TableField(value = "jiaoshi_email")

    private String jiaoshiEmail;


    /**
     * 预约价格
     */
    @ColumnInfo(comment="预约价格",type="decimal(10,2)")
    @TableField(value = "jiaoshi_mone")

    private Double jiaoshiMone;


    /**
     * 教师类型
     */
    @ColumnInfo(comment="教师类型",type="int(11)")
    @TableField(value = "jiaoshi_types")

    private Integer jiaoshiTypes;


    /**
     * 现有余额
     */
    @ColumnInfo(comment="现有余额",type="decimal(10,2)")
    @TableField(value = "new_money")

    private Double newMoney;


    /**
     * 个人介绍
     */
    @ColumnInfo(comment="个人介绍",type="longtext")
    @TableField(value = "jiaoshi_content")

    private String jiaoshiContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "jiaoshi_delete")

    private Integer jiaoshiDelete;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="添加时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }
    /**
	 * 设置：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }
    /**
	 * 设置：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：教师名称
	 */
    public String getJiaoshiName() {
        return jiaoshiName;
    }
    /**
	 * 设置：教师名称
	 */

    public void setJiaoshiName(String jiaoshiName) {
        this.jiaoshiName = jiaoshiName;
    }
    /**
	 * 获取：教师手机号
	 */
    public String getJiaoshiPhone() {
        return jiaoshiPhone;
    }
    /**
	 * 设置：教师手机号
	 */

    public void setJiaoshiPhone(String jiaoshiPhone) {
        this.jiaoshiPhone = jiaoshiPhone;
    }
    /**
	 * 获取：教师头像
	 */
    public String getJiaoshiPhoto() {
        return jiaoshiPhoto;
    }
    /**
	 * 设置：教师头像
	 */

    public void setJiaoshiPhoto(String jiaoshiPhoto) {
        this.jiaoshiPhoto = jiaoshiPhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }
    /**
	 * 设置：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：教师邮箱
	 */
    public String getJiaoshiEmail() {
        return jiaoshiEmail;
    }
    /**
	 * 设置：教师邮箱
	 */

    public void setJiaoshiEmail(String jiaoshiEmail) {
        this.jiaoshiEmail = jiaoshiEmail;
    }
    /**
	 * 获取：预约价格
	 */
    public Double getJiaoshiMone() {
        return jiaoshiMone;
    }
    /**
	 * 设置：预约价格
	 */

    public void setJiaoshiMone(Double jiaoshiMone) {
        this.jiaoshiMone = jiaoshiMone;
    }
    /**
	 * 获取：教师类型
	 */
    public Integer getJiaoshiTypes() {
        return jiaoshiTypes;
    }
    /**
	 * 设置：教师类型
	 */

    public void setJiaoshiTypes(Integer jiaoshiTypes) {
        this.jiaoshiTypes = jiaoshiTypes;
    }
    /**
	 * 获取：现有余额
	 */
    public Double getNewMoney() {
        return newMoney;
    }
    /**
	 * 设置：现有余额
	 */

    public void setNewMoney(Double newMoney) {
        this.newMoney = newMoney;
    }
    /**
	 * 获取：个人介绍
	 */
    public String getJiaoshiContent() {
        return jiaoshiContent;
    }
    /**
	 * 设置：个人介绍
	 */

    public void setJiaoshiContent(String jiaoshiContent) {
        this.jiaoshiContent = jiaoshiContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getJiaoshiDelete() {
        return jiaoshiDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setJiaoshiDelete(Integer jiaoshiDelete) {
        this.jiaoshiDelete = jiaoshiDelete;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Jiaoshi{" +
            ", id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", jiaoshiName=" + jiaoshiName +
            ", jiaoshiPhone=" + jiaoshiPhone +
            ", jiaoshiPhoto=" + jiaoshiPhoto +
            ", sexTypes=" + sexTypes +
            ", jiaoshiEmail=" + jiaoshiEmail +
            ", jiaoshiMone=" + jiaoshiMone +
            ", jiaoshiTypes=" + jiaoshiTypes +
            ", newMoney=" + newMoney +
            ", jiaoshiContent=" + jiaoshiContent +
            ", jiaoshiDelete=" + jiaoshiDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
