package top.wenbovo.cn.common.exception;


import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.wenbovo.cn.common.http.AxiosResult;
import top.wenbovo.cn.common.http.AxiosStatus;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理表单校验异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public AxiosResult<String> handlerFormValidException(MethodArgumentNotValidException e){
        BindingResult bindingResult = e.getBindingResult();

        boolean b = bindingResult.hasFieldErrors();
        AxiosStatus formValidError = AxiosStatus.FORM_VALID_ERROR;
        // 获取表单校验错误信息
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        if (!CollectionUtils.isEmpty(fieldErrors)){
            FieldError fieldError = fieldErrors.get(0);
            String defaultMessage = fieldError.getDefaultMessage();
            formValidError.setMessage(defaultMessage);
            return AxiosResult.error(formValidError);
        }
        formValidError.setMessage("表单校验错误");
        return AxiosResult.error(formValidError);
    }
}
