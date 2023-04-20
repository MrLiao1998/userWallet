package com.xin.userwallet.controller;

import com.xin.userwallet.pojo.UserWallet;
import com.xin.userwallet.pojo.WalletDetail;
import com.xin.userwallet.service.UserWalletService;
import com.xin.userwallet.vo.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/userWallet")
public class UserWalletController {

    @Autowired
    private UserWalletService userWalletService;

    /**新增用户钱包*/
    @PostMapping("/add")
    public String addUserWallet(@RequestBody UserWallet model){
        return userWalletService.addUserWallet(model);
    }

    /**查询用户钱包余额*/
    @GetMapping("/getById")
    public String getById(@RequestBody UserWallet model){
        return userWalletService.getById(model.getWalletId());
    }

    /**用户消费*/
    @PutMapping("/costMoney")
    public String costMoney(@RequestBody Money model){
        return userWalletService.costMoney(model);
    }

    /**用户退款*/
    @PutMapping("/rollBackMoney")
    public String rollBackMoney(@RequestBody Money model){
        return userWalletService.rollBackMoney(model);
    }

    @GetMapping("/getDetail")
    public List<WalletDetail> getDetail(@RequestBody  Money model){
        return userWalletService.getDetail(model.getWalletId());
    }

}
