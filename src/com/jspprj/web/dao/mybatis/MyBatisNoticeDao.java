package com.jspprj.web.dao.mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jspprj.web.dao.NoticeDao;
import com.jspprj.web.entities.Notice;
import com.jspprj.web.model.NoticeModel;

public class MyBatisNoticeDao implements NoticeDao{
	
	private SqlSessionFactory ssf;
	
	public MyBatisNoticeDao(){
		ssf = JspSessionFactoryBuilder.getSqlSqlsessionFactory();
	}

	@Override
	public Notice get(String code) {
		SqlSession session = ssf.openSession(); //트랜잭션을 하기위한 도구
		NoticeDao noticeDao = session.getMapper(NoticeDao.class);
		return noticeDao.get(code);
	}

	@Override
	public List<NoticeModel> getList(int page, String field, String query){
		SqlSession session = ssf.openSession(); //트랜잭션을 하기위한 도구
		NoticeDao noticeDao = session.getMapper(NoticeDao.class);
		return noticeDao.getList(page, field, query);
	}
	
	@Override
	public int getCount(String field, String query) {
		SqlSession session = ssf.openSession(); //트랜잭션을 하기위한 도구
		NoticeDao noticeDao = session.getMapper(NoticeDao.class);
		int count = noticeDao.getCount(field, query);
		session.close();
		return count;
	}

	@Override
	public List<NoticeModel> getList(int page) {

		return getList(page, "TITLE", "");
	}

	@Override
	public List<NoticeModel> getList() {

		return getList(1, "TITLe", "");
	}

	@Override
	public int add(Notice notice) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Notice notice) {
		SqlSession session = ssf.openSession(); //트랜잭션을 하기위한 도구
		NoticeDao noticeDao = session.getMapper(NoticeDao.class);
		
		int result = noticeDao.update(notice);
		session.commit();
		session.close();
		return result;
	}

	@Override
	public int delete(String code) {
		SqlSession session = ssf.openSession(); //트랜잭션을 하기위한 도구
		NoticeDao noticeDao = session.getMapper(NoticeDao.class);
		
		int result = noticeDao.delete(code);
		session.commit();
		session.close();
		return result;
	}
	
	@Override
	public int insert(Notice notice) {
		SqlSession session = ssf.openSession(); //트랜잭션을 하기위한 도구
		NoticeDao noticeDao = session.getMapper(NoticeDao.class);
		
		int result = noticeDao.insert(notice);
		session.commit();
		session.close();
		return result;
	}

	@Override
	public String getLastCode() {
		SqlSession session = ssf.openSession(); //트랜잭션을 하기위한 도구
		NoticeDao noticeDao = session.getMapper(NoticeDao.class);
		String code = noticeDao.getLastCode();
		session.close();
		return code;
	}
	
	/* 준모 오빠가 주신 코드 16.10.31 */
	
	@Override
	   public Notice getPrev(String code) {
	      // TODO Auto-generated method stub
	      SqlSession session = ssf.openSession(); //
	      NoticeDao noticeDao = session.getMapper(NoticeDao.class);
	      
	      Notice notice =  noticeDao.getPrev(code);
	      
	      
	      
	      return notice;
	   }

	   @Override
	   public Notice getNext(String code) {
	      // TODO Auto-generated method stub
	      SqlSession session = ssf.openSession(); //
	      NoticeDao noticeDao = session.getMapper(NoticeDao.class);
	         
	      Notice notice =  noticeDao.getNext(code);
	      
	      
	      
	      return notice;
	   }

	   @Override
	   public int hitUp(String code) {
	      SqlSession session = ssf.openSession(); //
	      NoticeDao noticeDao = session.getMapper(NoticeDao.class);
	      
	      int result = noticeDao.hitUp(code);
	      
	      session.commit();
	      session.close();
	      
	      return result;
	   }
	   
	   
	 

}
