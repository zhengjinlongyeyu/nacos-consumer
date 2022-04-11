package com.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * 定义一个接口  需要和微服务上面的做映射，每一个方法对应微服务中的一个方法，其他服务的接口正常写就可以了
 * @description 
 * @author Jeff
 * @date 2022年4月6日
 */
@FeignClient("nacostest")
public interface TsetOpenfeigen {

	@RequestMapping("/getMessage")
	public String getMessage() ;
	
	@RequestMapping("/gettest")
	public String gettest() ;
	
	@RequestMapping("/getlong")
	public String getlong(@RequestParam("aaaa") String aaaa) ;
	
	
	
	
}


