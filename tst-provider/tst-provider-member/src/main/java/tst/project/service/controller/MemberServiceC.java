package tst.project.service.controller;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service; //Service用此包
import org.springframework.transaction.annotation.Transactional;

import tst.project.aspect.AppException;
import tst.project.bean.member.AddressBean;
import tst.project.bean.member.BankCardBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.setting.AdviceBean;
import tst.project.bean.sheep.TaskClassBean;
import tst.project.controller.IMemberServiceC;
import tst.project.dao.controller.MemberDaoC;
import tst.project.dao.interfaces.MemberDao;
import tst.project.page.PageBean;
import tst.project.utils.HuanXinUtils;
import tst.project.utils.MD5Util;
import tst.project.utils.NumberUtils;

@Service
@Transactional
public class MemberServiceC implements IMemberServiceC{
	
	@Autowired
	MemberDaoC memberDaoC;
	
	
	@Value("${hx_id}")
	private String hx_id;

	@Value("${hx_name}")
	private String hx_name;
	
	@Override
	public Map<String, Object> getMemberBuyStatistics(MemberBean memberBean) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Map<String, Object> getMemberStatistics(MemberBean memberBean) {
		// TODO Auto-generated method stub
		return memberDaoC.getMemberStatistics(memberBean);
	}
	
	@Override
	public Object insertMember(MemberBean memberBean) {
		// TODO Auto-generated method stub
		if (memberBean.getMember_account() == null || memberBean.getMember_account().length() != 11) {
			throw new AppException("手机号非法!");
		}
		MemberBean memberBean2 = 
				memberDaoC.getMemberDetail(new MemberBean().setMember_account(memberBean.getMember_account()));
		if (memberBean2 != null) {
			throw new AppException("该手机号已注册过!");
		}
		try {
			String pass = "";
			try {
				pass = MD5Util.md5Encode(memberBean.getMember_password());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new AppException("加密失败!");
			}
			String t = NumberUtils.createRandom(true, 6);
			boolean is_success = HuanXinUtils.registerOneUser(hx_id, hx_name, memberBean.getMember_account() + t, pass);
			
			int num = memberDaoC.insertMember(memberBean.setMember_password(pass)
						.setHx_account(memberBean.getMember_account() + t).setMember_password(pass).setHx_password(pass)
						.setHx_nick_name(memberBean.getMember_account() + t)
						.setMember_token(UUID.randomUUID().toString()));

				if (num > 0) {
					return memberDaoC.getMemberDetail(memberBean);
				} else {
					throw new AppException("注册失败");
				}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException(e.getMessage());
		}

	}
	
	@Override
	public MemberBean getMemberDetail(MemberBean memberBean) {
		// TODO Auto-generated method stub
		MemberBean memberDetail = memberDaoC.getMemberDetail(memberBean);
		return memberDetail;
	}

	@Override
	public Object getMembers(MemberBean memberBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<MemberBean> members = memberDaoC.getMembers(memberBean, pageBean);
		return pageBean.setObject(members);
		
	}

	@Override
	public Object updateMemberDetail(MemberBean memberBean) {
		// TODO Auto-generated method stub
		int num = memberDaoC.updateMemberDetail(memberBean);
		if(num<=0){
			throw new AppException("修改详情失败");
		}
		return num;
	}

	@Override
	public Object deleteMember(MemberBean memberBean) {
		// TODO Auto-generated method stub
		int num = memberDaoC.deleteMember(memberBean);
		if(num<=0){
			throw new AppException("删除失败");
		}
		return num;
	}

	@Override
	public Object getMemberAddress(AddressBean addressBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<AddressBean> memberAddress = memberDaoC.getMemberAddress(addressBean, pageBean);
		return pageBean.setObject(memberAddress);
	}

	@Override
	public Object getMemberBankCards(BankCardBean bankCardBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<BankCardBean> memberBankCards = memberDaoC.getMemberBankCards(bankCardBean, pageBean);
		return pageBean.setObject(memberBankCards);
	}
	
	@Override
	public List<MemberBean> getMembersNoPage(MemberBean memberBean) {
		// TODO Auto-generated method stub
		List<MemberBean> memberBeans = memberDaoC.getMembersNoPage(memberBean);
		return memberBeans;
	}

	@Override
	public Object getMemberAddressCounts(AddressBean addressBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<AddressBean> addressBeans = memberDaoC.getMemberAddressCounts(addressBean, pageBean);
		
		return pageBean.setObject(addressBeans);
	}

	@Override
	public Object getMemberInsertCounts(MemberBean memberBean) {
		// TODO Auto-generated method stub
		return memberDaoC.getMemberInsertCounts(memberBean);
	}

	@Override
	public Object getAdvices(AdviceBean adviceBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<AdviceBean> adviceBeans = memberDaoC.getAdvices(adviceBean, pageBean);
		return pageBean.setObject(adviceBeans);
	}

	@Override
	public Object deleteAdvice(AdviceBean adviceBean) {
		// TODO Auto-generated method stub
		int num = memberDaoC.deleteAdvice(adviceBean);
		if(num <= 0) {
			throw new AppException("删除失败");
		}
		return num;
	}

	@Override
	public List<Map> exportMembers(MemberBean memberBean) {
		return memberDaoC.exportMembers(memberBean);
	}

	@Override
	public Object getTaskClasses(TaskClassBean taskClassBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		return pageBean.setObject(memberDaoC.getTaskClasses(taskClassBean, pageBean));
	}

	@Override
	public Object updateTaskClass(TaskClassBean taskClassBean) {
		int num = memberDaoC.updateTaskClass(taskClassBean);
		if(num <= 0){
			throw new AppException("修改失败");
		}
		return num;
	}

	@Override
	public Object deleteTaskClass(TaskClassBean taskClassBean) {
		int num = memberDaoC.deleteTaskClass(taskClassBean);
		if(num <= 0){
			throw new AppException("删除失败");
		}
		return num;
	}

	@Override
	public Object insertTaskClass(TaskClassBean taskClassBean) {
		int num = memberDaoC.insertTaskClass(taskClassBean);
		if(num <= 0){
			throw new AppException("添加失败");
		}
		return num;
	}

	@Override
	public Object getTaskClassDetail(TaskClassBean taskClassBean) {
		return memberDaoC.getTaskClassDetail(taskClassBean);
	}
	



	

}
