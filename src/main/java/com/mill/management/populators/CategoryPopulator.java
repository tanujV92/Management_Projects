package com.mill.management.populators;

import com.mill.management.dataDto.CategoryData;
import com.mill.management.dataDto.ProductData;
import com.mill.management.entity.Category;
import com.mill.management.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class CategoryPopulator {

    @Autowired
    private ProductDataPopulator productDataPopulator;

    public CategoryData populate(Category category,CategoryData categoryData,boolean isProductFetch){
        categoryData.setName(category.getName());
        categoryData.setType(category.getType());
        if(isProductFetch){
            categoryData.setProducts(populateProductData(category.getProducts()));
        }
        return categoryData;
    }

    private List<ProductData> populateProductData(Set<Product> productList){
        List<ProductData> productDataList=new ArrayList<>();
        for(Product product:productList){
            productDataList.add(productDataPopulator.populate(product,new ProductData(),false));
        }
        return productDataList;
    }
}
