package com.turbo.codegenerator.model.templet.mapper;

import com.turbo.codegenerator.model.templet.model.ModelTemplet;

import java.util.List;

/**
 * @author hailong.Yang
 * @create 2019-01-17 上午9:20
 **/
public interface MybatisMapperTemplet{

    /**
     * 插入数据
     * @param modelTemplet
     * @return
     */
    int insert(ModelTemplet modelTemplet);

    /**
     * 通过主键更新
     * @param modelTemplet
     * @return
     */
    int updateByPrimaryKey(ModelTemplet modelTemplet);

    /**
     * 获取列表
      * @param modelTemplet
     * @return
     */
    List<ModelTemplet> selectByModel(ModelTemplet modelTemplet);

    /**
     * 通过主键获取对象
     * @param id
     * @return
     */
    ModelTemplet selectByPrimaryKey(Long id);
}
