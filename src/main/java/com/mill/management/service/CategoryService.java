package com.mill.management.service;

import com.mill.management.dataDto.CategoryData;
import com.mill.management.entity.Category;
import com.mill.management.facade.CategoryFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryFacade categoryFacade;

    public List<CategoryData> getAllCategories(){
        return categoryFacade.getAllCategories();
    }

}
