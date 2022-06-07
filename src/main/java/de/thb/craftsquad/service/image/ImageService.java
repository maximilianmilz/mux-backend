package de.thb.craftsquad.service.image;

import de.thb.craftsquad.service.image.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepository repository;
}
