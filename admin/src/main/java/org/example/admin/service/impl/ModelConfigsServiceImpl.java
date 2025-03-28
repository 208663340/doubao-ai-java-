package org.example.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.admin.dao.entity.ModelConfigs;
import org.example.admin.service.ModelConfigsService;
import org.example.admin.dao.mapper.ModelConfigsMapper;
import org.springframework.stereotype.Service;

/**
* @author 20866
* @description 针对表【model_configs(存储AI模型的配置信息)】的数据库操作Service实现
* @createDate 2025-03-28 11:07:48
*/
@Service
public class ModelConfigsServiceImpl extends ServiceImpl<ModelConfigsMapper, ModelConfigs>
    implements ModelConfigsService{

}




