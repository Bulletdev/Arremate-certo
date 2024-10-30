package org.apache.http.entity;

import java.io.IOException;
import java.io.OutputStream;

public interface ContentProducer {
  void writeTo(OutputStream paramOutputStream) throws IOException;
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\entity\ContentProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */