package top.wenbovo.cn.controller.base;


import top.wenbovo.cn.common.http.AxiosResult;

/**
 * @author wenbo
 */
public class BaseController {

    protected AxiosResult<Void> toAxios(int row){

        return row > 0 ? AxiosResult.success():AxiosResult.error();
    }
}
