package com.liucj.mall.controller;

import com.liucj.mall.common.CommonPage;
import com.liucj.mall.common.CommonResult;
import com.liucj.mall.mbg.model.PmsBrand;
import com.liucj.mall.service.PmsBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "PmsBrandController", description = "商品品牌管理")
@Controller
@RequestMapping("/brand")
public class PmsBrandController {
    @Autowired
    private PmsBrandService pmsBrandService;

    private static final Logger LOGGER = LoggerFactory.getLogger(PmsBrandController.class);

    @ApiOperation("获取所有品牌列表")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsBrand>> getBrandList(){
        return CommonResult.success(pmsBrandService.listAllBrand());
    }

    @ApiOperation("添加品牌")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createBrand(@RequestBody PmsBrand brand){
        CommonResult commonResult;
        int count = pmsBrandService.createBrand(brand);
        if (count == 1){
            commonResult = CommonResult.success(brand);
            LOGGER.debug("create Success:{}",brand);
        }else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("create fail:{操作失败}", brand);
        }
        return commonResult;
    }

    @ApiOperation("更新指定id品牌信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateBrand(@PathVariable("id") Long id, @RequestBody PmsBrand brandDto){
        CommonResult commonResult;
        int count = pmsBrandService.updateBrand(id,brandDto);
        if (count == 1){
            commonResult = CommonResult.success(brandDto);
            LOGGER.debug("create Success:{}",brandDto);
        }else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("create fail:{操作失败}", brandDto);
        }
        return commonResult;
    }

    @ApiOperation("删除指定id的品牌")
    @RequestMapping(value = "/deleted/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult deletedBrand(@PathVariable("id") Long id){
        int count = pmsBrandService.deleteBrand(id);
        if (count == 1){
            LOGGER.debug("create Success:{}",id);
            return CommonResult.success(null);
        }else {
            LOGGER.debug("create fail:{操作失败}", id);
            return CommonResult.failed("操作失败");
        }
    }

    @ApiOperation("分页查询品牌列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<PmsBrand>> listBrand(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                        @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
        List<PmsBrand> brandList = pmsBrandService.listBrand(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(brandList));
    }

    @ApiOperation("获取指定id的品牌详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<PmsBrand> brand(@PathVariable("id") Long id) {
        return CommonResult.success(pmsBrandService.getBrand(id));
    }
}
