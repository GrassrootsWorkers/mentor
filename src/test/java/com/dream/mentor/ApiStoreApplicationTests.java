package com.dream.mentor;

import com.dream.mentor.bean.apiinfo.ApiBaseInfo;
import com.dream.mentor.bean.apiinfo.ApiProvider;
import com.dream.mentor.bean.apiinfo.UserSubscribeApiInfo;
import com.dream.mentor.dao.api.ApiInfoDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.function.Predicate;

@RunWith(SpringRunner.class)
//@SpringBootTest(classes = SearchApplication.class)
public class ApiStoreApplicationTests {

	@Autowired
	ApiInfoDao userSubscribeApiDao;
	@Test
	public void testApiDao() {
		// 测试用户订阅的api相关dao
		long userId = 100;
		//添加
		UserSubscribeApiInfo userSubscribeApiInfo = new UserSubscribeApiInfo();
		userSubscribeApiInfo.setUserId(userId);
		userSubscribeApiInfo.setApiId(2L);
		userSubscribeApiInfo.setApiProviderId(200L);
		userSubscribeApiInfo.setUsedTimes(100);
		userSubscribeApiInfo.setAllowTimes(200);
		userSubscribeApiInfo.setPeekValue(10);
		userSubscribeApiDao.saveUserSubscribeApi(userSubscribeApiInfo);
		//查询
		List<UserSubscribeApiInfo> query = userSubscribeApiDao.queryUserSubscribeApiInfoList(userId);
		Assert.assertEquals("user subscribe size  message",1,query.size());
		//修改
		userSubscribeApiInfo.setUsedTimes(300);
		userSubscribeApiInfo.setApiId(4L);
		userSubscribeApiInfo.setApiProviderId(400L);
		userSubscribeApiDao.updateUserSubscribeApi(userSubscribeApiInfo);
		//删除
		int deleteCount = userSubscribeApiDao.deleteUserSubscribeApi(query.get(0).getId());
		Assert.assertEquals("delete message", 1, deleteCount);
		//测试api 基本信息相关Dao
		//save

		//query base
		ApiBaseInfo baseInfo = userSubscribeApiDao.queryApiBaseInfoById(1);
		// query detail
		ApiBaseInfo detaiBaseInfo = userSubscribeApiDao.queryApiDetailInfoById(1);

	}
	@Test
	public void testApiService(){
		ApiBaseInfo info = userSubscribeApiDao.queryApiBaseInfoByUrl("/api/apistore");
		 info = userSubscribeApiDao.queryApiBaseInfoById(1L);
		 info = userSubscribeApiDao.queryApiDetailInfoById(1L);
		 long apiId = info.getId();
		UserSubscribeApiInfo userSubscribeApiInfo = userSubscribeApiDao.queryUserSubscribeApiInfo(100L, apiId);
		long providerId = userSubscribeApiInfo.getApiProviderId();
		ApiProvider apiProvider = userSubscribeApiDao.queryApiProvider(apiId, providerId);


	}
	@Test
	public void testLambda(){
		Predicate predicate ;
	}
}
