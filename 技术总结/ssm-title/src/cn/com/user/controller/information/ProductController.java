package cn.com.user.controller.information;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.com.user.controller.BaseController;
import cn.com.user.pojo.PagetionVo;
import cn.com.user.pojo.TLesSubRelation;
import cn.com.user.pojo.TLessonProductInfo;
import cn.com.user.pojo.information.ProductAndSubject;
import cn.com.user.service.exam.ProductService;
import cn.com.user.service.information.SubjectService;
import cn.com.user.util.DateUtil;
import cn.com.user.util.StateUtil;
//�Կγ̽��й���
@Controller
@RequestMapping("/product")
public class ProductController extends BaseController{
	private static Logger log=Logger.getLogger(ProductController.class);
	@Resource
	private ProductService productservice;
	@Resource
	private SubjectService subjectservice;
//	���ڷ�ҳ
	/**
	 * �����������ҿγ�
	 * @param request
	 * @return 
	 * @return
	 */
	@RequestMapping("/showProducts")
	public ModelAndView findProduct( HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		Map<String, String> map=new HashMap<>();
//		��ȡ��ѯ����
		String lessoncode=request.getParameter("lessoncode");
		String lessonname=request.getParameter("lessonname");
		String lessoncontent=request.getParameter("lessoncontent");
//		��ɷ�ҳ����
		String page=request.getParameter("page");
		if(page==null ||page.equals("")){
			page="1";
		}
		PagetionVo vo=new PagetionVo();
		vo.setpage(page);
		if(lessoncode !=null && !lessoncode.equals("")){
			map.put("lessoncode", lessoncode);
		}
		if(lessonname !=null && !lessonname.equals("")){
			map.put("lessonname", lessonname);
		}
		if(lessoncontent !=null && !lessoncontent.equals("")){
			map.put("lessoncontent", lessoncontent);
		}
		map.put("startnum", vo.getStartcount());
		map.put("endnum", vo.getEndcount());
		List <TLessonProductInfo> products=new ArrayList<>();
		products=productservice.findBySearche(map);
		String time=DateUtil.dateToStr(new Date(),DateUtil.DATETYPEONE);
		log.info(time+"�γ̽��в�ѯ��"+lessoncode+"  "+lessonname+"  "+lessoncontent);
		mv.addObject("productlist", products);
		mv.setViewName("product.productList");
		return mv;
	}
	/**
	 * ���ڲ��ҿγ���Ϣ���޸�ҳ��
	 * @param lessonid
	 * @return
	 */
	@RequestMapping("/findByLessonid")
	public ModelAndView findByLessonid(String lessonid){
		ModelAndView mv = new ModelAndView();
		TLessonProductInfo product = new TLessonProductInfo();
		product=productservice.findByLessonid(lessonid);
		mv.addObject("product", product);
		mv.setViewName("product.updateProduct");
		return mv;
	}
	/**
	 * ���¿γ���Ϣ
	 * @param product
	 * @return
	 */
	@RequestMapping("/updateProduct")
	@ResponseBody
	public String updateProduct(@RequestBody TLessonProductInfo product){
		int result=productservice.updateProduct(product);
		if(result==StateUtil.SUCCESSSTATE){
			return "1";
		}else{
			return "0";
		}
	}
	/**
	 * ɾ���γ���Ϣ
	 * @param lessonid
	 * @return
	 */
	@RequestMapping("/removeProduct")
	public ModelAndView removeProduct(String lessonid,HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		List <TLessonProductInfo> products=new ArrayList<>();
		Map<String, String> map = new HashMap<>();
//		��ִ��ɾ��������ִ�в�ѯ����
		productservice.removeProduct(lessonid);
		products=productservice.findBySearche(map);
		mv.addObject("productlist", products);
		mv.setViewName("product.productList");
		return mv;
	}
	/**
	 * ����µĿγ���Ϣ
	 * @param product
	 * @return
	 */
	@RequestMapping("/insertProduct")
	@ResponseBody
	public String insertProduct(@RequestBody TLessonProductInfo product){
		String message="1";
		int result =productservice.insertProduct(product);
		switch (result) {
		case 1:
			message="1";
			break;
		case 0:
			message="0";
			break;
		default:
			message="2";
			break;
		}
		return message;
	}
	/**
	 * �γ̿�Ŀ�������Ϣ
	 * @param request
	 * @param lessonid �γ�id
	 * @return
	 */
	@RequestMapping("/productandsubject")
	public ModelAndView productAndSubject(HttpServletRequest request,String lessonid){
		ModelAndView mv =new ModelAndView();
		List<ProductAndSubject> subjects=new ArrayList<>();
		subjects=subjectservice.findProductRelevanceSubject(lessonid);
//		���浱ǰ����������lessonid
		request.getSession().setAttribute("relevance_lessonid", lessonid);
		mv.addObject("subjects", subjects);
		mv.setViewName("product.productAndSubject");
		return mv;
	}
	/**
	 * �����Ѿ�ѡ�еĿ�Ŀ
	 * @param subjects ѡ�еĿ�Ŀdiƴ���ַ���
	 * @param request 
	 * @return ����״̬
	 */
	@RequestMapping("/relevance")
	public @ResponseBody String productRelevanceSubject(@RequestBody String subjects,HttpServletRequest request){
//		�ж����ݴ����Ƿ��쳣
		if(subjects == null || subjects==""){
			return "0";
		}
		String [] subjectlist=subjects.split("-");
		List<TLesSubRelation> list= new ArrayList<>();
//		��ȡ��ǰִ�й���������lessonid
		String lessonid=(String) request.getSession().getAttribute("relevance_lessonid");
		for(int i=0;i<subjectlist.length;i++){
			TLesSubRelation lessub=new TLesSubRelation();
			lessub.setLessonId(lessonid);
			lessub.setSubjectNo(BigDecimal.valueOf(Long.valueOf(subjectlist[i])));
			list.add(lessub);
		}
		int result=subjectservice.insertList(list);
		if(result==StateUtil.FAILSTATE){
			return "0";
		}
		return "1";
	}
	/**
	 * ȡ�����б������Ŀ�Ŀ
	 * @param subjects ѡ�еĿ�Ŀdiƴ���ַ���
	 * @param request 
	 * @return ����״̬
	 */
	@RequestMapping("/norelevance")
	public @ResponseBody String nullRelevan(HttpServletRequest request){
//		�ж����ݴ����Ƿ��쳣
//		��ȡ��ǰִ�й���������lessonid
		String lessonid=(String) request.getSession().getAttribute("relevance_lessonid");
		int result=subjectservice.removeAll(lessonid);
		if(result==StateUtil.FAILSTATE){
			return "0";
		}
		return "1";
	}
}
