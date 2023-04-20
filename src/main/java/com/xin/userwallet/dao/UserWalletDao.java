package com.xin.userwallet.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xin.userwallet.pojo.UserWallet;
import com.xin.userwallet.pojo.WalletDetail;
import com.xin.userwallet.vo.Money;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserWalletDao extends BaseMapper<UserWallet> {

    void costMoney(Money model);

    void rollBackMoney(Money model);

    void moneyDetail_add(Money model);

    void moneyDetail_cost(Money model);

    List<WalletDetail> getDetail(Integer wallet);
}
