package com.liucj.mall.service;

import com.liucj.mall.mbg.model.PmsBrand;
import com.liucj.mall.mbg.model.PmsBrandExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PmsBrandService {
    List<PmsBrand> listAllBrand();

    int createBrand(PmsBrand brand);

    int updateBrand(Long id, PmsBrand brand);

    int deleteBrand(Long id);

    List<PmsBrand> listBrand(int pageNum, int pageSize);

    PmsBrand getBrand(Long id);
}
