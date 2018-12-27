package com.learn.easy.open.config.result;

import com.gitee.easyopen.Result;
import com.gitee.easyopen.ResultCreator;

/**
 * @author 张伟
 * @version V1.0.0
 * @projectName learn_parent
 * @title MyResultCreator
 * @package com.learn.easy.open.config.result
 * @description 自定义返回结果生成类
 * @date 2018/12/27 11:26
 */
public class MyResultCreator implements ResultCreator {
    @Override
    public Result createResult(Object returnObj) {
        return new MyResult(returnObj);
    }

    @Override
    public Result createErrorResult(Object code, String errorMsg, Object data) {
        MyResult myResult = new MyResult();
        myResult.setErrMsg(errorMsg);
        myResult.setMsg(errorMsg);
        myResult.setCode(code);
        myResult.setData(data);
        return myResult;
    }
}
