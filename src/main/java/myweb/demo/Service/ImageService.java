package myweb.demo.Service;


import myweb.demo.Entity.Image;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;

public interface ImageService {
      Image create(MultipartFile multipartFile, Long carsId, String email);
      Image getById (Long id);
      Image deleteById (Long id);
}
