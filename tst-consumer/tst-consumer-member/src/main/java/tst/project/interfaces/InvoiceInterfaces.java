package tst.project.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tst.project.aspect.AppController;
import tst.project.bean.member.InvoiceBean;
import tst.project.page.PageBean;

@Controller
@RequestMapping("/invoiceInterfaces/v1.0")
public class InvoiceInterfaces {
	@Autowired
	private IInvoiceService invoiceService;
	
	 /**
     * 添加用户发票
     * @param invoiceBean
     * @return
     * @throws Exception
     */
    @RequestMapping("/insertInvoice")
    @AppController(isVerToken=true)
    public Object insertInvoice(InvoiceBean invoiceBean)throws Exception{
    	Object object = invoiceService.insertInvoice(invoiceBean);
    	return object;
    } 
    
    /**
     * 删除发票
     * @param invoiceBean
     * @return
     * @throws Exception
     */
    @RequestMapping("/deleteInvoice")
    @AppController(isVerToken=true)
    public Object deleteInvoice(InvoiceBean invoiceBean)throws Exception{
    	Object object = invoiceService.deleteInvoice(invoiceBean);
    	return object;
    }
    
    
    /**
     * 查询用户发票列表
     * @param invoiceBean
     * @return
     * @throws Exception
     */
    @RequestMapping("/getMemberInvoice")
    @AppController(isVerToken=true, isPage=true)
    public Object getMemberInvoice(InvoiceBean invoiceBean, PageBean pageBean)throws Exception{
    	Object object = invoiceService.getMemberInvoice(invoiceBean, pageBean);
    	return object;
    }
    
    /**
     * 设置用户默认发票
     * @param invoiceBean
     * @return
     * @throws Exception
     */
    @RequestMapping("/updateDefaultInvoice")
    @AppController(isVerToken=true)
    public Object updateDefaultInvoice(InvoiceBean invoiceBean)throws Exception{
    	Object object = invoiceService.updateDefaultInvoice(invoiceBean);
    	return object;
    }
    
    /**
     * 得到用户默认发票
     * @param invoiceBean
     * @return
     * @throws Exception
     */
    @RequestMapping("/getDefaultInvoice")
    @AppController(isVerToken=true)
    public Object getDefaultInvoice(InvoiceBean invoiceBean)throws Exception{
    	Object object = invoiceService.getDefaultInvoice(invoiceBean);
    	return object;
    }
    
    /**
     * 得到用户发票详情
     * @param invoiceBean
     * @return
     * @throws Exception
     */
    @RequestMapping("/getInvoiceDetail")
    @AppController(isVerToken=true)
    public Object getInvoiceDetail(InvoiceBean invoiceBean)throws Exception{
    	Object object = invoiceService.getInvoiceDetail(invoiceBean);
    	return object;
    }
}
