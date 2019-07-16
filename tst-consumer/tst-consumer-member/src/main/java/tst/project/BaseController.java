package tst.project;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.filefilter.FalseFileFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.util.WebUtils;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

import tst.project.utils.TimeUtils;
import tst.project.utils.UUIDUtils;

public class BaseController {
	@Value("${img_path}")
	private String img_path;
	
	
	public String getPath() {
		return img_path;
	}
	
	private static String accessKey = "NP4_XWRulRuhb2sEg460zF1gfJJSt3D_JryE3KZD";  
	private static String secretKey = "jLz6FqMBksfLuQ9JyYlZnSqQOKq0HHv4lT8SLhHI";  
	private static String bucket = "yzapp";  
	
	/** 
	 * 获取上传凭证 
	 */  
	public static String getUploadCredential() {  
	    Auth auth = Auth.create(accessKey, secretKey);  
	    String upToken = auth.uploadToken(bucket);  
	    System.out.println(upToken);  
	    return upToken;  
	}
	/** 
	 * 文件上传 
	 * @param zone  
	 *    华东    Zone.zone0() 
	 *    华北    Zone.zone1() 
	 *    华南    Zone.zone2() 
	 *    北美    Zone.zoneNa0() 
	 * @param upToken 上传凭证 
	 * @param localFilePath 需要上传的文件本地路径 
	 * @return 
	 */  
	public static String fileUploadToQiNiu(Zone zone,String upToken,byte[] file,String file_name) {  
	    // 构造一个带指定Zone对象的配置类  
	    Configuration cfg = new Configuration(zone);  
	    // ...其他参数参考类注释  
	    UploadManager uploadManager = new UploadManager(cfg);  
	    // 默认不指定key的情况下，以文件内容的hash值作为文件名  
	    
	    String key = file_name;  
	    try {  
	        Response response = uploadManager.put(file, key, upToken);
	        // 解析上传成功的结果  
	        DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);  
	        System.out.println(putRet.key);  
	        System.out.println(putRet.hash);  
	        return putRet.key;  
	    } catch (QiniuException ex) {  
	        Response r = ex.response;  
	        System.err.println(r.toString());  
	        try {  
	            System.err.println(r.bodyString());  
	        } catch (QiniuException ex2) {  
	            // ignore  
	        }  
	    }  
	    return null;  
	}  
	
	
	public List<String> saveFiles(HttpServletRequest request, String key) {
		InputStream inputStream = null;
		String fileName = "";
		OutputStream os = null;
		try {
			List<String> seStrings=new ArrayList<String>();
			String contentType = request.getContentType();

			if (contentType != null && contentType.toLowerCase().startsWith("multipart/")) {
				String new_path = TimeUtils.getCurrentTime("yyyyMMdd") + "/";
				String path = img_path + new_path;
				
				MultipartHttpServletRequest multipartRequest = WebUtils.getNativeRequest(request,
						MultipartHttpServletRequest.class);
				List<MultipartFile> files = multipartRequest.getFiles(key);
				if (files == null) {
					return null;
				}
				for (int i = 0; i < files.size(); i++) {
					MultipartFile file=files.get(i);
					
					inputStream = file.getInputStream();

					UUIDUtils uusUtils = new UUIDUtils(1);
					String original_filename = file.getOriginalFilename();
					int a = original_filename.lastIndexOf(".");
					fileName = uusUtils.nextId(false, 10) + original_filename.substring(a, original_filename.length());
					
					// 2、保存到临时文件
					// 1K的数据缓冲
					byte[] bs = new byte[1024];
					// 读取到的数据长度
					int len;
					// 输出的文件流保存到本地文件

					File tempFile = new File(path);
					if (!tempFile.exists()) {
						tempFile.mkdirs();
					}
					os = new FileOutputStream(tempFile.getPath() + File.separator + fileName);
					// 开始读取
					while ((len = inputStream.read(bs)) != -1) {
						os.write(bs, 0, len);
					}
					
					seStrings.add(new_path + fileName);
				}
				
			}
			
			return seStrings;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			// 完毕，关闭所有链接
			try {
				if (inputStream != null) {
					os.close();
					inputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}

	}
	public String saveFileToQiNiu(HttpServletRequest request, String key) {
		
		
		String fileName = "";
		
		try {
			String new_path = TimeUtils.getCurrentTime("yyyyMMdd") + "/";
			String contentType = request.getContentType();
			if (contentType != null && contentType.toLowerCase().startsWith("multipart/")) {
				MultipartHttpServletRequest multipartRequest = WebUtils.getNativeRequest(request,
						MultipartHttpServletRequest.class);
								
				MultipartFile file = multipartRequest.getFile(key);
				if (file == null) {
					return null;
				}
				

				UUIDUtils uusUtils = new UUIDUtils(1);
				String original_filename = file.getOriginalFilename();
				int a = original_filename.lastIndexOf(".");
				fileName = uusUtils.nextId(false, 10) + original_filename.substring(a, original_filename.length());
				String final_key = fileUploadToQiNiu(Zone.zone0(), getUploadCredential(),file.getBytes(),new_path + fileName);
				System.out.println(final_key);
			}
			return new_path + fileName;
		}  catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			
		}

	}
	public String saveFile(HttpServletRequest request, String key) {
		InputStream inputStream = null;
		String fileName = "";
		OutputStream os = null;
		try {
			String new_path = TimeUtils.getCurrentTime("yyyyMMdd") + "/";
			String path = img_path + new_path;
			String contentType = request.getContentType();
			if (contentType != null && contentType.toLowerCase().startsWith("multipart/")) {
				MultipartHttpServletRequest multipartRequest = WebUtils.getNativeRequest(request,
						MultipartHttpServletRequest.class);
								
				MultipartFile file = multipartRequest.getFile(key);
				if (file == null) {
					return null;
				}
				inputStream = file.getInputStream();

				UUIDUtils uusUtils = new UUIDUtils(1);
				String original_filename = file.getOriginalFilename();
				int a = original_filename.lastIndexOf(".");
				fileName = uusUtils.nextId(false, 10) + original_filename.substring(a, original_filename.length());
			}
			// 2、保存到临时文件
			// 1K的数据缓冲
			byte[] bs = new byte[1024];
			// 读取到的数据长度
			int len;
			// 输出的文件流保存到本地文件

			File tempFile = new File(path);
			if (!tempFile.exists()) {
				tempFile.mkdirs();
			}
			os = new FileOutputStream(tempFile.getPath() + File.separator + fileName);
			// 开始读取
			while ((len = inputStream.read(bs)) != -1) {
				os.write(bs, 0, len);
			}
			return new_path + fileName;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			// 完毕，关闭所有链接
			try {
				if (inputStream != null) {
					os.close();
					inputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}

	}
	public static void main(String[] args){
		System.out.println(getUploadCredential());
	}

}
