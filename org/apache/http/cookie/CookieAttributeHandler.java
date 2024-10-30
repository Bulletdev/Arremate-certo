package org.apache.http.cookie;

public interface CookieAttributeHandler {
  void parse(SetCookie paramSetCookie, String paramString) throws MalformedCookieException;
  
  void validate(Cookie paramCookie, CookieOrigin paramCookieOrigin) throws MalformedCookieException;
  
  boolean match(Cookie paramCookie, CookieOrigin paramCookieOrigin);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\cookie\CookieAttributeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */