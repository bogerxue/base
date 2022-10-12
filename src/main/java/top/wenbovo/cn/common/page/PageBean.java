package top.wenbovo.cn.common.page;

import lombok.Data;

import java.util.List;

@Data
public class PageBean<T> {
    // 页面的总数据量
    private long total;

    // 数据
    private List<T> data;

    private PageBean(long total,List<T> data){
        this.total = total;
        this.data = data;
    }

    public static <T> PageBean<T> initData(long total,List<T> data){
        return new PageBean<T>(total,data);
    }
}
