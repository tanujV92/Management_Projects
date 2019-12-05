package com.mill.management.reversepopulators;

import com.mill.management.dataDto.CategoryData;
import com.mill.management.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryReversePopulator {

    public Category reversePopulator(Category category, CategoryData categoryData){

            category.setName(categoryData.getName());
            category.setType(categoryData.getType());
            category.setActive(true);
            category.setCreatedBy(categoryData.getCreatedBy());
            category.setCreatedOn(categoryData.getCreatedOn());

        return category;
    }

}
