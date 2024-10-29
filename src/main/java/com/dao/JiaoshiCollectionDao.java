package com.dao;

import com.entity.JiaoshiCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JiaoshiCollectionView;

/**
 * 教师收藏 Dao 接口
 *
 * @author 
 */
public interface JiaoshiCollectionDao extends BaseMapper<JiaoshiCollectionEntity> {

   List<JiaoshiCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
