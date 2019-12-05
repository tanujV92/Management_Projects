package com.mill.management.facade;

import com.mill.management.dataDto.CategoryData;
import com.mill.management.entity.Category;

import java.util.List;

public interface CategoryFacade {

    List<CategoryData> getAllCategories();
}
