package org.apache.http.io;

import java.io.IOException;
import org.apache.http.HttpException;

public interface HttpMessageParser<T extends org.apache.http.HttpMessage> {
  T parse() throws IOException, HttpException;
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\io\HttpMessageParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */