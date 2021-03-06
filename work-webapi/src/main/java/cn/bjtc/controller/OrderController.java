package cn.bjtc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.bjtc.annotation.SysLogger;
import cn.bjtc.api.ApiParam;
import cn.bjtc.api.ApiReturn;
import cn.bjtc.api.util.ParamUtil;
import cn.bjtc.aspect.AspectType;
import cn.bjtc.service.IOrderService;
import cn.bjtc.view.OrderView;
import cn.bjtc.view.OrderDetView;

@RestController
@RequestMapping("order")
public class OrderController extends BaseController {

	@RequestMapping(value="all", method=RequestMethod.POST)
	@SysLogger(content="查询订单信息",type=AspectType.CONTROLLER)
	public ApiReturn showOrder(){
		try {
			ApiParam param = findApiParam();
			OrderView view = (OrderView) ParamUtil.convertToView(param, OrderView.class);
			int count = orderService.countAllOrder(view);
			List<?> Orders = orderService.findAllOrder(view);
			apiReturn.setCount(count);
			apiReturn.setData(Orders);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	@RequestMapping(value="orderdet", method=RequestMethod.POST)
	@SysLogger(content="查询订单明细信息",type=AspectType.CONTROLLER)
	public ApiReturn showOrderDets(){
		try {
			ApiParam param = findApiParam();
			OrderDetView view = (OrderDetView) ParamUtil.convertToView(param, OrderDetView.class);
			int count = orderService.countAllOrderDets(view);
			List<?> privis = orderService.findAllOrderDets(view);
			apiReturn.setCount(count);
			apiReturn.setData(privis);
		} catch (Exception e) {
			showServerError();
		}
		return apiReturn;
	}
	@Autowired
	private IOrderService orderService;
}
