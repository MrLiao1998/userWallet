package com.xin.userwallet.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("user_wallet")
public class  UserWallet implements Serializable {

    private static final long serialVersionUID = -8375576830507690524L;

    @TableId(value = "wallet_id",type = IdType.AUTO)
    private Integer walletId;                  // 钱包id

    private Integer userId;                    // 用户id

    private BigDecimal walletMoney;            // 剩余金额

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;                   // 更新时间
}
