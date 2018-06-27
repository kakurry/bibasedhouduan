package com.example.bibasedhouduan.controller;

import com.example.bibasedhouduan.dto.BootstrapTablePageDTO;
import com.example.bibasedhouduan.javabean.RukuMst;
import com.example.bibasedhouduan.javabean.RukuMstExample;
import com.example.bibasedhouduan.service.RukuService;
import com.example.bibasedhouduan.util.JqPage;
import com.example.bibasedhouduan.util.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class RukuController {
    @Autowired
    @Qualifier("rukuServiceImpl")
    private RukuService rukuService;

    /**
     * <p>Title: queryPages</p>
     * <p>Description: 列表页分页数据</p>
     * @author hdx
     */
    @RequestMapping("queryruku.action")
    public @ResponseBody
    BootstrapTablePageDTO queryPages(JqPage page, Date createTime, Date updateTime, String name, String chepaihao) {
        RukuMstExample criteria = new RukuMstExample();
        RukuMstExample.Criteria cri = criteria.createCriteria();
        if(createTime != null) {
            cri.andCreatetimeEqualTo(createTime);
        }
        if(updateTime != null) {
            cri.andUpdatetimeEqualTo(updateTime);
        }
        if(name != "") {	//客户姓名
            cri.andNameEqualTo(name);
        }
        if(chepaihao != "") {	//车牌号码
            cri.andChepaihaoEqualTo(chepaihao);
        }
        List<RukuMst> list = rukuService.selectByExample(criteria);
        int count = this.rukuService.countByCriteria(criteria);
        BootstrapTablePageDTO bootTable = new BootstrapTablePageDTO(String.valueOf(count));
        bootTable.pageValue(page, list);
        bootTable.setPageSize(page.getPageSize() + "");
        return bootTable;
    }


    @RequestMapping("addruku.action")
    public @ResponseBody String saveOrUpdate(String id,String startTime,String endTime,String name,String chepaihao,String money) {
        RukuMstExample criteria = new RukuMstExample();
        RukuMstExample.Criteria cri = criteria.createCriteria();
        cri.andNameEqualTo(name);
        RukuMst rukuMst = new RukuMst();
        rukuMst.setName(name);
        rukuMst.setChepaihao(chepaihao);
        rukuMst.setMoney(money);
        rukuMst.setCreatetime(new Date());
        rukuMst.setUpdatetime(new Date());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date0 = null;
        Date date1 = null;
        try {
            date0 = df.parse(startTime);
            date1 = df1.parse(endTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        rukuMst.setStarttime(date0);
        rukuMst.setEndtime(date1);
        String result = "true";
        if(id == ""){
            rukuMst.setId(UUIDGenerator.create32Key());
            rukuService.insert(rukuMst);
        }else{
            rukuMst.setId(id);
            rukuService.update(rukuMst);
        }
        return result;
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping("deleteruku.action")
    public @ResponseBody
    boolean deleteTemplates(String ids) {
        String idArr[] = ids.split(",");
        List<RukuMst> list = new ArrayList<RukuMst>();
        for (int i = 0; i < idArr.length; i++) {
            RukuMst rukuMst = new RukuMst();
            rukuMst.setId(idArr[i]);
            list.add(rukuMst);
        }
        try {
            this.rukuService.batchDisabled(list);
            return true;
        }catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
