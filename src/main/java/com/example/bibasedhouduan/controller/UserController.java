package com.example.bibasedhouduan.controller;

import com.example.bibasedhouduan.dto.BootstrapTablePageDTO;
import com.example.bibasedhouduan.javabean.UserMst;
import com.example.bibasedhouduan.javabean.UserMstExample;
import com.example.bibasedhouduan.service.UserService;
import com.example.bibasedhouduan.util.JqPage;
import com.example.bibasedhouduan.util.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    /**
     * <p>Title: queryPages</p>
     * <p>Description: 列表页分页数据</p>
     * @author hdx
     */
    @RequestMapping("querykauser.action")
    public @ResponseBody
    BootstrapTablePageDTO queryPages(JqPage page, Date createTime, Date updateTime, String name, String telephone, String shenfenzheng,String dizhi,String email) {
        UserMstExample criteria = new UserMstExample();
        UserMstExample.Criteria cri = criteria.createCriteria();
        if(createTime != null) {
            cri.andCreatetimeEqualTo(createTime);
        }
        if(updateTime != null) {
            cri.andUpdatetimeEqualTo(updateTime);
        }
        if(name != "") {	//客户姓名
            cri.andNameEqualTo(name);
        }
        if(telephone != "") {	//客户电话
            cri.andTelephoneEqualTo(telephone);
        }
        if(shenfenzheng != "") {	//省份证号码
            cri.andShenfenzhengEqualTo(shenfenzheng);
        }
        List<UserMst> list = userService.selectByExample(criteria);
        int count = this.userService.countByCriteria(criteria);
        BootstrapTablePageDTO bootTable = new BootstrapTablePageDTO(String.valueOf(count));
        bootTable.pageValue(page, list);
        bootTable.setPageSize(page.getPageSize() + "");
        return bootTable;
    }


    @RequestMapping("addcaruser.action")
    public @ResponseBody String saveOrUpdate(String id,String name,String telephone,String dizhi,String email,String shenfenzheng) {
        UserMstExample criteria = new UserMstExample();
        UserMstExample.Criteria cri = criteria.createCriteria();
        cri.andNameEqualTo(name);
        UserMst userMst = new UserMst();
        userMst.setName(name);
        userMst.setDizhi(dizhi);
        userMst.setTelephone(telephone);
        userMst.setEmail(email);
        userMst.setShenfenzheng(shenfenzheng);
        userMst.setCreatetime(new Date());
        userMst.setUpdatetime(new Date());
        String result = "true";
        if(id == ""){
            userMst.setId(UUIDGenerator.create32Key());
            userService.insert(userMst);
        }else{
            userMst.setId(id);
            userService.update(userMst);
        }
        return result;
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping("deletecaruser.action")
    public @ResponseBody
    boolean deleteTemplates(String ids) {
        String idArr[] = ids.split(",");
        List<UserMst> list = new ArrayList<UserMst>();
        for (int i = 0; i < idArr.length; i++) {
            UserMst userMst = new UserMst();
            userMst.setId(idArr[i]);
            list.add(userMst);
        }
        try {
            this.userService.batchDisabled(list);
            return true;
        }catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
