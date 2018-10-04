package com.leiyuan.bs.service.impl;

import com.leiyuan.bs.entity.Center;
import com.leiyuan.bs.entity.User;
import com.leiyuan.bs.mapper.CenterMapper;
import com.leiyuan.bs.service.CenterService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CenterServiceImpl implements CenterService {
    @Autowired
    private CenterMapper centerMapper;

    @Override
    public List<Center> queryAll(Integer type) {
        if (type != 0 && type != 1)
            return centerMapper.getAllList();
        return centerMapper.queryAll(type);
    }

    @Override
    public String newCenter(Center center, HttpServletRequest request) {
        User userSession = (User) request.getSession().getAttribute("userSession");
        if (userSession == null)
            return "error";
        else if (userSession.getState() != -1)
            return "error";
        if (verifyCenter(center)) return "error";
        centerMapper.insert(center);
        return "success";
    }

    @Override
    public Center getById(Integer centerId) {
        if (centerId == null)
            return null;
        return centerMapper.selectByPrimaryKey(centerId);
    }

    @Override
    public String updateCenter(Center center, HttpServletRequest request) {
        User userSession = (User) request.getSession().getAttribute("userSession");
        if (userSession == null)
            return "error";
        else if (userSession.getState() != -1)
            return "error";
        if (verifyCenter(center))
            return "error";
        else if (center.getId() == null)
            return "error";
        else if (centerMapper.selectByPrimaryKey(center.getId()) == null)
            return "error";
        centerMapper.updateByPrimaryKeySelective(center);
        return "success";
    }

    /**
     * 验证信息
     *
     * @param center 信息详情
     * @return true、false
     */
    private boolean verifyCenter(Center center) {
        if (center.getInfo().length() > 2000 || center.getInfo().length() < 5)
            return true;
        else if (center.getState() != 0 && center.getState() != 1)
            return true;
        else if (center.getTitle().length() > 20 || center.getTitle().length() < 3)
            return true;
        return false;
    }

    @Override
    public String deleteCenter(Integer centerId, HttpServletRequest request) {
        User userSession = (User) request.getSession().getAttribute("userSession");
        if (userSession == null)
            return "error";
        if (userSession.getState() != -1)
            return "error";
        else if (centerMapper.selectByPrimaryKey(centerId) == null)
            return "error";
        centerMapper.deleteByPrimaryKey(centerId);
        return "success";
    }
}
