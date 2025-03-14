package com.suli.springmybaties.mapper;

import com.suli.springmybaties.model.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Mapper
public interface UserInfoMapper {
    /**
     * 解决Java命名和数据库命名冲突：
     * @return
     */
    //1.改数据库：
    /*@Select("select id, username,`password`, age, gender,  phone, " +
            "delete_flag as deleteFlag, create_time as createTime, update_time as updateTime" +
            " from user_info")
    List<UserInfo> selectAll();*/


    //2.用注解绑定：
    /*@Results(id = "BaseMap",value = {
            @Result(column = "delete_flag", property = "deleteFlag"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    @Select("SELECT * FROM `user_info`")
    List<UserInfo> selectAll();*/

    //3.用配置文件代替，看application








    /*@Select("SELECT * FROM `user_info`")
    List<UserInfo> selectAll();*/

//    @ResultMap(value = "BaseMap")，通用上面的方法二
    @Select("SELECT * FROM user_info where id = #{id}")
    UserInfo selectAllById(Integer id);

    @Select("SELECT * FROM user_info where id = ${id}")
    UserInfo selectAllById3(Integer id);

    //参数只有一个没得选，可以随便写aa
    @Select("SELECT * FROM user_info where id = #{aa}")
    List<UserInfo> selectAllById2(Integer id);

    @Select("SELECT * FROM `user_info` where username= #{username} and `password` = #{password}")
    List<UserInfo> selectByNameAndPassword(String username, String password);


    //绑定参数
    @Select("SELECT * FROM `user_info` where username= #{aa} and `password` = #{bb}")
    List<UserInfo> selectByNameAndPassword2(@Param("param1") String password, @Param("param1") String username);

    @Select("SELECT * FROM `user_info` where username= '${username}' and `password` = '${password}'")
    List<UserInfo> selectByNameAndPassword3(String username, String password);

    //获取插入时自增的id
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("INSERT INTO user_info (username,`password`,age) VALUES(#{username},#{password},#{age})")
    Integer insertUser(UserInfo userInfo);


    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("INSERT INTO user_info (username,`password`,age) " +
            "VALUES(#{userInfo.username},#{userInfo.password},#{userInfo.age})")
    Integer insertUser2(@Param("userInfo") UserInfo userInfo);

    @Select("select * from user_info order by id ${order}")
    List<UserInfo> selectUserInfoByOrder(String order);

    @Select("select * from user_info where username like '%${username}%'")
    List<UserInfo> selectUserInfoByLike(String username);
}