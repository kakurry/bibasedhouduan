package com.example.bibasedhouduan.controller;

import com.example.bibasedhouduan.dto.BootstrapTablePageDTO;
import com.example.bibasedhouduan.javabean.YudingMst;
import com.example.bibasedhouduan.javabean.YudingMstExample;
import com.example.bibasedhouduan.service.YudingService;
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
public class YudingController {
    @Autowired
    @Qualifier("yudingServiceImpl")
    private YudingService yudingService;

    /**
     * <p>Title: queryPages</p>
     * <p>Description: 列表页分页数据</p>
     * @author hdx
     */
    @RequestMapping("queryyuding.action")
    public @ResponseBody
    BootstrapTablePageDTO queryPages(JqPage page, Date createTime, Date updateTime, String name, String chepaihao) {
        YudingMstExample criteria = new YudingMstExample();
        YudingMstExample.Criteria cri = criteria.createCriteria();
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
        List<YudingMst> list = yudingService.selectByExample(criteria);
        int count = this.yudingService.countByCriteria(criteria);
        BootstrapTablePageDTO bootTable = new BootstrapTablePageDTO(String.valueOf(count));
        bootTable.pageValue(page, list);
        bootTable.setPageSize(page.getPageSize() + "");
        return bootTable;
    }


    @RequestMapping("addyuding.action")
    public @ResponseBody String saveOrUpdate(String id,String name,String yudingTime,String chepaihao,String description) {
        YudingMstExample criteria = new YudingMstExample();
        YudingMstExample.Criteria cri = criteria.createCriteria();
        cri.andNameEqualTo(name);
        YudingMst yudingMst = new YudingMst();
        yudingMst.setName(name);
        yudingMst.setChepaihao(chepaihao);
        yudingMst.setDescription(description);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date0 = null;
        try {
            date0 = df.parse(yudingTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        yudingMst.setYudingtime(date0);
       //yudingMst.setYudingtime(yudingTime);
        yudingMst.setCreatetime(new Date());
        yudingMst.setUpdatetime(new Date());
        String result = "true";
        if(id == ""){
            yudingMst.setId(UUIDGenerator.create32Key());
            yudingService.insert(yudingMst);
        }else{
            yudingMst.setId(id);
            yudingService.update(yudingMst);
        }
        return result;
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping("deleteyuding.action")
    public @ResponseBody
    boolean deleteTemplates(String ids) {
        String idArr[] = ids.split(",");
        List<YudingMst> list = new ArrayList<YudingMst>();
        for (int i = 0; i < idArr.length; i++) {
            YudingMst yudingMst = new YudingMst();
            yudingMst.setId(idArr[i]);
            list.add(yudingMst);
        }
        try {
            this.yudingService.batchDisabled(list);
            return true;
        }catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
