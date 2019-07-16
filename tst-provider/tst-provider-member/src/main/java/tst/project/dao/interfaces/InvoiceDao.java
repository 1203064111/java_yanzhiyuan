package tst.project.dao.interfaces;

import java.util.List;

import tst.project.annotation.Mapper;
import tst.project.bean.member.InvoiceBean;
import tst.project.page.PageBean;

@Mapper
public interface InvoiceDao {
	/**
	 * 添加用户发票
	 * @param InvoiceBean
	 * @return
	 */
	int insertInvoice(InvoiceBean invoiceBean);

	/**
	 * 删除发票
	 * @param InvoiceBean
	 * @return
	 */
	int updateInvoice(InvoiceBean invoiceBean);
	
	/**
	 * 删除发票
	 * @param InvoiceBean
	 * @return
	 */
	int deleteInvoice(InvoiceBean invoiceBean);

	/**
	 * 查询用户发票列表
	 * @param InvoiceBean
	 * @return
	 */
	List<InvoiceBean> getMemberInvoice(InvoiceBean invoiceBean, PageBean pageBean);

	/**
	 * 设置用户默认发票
	 * @param InvoiceBean
	 * @return
	 */
	int updateDefaultInvoice(InvoiceBean invoiceBean);

	/**
	 * 得到用户默认发票
	 * @param InvoiceBean
	 * @return
	 */
	InvoiceBean getDefaultInvoice(InvoiceBean invoiceBean);

	/**
	 * 得到用户发票详情
	 * @param InvoiceBean
	 * @return
	 */
	InvoiceBean getInvoiceDetail(InvoiceBean invoiceBean);
}
