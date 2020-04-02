package com.example.repository;

import com.example.module.entity.IndustryEntity;
import com.example.repository.base.BaseRepository;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


/**
 * @ClassName UrlRepository
 * @Description TODO
 * @Author miaoyi
 * @Date 2020-03-21 13:07
 * @Version 1.0
 **/

public interface IndustryRepository extends BaseRepository<IndustryEntity,Integer>, JpaSpecificationExecutor<IndustryEntity> {
    @NonNull
    Optional<IndustryEntity> findIndustryEntityByHref(@NonNull String name);


    @Transactional
    @Modifying
    @Query("UPDATE IndustryEntity  SET done=?1, " +
            " maxPage =?2 " +
            " where id =?3 ")
    int updateById(Integer done,Integer maxPage,Integer id);
}
