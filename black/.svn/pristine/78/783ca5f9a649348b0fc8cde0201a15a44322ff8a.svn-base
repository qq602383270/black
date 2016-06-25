package com.brd.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.brd.business.userinfo.domain.UserInfo;
import com.brd.business.userinfo.service.UserInfoService;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.config.CacheConfiguration;
import net.sf.ehcache.config.Configuration;
import net.sf.ehcache.config.MemoryUnit;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/applicationContext*.xml")
public class TestCache {

	@Autowired
	UserInfoService userInfoService;

	@Test
	public void test() throws Exception {
		int i = 1;
		while (true) {
			UserInfo userInfo = userInfoService.getUserInfoById_DAO("1");
			System.out.println(userInfo);
			Thread.sleep(1000);
			while (i++ % 10 == 0) {
				System.out.println(i);
				userInfoService.deleteUserById("1");
			}
		}
	}

	@Test
	public void test2() {
		float price = 1500.00f;
		System.out.println((int) price);
		System.out.println(price);
	}

	@Test
	public void testEhCache1() {
		CacheManager cacheManager = new CacheManager(/*"src/main/resources/ehcache.xml"*/);
		// 输出当前cacheManager正在使用的配置对应的Xml格式文本
		System.out.println(cacheManager.getActiveConfigurationText());
	}

	@Test
	public void testEhCache2() {
		// 新建一个CacheManager的配置信息
		Configuration configuration = new Configuration();
		// 新建一个缓存的配置信息
		CacheConfiguration cacheConfiguration = new CacheConfiguration().name("test");
		// 指定当前缓存的最大堆内存值为100M
		cacheConfiguration.maxBytesLocalHeap(100, MemoryUnit.MEGABYTES);
		// 添加一个cache
		configuration.addCache(cacheConfiguration);
		configuration.dynamicConfig(false); // 不允许动态修改配置信息
		CacheManager cacheManager = new CacheManager(configuration);
		Cache cache = cacheManager.getCache("test");
		cache.put(new Element("test", "test"));
		System.out.println(cache.get("test").getObjectValue());
		;
	}
}
