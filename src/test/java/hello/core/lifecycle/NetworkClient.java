package hello.core.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient {

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = "+url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작시 호출
    public void connect(){
        System.out.println("connect: "+url);
    }

    // 연결이 된 상태. 메세지를 던질 수 있다.
    public void call(String message){
        System.out.println("call: "+url+", message: "+message);
    }

    // 서비스 종료시 호출
    public void disconnect(){
        System.out.println("close: "+url);
    }

    @PostConstruct
    public void init() throws Exception {
        // 의존관계 주입이 끝나면 호출
        connect();
        call("초기화 연결 메시지");
    }

    @PreDestroy
    public void close() throws Exception {
        System.out.println("NetworkClient.destroy");
        // 삭제 전
        disconnect();
    }
}
