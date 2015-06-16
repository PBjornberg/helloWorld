package my.group.server;

import javax.ejb.Remote;
@Remote
public interface HelloWorld

{
public void sayHello(String name);
}