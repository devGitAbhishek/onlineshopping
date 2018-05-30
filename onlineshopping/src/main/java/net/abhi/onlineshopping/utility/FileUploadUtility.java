package net.abhi.onlineshopping.utility;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {

	public static final String ABS_IMG_PATH = "X:\\Development resources\\projects\\onlineshopping\\onlineshopping\\src\\main\\webapp\\WEB-INF\\assets\\images\\";
	public static String REL_IMG_PATH = "";

	public static final Logger logger = org.slf4j.LoggerFactory.getLogger(FileUploadUtility.class);

	public static void uploadFile(HttpServletRequest req, MultipartFile file, String code) {

		REL_IMG_PATH = req.getSession().getServletContext().getRealPath("/assets/images/");
		logger.info("Real ing path" + REL_IMG_PATH);

		// make sure all the directories exists if not existing create it
		if (!new File(ABS_IMG_PATH).exists()) {

			// creating the directory
			new File(ABS_IMG_PATH).mkdirs();
		}

		// make sure all the directories exists if not existing create it
		if (!new File(REL_IMG_PATH).exists()) {
			// creating the directory
			new File(REL_IMG_PATH).mkdirs();
		}
		
		try {
			//Server upload 
			file.transferTo(new File(REL_IMG_PATH + code + ".jpg"));
			//project directory upload
			file.transferTo(new File(ABS_IMG_PATH + code + ".jpg"));
			
		}catch(IOException e) {
			logger.error("Not able to transfer file");
		}

	}

}
