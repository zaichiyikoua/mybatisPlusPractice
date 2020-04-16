/**
 * 
 */
package com.zaichiyikou.starter.pojo;

import java.sql.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author ASUS
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysRole {
    // 分布式系统唯一ID生成方法：
    // 对应数据库中的主键(uuid,自增ID,雪花算法,redis,zookeeper等方法可以生成唯一ID)
    // mybatisPlus使用的是雪花算法
    
    
    // 初步体验自增ID 使用下面这个注解   并且数据库ID也必须要自增
    //@TableId(type = IdType.AUTO) 自增
    //IdType这是一个枚举类，进去可以看，比如手动输入，比如全局唯一ID等等
    private Long id;
    private String name;
    private String remark;
    private String available;
    // 使用注解  fill是自动填充策略，也是一个枚举类  比如插入填充字段，插入和更新填充字段等等
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date createtime;
    
//    MP乐观锁注解
//    @Version
//    private Integer version;
    
//    逻辑删除
//    @TableLogic
//    private Integer delete;

}
