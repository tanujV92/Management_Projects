package com.mill.management.facadeImpl;

import com.mill.management.dataDto.ProductData;
import com.mill.management.dataDto.ProductMasterData;
import com.mill.management.entity.Category;
import com.mill.management.entity.Product;
import com.mill.management.exceptions.DuplicateEntryException;
import com.mill.management.facade.ProductFacade;
import com.mill.management.populators.ProductDataPopulator;
import com.mill.management.repository.ProductRepository;
import com.mill.management.reversepopulators.ProductReversePopulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class ProductFacadeImpl implements ProductFacade {

    @Autowired
    private ProductDataPopulator productDataPopulator;

    @Autowired
    private ProductReversePopulator productReversePopulator;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product findProductByName(String productName) {
        return productRepository.findByName(productName);
    }

    @Override
    public Product findProductById(long productId) {
        return productRepository.findByProduct_Id(productId);
    }

    @Override
    public boolean saveProduct(ProductData product) throws DuplicateEntryException {
        Product newProduct=null;
        try{
            newProduct=productReversePopulator.reversePopulator(new Product(),product,true,true);
            productRepository.save(newProduct);
        }catch (RuntimeException e){
            e.printStackTrace();
                throw new DuplicateEntryException(e.getMessage());
        }
        return  newProduct!= null;
    }

    @Override
    public ProductMasterData getAllTheProducts() {
        ProductMasterData productMasterData=new ProductMasterData();
        List<Product> productList = (List<Product>)productRepository.findAll();

        List<ProductData> productData = new ArrayList<>();
        for(Product product: productList){
            productData.add(productDataPopulator.populate(product,new ProductData(),true));
        }
        productMasterData.setProducts(productData);
        updateCategories(productList,productMasterData);
        updateProducts(productList,productMasterData);
        return productMasterData;
    }

    private void updateCategories(List<Product> productList,ProductMasterData productMasterData){
            Set<String> categories=new HashSet<>();
            for(Product product:productList){
                if(product.getCategories()!=null && product.getCategories().size()>0){
                    for (Category category:product.getCategories()){
                            categories.add(category.getName());
                    }
                }
            }
        productMasterData.setCategoryNameList(categories);
        productMasterData.setCategoryCount(categories.size());
    }

    private void updateProducts(List<Product> productList,ProductMasterData productMasterData){
        Set<String> products=new HashSet<>();
        if(productList!=null && productList.size()>0){
            for (Product product:productList){
                products.add(product.getName());
            }
        }

        productMasterData.setProductsNameList(products);
        productMasterData.setProductCount(products.size());
    }

}
