package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import com.sist.dao.*;
import com.sist.naver.NaverManager;
@Controller
@RequestMapping("food/")
//7nesYN2hX6XCmB9dbchv
//nJpXpfycr2
public class FoodController {
   @Autowired
   private FoodDAO fdao;
   @Autowired
   private NaverManager nm;
   
   @RequestMapping("list.do")
   public String food_list(Model model)
   {
	   List<FoodCategoryVO> list=fdao.foodCategoryAllData();
	   model.addAttribute("list", list);
	   return "food/list";
   }
   @RequestMapping("food_category.do")
   public String food_category(int no,Model model)
   {
	   List<FoodVO> list=fdao.foodCategoryFoodListData(no);
	   for(FoodVO vo:list)
	   {
		   String s=vo.getPoster();
		   s=s.substring(0,s.indexOf("^"));
		   vo.setPosterOne(s);
	   }
	   FoodCategoryVO vo=fdao.foodCategoryInfoData(no);
	   model.addAttribute("list", list);
	   model.addAttribute("vo", vo);
	   return "food/category";
   }
   @RequestMapping("food_detail.do")
   public String food_detail(int no,Model model)
   {
      FoodVO vo=fdao.foodDetailData(no);
      String s=vo.getAddr();
      System.out.println("s는"+s);
      StringTokenizer st= new StringTokenizer(s,"지");
      vo.setAddr1(st.nextToken());
      vo.setAddr2("지"+st.nextToken());
      
      String type=vo.getType();
      st=new StringTokenizer(type,"/");
      String result="";
      while(st.hasMoreTokens())
      {
    	  result+=st.nextToken().trim()+"|";
      }
      result=result.substring(0,result.lastIndexOf("|"));
      List<RecipeVO> list = fdao.foodLikeRecipeData(result);
      
      nm.naverData(vo.getTitle());
      model.addAttribute("vo", vo);
      model.addAttribute("list",list);
      return "food/food_detail";
   }
}
