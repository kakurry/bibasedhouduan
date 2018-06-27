package com.example.bibasedhouduan.controller;

import com.example.bibasedhouduan.dto.BootstrapTablePageDTO;
import com.example.bibasedhouduan.javabean.GuanliyuanuserMst;
import com.example.bibasedhouduan.javabean.GuanliyuanuserMstExample;
import com.example.bibasedhouduan.javabean.KuneicarMst;
import com.example.bibasedhouduan.javabean.KuneicarMstExample;
import com.example.bibasedhouduan.service.KuneicarService;
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
public class KuneicarController {
    @Autowired
    @Qualifier("kuneicarServiceImpl")
    private KuneicarService kuneicarService;

    /**
     * <p>Title: queryPages</p>
     * <p>Description: 列表页分页数据</p>
     * @author hdx
     */
    @RequestMapping("querykuneicar.action")
    public @ResponseBody
    BootstrapTablePageDTO queryPages(JqPage page, Date createTime, Date updateTime, String name, String chepai, String status) {
        KuneicarMstExample criteria = new KuneicarMstExample();
        KuneicarMstExample.Criteria cri = criteria.createCriteria();
        if(createTime != null) {
            cri.andCreatetimeEqualTo(createTime);
        }
        if(updateTime != null) {
            cri.andUpdatetimeEqualTo(updateTime);
        }
        if(name != "") {	//车辆所有者
            cri.andNameEqualTo(name);
        }
        if(chepai != "") {	//车牌号
            cri.andChepaiEqualTo(chepai);
        }
        if(status != "") {	//当前状态
            cri.andStatusEqualTo(status);
        }
        List<KuneicarMst> list = kuneicarService.selectByExample(criteria);
        int count = this.kuneicarService.countByCriteria(criteria);
        BootstrapTablePageDTO bootTable = new BootstrapTablePageDTO(String.valueOf(count));
        bootTable.pageValue(page, list);
        bootTable.setPageSize(page.getPageSize() + "");
        return bootTable;
    }


    @RequestMapping("addkuneicar.action")
    public @ResponseBody String saveOrUpdate(String id,String name,String chepai,String description,String status,String money) {
        KuneicarMstExample criteria = new KuneicarMstExample();
        KuneicarMstExample.Criteria cri = criteria.createCriteria();
        cri.andNameEqualTo(name);
        KuneicarMst kuneicarMst = new KuneicarMst();
        kuneicarMst.setName(name);
        kuneicarMst.setChepai(chepai);
        kuneicarMst.setDescription(description);
        kuneicarMst.setMoney(money);
        kuneicarMst.setStatus(status);
        kuneicarMst.setCreatetime(new Date());
        kuneicarMst.setUpdatetime(new Date());
        String result = "true";
        if(id == ""){
            kuneicarMst.setId(UUIDGenerator.create32Key());
            kuneicarService.insert(kuneicarMst);
        }else{
            kuneicarMst.setId(id);
            kuneicarService.update(kuneicarMst);
        }
        return result;
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping("deletekuneika.action")
    public @ResponseBody boolean deleteTemplates(String ids) {
        String idArr[] = ids.split(",");
        List<KuneicarMst> list = new ArrayList<KuneicarMst>();
        for (int i = 0; i < idArr.length; i++) {
            KuneicarMst kuneicarMst = new KuneicarMst();
            kuneicarMst.setId(idArr[i]);
            list.add(kuneicarMst);
        }
        try {
            this.kuneicarService.batchDisabled(list);
            return true;
        }catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
