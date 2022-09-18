package hello.core.singleton;

public class SingletonService {

    // 자기 자신을 내부에 private 으로 가진다. static을 통해 해당 클래스 내에서만 사용하기 대문에 딱 하나만 생성된다.
    // java 싱행될 때 static 영역이 초기화되고 올라간다.
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }

    // private 생성자를 사용해 외부에서 new로 객체 생성을 막는다.
    private SingletonService(){
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
