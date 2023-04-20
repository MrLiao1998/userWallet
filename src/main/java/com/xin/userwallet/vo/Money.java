package com.xin.userwallet.vo;

import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class Money implements Serializable {
    private static final long serialVersionUID = 4478964411571564652L;

    private Integer walletId;                  // 钱包id
    private BigDecimal money;                  // 金额
}
