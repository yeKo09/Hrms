package kodlamaio.hrms.adapters;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;

@Service
public class CloudinaryServiceAdapter implements SaveImageService{

	@Override
	public String saveImage(String imageUrl) throws IOException {
		Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "yeko33",
				"api_key", "381424617835856",
				"api_secret", "wmVExy_zWOBmdPXFfresOrjmCw0",
				"secure", true));
		
		File file = new File(imageUrl);
		Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
		
		return uploadResult.get("url").toString();
	}

}
