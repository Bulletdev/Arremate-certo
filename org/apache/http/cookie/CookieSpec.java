package org.apache.http.cookie;

import java.util.List;
import org.apache.http.Header;
import org.apache.http.annotation.Obsolete;

public interface CookieSpec {
  @Obsolete
  int getVersion();
  
  List<Cookie> parse(Header paramHeader, CookieOrigin paramCookieOrigin) throws MalformedCookieException;
  
  void validate(Cookie paramCookie, CookieOrigin paramCookieOrigin) throws MalformedCookieException;
  
  boolean match(Cookie paramCookie, CookieOrigin paramCookieOrigin);
  
  List<Header> formatCookies(List<Cookie> paramList);
  
  @Obsolete
  Header getVersionHeader();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\cookie\CookieSpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */