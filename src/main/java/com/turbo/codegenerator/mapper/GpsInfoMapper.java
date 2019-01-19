package com.turbo.codegenerator.mapper;
import java.util.List;
import com.turbo.codegenerator.model.GpsInfo;

/**
*
* @author hl.Yang
* @create 2019-1-19 15:23:10
* @desc GPS信息表（根据经纬度获取）
**/
public interface GpsInfoMapper{

    /**
    * 插入数据
    * @param entity
    * @return
    */
    int insert(GpsInfo entity);

    /**
    * 更新
    * @param entity
    * @return
    */
    int update(GpsInfo entity);

    /**
    * 通过主键更新
    * @param entity
    * @return
    */
    int updateByPrimaryKey(GpsInfo entity);

    /**
    * 获取列表
    * @param entity
    * @return
    */
    List<GpsInfo> selectByExample(GpsInfo entity);

    /**
    * 通过主键获取对象
    * @param id
    * @return
    */
    GpsInfo selectByPrimaryKey(Long id);

 }
