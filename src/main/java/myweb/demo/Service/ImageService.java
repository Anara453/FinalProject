package myweb.demo.Service;


import myweb.demo.Entity.Image;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
      Image create (MultipartFile multipartFile, Long carsId);
      Image getById (Long id);
      Image deleteById (Long id);
}
