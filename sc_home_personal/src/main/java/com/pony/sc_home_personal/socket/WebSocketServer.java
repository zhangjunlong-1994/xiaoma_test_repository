package com.pony.sc_home_personal.socket;

import com.pony.sc_home_personal.facade.CustomerServiceFacade;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author suntai
 * @date 2019/12/2 10:44
 */
@ServerEndpoint(value = "/WebSocket/{userType}/{userId}")
@Component
public class WebSocketServer {
    private final static Logger LOGGER = LoggerFactory.getLogger(WebSocketServer.class);
    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，
    // 可以使用Map来存放，其中Key可以为用户标识
    private static ConcurrentHashMap<String, WebSocketServer> webSocketSet = new ConcurrentHashMap<>();
    public static final int TYPE_MANAGER = 1;
    public static final int TYPE_USER = 2;
    public static final int MESSAGE_CUSTOMER_SERVICE = 1;
    public static final int MESSAGE_WARN = 2;
    public static final int MESSAGE_INTELLIGENT = 3;

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;
    //用户：2；客服：1
    private int userType = 0;
    //用户Id/客服Id
    private long userId = 0;

    private static CustomerServiceFacade customerServiceFacade;

    @Autowired
    public void setCustomerServerFacade(CustomerServiceFacade customerServiceFacade) {
        WebSocketServer.customerServiceFacade = customerServiceFacade;
    }

    /**
     * 给指定的人发送消息
     *
     * @param message 消息内容
     */
    public static void sendMessageToUser(int userType, long userId, String message) {
        try {
            if (webSocketSet.get(userType + "-" + userId) != null) {
                webSocketSet.get(userType + "-" + userId).session.getBasicRemote().sendText(message);
                LOGGER.info("发送至" + (userType == TYPE_MANAGER ? "管理员" : "用户") + "成功（" + userId + ":" + message + "）");
            } else {
                LOGGER.info("当前" + (userType == TYPE_MANAGER ? "管理员" : "用户") + "不在线");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 给所有客服发送消息
     *
     * @param message 消息内容
     */
    public static void sendMessageToAllManager(String message) {
        try {
            for (Map.Entry<String, WebSocketServer> map : webSocketSet.entrySet()) {
                if (map.getKey().startsWith(TYPE_MANAGER + "-")) {
                    map.getValue().session.getBasicRemote().sendText(message);
                }
            }
            LOGGER.info("发送至所有客服成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(@PathParam("userType") int userType, @PathParam("userId") long userId, Session session) {
        this.userType = userType;
        this.userId = userId;
        this.session = session;
        webSocketSet.put(userType + "-" + userId, this);
        LOGGER.info("webSocket连接建立： " + this.userType + "-" + this.userId);
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        if (this.userType != 0 && this.userId != 0) {
            webSocketSet.remove(this.userType + "-" + this.userId);
            LOGGER.info("webSocket连接断开： " + this.userType + "-" + this.userId);
        }
    }

    /**
     * 发生错误时调用
     */
    @OnError
    public void onError(Session session, Throwable error) {
        if (this.userType != 0 && this.userId != 0) {
            webSocketSet.remove(this.userType + "-" + this.userId);
            LOGGER.info("webSocket连接错误： " + this.userType + "-" + this.userId + "-" + error.getMessage());
        }
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message) {
        try {
            JSONObject jsonObject = JSONObject.fromObject(message);
            long manageId = 0, customerId = 0;
            int sender = 0, type = 0;
            String content = "";
            if (jsonObject.has("manageId")) manageId = Long.parseLong(jsonObject.getString("manageId"));
            if (jsonObject.has("customerId")) customerId = Long.parseLong(jsonObject.getString("customerId"));
            if (jsonObject.has("sender")) sender = jsonObject.getInt("sender");
            if (jsonObject.has("type")) type = jsonObject.getInt("type");
            if (jsonObject.has("content")) content = jsonObject.getString("content");

            customerServiceFacade.editCustomerServiceMessage(manageId, customerId, sender, type, content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
