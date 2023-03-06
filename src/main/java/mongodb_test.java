import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.logging.Level;
import java.util.logging.Logger;

public class mongodb_test{
  public static void main( String args[] ){
    // 关闭mongodb driver的日志显示
    Logger log = Logger.getLogger("org.mongodb.driver");
    log.setLevel(Level.OFF);
    try{
      // 连接到 mongodb 服务
      MongoClient mongoClient = new MongoClient( "10.200.53.96" , 27017 );

      // 连接到数据库
      MongoDatabase mongoDatabase = mongoClient.getDatabase("test");
      System.out.println("Connect to database successfully");
      MongoCollection<Document> collection = mongoDatabase.getCollection("tang");
      System.out.println("集合 tang 选择成功");

      //检索所有文档
      /**
       * 1. 获取迭代器FindIterable<Document>
       * 2. 获取游标MongoCursor<Document>
       * 3. 通过游标遍历检索出的文档集合
       * */
      FindIterable<Document> findIterable = collection.find();
      MongoCursor<Document> mongoCursor = findIterable.iterator();
      while(mongoCursor.hasNext()){
        System.out.println(mongoCursor.next());
      }

    }catch(Exception e){
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
    }
  }
}