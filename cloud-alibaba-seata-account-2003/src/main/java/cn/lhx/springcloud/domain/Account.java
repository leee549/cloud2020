package cn.lhx.springcloud.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author lee549
 * @date 2020/8/5 17:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_account")
public class Account {

    private Long id;
    private Long userId;
    private BigDecimal total;
    private Integer used;

    private Integer residue;

}
