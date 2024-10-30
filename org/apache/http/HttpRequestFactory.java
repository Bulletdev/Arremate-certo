package org.apache.http;

public interface HttpRequestFactory {
  HttpRequest newHttpRequest(RequestLine paramRequestLine) throws MethodNotSupportedException;
  
  HttpRequest newHttpRequest(String paramString1, String paramString2) throws MethodNotSupportedException;
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\HttpRequestFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */