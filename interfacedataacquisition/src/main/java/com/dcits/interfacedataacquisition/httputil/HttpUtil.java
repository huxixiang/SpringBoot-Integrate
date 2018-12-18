package com.dcits.interfacedataacquisition.httputil;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpUtil {
    public static void main(String[] args) throws IOException {
        HttpGet httpGet = new HttpGet("https://www.baidu.com");
        String res = httpRequest("GET",httpGet);
        System.out.println("res:"+res);


    }


    public static String httpRequest(String method,Object getOrPost){
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            if (method.equalsIgnoreCase("GET")) {
                HttpGet httpGet = (HttpGet) getOrPost;
                CloseableHttpResponse response = httpclient.execute(httpGet);
                try {
                    // 获取响应实体
                    HttpEntity entity = response.getEntity();
                    // 打印响应状态
//                    System.out.println(response.getStatusLine());
                    if (entity != null) {
                        // 打印响应内容长度
//                        System.out.println("Response content length: " + entity.getContentLength());
//                        // 打印响应内容
//                        System.out.println("Response content: " + EntityUtils.toString(entity));
                        return EntityUtils.toString(entity);
                    }
                } finally {
                    response.close();
                }
            }
        }catch (ClientProtocolException e){
            e.printStackTrace();
        }catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;


    }
}
