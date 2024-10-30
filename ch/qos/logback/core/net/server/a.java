package ch.qos.logback.core.net.server;

import ch.qos.logback.core.spi.ContextAware;
import java.io.Serializable;
import java.util.concurrent.BlockingQueue;

interface a extends Client, ContextAware {
  void a(BlockingQueue<Serializable> paramBlockingQueue);
  
  boolean a(Serializable paramSerializable);
}


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\net\server\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */