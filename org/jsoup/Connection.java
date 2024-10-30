/*    */ package org.jsoup;
/*    */ import java.io.IOException;
/*    */ import java.util.Map;
/*    */ import org.jsoup.nodes.Document;
/*    */ public interface Connection { Connection url(URL paramURL); Connection url(String paramString); Connection userAgent(String paramString); Connection timeout(int paramInt); Connection maxBodySize(int paramInt); Connection referrer(String paramString); Connection followRedirects(boolean paramBoolean); Connection method(Method paramMethod); Connection ignoreHttpErrors(boolean paramBoolean); Connection ignoreContentType(boolean paramBoolean); Connection data(String paramString1, String paramString2); Connection data(Collection<KeyVal> paramCollection); Connection data(Map<String, String> paramMap); Connection data(String... paramVarArgs); Connection header(String paramString1, String paramString2); Connection cookie(String paramString1, String paramString2); Connection cookies(Map<String, String> paramMap); Connection parser(Parser paramParser); Document get() throws IOException; Document post() throws IOException; Response execute() throws IOException; Request request(); Connection request(Request paramRequest); Response response(); Connection response(Response paramResponse); public static interface KeyVal { KeyVal key(String param1String); String key(); KeyVal value(String param1String); String value(); } public static interface Response extends Base<Response> { int statusCode(); String statusMessage(); String charset(); String contentType(); Document parse() throws IOException; String body(); byte[] bodyAsBytes(); } public static interface Request extends Base<Request> { int timeout(); Request timeout(int param1Int); int maxBodySize(); Request maxBodySize(int param1Int); boolean followRedirects(); Request followRedirects(boolean param1Boolean); boolean ignoreHttpErrors();
/*    */     Request ignoreHttpErrors(boolean param1Boolean);
/*    */     boolean ignoreContentType();
/*    */     Request ignoreContentType(boolean param1Boolean);
/*    */     Request data(Connection.KeyVal param1KeyVal);
/*    */     Collection<Connection.KeyVal> data();
/*    */     Request parser(Parser param1Parser);
/*    */     Parser parser(); }
/*    */   public static interface Base<T extends Base> { URL url();
/*    */     T url(URL param1URL);
/*    */     Connection.Method method();
/*    */     T method(Connection.Method param1Method);
/*    */     String header(String param1String);
/*    */     T header(String param1String1, String param1String2);
/*    */     boolean hasHeader(String param1String);
/*    */     T removeHeader(String param1String);
/*    */     Map<String, String> headers();
/*    */     String cookie(String param1String);
/*    */     T cookie(String param1String1, String param1String2);
/*    */     boolean hasCookie(String param1String);
/*    */     T removeCookie(String param1String);
/*    */     Map<String, String> cookies(); }
/* 27 */   public enum Method { GET, POST; }
/*    */    }


/* Location:              C:\Arremate\Arremate.jar!\org\jsoup\Connection.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */