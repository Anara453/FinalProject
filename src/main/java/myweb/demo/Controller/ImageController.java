package myweb.demo.Controller;

import myweb.demo.Entity.Image;
import myweb.demo.Service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/image")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @PostMapping("{carsId}")
    public Image create(@RequestParam(name = "file") MultipartFile multipartFile,
                        @PathVariable (name = "carsId") Long carsId){
        return imageService.create(multipartFile,carsId);
    }
    @DeleteMapping("{id}")
    public Image deleteById (@PathVariable Long id){
        return imageService.deleteById(id);
    }

}
