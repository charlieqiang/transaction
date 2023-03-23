package cn.charlie.transaction.controller;

import cn.charlie.transaction.entity.base.BaseInfo;
import cn.charlie.transaction.entity.base.BaseInfoParam;
import cn.charlie.transaction.entity.result.Result;
import cn.charlie.transaction.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author charlie
 * @date 3/23/2023 8:00 PM
 **/
@RestController
@RequestMapping("/base")
public class BaseController {

    @Autowired
    private BaseService baseService;

    @GetMapping("")
    public Result<String> getResult(@RequestParam String param) {
        return Result.success(param);
    }

    @PostMapping("")
    public Result<BaseInfo> saveBaseInfoByParam(@RequestBody BaseInfoParam baseInfoParam) throws Exception {
        return Result.success(baseService.save(baseInfoParam));
    }
}
