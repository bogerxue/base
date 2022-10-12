package top.wenbovo.cn.transfer.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * 对象互相拷贝属性
 * @param <DTO>  DTO类型的泛型
 * @param <Entity>   Entity类型的泛型
 */
@Slf4j
public class BaseTransfer<DTO,Entity> {
    /**
     * entity转DTO
     */
    public DTO toDTO(Entity entity){
        DTO dto = null;
        try {
            // 获取类泛型的类型
            Class<DTO> clz = (Class<DTO>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
            dto = clz.newInstance();

            BeanUtils.copyProperties(entity,dto);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("实体类转换DTO错误" + e.getMessage());
        }
        return dto;
    }

    /**
     * DTO转entity
     */
    public Entity toEntity(DTO dto){
        Entity entity = null;
        try {
            // 获取类泛型的类型
            Class<Entity> clz = (Class<Entity>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
            entity = clz.newInstance();
            BeanUtils.copyProperties(dto,entity);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("DTO转换实体类错误" + e.getMessage());
        }
        return entity;
    }

    /**
     * entity集合转DTO集合
     */
    public List<DTO> toDTO(List<Entity> list){
        List<DTO> dtos = new ArrayList<>();
        list.forEach(entity -> dtos.add(toDTO(entity)));
        return dtos;
    }

    /**
     * DTO集合转entity集合
     */
    public List<Entity> toEntity(List<DTO> list){
        List<Entity> entities = new ArrayList<>();
        list.forEach(dto -> entities.add(toEntity(dto)));
        return entities;
    }
}