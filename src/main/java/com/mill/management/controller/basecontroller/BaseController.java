package com.mill.management.controller.basecontroller;

import lombok.Data;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.stereotype.Controller;

@Controller
@Data
public class BaseController {

     private MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

}
