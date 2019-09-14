package org.westos.web;

import org.westos.domain.PageBean;
import org.westos.service.PageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: ShenMouMou
 * @CreateTime: 2019-09-14 16:00
 * @Description:西部开源教育科技有限公司
 */
@WebServlet(name = "PageServlet",value = "/page")
public class PageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int pageNum=1;
            //获取当前的页码
            String currentPage = request.getParameter("currentPage");
            if(currentPage!=null){
                pageNum = Integer.parseInt(currentPage);
            }else{
                pageNum = 1;
            }
            //把页码封装到pageBean
            PageBean pageBean = new PageBean();
            pageBean.setCurrentPage(pageNum);
            //把pageBean传给service
            new PageService().selectData(pageBean);

            //
            //System.out.println(pageBean);
            //System.out.println(pageBean.getCurrentPage());
            //System.out.println(pageBean.getTotalPage());
            //System.out.println(pageBean.getPageCount());
            //System.out.println(pageBean.getPageData());
            //System.out.println(pageBean.getTotalCount());

            //把pageBean存到域中
            request.setAttribute("pageBean",pageBean);
            //转发到页面
            request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request,response);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
