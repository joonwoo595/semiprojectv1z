package com.example.zzyzzy.semiprojectv1.service;


import com.example.zzyzzy.semiprojectv1.domain.Gallery;
import com.example.zzyzzy.semiprojectv1.repository.GalleryRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Setter
@RequiredArgsConstructor
public class GalleryServiceImpl implements GalleryService{

    private final GalleryRepository galleryMapper;

    @Override
    public List<Gallery> selectGallery() {
        return galleryMapper.selectGallery();
    }

}
