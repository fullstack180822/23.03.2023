package db1.pattern1;

public interface IConnectionPool {

    MyDbConnection getConnection() throws InterruptedException;

    void returnConnection(MyDbConnection aaa);

    void close();

}
