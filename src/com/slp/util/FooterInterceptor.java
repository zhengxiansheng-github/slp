package com.slp.util;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.slp.bean.SiteInfo;
import com.slp.service.SiteInfoService;

@Component
public class FooterInterceptor implements Interceptor{
	
	@Resource
	private SiteInfoService siteInfoService;
	public void destroy() {
		
	}

	public void init() {
		
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		String [] names = {"24小时服务热线", "赛利浦官方网站", "赛利浦邮箱", "版权所有", "黑板关于", "赛利普微信"};
		List<SiteInfo> siteInfoList = siteInfoService.findSiteInfo(names);
		ActionContext.getContext().put("infoList", siteInfoList);
		return invocation.invoke();
	}

}
