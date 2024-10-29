package com.dao;

import com.entity.JiaoshiCommentbackEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JiaoshiCommentbackView;

/**
 * 教师评价 Dao 接口
 *
 * @author 
 */
public interface JiaoshiCommentbackDao extends BaseMapper<JiaoshiCommentbackEntity> {

   List<JiaoshiCommentbackView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
