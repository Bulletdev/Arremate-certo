package org.apache.http.client.entity;

import java.io.IOException;
import java.io.InputStream;

public interface InputStreamFactory {
  InputStream create(InputStream paramInputStream) throws IOException;
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\client\entity\InputStreamFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */