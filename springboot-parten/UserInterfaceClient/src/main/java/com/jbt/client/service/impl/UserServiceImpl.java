package com.jbt.client.service.impl;//package com.cdl.service.impl;
//
//import com.cdl.model.User;
//import com.cdl.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.client.discovery.DiscoveryClient;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.List;
//import java.util.Map;
//@Service
//public class UserServiceImpl implements UserService {
//
//    @Autowired
//    private RestTemplate restTemplate;
//
////    @Autowired
////    private DiscoveryClient discoveryClient;
////
////    //通过客户端发现服务工具，查找服务
////    public String getServerUrl(){
////        List<ServiceInstance> list = discoveryClient.getInstances("USERPROVIDER01");
////        //获取服务集合第一个服务器
////        ServiceInstance serviceInstance = list.get(0);
////        //获取服务器ip地址
////        String ip = serviceInstance.getHost();
////        int port = serviceInstance.getPort();
////        //拼接调用地址
////        String serverUrl="http://"+ip+":"+port;
////        return serverUrl+"/user/";
////    }
//
//    String url="http://USERPROVIDER";
//
//    @Override
//    public Map findAll() {
//        Map map = restTemplate.getForObject(url+"/user/", Map.class);
//        return map;
//    }
//
//    @Override
//    public void addUser(User user) {
//        restTemplate.postForObject(url+"/user/", user,String.class);
//    }
//
//
//
//    @Override
//    public void deleteUser(Integer id) {
//        restTemplate.delete(url+"/user/"+id);
//    }
//
//    @Override
//    public void updateUser(Integer id, User user) {
//
//    }
//
//    @Override
//    public User findOne(Integer id) {
//        return null;
//    }
//}
