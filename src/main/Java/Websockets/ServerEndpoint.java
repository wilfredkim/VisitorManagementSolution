package Websockets;

import com.google.gson.Gson;

import javax.servlet.http.Cookie;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@javax.websocket.server.ServerEndpoint(value = "/chat/{username}")
public class ServerEndpoint {
    static Map<String, Session> sessionMap = new HashMap<String, Session>();


    @OnOpen
    public void onOpen(Session session, @PathParam("username") String s) {
        sessionMap.put(s, session);
        getConnection();

    }

    public void getConnection() {
        for (Map.Entry m : sessionMap.entrySet()) {
            Session s1 = (Session) m.getValue();
            System.out.println("join the chat room\t" + m.getKey() + " \t" + s1.getId());
        }
    }

    @OnMessage
    public void onMessage(Session session,String s) throws IOException, EncodeException {
        try {
            Gson gson = new Gson();
            Message msg = gson.fromJson(s, Message.class);
            if (sessionMap.get(msg.getRecepient()) != null) {
                sessionMap.get(msg.getRecepient()).getBasicRemote().sendText(msg.getContent());
                //sessionMap.get(msg.getSender()).getBasicRemote().sendText("Message Sent Successfully");
            } else {
                onError(session, new Throwable());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @OnClose
    public void onClose(Session session) throws IOException, EncodeException {




    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        try {
            session.getBasicRemote().sendText("Receiver doesn't exist");
        } catch (IOException e) {
            e.printStackTrace();
            throwable.getMessage();

        }


    }
}
