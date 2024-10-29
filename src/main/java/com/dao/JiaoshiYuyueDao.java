package com.dao;

import com.entity.JiaoshiYuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JiaoshiYuyueView;

/**
 * 预约信息 Dao 接口
 *
 * @author 
 */
public interface JiaoshiYuyueDao extends BaseMapper<JiaoshiYuyueEntity> {

   List<JiaoshiYuyueView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
