package com.jspprj.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jspprj.web.dao.NoticeFileDao;
import com.jspprj.web.entities.NoticeFile;

public class MyBatisNoticeFileDao implements NoticeFileDao {

	private SqlSessionFactory ssf;
	
	public MyBatisNoticeFileDao() {
		ssf = JspSessionFactoryBuilder.getSqlSqlsessionFactory();
	}
	
	@Override
	public int delete(String code) {
		SqlSession session = ssf.openSession(); //트랜잭션을 하기위한 도구
		NoticeFileDao noticeFileDao = session.getMapper(NoticeFileDao.class);
		
		int result = noticeFileDao.delete(code);
		session.commit();
		session.close();
		return result;
	}

	@Override
	public List<NoticeFile> getList(String noticeCode) {
		SqlSession session = ssf.openSession(); //트랜잭션을 하기위한 도구
		NoticeFileDao NoticeFileDao = session.getMapper(NoticeFileDao.class);
		return NoticeFileDao.getList(noticeCode);
	}

	@Override
	public int insert(NoticeFile file) {
		SqlSession session = ssf.openSession(); //트랜잭션을 하기위한 도구
		NoticeFileDao noticeFileDao = session.getMapper(NoticeFileDao.class);
		
		int result = noticeFileDao.insert(file);
		session.commit();
		session.close();
		return result;
	}

	@Override
	public int update(NoticeFile file) {
		SqlSession session = ssf.openSession(); //트랜잭션을 하기위한 도구
		NoticeFileDao noticeFileDao = session.getMapper(NoticeFileDao.class);
		
		int result = noticeFileDao.update(file);
		session.commit();
		session.close();
		return result;
	}

}
