package org.apache.http.entity.mime.content;

import java.io.IOException;
import java.io.OutputStream;

public interface ContentBody extends ContentDescriptor {
  String getFilename();
  
  void writeTo(OutputStream paramOutputStream) throws IOException;
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\entity\mime\content\ContentBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */