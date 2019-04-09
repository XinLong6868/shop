package com.fh.shop.backend.biz.product;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fh.shop.backend.api.product.ProductVoApi;
import com.fh.shop.backend.common.DataTableResult;
import com.fh.shop.backend.util.DateUtil;
import com.fh.shop.backend.util.SystemContent;
import com.fh.shop.backend.vo.productVo.ProductVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.shop.backend.biz.DateUtils;
import com.fh.shop.backend.mapper.product.IProductMapper;
import com.fh.shop.backend.po.product.Product;

@Service("iProductService")
public class IProductServiceImpl implements IProductService {
    @Autowired
    private IProductMapper iProductMapper;

    /**
     * <pre>项目名称：接口实现层
     * 类名称：IProductServiceImpl
     * 类描述：
     * 创建人：辛龙       2427776882@qq.com
     * 创建时间：2018年12月23日 下午7:08:47
     * 修改人：辛龙       2427776882@qq.com
     * 修改时间：2018年12月23日 下午7:08:47
     * 修改备注：
     * @version </pre>
     */
    //<bean id="iProductServiceImpl" class="com.fh.shop.backend.biz.product.IProductServiceImpl"/>
    @Override
    public DataTableResult buildProductDataTable(Integer start, Integer length, Integer draw, Product product, Map<String, String[]> parameterMap) {
        //构建排序信息
        buildOrder(parameterMap, product);
        //构建分页信息
        product.setStartPos(start);
        product.setPageSize(length);
        //获取总条数
        Long totalCount = findProductListCount(product);
        //获取分页列表
        List<Product> findProduct = listProduct(product);
        //PO转VO
        List<ProductVo> productVoList = wrapperProductVo(findProduct);
        //组装过后的结果
        return DataTableResult.buid(draw, totalCount, totalCount, productVoList);
    }

    private List<ProductVo> wrapperProductVo(List<Product> findProduct) {
        List<ProductVo> productVoList = new ArrayList<>();
        for (Product productInfo : findProduct) {
            //po---->vo
            ProductVo productVo = new ProductVo();
            productVo.setId(productInfo.getId());
            productVo.setProductName(productInfo.getProductName());
            productVo.setProductImagePath(productInfo.getProductImagePath());
            productVo.setBrandName(productInfo.getBrandText().getBrandName());
            productVo.setProductprivace(productInfo.getProductprivace());
            productVo.setCreateTimeStr(DateUtil.date2Str(productInfo.getCreateTime(), DateUtil.FULL_DATE));
            productVo.setUpdateTimeStr(DateUtil.date2Str(productInfo.getUpdateTime(), DateUtil.FULL_DATE));
            //将上述转换后的vo对象放入到集合中
            productVoList.add(productVo);
        }
        return productVoList;
    }

    private void buildOrder(Map<String, String[]> parameterMap, Product product) {
        //提取排序的字段
        //通过下标获取字段
        String orderFiled = "";
        if (parameterMap.get(SystemContent.ORDER_COLUMN) != null) {
            String orderColumn = parameterMap.get(SystemContent.ORDER_COLUMN)[0];
            //将获取的字段放入
            String orderFiledTemp = parameterMap.get(getColumnDate(orderColumn))[0];
            String orderInfo = (String) SystemContent.FIELD_MAPPING.get(orderFiledTemp);
            orderFiled = StringUtils.isEmpty(orderInfo) ? orderFiledTemp : orderInfo;
        }
        //提取排序的方向
        String orderDirect = "";
        if (parameterMap.get(SystemContent.ORRDER_DIR) != null) {
            orderDirect = parameterMap.get(SystemContent.ORRDER_DIR)[0];
        }
        //要排序的字段名
        product.setSortField(orderFiled);
        //排序的方式
        product.setSort(orderDirect);
    }

    private String getColumnDate(String orderColumn) {
        return "columns[" + orderColumn + "][data]";
    }

    /**增加
     *
     */
    @Override
    public void addProduct(Product product) {
        product.setUpdateTime(DateUtils.getDateNow());
        product.setCreateTime(DateUtils.getDateNow());
        iProductMapper.addProduct(product);
    }

    /**
     * 查询
     */
    @Override
    public List<Product> listProduct(Product product) {

        return iProductMapper.listProduct(product);
    }

    /**
     * poi导出
     *
     * @param product
     * @return
     */
    @Override
    public List<Product> findProductList(Product product) {
        List<Product> productList = iProductMapper.findProductList(product);
        return productList;
    }

    @Override
    public Integer selectMaxId() {
        return iProductMapper.selectMaxId();
    }

    /**
     * 普通接口
     * @return
     */
    @Override
    public List<ProductVoApi> findAllProductList() {
        //此处集合中的对象是数据库查出来的
        List<Product> productList = iProductMapper.findAllProductList();
        //此处集合中的对象是要转换的接口中的api
        List<ProductVoApi> productVoApiList = new ArrayList<>();
        for (Product Product : productList) {
            ProductVoApi productVoApi = new ProductVoApi();
            productVoApi.setId(Product.getId());
            productVoApi.setProductName(Product.getProductName());
            productVoApi.setProductprivace(Product.getProductprivace());
            productVoApi.setProductImagePath(Product.getProductImagePath());
            productVoApiList.add(productVoApi);
        }
        return productVoApiList;
    }

    /**
     * 单个删除
     */
    @Override
    public void deleteProductID(Integer id) {
        iProductMapper.deleteProductID(id);
    }

    /**
     * 批量删除
     */
    @Override
    public void deleteBatchProduct(String ids) {
        if (StringUtils.isNotEmpty(ids)) {
            List<Integer> idList = new ArrayList<Integer>();
            String[] idArr = ids.split(",");
            for (String id : idArr) {
                idList.add(Integer.parseInt(id));
            }
            iProductMapper.deleteBatchProduct(idList);
        }
    }

    /**
     * 回填
     */
    @Override
    public Product findproduct(Integer id) {
        Product product = iProductMapper.findproduct(id);
        return product;
    }

    /**
     * 修改
     */
    @Override
    public void updateProduct(Product product) {
        iProductMapper.updateProduct(product);
    }

    /**
     * 开始 分页
     */
    @Override
    public Long findProductListCount(Product product) {
        Long count = iProductMapper.findProductListCount(product);
        return count;
    }

}
