package cn.lhx.springcloud.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author lee549
 * @date 2020/6/29 17:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    private String serial;
}
