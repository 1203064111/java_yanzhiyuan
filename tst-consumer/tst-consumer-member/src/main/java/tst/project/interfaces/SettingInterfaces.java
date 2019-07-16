package tst.project.interfaces;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

import tst.project.BaseController;
import tst.project.aspect.AppController;
import tst.project.aspect.AppException;
import tst.project.bean.CodeBean;
import tst.project.bean.setting.AdviceBean;
import tst.project.bean.setting.HtmlBean;
import tst.project.bean.setting.MsgTypeBean;
import tst.project.utils.RedisUtils;

@Controller
@RequestMapping("/settingInterfaces/v1.0")
public class SettingInterfaces extends BaseController{

	
	
	@Autowired
    private ISettingService settingService;
	@RequestMapping("/test4") 
    @AppController
    public Object test4(String result) throws Exception{ 
		return result;
    }
	
	@RequestMapping("/test5") 
    @AppController
    public Object test5(int count,String key,String result) throws Exception{ 
		RedisUtils.getKey(key);
		return result;
    }
	
	@RequestMapping("/test3") 
    @AppController
    public Object test3(int count,String key) throws Exception{ 
		String a="";
		for (int i = 0; i < count; i++) {
			a=RedisUtils.getKey(key);
		}
		return a;
    }
	
	@RequestMapping("/test2") 
    @AppController
    public Object test2(String key) throws Exception{ 
		String result=RedisUtils.getKey(key);
		return result;
    }
	
	@RequestMapping("/test") 
    @AppController
    public Object test() throws Exception{ 
		return settingService.test();
    }
	
	@RequestMapping("/insertAdvice") 
    @AppController(isVerToken=true)
    public Object insertAdvice(AdviceBean adviceBean) throws Exception{ 
    	Object obejct=settingService.insertAdvice(adviceBean);
        return obejct;   
    }
	/**
	 * 发送验证码
	 * @param codeBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/sendCode") 
    @AppController
    public Object sendCode(CodeBean codeBean) throws Exception{ 
    	Object obejct=settingService.sendAliCode(codeBean);
        return obejct;   
    }
	@RequestMapping("/sendAliCode") 
    @AppController
    public Object sendAliCode(CodeBean codeBean) throws Exception{ 
    	Object obejct=settingService.sendAliCode(codeBean);
        return obejct;   
    }
	@RequestMapping("/sendAliCodeV2") 
    @AppController
    public Object sendAliCodeV2(CodeBean codeBean) throws Exception{ 
    	Object obejct=settingService.sendAliCodeV2(codeBean);
        return obejct;   
    }
	
	@RequestMapping("/uploadImg") 
    @AppController
    public Object uploadImg(HttpServletRequest request) throws Exception{ 
		String file_name=saveFile(request,"file");
		if(file_name==null){
			throw new AppException("文件为空!");
		}
        return file_name;   
    }
	/**
	 * 上传图片到七牛云
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/uploadImgToQiNiu") 
    @AppController
    public Object uploadImgToQiNiu(HttpServletRequest request) throws Exception{ 
		String file_name =  saveFileToQiNiu(request, "file");
		
		if(file_name==null){
			throw new AppException("文件为空!");
		}
        return file_name;   
    }
	/**
	 * 上传图片
	 * @param request
	 * @param file
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/uploadImgs") 
    @AppController
    public Object uploadImgV2(HttpServletRequest request,MultipartFile file) throws Exception{ 
		List<String> file_names=saveFiles(request,"file");
		if(file_names==null||file_names.size()<=0){
			throw new AppException("文件为空!");
		}
        return file_names;   
    }
	
	/**
	 * 获得微信分享权限
	 * 
	 * @param percentBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/getWxAutho") 
    @AppController
	public Object getWxAutho(String url)throws Exception {
		return settingService.getWxAutho(url);
	}
	
	/**
	 * 图文配置详情
	 * 
	 * @param percentBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/getHtmlDetail") 
    @AppController
	public Object getHtmlDetail(HtmlBean htmlBean)throws Exception {
		return settingService.getHtmlDetail(htmlBean);
	}
	@RequestMapping("/getHtmlDetail2") 
    @AppController
	public Object getHtmlDetail2(HtmlBean htmlBean)throws Exception {
		return settingService.getHtmlDetail2(htmlBean);
	}
	
	/**
	 * 图文配置详情
	 * 
	 * @param percentBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/getHtmls") 
    @AppController
	public Object getHtmls(HtmlBean htmlBean)throws Exception {
		return settingService.getHtmls(htmlBean);
	}
	
	
	/**
	 * 消息类型
	 * 
	 * @param percentBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/getMsgType") 
    @AppController
	public Object getMsgType(MsgTypeBean msgTypeBean)throws Exception {
		return settingService.getMsgType(msgTypeBean);
	}
	
	
	
	
}
