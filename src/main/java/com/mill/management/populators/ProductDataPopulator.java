package com.mill.management.populators;

import com.mill.management.dataDto.CategoryData;
import com.mill.management.dataDto.PriceData;
import com.mill.management.dataDto.ProductData;
import com.mill.management.entity.Category;
import com.mill.management.entity.Price;
import com.mill.management.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class ProductDataPopulator {

    @Autowired
    private CategoryPopulator categoryPopulator;

    @Autowired
    private Quantitypopulator quantitypopulator;

    @Autowired
    private PricePopulator pricePopulator;

    public ProductData populate(Product product, ProductData productData,boolean isSetCategory){
        productData.setName(product.getName());
        productData.setExpDate(product.getExpDate());
        productData.setMfgDate(product.getMfgDate());
        productData.setType(product.getType());
        Set<CategoryData> categoryDataList = new HashSet<>();
        if(isSetCategory){
            for(Category category:product.getCategories()){
                categoryDataList.add(categoryPopulator.populate(category,new CategoryData(),false));
            }
            productData.setCategories(categoryDataList);
        }
        updatePriceDataIntoProduct(getPriceData(product.getPrice()),productData);
        quantitypopulator.populate(product.getQuantity(),productData);
        return productData;
    }

    private PriceData getPriceData(List<Price> priceList){
        PriceData priceData=null;
        for (Price price:priceList){
          if(price.isActive()){
              priceData = pricePopulator.populate(new PriceData(),price);
          }
        }
        return priceData;
    }

    private void updatePriceDataIntoProduct(PriceData priceData,ProductData productData){
       if(priceData!=null && productData !=null){
           productData.setPrice(priceData.getPrice());
           productData.setPriceType(priceData.getPriceType());
           productData.setSurcharges(priceData.getSurcharges());
           productData.setSurchargeType(priceData.getSurchargeType());
       }
    }
}
