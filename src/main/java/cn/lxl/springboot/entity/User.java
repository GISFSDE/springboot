package cn.lxl.springboot.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
/**添加lombok组件后@Data注解可以实现在编译器自动添加set和get函数的效果*/
@Data
@ApiModel(description = "用户实体")
public class User {

    private Long userId;
    private String userDate;
    private String userName;
    private String userAddress;
    @ApiModelProperty("用户编号")
    private Long id;

    @NotNull
    @ApiModelProperty("用户姓名")
    private String name;

    @NotNull
    @ApiModelProperty("用户年龄")
    private Integer age;



    public User(Long userId, String userDate, String userName, String userAddress, Long id, String name, Integer age) {
        this.userId = userId;
        this.userDate = userDate;
        this.userName = userName;
        this.userAddress = userAddress;
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
