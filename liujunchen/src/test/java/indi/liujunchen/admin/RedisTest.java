package indi.liujunchen.admin;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import indi.liujunchen.admin.common.utils.RedisUtils;
import indi.liujunchen.admin.modules.sys.entity.SysUserEntity;
import indi.liujunchen.admin.modules.sys.service.SysUserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private SysUserService sysUserService;

    @Test
    public void test(){
        SysUserEntity user = sysUserService.queryObject(1L);
        System.out.println(ToStringBuilder.reflectionToString(user));

        redisUtils.set("user", user);

        user = redisUtils.get("user", SysUserEntity.class);
        System.out.println(ToStringBuilder.reflectionToString(user));
    }
}
