import redis.clients.jedis.Jedis;
public class redis_test {

  public static void main(String[] args) {
    //连接本地的 Redis 服务
    Jedis jedis = new Jedis("10.200.53.96");
    // 如果 Redis 服务设置了密码，需要下面这行，没有就不需要
    // jedis.auth("123456");
    System.out.println("连接成功");
    //查看服务是否运行
    System.out.println("服务正在运行: " + jedis.ping());
    System.out.println("redis 存储的字符串为: "+ jedis.get("user"));
  }
}