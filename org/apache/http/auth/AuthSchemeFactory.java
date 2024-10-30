package org.apache.http.auth;

import org.apache.http.params.HttpParams;

@Deprecated
public interface AuthSchemeFactory {
  AuthScheme newInstance(HttpParams paramHttpParams);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\auth\AuthSchemeFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */