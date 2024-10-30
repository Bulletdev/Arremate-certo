package ch.qos.logback.core.net.server;

public interface ClientVisitor<T extends Client> {
  void visit(T paramT);
}


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\net\server\ClientVisitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */