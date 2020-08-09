package cn.lhx.springcloud.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lee549
 * @date 2020/8/5 16:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_storage")

public class Storage {

    private Long id;

    private Long productId;

    private Integer total;

    private Integer used;

    private Integer residue;

}
