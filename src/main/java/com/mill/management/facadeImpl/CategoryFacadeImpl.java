package com.mill.management.facadeImpl;

import com.mill.management.dataDto.CategoryData;
import com.mill.management.entity.Category;
import com.mill.management.facade.CategoryFacade;
import com.mill.management.populators.CategoryPopulator;
import com.mill.management.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryFacadeImpl implements CategoryFacade {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryPopulator categoryPopulator;

    @Override
    public List<CategoryData> getAllCategories() {

        return populateCategoryData((List<Category>)categoryRepository.findAll());
    }

    private List<CategoryData> populateCategoryData(List<Category> categories){
            List<CategoryData> categoryDataList=new ArrayList<>();
            for(Category category: categories){
                categoryDataList.add(categoryPopulator.populate(category,new CategoryData(),true));
            }
            return categoryDataList;
    }


}
