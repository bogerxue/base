package top.wenbovo.cn.common.http;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public enum AxiosStatus {
    OK(20000,"操作成功"),
    ERROR(5555,"操作失败"),
    FORM_VALID_ERROR(33333,"表单操作失败");

    private int status;


    private String message;

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
