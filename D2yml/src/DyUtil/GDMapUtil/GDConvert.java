package DyUtil.GDMapUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;



public class GDConvert {
	//高德地图接口
	//public static final String GD_MAP_CONVERT = "https://restapi.amap.com/v3/assistant/coordinate/convert";
	//高德API秘钥
	//public static final String KEY = "507f5ff5186c11071e5ae9b69e19031b";
	//数据库URL
	public static final String URL = "jdbc:mysql://192.168.1.199:3456/test?useUnicode=true&amp;characterEncoding=utf-8";
	//访问接口请求参数
	//public static Map map = new HashMap<>();
	public static Connection conn = null;
	public static String sql;
	//加载数据库驱动
	static{
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("成功加载MySQL驱动程序");
			try {
				conn = DriverManager.getConnection(URL,"root","root");
				System.out.println("成功创建连接");
			} catch (SQLException e) {
				System.out.println("连接数据库失败");
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			System.out.println("加载失败");
			e.printStackTrace();
		}
	}
	/**
	 * 将百度经纬度转换为高德经纬度
	 * @param num 需要转换的条数
	 * @param start	起始位置;默认1
	 * @param dbName 表名
	 */
	public static void main(String[] args) {
		//public static void convert(int num,Integer  start,String dbName){
		PreparedStatement preparedStatement = null;
		String locations;
		//String afterLocations;
		//String[] beForeArr;
		//map.put("key", KEY);
		//map.put("coordsys", "baidu");
		//		if (start == null) {
		//			start = 1;
		//		}
		String sql = "update fang_t set longitude = ? ,latitude = ? where ids = ?";
		try {
			//for (int i = 2; i < 1667; i++) {
			for (int i = 1667; i < 3011; i++) {
				locations = getXYById(i);
				if (locations == null) {
					throw new Exception("查询第"+i+"条数据时发生异常");
				} 
				if ("".equals(locations)) {
					throw new Exception(locations);
				}
				//调用高德接口时可用
				/*
				 * map.put("locations", locations);
				 * String post = HttpClientUtil.post(GD_MAP_CONVERT, map);
				 * JSONObject jsonObject = JSONObject.fromObject(post);
				 * if (!"1".equals(jsonObject.getString("status"))) {
				 * 	System.out.println("第"+i+"次调用接口失败");
				 * 	continue;
				 * }
				 * afterLocations = jsonObject.getString("locations");
				 * beForeArr = afterLocations.split(",");
				 * preparedStatement = conn.prepareStatement(sql);
				 * preparedStatement.setString(1, beFore[0]);
				 * preparedStatement.setString(2, beFore[1]);
				 * preparedStatement.setInt(3, i);
				 */
				LngLat lngLat = new LngLat(locations);
				lngLat = CoodinateCovertor.bd_decrypt(lngLat);
				preparedStatement = conn.prepareStatement(sql);
				preparedStatement.setString(1, String.valueOf(lngLat.getLongitude()));
				preparedStatement.setString(2, String.valueOf(lngLat.getLantitude()));
				preparedStatement.setInt(3, i);
				if (preparedStatement.executeUpdate() == -1) {
					System.out.println("第"+i+"条数据修改失败");
				}
			}
			System.out.println("执行完毕");
		} catch (SQLException e) {
			System.out.println("MySQL操作错误");
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	private static String getXYById(int id){
		 ResultSet rs = null;
		 Statement stmt = null;
	     try {
	         stmt = conn.createStatement();
	         sql = "select longitude,latitude from fang_t where ids=";
	         rs = stmt.executeQuery(sql+id);
	        if (!rs.next()) {
				throw new Exception("第"+id+"条数据为空");
			} else {
				return rs.getString(1)+","+rs.getString(2);
			}
	     } catch (SQLException e) {
	         System.out.println("MySQL操作错误");
	         e.printStackTrace();
	         return null;
	     } catch (Exception e1) {
	         e1.printStackTrace();
	         return null;
	     } finally {
	         try {
	        	rs.close();
	        	stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	        
	     }
		
	}
	 
}
	

