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
@TableName("wallet_detail")
public class WalletDetail implements Serializable {

    private static final long serialVersionUID = 3678339492989079444L;

    @TableId(value = "lsh",type = IdType.AUTO)
    private Integer lsh;                //流水号

    private Integer walletId;           //钱包id

    private BigDecimal operateMoney;    // 消费或者退款

    //private Integer userId;            // 用户id

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;           // 创建时间

    //private String bz;                 // 备注

}
