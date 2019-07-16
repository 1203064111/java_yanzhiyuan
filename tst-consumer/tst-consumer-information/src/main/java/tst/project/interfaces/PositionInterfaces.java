package tst.project.interfaces;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.hp.hpl.sparta.xpath.TrueExpr;

import tst.project.aspect.AppController;
import tst.project.bean.information.AdvertiseOrderBean;
import tst.project.bean.information.AssessmentBean;
import tst.project.bean.information.MaterialBean;
import tst.project.bean.information.MemberAssessmentBean;
import tst.project.bean.information.PayDetailBean;
import tst.project.bean.information.PositionBean;
import tst.project.bean.information.PositionClassBean;
import tst.project.bean.information.PositionPersonsBean;
import tst.project.bean.information.RequirePositionBean;
import tst.project.bean.information.SalaryBean;
import tst.project.bean.information.SystemInformationClassBean;
import tst.project.bean.member.BankCardBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.sheep.MemberSignBean;
import tst.project.information.interfaces.IPositionService;
import tst.project.page.PageBean;
import tst.project.utils.WXUtils;

@Controller
@RequestMapping("/positionInterfaces/v1.0")
public class PositionInterfaces {
	@Autowired
	IPositionService positionService;
	
	@RequestMapping("/getMemberSignByMemberId")
	@AppController(isVerToken=true)
	public Object getMemberSignByMemberId(MemberSignBean memberSignBean)throws Exception{
		return positionService.getMemberSignByMemberId(memberSignBean);
	}
	/*
	 * 签到
	 */
	@RequestMapping("/updateMemberSign")
	@AppController(isVerToken=true)
	public Object updateMemberSign(MemberSignBean memberSignBean)throws Exception{
		return positionService.updateMemberSign(memberSignBean);
	}
	/**
	 * 
	 * @param memberAssessmentBean
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getMemberAssessmentByMemberId")
	@AppController(isPage=true)
	public Object getMemberAssessmentByMemberId(MemberAssessmentBean memberAssessmentBean,PageBean pageBean)throws Exception{
		return positionService.getMemberAssessmentByMemberId(memberAssessmentBean,pageBean);
	}
	
	@RequestMapping("/getPayDetailsByMember")
	@AppController(isVerToken=true,isPage=true)
	public Object getPayDetailsByMember(PayDetailBean payDetailBean,PageBean pageBean)throws Exception{
		return positionService.getPayDetailsByMember(payDetailBean,pageBean);
	}
	
	@RequestMapping("/insertMemberAssessment")
	@AppController(isVerToken=true)
	public Object insertMemberAssessment(MemberAssessmentBean memberAssessmentBean)throws Exception{
		return positionService.insertMemberAssessment(memberAssessmentBean);
	}
	
	/**
	 * 认证资料的职位列表
	 * @param positionBean
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getPositionsByMaterialId")
	@AppController(isPage=true)
	public Object getPositionsByMaterialId(PositionBean positionBean,PageBean pageBean)throws Exception{
		return positionService.getPositionsByMaterialId(positionBean,pageBean);
	}
	/*
	 * 认证信息详情
	 */
	@RequestMapping("/getMaterialById")
	@AppController
	public Object getMaterialById(MaterialBean materialBean)throws Exception{
		return positionService.getMaterialById(materialBean);
	}
	/**
	 * 用户的认证信息
	 * @param memberBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getMaterialByMemberId")
	@AppController(isVerToken=true)
	public Object getMaterialByMemberId(MemberBean memberBean)throws Exception{
		return positionService.getMaterialByMemberId(memberBean);
	}
	/**
	 * 认证资料的评论列表
	 * @param assessmentBean
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getAssessmentsByMaterial")
	@AppController(isPage=true)
	public Object getAssessmentsByMaterial(AssessmentBean assessmentBean,PageBean pageBean)throws Exception{
		return positionService.getAssessmentsByMaterial(assessmentBean,pageBean);
	}
	@RequestMapping("/insertAssessment")
	@AppController(isVerToken=true)
	public Object insertAssessment(AssessmentBean assessmentBean)throws Exception{
		return positionService.insertAssessment(assessmentBean);
	}
	@RequestMapping("/getAssessmentByMember")
	@AppController()
	public Object getAssessmentByMember(AssessmentBean assessmentBean)throws Exception{
		return positionService.getAssessmentByMember(assessmentBean);
	}
	@RequestMapping("/getMemberAssessment")
	@AppController()
	public Object getMemberAssessment(MemberAssessmentBean memberAssessmentBean)throws Exception{
		return positionService.getMemberAssessment(memberAssessmentBean);
	}
	
	/**
	 * 用户的投递列表
	 * @param positionPersonsBean
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getPositionPersonsByMember")
	@AppController(isVerToken=true,isPage=true)
	public Object getPositionPersonsByMember(PositionPersonsBean positionPersonsBean,PageBean pageBean)throws Exception{
		return positionService.getPositionPersonsByMember(positionPersonsBean,pageBean);
	}
	/**
	 * 用户的进展中列表
	 * @param positionPersonsBean
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getMiddlePositionPersonsByMember")
	@AppController(isVerToken=true,isPage=true)
	public Object getMiddlePositionPersonsByMember(PositionPersonsBean positionPersonsBean,PageBean pageBean)throws Exception{
		return positionService.getMiddlePositionPersonsByMember(positionPersonsBean,pageBean);
	}
	/**
	 * 用户已录取列表
	 * @param positionPersonsBean
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getFinalPositionPersonsByMember")
	@AppController(isVerToken=true,isPage=true)
	public Object getFinalPositionPersonsByMember(PositionPersonsBean positionPersonsBean,PageBean pageBean)throws Exception{
		return positionService.getFinalPositionPersonsByMember(positionPersonsBean,pageBean);
	}
	/**
	 * 已完成的金额汇总
	 * @param positionPersonsBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getFinalAmountByMember")
	@AppController(isVerToken=true)
	public Object getFinalAmountByMember(PositionPersonsBean positionPersonsBean)throws Exception{
		return positionService.getFinalAmountByMember(positionPersonsBean);
	}
	
	
	/**
	 * 邀请
	 * @param require_position_id
	 * @param position_id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/inviteRequirePosition")
	@AppController(isVerToken=true)
	public Object inviteRequirePosition(String require_position_id,String position_id)throws Exception{
		return positionService.inviteRequirePosition(position_id, require_position_id);
	}
	
	/**
	 * 邀请的职位列表
	 * @param requirePositionBean
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getinvateRequirePositions")
	@AppController(isPage=true)
	public Object getinvateRequirePositions(RequirePositionBean requirePositionBean,PageBean pageBean)throws Exception{
		return positionService.getinvateRequirePositions(requirePositionBean,pageBean);
	}
	/**
	 * 认证信息
	 * @param positionBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getMaterial")
	@AppController(isVerToken=true)
	public Object getMaterial(PositionBean positionBean)throws Exception{
		return positionService.getMaterial(positionBean);
	}	
	
	/**
	 * 搜索职位
	 * @param positionBean
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/searchPositions")
	@AppController(isPage=true)
	public Object searchPositions(PositionBean positionBean, PageBean pageBean)throws Exception{
		return positionService.searchPositions(positionBean, pageBean);
	}	
	/**
	 * 搜索简历
	 * @param requirePositionBean
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/searchRequirePositions")
	@AppController(isPage=true)
	public Object searchRequirePositions(RequirePositionBean requirePositionBean, PageBean pageBean)throws Exception{
		return positionService.searchRequirePositions(requirePositionBean, pageBean);
	}
	
	/**
	 * 订单支付价格
	 * @param invitation_num
	 * @param price
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getAdvertiseOrderPay")
	@AppController
	public Object getAdvertiseOrderPay(String invitation_num,String price)throws Exception{
		return positionService.getAdvertiseOrderPay(invitation_num, price);
	}
	/**
	 * 支付最终订单
	 * @param advertiseOrderBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/payRealAdvertiseOrder")
	@AppController
	public Object payRealAdvertiseOrder(AdvertiseOrderBean advertiseOrderBean)throws Exception{
		return positionService.payRealAdvertiseOrder(advertiseOrderBean);
	}	
	/**
	 * 支付订单
	 * @param advertiseOrderBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/payFinalAdvertiseOrder")
	@AppController
	public Object payFinalAdvertiseOrder(AdvertiseOrderBean advertiseOrderBean)throws Exception{
		return positionService.payFinalAdvertiseOrder(advertiseOrderBean);
	}
	/**
	 * 添加订单
	 * @param advertiseOrderBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertAdvertiseOrder")
	@AppController(isVerToken=true)
	public Object insertAdvertiseOrder(AdvertiseOrderBean advertiseOrderBean)throws Exception{
		return positionService.insertAdvertiseOrder(advertiseOrderBean);
	}	
	/**
	 * 订单详情
	 * @param advertiseOrderBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getAdvertiseOrder")
	@AppController
	public Object getAdvertiseOrder(AdvertiseOrderBean advertiseOrderBean)throws Exception{
		return positionService.getAdvertiseOrder(advertiseOrderBean);
	}
	/**
	 * 添加订单
	 * @param advertiseOrderBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertFinalAdvertiseOrder")
	@AppController
	public Object insertFinalAdvertiseOrder(AdvertiseOrderBean advertiseOrderBean)throws Exception{
		return positionService.insertFinalAdvertiseOrder(advertiseOrderBean);
	}	
	/**
	 * 职位列表
	 * @param positionBean
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getPositions")
	@AppController(isPage=true)
	public Object getPositions(PositionBean positionBean, PageBean pageBean)throws Exception{
		return positionService.getPositions(positionBean, pageBean);
	}	
	/**
	 * 修改职位
	 * @param positionBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updatePosition")
	@AppController(isVerToken=true)
	public Object updatePosition(PositionBean positionBean)throws Exception{
		return positionService.updatePosition(positionBean);
	}	
	/**
	 * 职位详情
	 * @param positionBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getPosition")
	@AppController
	public Object getPosition(PositionBean positionBean)throws Exception{
		return positionService.getPosition(positionBean);
	}
	/**
	 * 删除职位详情
	 * @param positionBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deletePosition") 
    @AppController(isVerToken=true)
    public Object deletePosition(PositionBean positionBean) throws Exception{ 
		return positionService.deletePosition(positionBean);
	}
	/**
	 * 添加职位
	 * @param positionBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertPosition") 
    @AppController(isVerToken=true)
	public Object insertPosition(PositionBean positionBean) throws Exception{ 
		return positionService.insertPosition(positionBean);
	}
	/**
	 * 添加银行卡
	 * @param bankCardBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertBankCard") 
    @AppController(isVerToken=true)
	public Object insertBankCard(BankCardBean bankCardBean) throws Exception{ 
		return positionService.insertBankCard(bankCardBean);
	}
	/**
	 * 修改银行卡
	 * @param bankCardBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateBankCard")
	@AppController(isVerToken=true)
	public Object updateBankCard(BankCardBean bankCardBean)throws Exception{
		return positionService.updateBankCard(bankCardBean);
	}	
	/**
	 * 用户的银行卡信息
	 * @param bankCardBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getBankCardByMemberId")
	@AppController(isVerToken=true)
	public Object getBankCardByMemberId(BankCardBean bankCardBean)throws Exception{
		return positionService.getBankCardByMemberId(bankCardBean);
	}
	/**
	 * 修改投递状态
	 * @param positionPersonsBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updatePositionPersons")
	@AppController(isVerToken=true)
	public Object updatePositionPersons(PositionPersonsBean positionPersonsBean)throws Exception{
		return positionService.updatePositionPersons(positionPersonsBean);
	}	
	/**
	 * 投递记录同意线下支付
	 * @param positionPersonsBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/agreeOfflinePositionPerson")
	@AppController(isVerToken=true)
	public Object agreeOfflinePositionPerson(PositionPersonsBean positionPersonsBean)throws Exception{
		return positionService.agreeOfflinePositionPerson(positionPersonsBean);
	}
	/**
	 * 投递人列表
	 * @param positionPersonsBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getPositionPersonss")
	@AppController()
	public Object getPositionPersonss(PositionPersonsBean positionPersonsBean)throws Exception{
		return positionService.getPositionPersonss(positionPersonsBean);
	}
	/**
	 * 取消投递
	 * @param positionPersonsBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deletePositionPersons") 
    @AppController(isVerToken=true)
    public Object deletePositionPersons(PositionPersonsBean positionPersonsBean) throws Exception{ 
		return positionService.deletePositionPersons(positionPersonsBean);
	}
	/**
	 * 添加投递记录
	 * @param positionPersonsBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertPositionPersons") 
    @AppController(isVerToken=true)
	public Object insertPositionPersons(PositionPersonsBean positionPersonsBean) throws Exception{ 
		
		return positionService.insertPositionPersons(positionPersonsBean);
	}
	
	/**
	 * 简历列表
	 * @param requirePositionBean
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getRequirePositions")
	@AppController(isPage=true)
	public Object getRequirePositions(RequirePositionBean requirePositionBean, PageBean pageBean)throws Exception{
		return positionService.getRequirePositions(requirePositionBean, pageBean);
	}	
	/**
	 * 修改简历信息
	 * @param requirePositionBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateRequirePosition")
	@AppController(isVerToken=true)
	public Object updateRequirePosition(RequirePositionBean requirePositionBean)throws Exception{
		return positionService.updateRequirePosition(requirePositionBean);
	}	
	/**
	 * 简历信息
	 * @param requirePositionBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getRequirePosition")
	@AppController
	public Object getRequirePosition(RequirePositionBean requirePositionBean)throws Exception{
		return positionService.getRequirePosition(requirePositionBean);
	}
	/**
	 * 用户的简历信息
	 * @param requirePositionBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getRequirePositionByMemberId")
	@AppController(isVerToken=true)
	public Object getRequirePositionByMemberId(RequirePositionBean requirePositionBean)throws Exception{
		return positionService.getRequirePositionByMemberId(requirePositionBean);
	}
	/**
	 * 清除简历信息
	 * @param require_position_ids
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteRequirePosition") 
    @AppController(isVerToken=true)
    public Object deleteRequirePosition(String require_position_ids) throws Exception{ 
		return positionService.deleteRequirePosition(require_position_ids);
	}
	/**
	 * 添加简历
	 * @param requirePositionBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertRequirePosition") 
    @AppController(isVerToken=true)
	public Object insertRequirePosition(RequirePositionBean requirePositionBean) throws Exception{ 
		return positionService.insertRequirePosition(requirePositionBean);
	}
	/**
	 * 添加认证
	 * @param materialBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertMaterial")
	@AppController(isVerToken=true)
	public Object insertMaterial(MaterialBean materialBean)throws Exception{
		return  positionService.insertMaterial(materialBean);
	}
	/**
	 * 修改认证
	 * @param materialBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateMaterial")
	@AppController(isVerToken=true)
	public Object updateMaterial(MaterialBean materialBean)throws Exception{
		return  positionService.updateMaterial(materialBean);
	}
	/**
	 * 职位分类
	 * @param positionClassBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getPositionClasss")
	@AppController
	public Object getPositionClasss(PositionClassBean positionClassBean)throws Exception{
		return positionService.getPositionClasss(positionClassBean);
	}	
	/**
	 * 薪资分类
	 * @param salaryBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getSalarys")
	@AppController
	public Object getSalarys(SalaryBean salaryBean)throws Exception{
		return positionService.getSalarys(salaryBean);
	}	
	@RequestMapping("/getPositionPersons")
	@AppController(isPage=true)
	public Object getPositionPersons(PositionPersonsBean positionPersonsBean, PageBean pageBean)throws Exception{
		return positionService.getPositionPersons(positionPersonsBean, pageBean);
	}	
	
	@RequestMapping("/getPositionPerson")
	@AppController(isVerToken=true)
	public Object getPositionPerson(PositionPersonsBean positionPersonsBean)throws Exception{
		return positionService.getPositionPerson(positionPersonsBean);
	}	
	
	/**
	 * 微信app支付回调
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/wxCallback")
	@AppController(isNeedPackage = false)
	public Object wxpayMemberIntegralOrder(HttpServletRequest request) throws Exception {
		InputStream inStream = request.getInputStream();
		ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = inStream.read(buffer)) != -1) {
			outSteam.write(buffer, 0, len);
		}
		outSteam.close();
		inStream.close();
		String resultStr = new String(outSteam.toByteArray(), "UTF-8");
		Map<String, String> resultMap = WXUtils.doXMLParse(resultStr);

		String out_trade_no = resultMap.get("out_trade_no");
		String transaction_id = resultMap.get("transaction_id");
		String sign = resultMap.get("sign");
		String return_code = resultMap.get("return_code");
		String cash_fee = resultMap.get("cash_fee");
		if(out_trade_no.indexOf("g")>=0){//订单支付成功回调
			positionService.payOrderCallback(new AdvertiseOrderBean().setOut_trade_no(out_trade_no));
		}
	    return "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
	}
	
	@RequestMapping("/alipayCallback")
	@AppController
	public Object alipayCallback(String out_trade_no,String trade_no,String trade_status) throws Exception {
		if("TRADE_SUCCESS".equals(trade_status)){//支付成功回调
			if(out_trade_no.indexOf("g")>=0){//订单支付成功回调
				return  positionService.payOrderCallback(new AdvertiseOrderBean().setOut_trade_no(out_trade_no));
			}else{
				return "ok";
			}
		}else if("TRADE_CLOSED".equals(trade_status)){//退款成功回调
			return "ok";
		}else{
			return "ok";
		}
	}
	
	@RequestMapping("/timeingCloseOrders")
	@AppController(isLog=false)
	public Object timeingCloseOrders(AdvertiseOrderBean advertiseOrderBean) throws Exception	{
		return positionService.timeingCloseOrders(advertiseOrderBean);
	}
}
