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
 * 预约信息
 *
 * @author 
 * @email
 */
@TableName("jiaoshi_yuyue")
public class JiaoshiYuyueEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiaoshiYuyueEntity() {

	}

	public JiaoshiYuyueEntity(T t) {
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
     * 预约编号
     */
    @ColumnInfo(comment="预约编号",type="varchar(200)")
    @TableField(value = "jiaoshi_yuyue_uuid_number")

    private String jiaoshiYuyueUuidNumber;


    /**
     * 教师
     */
    @ColumnInfo(comment="教师",type="int(11)")
    @TableField(value = "jiaoshi_id")

    private Integer jiaoshiId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 预约信息
     */
    @ColumnInfo(comment="预约信息",type="longtext")
    @TableField(value = "jiaoshi_yuyue_text")

    private String jiaoshiYuyueText;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="预约时间",type="timestamp")
    @TableField(value = "jiaoshi_yuyue_time")

    private Date jiaoshiYuyueTime;


    /**
     * 审核状态
     */
    @ColumnInfo(comment="审核状态",type="int(11)")
    @TableField(value = "jiaoshi_yuyue_yesno_types")

    private Integer jiaoshiYuyueYesnoTypes;


    /**
     * 审核回复
     */
    @ColumnInfo(comment="审核回复",type="longtext")
    @TableField(value = "jiaoshi_yuyue_yesno_text")

    private String jiaoshiYuyueYesnoText;


    /**
     * 预约状态
     */
    @ColumnInfo(comment="预约状态",type="int(11)")
    @TableField(value = "jiaoshi_yuyue_types")

    private Integer jiaoshiYuyueTypes;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="添加时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间  listShow
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
	 * 获取：预约编号
	 */
    public String getJiaoshiYuyueUuidNumber() {
        return jiaoshiYuyueUuidNumber;
    }
    /**
	 * 设置：预约编号
	 */

    public void setJiaoshiYuyueUuidNumber(String jiaoshiYuyueUuidNumber) {
        this.jiaoshiYuyueUuidNumber = jiaoshiYuyueUuidNumber;
    }
    /**
	 * 获取：教师
	 */
    public Integer getJiaoshiId() {
        return jiaoshiId;
    }
    /**
	 * 设置：教师
	 */

    public void setJiaoshiId(Integer jiaoshiId) {
        this.jiaoshiId = jiaoshiId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：预约信息
	 */
    public String getJiaoshiYuyueText() {
        return jiaoshiYuyueText;
    }
    /**
	 * 设置：预约信息
	 */

    public void setJiaoshiYuyueText(String jiaoshiYuyueText) {
        this.jiaoshiYuyueText = jiaoshiYuyueText;
    }
    /**
	 * 获取：预约时间
	 */
    public Date getJiaoshiYuyueTime() {
        return jiaoshiYuyueTime;
    }
    /**
	 * 设置：预约时间
	 */

    public void setJiaoshiYuyueTime(Date jiaoshiYuyueTime) {
        this.jiaoshiYuyueTime = jiaoshiYuyueTime;
    }
    /**
	 * 获取：审核状态
	 */
    public Integer getJiaoshiYuyueYesnoTypes() {
        return jiaoshiYuyueYesnoTypes;
    }
    /**
	 * 设置：审核状态
	 */

    public void setJiaoshiYuyueYesnoTypes(Integer jiaoshiYuyueYesnoTypes) {
        this.jiaoshiYuyueYesnoTypes = jiaoshiYuyueYesnoTypes;
    }
    /**
	 * 获取：审核回复
	 */
    public String getJiaoshiYuyueYesnoText() {
        return jiaoshiYuyueYesnoText;
    }
    /**
	 * 设置：审核回复
	 */

    public void setJiaoshiYuyueYesnoText(String jiaoshiYuyueYesnoText) {
        this.jiaoshiYuyueYesnoText = jiaoshiYuyueYesnoText;
    }
    /**
	 * 获取：预约状态
	 */
    public Integer getJiaoshiYuyueTypes() {
        return jiaoshiYuyueTypes;
    }
    /**
	 * 设置：预约状态
	 */

    public void setJiaoshiYuyueTypes(Integer jiaoshiYuyueTypes) {
        this.jiaoshiYuyueTypes = jiaoshiYuyueTypes;
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
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "JiaoshiYuyue{" +
            ", id=" + id +
            ", jiaoshiYuyueUuidNumber=" + jiaoshiYuyueUuidNumber +
            ", jiaoshiId=" + jiaoshiId +
            ", yonghuId=" + yonghuId +
            ", jiaoshiYuyueText=" + jiaoshiYuyueText +
            ", jiaoshiYuyueTime=" + DateUtil.convertString(jiaoshiYuyueTime,"yyyy-MM-dd") +
            ", jiaoshiYuyueYesnoTypes=" + jiaoshiYuyueYesnoTypes +
            ", jiaoshiYuyueYesnoText=" + jiaoshiYuyueYesnoText +
            ", jiaoshiYuyueTypes=" + jiaoshiYuyueTypes +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
