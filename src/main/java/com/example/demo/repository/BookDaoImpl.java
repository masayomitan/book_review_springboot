package com.example.demo.repository;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Map;


import com.example.demo.entity.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


//Repositoryは、以下2つの役割を担う。

//1.Serviceに対して、Entityのライフサイクルを制御するための操作（Repositoryインタフェース）を提供する。
//Entityのライフサイクルを制御するための操作は、EntityオブジェクトへのCRUD操作となる。

//2.Entityを永続化する処理(Repositoryインタフェースの実装クラス)を提供する。
//Entityオブジェクトは、アプリケーションのライフサイクル(サーバの起動や、停止など)に依存しないレイヤに、永続化しておく必要がある。
//実際の永続化処理は、O/R Mapperなどから提供されているAPIを使って行う。
//この役割は、インフラストラクチャ層のRepositoryImplで実装することになる。


//@RepositoryはSpring MVCでデータ層のクラス（DAO等のDBアクセスを行うクラス）に付与する。
@Repository
public class BookDaoImpl implements BookDao {
  
  private final JdbcTemplate jdbcTemplate;

  //＠Autowiredで引数JdbcTemplateをBookDaoImplクラスに注入
  //https://dev.classmethod.jp/articles/springboot-what-is-bean/
  @Autowired
  public BookDaoImpl(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public List<Book> findAll() {

    String sql = "SELECT book.id, title, author, publisher, buyDate, releaseDate, overView ";

    //book一覧をMapのListで取得
    //queryForList() メソッドは java.util.List を返します。この List はカラム名をキーとし、カラムのデータを値とする java.util.Map を要素としてもちます。
    List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
    
    //return用の空のListを用意
    List<Book> list = new ArrayList<Book>();

    //result : resultListが大事
    for(Map<String, Object> result : resultList) {

      //bookの配列を作り
      Book book = new Book();
			book.setId((int)result.get("id"));
			book.setTitle((String)result.get("title"));
			book.setAuthor((String)result.get("author"));
			book.setPublisher((String)result.get("publisher"));
      book.setBuyDate((Date)result.get("buyDate"));
      book.setReleaseDate((Date)result.get("releaseDate"));
      book.setOverView((String)result.get("overView"));
      book.setDeadline(((Timestamp) result.get("deadline")).toLocalDateTime());
    
  }
  return list;
 }


 @Override
 public Optional<Book> findById(int id){

  String sql = "SELECT book.id, title, author, publisher, buyDate, releaseDate, overView "
  + "WHERE book.id = ?";

  Map<String, Object> result = jdbcTemplate.queryForMap(sql, id);

  Book book = new Book();
			book.setId((int)result.get("id"));
			book.setTitle((String)result.get("title"));
			book.setAuthor((String)result.get("author"));
			book.setPublisher((String)result.get("publisher"));
      book.setBuyDate((Date)result.get("buyDate"));
      book.setReleaseDate((Date)result.get("releaseDate"));
      book.setOverView((String)result.get("overView"));
      book.setDeadline(((Timestamp) result.get("deadline")).toLocalDateTime());

    //taskをOptionalでラップする
		Optional<Book> taskOpt = Optional.ofNullable(book);
		return taskOpt;
 }


 @Override
	public void insert(Book book) {
		jdbcTemplate.update("INSERT INTO book(id, title, author, publisher, buyDate, releaseDate, overView, deadline) VALUES(?, ?, ?, ?, ?, ?, ?, ?)",
				 book.getId(), book.getTitle(), book.getAuthor(), book.getPublisher(), book.getBuyDate(), book.getReleaseDate(), book.getOverView(), book.getDeadline() );
  }
  
  @Override
	public void save(Book book) {
		jdbcTemplate.update("INSERT INTO book(id, title, author, publisher, buyDate, releaseDate, overView, deadline) VALUES(?, ?, ?, ?, ?, ?, ?, ?)",
				 book.getId(), book.getTitle(), book.getAuthor(), book.getPublisher(), book.getBuyDate(), book.getReleaseDate(), book.getOverView(), book.getDeadline() );
	}
	
	@Override
	public int update(Book book) {
		return 	jdbcTemplate.update("UPDATE book SET id = ?, title = ?, author = ?, publisher = ?, buyDate = ?, releaseDate = ?, overView = ?, deadline = ? WHERE id = ?",
    book.getId(), book.getTitle(), book.getAuthor(), book.getPublisher(), book.getBuyDate(), book.getReleaseDate(), book.getOverView(), book.getDeadline() );
}

	@Override
	public int deleteById(int id) {
		return jdbcTemplate.update("DELETE FROM book WHERE id = ?", id);
	}

}