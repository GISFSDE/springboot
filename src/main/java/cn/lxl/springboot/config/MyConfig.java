package cn.wmyskxz.springboot.config;


import cn.wmyskxz.springboot.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**配置类
 * @author lxl
 * /@Configuration告诉SpringBoot这是一个配置类
 * proxyBeanMethods = true 表示创建单例对象,有线程安全问题  为Full组件依赖
 * proxyBeanMethods = false 表示创建多例对象，为Lite组件依赖,每次创建对象不会检查容器中是否有此对象从而直接创建新对象。别人不会依赖设置为false启动会更快。
 * */
@Configuration(proxyBeanMethods = true)
public class MyConfig {

    /**
     * 给容器中添加组件，以方法名为组件的ID,返回类型就是组件类型，返回的值就是组件在容器中的实例
     */
    @Bean
    public User user01() {
        return new User(11111111111L, "lxl", 1);
    }


}
