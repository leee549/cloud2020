package cn.lhx.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lee549
 * @date 2020/6/29 18:28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JsonResult<T> {
    private Integer code;
    private String msg;
    private T data;

    public static <T> JsonResult<Object> success(Integer code,String msg,T data){
        return JsonResult.builder().code(code).msg(msg).data(data).build();
    }



}
