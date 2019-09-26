//package Study;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import MyMIDI.main;
//import redis.clients.jedis.Jedis;
//
//public class Redis {
//	
////	private static Redis redis = new Redis();
//	
//	public static void main(String[] args) {
//		Jedis jedis = new Jedis("127.0.0.1", 6379);
//		jedis.flushDB();						//清空数据
//		jedisString(jedis);
//        
//	}
//	public static void jedisString(Jedis jedis) {
//		jedis.set("name","d2yml");							//写入一个字符串 
//		jedis.get("name");									//读取一个字符串
//		jedis.setnx("key1", "value1");						//写入一个字符串;防止覆盖
//		jedis.append("name", " is my life");				//字符串拼接;第一个参数为要拼接的key 第二个参数为要拼接的内容
//		jedis.exists("");									//判断指定key是否存在
//		jedis.del("");										//删除指定key
//		jedis.mset("key01", "value01", "key02", "value02");	//添加多个K-V
//		jedis.mget("key01","key02");						//获取多个K-V
//		jedis.del(new String[]{"key01", "key02"});			//删除多个K-V
//		jedis.setex("key3", 2, "value3");					//设置生存时间;秒为单位
//		jedis.getrange("key2", 2, 4);						//截取字符串2,3,4位
//		System.out.println(jedis.get("name"));
//	}
//	
//	public static void jedisHash(Jedis jedis) {
//		jedis.flushDB();
//	    Map<String, String> map = new HashMap<>();
//	    map.put("key1", "value1");
//	    map.put("key2", "value2");
//	    map.put("key3", "value3");
//	    map.put("key4", "value4");
//	    jedis.hmset("hash", map);
//	    jedis.hset("hash", "key5", "value5");
//	}
//}
