package com.turbo.codegenerator.mapper;

import com.turbo.codegenerator.model.SchemaTable;
import com.turbo.codegenerator.model.Schemata;
import com.turbo.codegenerator.model.TableColumn;

import java.util.List;
import java.util.Map;

/**
 * @author hailong.Yang
 * @create 2018-06-03 下午2:49
 **/
public interface InformationSchemaMapper {

    List<Schemata> querySchemataList();

    List<SchemaTable> querySchemaTableList(Map<String,String> table);

    List<TableColumn> queryTableColumnList(Map<String,String> table);

}
