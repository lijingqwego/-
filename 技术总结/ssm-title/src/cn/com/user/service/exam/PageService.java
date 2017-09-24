package cn.com.user.service.exam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.user.mapper.TExaPaperMapper;
import cn.com.user.pojo.TExaPaper;
import cn.com.user.pojo.exam.PageVO;

@Service
public class PageService {
	@Resource
	private TExaPaperMapper pagemapper;

	public List<TExaPaper> findAll() {
		// TODO Auto-generated method stub
		List<TExaPaper> list=new ArrayList<>();
		list=pagemapper.findAll();
		return list;
	}

	public int insertPage(PageVO vo) {
		// TODO Auto-generated method stub
		Map<String, Object> map= new HashMap<>();
		int type=vo.getExaminationType();
		map.put("vo", vo);
		try {
				pagemapper.insertByType(map);
			int result=(int) map.get("result0");
			if(result==1){
				return 1;
			}else{
				return 0;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}
}
