package com.example.repository;

import com.example.module.entity.UrlEntity;
import com.example.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.lang.NonNull;

import java.util.Optional;

/**
 * @ClassName UrlRepository
 * @Description TODO
 * @Author miaoyi
 * @Date 2020-03-21 13:07
 * @Version 1.0
 **/

public interface UrlRepository extends BaseRepository<UrlEntity,Integer>, JpaSpecificationExecutor<UrlEntity> {
    @NonNull
    Optional<UrlEntity> findByMd5(@NonNull String md5);

    @NonNull
    Optional<UrlEntity> findByUrl(@NonNull String url);
}
