package tst.project.interfaces;

import tst.project.bean.member.InvoiceBean;
import tst.project.page.PageBean;

public interface IInvoiceService {

	/**
	 * 添加用户发票
	 * @param InvoiceBean
	 * @return
	 */
	Object insertInvoice(InvoiceBean invoiceBean);

	/**
	 * 删除发票
	 * @param InvoiceBean
	 * @return
	 */
	Object deleteInvoice(InvoiceBean invoiceBean);

	/**
	 * 查询用户发票列表
	 * @param InvoiceBean
	 * @return
	 */
	Object getMemberInvoice(InvoiceBean invoiceBean, PageBean pageBean);

	/**
	 * 设置用户默认发票
	 * @param InvoiceBean
	 * @return
	 */
	Object updateDefaultInvoice(InvoiceBean invoiceBean);

	/**
	 * 得到用户默认发票
	 * @param InvoiceBean
	 * @return
	 */
	Object getDefaultInvoice(InvoiceBean invoiceBean);

	/**
	 * 得到用户发票详情
	 * @param InvoiceBean
	 * @return
	 */
	InvoiceBean getInvoiceDetail(InvoiceBean invoiceBean);
}
