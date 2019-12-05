package com.mill.management.controller;

import com.mill.management.controller.basecontroller.BaseController;
import com.mill.management.dataDto.CategoryData;
import com.mill.management.dataDto.ProductData;
import com.mill.management.dto.CategoryWsDto;
import com.mill.management.dto.ProductWsDto;
import com.mill.management.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController extends BaseController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllCategories(){
            return new ResponseEntity<>(getAllCategoryResponse(categoryService.getAllCategories()), HttpStatus.OK);
    }

    private List<CategoryWsDto> getAllCategoryResponse(List<CategoryData> categoryDataList){
        List<CategoryWsDto> categoryWsDtoList=new ArrayList<>();
        getMapperFactory().classMap(CategoryData.class, CategoryWsDto.class).byDefault();
        for(CategoryData categoryData : categoryDataList){
            categoryWsDtoList.add(getMapperFactory().getMapperFacade().map(categoryData, CategoryWsDto.class));
        }
        return  categoryWsDtoList;
    }
}
