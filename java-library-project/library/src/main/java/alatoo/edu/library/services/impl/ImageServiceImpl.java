package alatoo.edu.library.services.impl;

import alatoo.edu.library.dao.BookRepo;
import alatoo.edu.library.dao.ImageRepo;
import alatoo.edu.library.exceptions.NotFoundByIdException;
import alatoo.edu.library.mappers.BookMapper;
import alatoo.edu.library.mappers.ImageMapper;
import alatoo.edu.library.models.dto.ImageDto;
import alatoo.edu.library.services.BaseCrudService;
import alatoo.edu.library.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageRepo repo;

    @Override
    public ImageDto save(ImageDto imageDto) {
        return map().toDto(repo.save(map().toEntity(imageDto)));
    }

    @Override
    public ImageDto update(ImageDto imageDto) {
        return null;
    }

    @Override
    public ImageDto findById(Long id) {
        return map().toDto(repo.findById(id).orElseThrow(()->new NotFoundByIdException("Image is not found!!!")));
    }

    @Override
    public List<ImageDto> findAll() {
        return map().toDtoList(repo.findAll());
    }

    public ImageMapper map() {
        ImageMapper mapper = new ImageMapper();
        return mapper;
    }
}
