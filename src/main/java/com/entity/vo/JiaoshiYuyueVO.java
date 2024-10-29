package com.entity.vo;

import com.entity.JiaoshiYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 预约信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jiaoshi_yuyue")
public class JiaoshiYuyueVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 预约编号
     */

    @TableField(value = "jiaoshi_yuyue_uuid_number")
    private String jiaoshiYuyueUuidNumber;


    /**
     * 教师
     */

    @TableField(value = "jiaoshi_id")
    private Integer jiaoshiId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 预约信息
     */

    @TableField(value = "jiaoshi_yuyue_text")
    private String jiaoshiYuyueText;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "jiaoshi_yuyue_time")
    private Date jiaoshiYuyueTime;


    /**
     * 审核状态
     */

    @TableField(value = "jiaoshi_yuyue_yesno_types")
    private Integer jiaoshiYuyueYesnoTypes;


    /**
     * 审核回复
     */

    @TableField(value = "jiaoshi_yuyue_yesno_text")
    private String jiaoshiYuyueYesnoText;


    /**
     * 预约状态
     */

    @TableField(value = "jiaoshi_yuyue_types")
    private Integer jiaoshiYuyueTypes;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：预约编号
	 */
    public String getJiaoshiYuyueUuidNumber() {
        return jiaoshiYuyueUuidNumber;
    }


    /**
	 * 获取：预约编号
	 */

    public void setJiaoshiYuyueUuidNumber(String jiaoshiYuyueUuidNumber) {
        this.jiaoshiYuyueUuidNumber = jiaoshiYuyueUuidNumber;
    }
    /**
	 * 设置：教师
	 */
    public Integer getJiaoshiId() {
        return jiaoshiId;
    }


    /**
	 * 获取：教师
	 */

    public void setJiaoshiId(Integer jiaoshiId) {
        this.jiaoshiId = jiaoshiId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：预约信息
	 */
    public String getJiaoshiYuyueText() {
        return jiaoshiYuyueText;
    }


    /**
	 * 获取：预约信息
	 */

    public void setJiaoshiYuyueText(String jiaoshiYuyueText) {
        this.jiaoshiYuyueText = jiaoshiYuyueText;
    }
    /**
	 * 设置：预约时间
	 */
    public Date getJiaoshiYuyueTime() {
        return jiaoshiYuyueTime;
    }


    /**
	 * 获取：预约时间
	 */

    public void setJiaoshiYuyueTime(Date jiaoshiYuyueTime) {
        this.jiaoshiYuyueTime = jiaoshiYuyueTime;
    }
    /**
	 * 设置：审核状态
	 */
    public Integer getJiaoshiYuyueYesnoTypes() {
        return jiaoshiYuyueYesnoTypes;
    }


    /**
	 * 获取：审核状态
	 */

    public void setJiaoshiYuyueYesnoTypes(Integer jiaoshiYuyueYesnoTypes) {
        this.jiaoshiYuyueYesnoTypes = jiaoshiYuyueYesnoTypes;
    }
    /**
	 * 设置：审核回复
	 */
    public String getJiaoshiYuyueYesnoText() {
        return jiaoshiYuyueYesnoText;
    }


    /**
	 * 获取：审核回复
	 */

    public void setJiaoshiYuyueYesnoText(String jiaoshiYuyueYesnoText) {
        this.jiaoshiYuyueYesnoText = jiaoshiYuyueYesnoText;
    }
    /**
	 * 设置：预约状态
	 */
    public Integer getJiaoshiYuyueTypes() {
        return jiaoshiYuyueTypes;
    }


    /**
	 * 获取：预约状态
	 */

    public void setJiaoshiYuyueTypes(Integer jiaoshiYuyueTypes) {
        this.jiaoshiYuyueTypes = jiaoshiYuyueTypes;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
