package com.learn.easy.open.config.result;

import com.gitee.easyopen.ApiResult;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author 张伟
 * @version V1.0.0
 * @projectName learn_parent
 * @title MyResult
 * @package com.learn.easy.open.config.result
 * @description 自定义easy open 的数据返回格式
 * @date 2018/12/27 11:17
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class MyResult extends ApiResult {
    private String errMsg = "";

    public MyResult(Object data) {
        super(data);
    }
}
