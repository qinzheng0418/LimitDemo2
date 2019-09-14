package org.westos.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.westos.domain.JDBCUtils;
import org.westos.domain.PageBean;
import org.westos.domain.User;

import javax.sql.DataSource;
import java.util.List;

/**
 * @Author: ShenMouMou
 * @CreateTime: 2019-09-14 15:32
 * @Description:西部开源教育科技有限公司
 */
public class PageDao {
    private static int sum;
    static{
        try {
            sum = findAllItem();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void findLimitData(PageBean pageBean) throws Exception {
        //pageBean：当前页 每页的条数
        //private int currentPage = 1;   //当前页
        //private int pageCount = 5;       // 每页的条数
        //private int totalCount; // 总条数
        //private int totalPage;    // 总页数=总条数/每页的条数
        //private List<User> pageData; // 分页查询到的数据
        //给pageBean 把数据补完整

        //填充用户的数据到pageBean中
        pageBean.setPageData(findUserLimt(pageBean.getCurrentPage(), pageBean.getPageCount()));
        //填充了总记录数
        pageBean.setTotalCount(sum);
    }

    //查询每页的数据
    public List<User> findUserLimt(int currentPage, int pageCount) throws Exception {
        DataSource ds = JDBCUtils.getDataSouuce();
        QueryRunner queryRunner = new QueryRunner(ds);
        String sql = "select * from user limit ?,?";
        int index = (currentPage - 1) * pageCount;
        List<User> list = queryRunner.query(sql, new BeanListHandler<User>(User.class), index, pageCount);
        return list;
    }

    //查询总条数
    public static int findAllItem() throws Exception {
        DataSource ds = JDBCUtils.getDataSouuce();
        QueryRunner queryRunner = new QueryRunner(ds);
        //聚合函数 count() sum() avg() min() max()
        String sql = "select count(*) from user";
        Long sum = (Long) queryRunner.query(sql, new ScalarHandler());

        return sum.intValue();
    }
}
