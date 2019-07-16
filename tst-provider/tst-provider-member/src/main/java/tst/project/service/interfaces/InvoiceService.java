package tst.project.service.interfaces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tst.project.aspect.AppException;
import tst.project.bean.member.InvoiceBean;
import tst.project.dao.interfaces.InvoiceDao;
import tst.project.interfaces.IInvoiceService;
import tst.project.page.PageBean;

@Service
@Transactional(rollbackFor=Exception.class)
public class InvoiceService implements IInvoiceService{

	@Autowired
	InvoiceDao invoiceDao;
	
	@Override
	public Object insertInvoice(InvoiceBean invoiceBean) {
		// TODO Auto-generated method stub	
		List<InvoiceBean> invoiceBeans = invoiceDao.getMemberInvoice(invoiceBean, new PageBean());
		if (invoiceBeans == null || invoiceBeans.size() == 0) {
			invoiceBean.setIs_default("1");
		} 
		
		int num = 0;
		if(invoiceBean.getInvoice_id()==0) {
			num = invoiceDao.insertInvoice(invoiceBean);
			if (num <= 0) {
				new AppException("发票添加失败");
			}
			
			if("1".equals(invoiceBean.getIs_default())){
				num=invoiceDao.updateDefaultInvoice(invoiceBean);
				if (num <= 0) {
					new AppException("默认发票设置失败");
				}
			}
			
			return invoiceBean.getInvoice_id();
		}else {
			num = invoiceDao.updateInvoice(invoiceBean);
			if (num <= 0) {
				new AppException("发票修改失败");
			}
			return "修改成功";
		}
	}

	@Override
	public Object deleteInvoice(InvoiceBean invoiceBean) {
		// TODO Auto-generated method stub
		int num = invoiceDao.deleteInvoice(invoiceBean);
		if (num <= 0) {
			new AppException("删除发票失败");
		}
		/**
		 * 删除之后还要判断有没有默认发票
		 */
		List<InvoiceBean> invoiceBeans = invoiceDao.getMemberInvoice(invoiceBean, new PageBean().setPageSize(1000));
		boolean is_have_default = false;

		if (invoiceBeans != null && invoiceBeans.size() > 0) {
			for (int i = 0; i < invoiceBeans.size(); i++) {
				if (invoiceBeans.get(i).getIs_default().equals("1")) {
					is_have_default = true;
					break;
				}
			}
			/**
			 * 如果没有默认,设置第一条为默认
			 */
			if (!is_have_default) {
				invoiceDao.updateDefaultInvoice(invoiceBeans.get(0));
			}
		}
		return num;
	}

	@Override
	public Object getMemberInvoice(InvoiceBean invoiceBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<InvoiceBean> invoiceBeans = invoiceDao.getMemberInvoice(invoiceBean, pageBean);
		PageBean object = pageBean.setObject(invoiceBeans);
		return object;
	}

	@Override
	public Object updateDefaultInvoice(InvoiceBean invoiceBean) {
		// TODO Auto-generated method stub
		int num = invoiceDao.updateDefaultInvoice(invoiceBean);
		if(num<=0){
			new AppException("设置失败");
		}
		return num;
	}

	@Override
	public Object getDefaultInvoice(InvoiceBean invoiceBean) {
		// TODO Auto-generated method stub
		InvoiceBean invoiceBean2 = invoiceDao.getDefaultInvoice(invoiceBean);
		return invoiceBean2;
	}

	@Override
	public InvoiceBean getInvoiceDetail(InvoiceBean invoiceBean) {
		// TODO Auto-generated method stub
		InvoiceBean invoiceBean2 = invoiceDao.getInvoiceDetail(invoiceBean);
		return invoiceBean2;
	}

}
