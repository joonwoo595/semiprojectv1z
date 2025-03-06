package com.example.zzyzzy.semiprojectv1.repository;

import com.example.zzyzzy.semiprojectv1.domain.Gallery;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GalleryRepository {



    @Select("select gno,title,userid,thumbs,views,regdate from gallerys order by gno desc")
     List<Gallery> selectGallery();

}
