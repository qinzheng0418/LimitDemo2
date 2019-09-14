package org.westos.service;

import org.westos.dao.PageDao;
import org.westos.domain.PageBean;

/**
 * @Author: ShenMouMou
 * @CreateTime: 2019-09-14 16:05
 * @Description:西部开源教育科技有限公司
 */
public class PageService {
    public void selectData(PageBean pageBean) throws Exception {
        new PageDao().findLimitData(pageBean);//当前页码，每页的条数
    }
}
