package spring.SpringBasic.singleton;

public class SingletonService {
    // 자기자신을 내부에 private으로 하나 가지고 있다.
    // static으로 인해 클래스레벨로 올라가기 때문에, 1개만 생성된다.
    // 자바가 뜰때 SingletonService의 static영역에 자기자신을 생성한다음 instance에 참조를 넣어논다.
    // -> 자기 자신, 인스턴스 객체를 생성해서, instance안에 넣어논다.
    private static final SingletonService instance = new SingletonService();


    //2. public으로 열어서 객체 인스터스가 필요하면 이 static 메서드를 통해서만 조회하도록 허용한다.
    public static SingletonService getInstance() {
        return instance;
    }

    //3. 생성자를 private으로 선언해서 외부에서 new 키워드를 사용한 객체 생성을 못하게 막는다.
    private SingletonService() {
    }
    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
