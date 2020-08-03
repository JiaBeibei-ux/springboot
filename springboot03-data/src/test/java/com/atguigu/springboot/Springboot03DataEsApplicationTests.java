package com.atguigu.springboot;


import com.atguigu.springboot.bean.Article;
import com.atguigu.springboot.bean.Book;
import com.atguigu.springboot.repository.BookRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.DocumentResult;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.elasticsearch.index.query.CommonTermsQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class Springboot03DataEsApplicationTests {

    @Autowired
    JestClient jestClient;

    @Resource
    BookRepository bookRepository;

    @Test
    public void contextLoads() {
        //给es中索引（save）一个文档
        Article article = new Article();
        article.setId(1);
        article.setTitle("钢铁是怎样炼成的！");
        article.setAuthor("Jack");
        article.setContent("Hello World!");
        //构建一个索引
        Index build = new Index.Builder(article).index("atguigu").type("news").build();
        try {
            //执行
            jestClient.execute(build);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //全文搜索
    @Test
    public void test(){
        //查询表达式
        String query = "{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {\n" +
                "            \"content\" : \"Hello\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        //构建搜索功能
        Search search = new Search.Builder(query).addIndex("atguigu").addType("news").build();
        try {
            //执行
            SearchResult execute = jestClient.execute(search);
            System.out.println(execute.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //测试搜索
    @Test
    public void search(){

        //查询表达式
        String json ="{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {\n" +
                "            \"content\" : \"Hello\"\n" +
                "        }\n" +
                "    }\n" +
                "}";

        //更多操作：https://github.com/searchbox-io/Jest/tree/master/jest
        //构建搜索功能
        Search search = new Search.Builder(json).addIndex("atguigu").addType("news").build();

        //执行
        try {
            SearchResult result = jestClient.execute(search);
            System.out.println(result.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2(){
        Book book = new Book();
        book.setId(1);
        book.setAuthor("Rose");
        book.setBookName("Hello World!");
        bookRepository.index(book);
    }
    @Test
    public void test3(){
        List<Book> books = bookRepository.findByBookNameLike("h");
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
