package com.mill.management.reversepopulators;

import com.mill.management.dataDto.CategoryData;
import com.mill.management.dataDto.PriceData;
import com.mill.management.dataDto.ProductData;
import com.mill.management.dataDto.QuantityData;
import com.mill.management.entity.Category;
import com.mill.management.entity.Price;
import com.mill.management.entity.Product;
import com.mill.management.entity.Quantity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
public class ProductReversePopulator {

    @Autowired
    private CategoryReversePopulator categoryReversePopulator;

    @Autowired
    private QuantityReversePopulator quantityReversePopulator;

    @Autowired
    private PriceReversePopulator priceReversePopulator;

    public Product reversePopulator(Product product, ProductData productData,boolean isSetCategories,boolean isSetQuantity){
            product.setActive(true);
            product.setExpDate(productData.getExpDate());
            product.setMfgDate(productData.getMfgDate());
            product.setName(productData.getName());
            if(isSetQuantity){
                Quantity quantity=quantityReversePopulator.reversepopulator(new Quantity(), retrieveQuantityData(productData));
                quantity.setProduct(product);
                product.setQuantity(quantity);
            }
        if(isSetCategories){
            product.setCategories(populateCategories(productData.getCategories()));
        }
            product.setType(productData.getType());
            product.setCreatedBy(productData.getCreatedBy());
            product.setCreatedOn(productData.getCreatedOn());
            Price price = priceReversePopulator.reversePopulator(new Price(),retrivePriceData(productData),false);
            price.setProduct(product);
            product.setPrice(Arrays.asList(price));
            return product;
    }

    private Set<Category> populateCategories(Set<CategoryData> categoryDataList){
        Set<Category> categoryList=new HashSet<>();
        for (CategoryData categoryData:categoryDataList ){
            categoryList.add(categoryReversePopulator.reversePopulator(new Category(),categoryData));
        }
        return categoryList;
    }

    private QuantityData retrieveQuantityData(ProductData productData){
            QuantityData quantityData=new QuantityData();
            quantityData.setAvailableQty(productData.getAvailableQty());
            quantityData.setAvailableQtyType(productData.getAvailableQtyType());
            return quantityData;
    }

    private PriceData retrivePriceData(ProductData productData){
            PriceData priceData=new PriceData();
            priceData.setPrice(productData.getPrice());
            priceData.setPriceType(productData.getPriceType());
            priceData.setSurcharges(productData.getSurcharges());
            priceData.setSurchargeType(productData.getSurchargeType());
            return priceData;
    }

}
