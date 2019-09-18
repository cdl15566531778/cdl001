package cc.hualife.akernel.web.demo.controller;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;
import lombok.extern.slf4j.Slf4j;
import sun.misc.BASE64Encoder;

@RestController
@RequestMapping("/down")
@Slf4j
public class DownController {

	
	
	@RequestMapping("/doc")
	public void download(HttpServletResponse res) {
		Map<String, Object> map =new HashMap<>();
		try {
			map.put("name", "骗子");
			map.put("age", 19);
			map.put("adress", "海淀区");
			map.put("imgStr", getImageStr());
			
			Configuration configuration= new Configuration(new Version("2.3.0"));
			configuration.setDefaultEncoding("UTF-8");
			
			configuration.setDirectoryForTemplateLoading(new File("D:\\upload"));
			
			
		
			Template template = configuration.getTemplate("简历模板.ftl");
			File file = createDoc(map, template);
			String filename="简历.doc";
			
			res.setCharacterEncoding("UTF-8");
			res.setHeader("Content-disposition", "attachment;filename="+new String(filename.getBytes("UTF-8"),"ISO-8859-1"));
			FileInputStream fis = new FileInputStream(file);
			ServletOutputStream out = res.getOutputStream();
			
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len=fis.read(buffer))!=-1) {
				out.write(buffer, 0, len);
				
			}
			if (out!=null) {
				out.close();
			}
			if (fis!=null) {
				fis.close();
			}
			if (file!=null) {
				file.delete();
			}
			
			
					
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
			
		
	}
	
	
	   public String getImageStr() {  
	        String imgFile = "d:\\1.jpg";  
	        InputStream in = null;  
	        byte[] data = null;  
	        try {  
	            in = new FileInputStream(imgFile);  
	            data = new byte[in.available()];  
	            in.read(data);  
	            in.close();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        BASE64Encoder encoder = new BASE64Encoder();  
	        return encoder.encode(data);  
	        
	    } 
	
	
	   private static File createDoc(Map<?, ?> dataMap, Template template) {  
	        String name =  "简历.doc";  
	        File f = new File(name);  
	        Template t = template;  
	        try {  
	           
	            Writer w = new OutputStreamWriter(new FileOutputStream(f), "utf-8");  
	            t.process(dataMap, w);  
	            w.close();  
	        } catch (Exception ex) {  
	            ex.printStackTrace();  
	            throw new RuntimeException(ex);  
	        }  
	        return f;  
	    }  
	   
}
