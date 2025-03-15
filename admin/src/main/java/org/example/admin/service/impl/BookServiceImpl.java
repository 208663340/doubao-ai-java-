package org.example.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.admin.dao.entity.BookDO;
import org.example.admin.service.BookService;
import org.example.admin.dao.mapper.BookMapper;
import org.springframework.stereotype.Service;

/**
* @author 20866
* @description 针对表【book】的数据库操作Service实现
* @createDate 2025-03-15 13:23:39
*/
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, BookDO>
    implements BookService{

}




