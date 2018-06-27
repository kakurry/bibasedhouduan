package com.example.bibasedhouduan.controller;

import com.example.bibasedhouduan.dto.BootstrapTablePageDTO;
import com.example.bibasedhouduan.javabean.CarshiyongMst;
import com.example.bibasedhouduan.javabean.CarshiyongMstExample;
import com.example.bibasedhouduan.javabean.RukuMst;
import com.example.bibasedhouduan.javabean.RukuMstExample;
import com.example.bibasedhouduan.service.CarshiyongService;
import com.example.bibasedhouduan.util.JqPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class ShiyongController {
    @Autowired
    @Qualifier("carshiyongServiceImpl")
    private CarshiyongService carshiyongService;

    /**
     * <p>Title: queryPages</p>
     * <p>Description: 列表页分页数据</p>
     * @author hdx
     */
    @RequestMapping("queryshiyong.action")
    public @ResponseBody
    BootstrapTablePageDTO queryPages(JqPage page, Date createTime, Date updateTime, String name, String chepaihao) {
        CarshiyongMstExample criteria = new CarshiyongMstExample();
        CarshiyongMstExample.Criteria cri = criteria.createCriteria();
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
        List<CarshiyongMst> list = carshiyongService.selectByExample(criteria);
        int count = this.carshiyongService.countByCriteria(criteria);
        BootstrapTablePageDTO bootTable = new BootstrapTablePageDTO(String.valueOf(count));
        bootTable.pageValue(page, list);
        bootTable.setPageSize(page.getPageSize() + "");
        return bootTable;
    }

}
