package cn.lxl.springboot.config;


import cn.lxl.springboot.entity.StudentProperties;
import cn.lxl.springboot.entity.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;
/*测试均在主程序类*/


//将配置文件中的bean注入容器
@ImportResource("classpath:beans.xml")
//告诉springboot这是个配置类
// proxybeanMethods：代理bean的方法
//     Full模式：@Configuration(proxybeanMethods=true)  全模式      记录上次用的bean，检查组件是否在容器中有，单实例
//     Lite模式：@Configuration(proxybeanMethods=false) 轻量级模式  每次加载新的bean，跳过检查
@Configuration
// 表示通过aop框架暴露该代理对象,AopContext能够访问
@EnableAspectJAutoProxy(exposeProxy = true)
//给容器中自动创建出对应类型的组件、默认组件名为其全类名、使用其无参构造函数
//@Import({User.class})

//当不能在原类中添加@component注解时（比如用他人包时），则在使用的地方添加此注解,作用是开启student配置绑定功能且将其注入到容器中
//@EnableConfigurationProperties(StudentProperties.class)
public class MyConfig {
    //给容器添加组件，一方法名作为组件的id。返回类型就是组件类型。返回的值就是组建在容器中的实例
    @Bean
    public User user01() {
        return new User(111111111L, "1", 1);
    }
//条件装配，有name为user01 的bean才注入注解下的student的bean，反之有 @ConditionalOnMissingBean

    @ConditionalOnBean(name = "user02")
    @Bean
    public StudentProperties student() {
        return new StudentProperties();
    }
    @ConditionalOnBean(name = "user01")
    @Bean
    public StudentProperties student1() {
        return new StudentProperties();
    }
}
