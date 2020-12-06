package myweb.demo.Service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import myweb.demo.Entity.Cars;
import myweb.demo.Entity.Image;
import myweb.demo.Entity.User;
import myweb.demo.Repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private CarsService carsService;
    @Autowired
    private  UserService userService;
    @Override
    public Image create(MultipartFile multipartFile, Long carsId, String email) {
        Cars cars = carsService.getById(carsId);
        User user = userService.getByEmail(email);
        if (cars == null) return null;
        final String urlKey = "cloudinary://686196192879841:idlpOxiySGmoCAwvWGReXMmhm8U@drtmc8tgv";
        File f ;
        Image image =  new Image();
        try {
            f = Files.createTempFile(System.currentTimeMillis()+ "",multipartFile.getOriginalFilename()
                    .substring(multipartFile.getOriginalFilename().length() - 4)).toFile();
            multipartFile.transferTo(f);
            Cloudinary cloudinary = new Cloudinary(urlKey);
            Map uploadResult = cloudinary.uploader().upload(f, ObjectUtils.emptyMap());
           // Получаем результат
            image.setName((String)uploadResult.get("public_id"));
            image.setUrl((String)uploadResult.get("url"));
            image.setFormat((String)uploadResult.get("format"));
            image.setCars(cars);
            image.setUser(user);
             return imageRepository.save(image); //Сохраняем
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Image getById(Long id) {
        return imageRepository.findById(id).orElse(null);
    }

    @Override
    public Image deleteById(Long id) {
        Image image = getById(id);
        if (image != null){
            imageRepository.deleteById(id);
        }
        return null;
    }
}
