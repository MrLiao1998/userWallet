package com.xin.userwallet.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xin.userwallet.dao.UserWalletDao;
import com.xin.userwallet.pojo.UserWallet;
import com.xin.userwallet.pojo.WalletDetail;
import com.xin.userwallet.vo.Money;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
@Transactional
@Slf4j
public class UserWalletService extends ServiceImpl<UserWalletDao, UserWallet> {

    @Autowired
    private UserWalletDao userWalletDao;

    public String addUserWallet(UserWallet model){
        if(model != null){
            model.setUpdateTime(new Date());
            save(model);
            return "新增成功";
        }
        return "入参不能为空";
    }

    public String getById(Integer walletId){
        if(walletId != null){
            String res = String.valueOf(userWalletDao.selectById(walletId).getWalletMoney());
            return res;
        }
        return "0";
    }

    public String costMoney(Money model){
        if(model != null){
            BigDecimal res = userWalletDao.selectById(model.getWalletId()).getWalletMoney();
            if(res.compareTo(model.getMoney()) == -1){
                return "您的余额不足，请及时充值";
            }else{
                userWalletDao.costMoney(model);
                userWalletDao.moneyDetail_cost(model);
                return "消费成功";
            }
        }
        return "消费失败";
    }

    public String rollBackMoney(Money model){
        if(model != null){
           userWalletDao.rollBackMoney(model);
           userWalletDao.moneyDetail_add(model);
           return "退款成功";

        }
        return "退款失败";
    }

    public List<WalletDetail> getDetail (Integer walletId){
        if(walletId != null){
            return userWalletDao.getDetail(walletId);
        }
        return null;
    }

}
