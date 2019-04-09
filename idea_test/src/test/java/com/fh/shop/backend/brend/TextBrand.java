package com.fh.shop.backend.brend;

import com.fh.shop.backend.biz.brand.IBrandService;
import com.fh.shop.backend.po.brand.BrandText;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-common.xml")
public class TextBrand extends AbstractJUnit4SpringContextTests {
    @Resource(name = "iBrandService")
    private IBrandService iBrandService;
    @Test
    public void textAddBrand(){
        BrandText brandText = new BrandText();
        brandText.setBrandName("iphoneX Max");
        iBrandService.addBrand(brandText);
    }
    //测试删除方法
    @Test
    public void textDeleteBrand(){
        iBrandService.deleteBrandID(6);
    }
    //测试批量删除
    @Test
    public void textDeleteBrandAll(){
        iBrandService.deleteBatchBrand("20,19");
    }
    //测试修改
    @Test
    public void textUpdateBrand(){
        BrandText brandText = new BrandText();
        brandText.setId(8);
        brandText.setBrandName("iphone 5S");
        iBrandService.updateBrandText(brandText);
    }
    //测试查询
    @Test
    public void textSelectBrand(){
        BrandText brandText = new BrandText();
        List<BrandText> brandTexts = iBrandService.listBrand(brandText);
        System.out.println(brandTexts);
    }
}
