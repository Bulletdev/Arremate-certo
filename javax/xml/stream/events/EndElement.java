package javax.xml.stream.events;

import java.util.Iterator;
import javax.xml.namespace.b;

public interface EndElement extends XMLEvent {
  b getName();
  
  Iterator getNamespaces();
}


/* Location:              C:\Arremate\Arremate.jar!\javax\xml\stream\events\EndElement.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */