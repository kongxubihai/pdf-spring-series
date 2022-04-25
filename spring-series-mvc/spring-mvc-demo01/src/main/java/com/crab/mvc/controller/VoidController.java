package com.crab.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 返回void
 *
 * @author zfd
 * @version v1.0
 * @date 2022/4/25 16:53
 */
@Controller
public class VoidController {
    /**
     * 通过HttpServletRequest重定向
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @GetMapping("/hello2")
    public void hello2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("hello").forward(req, resp);
    }

    /**
     * 通过HttpServletResponse重定向
     *
     * @param resp
     * @throws IOException
     */
    @GetMapping("/hello3")
    public void hello3(HttpServletResponse resp) throws IOException {
        resp.sendRedirect("hello");
    }

    /**
     * 通过指定响应头来实现重定向
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @GetMapping("/hello4")
    public void hello3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(302);
        resp.setHeader("Location", "hello");
    }

    /**
     * 通过HttpServletResponse 给出响应
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @GetMapping("/hello5")
    public void hello4(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.write("xxx");
        out.flush();
        out.close();
    }
}
