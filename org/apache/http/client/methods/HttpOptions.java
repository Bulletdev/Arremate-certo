/*    */ package org.apache.http.client.methods;
/*    */ 
/*    */ import java.net.URI;
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ import org.apache.http.Header;
/*    */ import org.apache.http.HeaderElement;
/*    */ import org.apache.http.HeaderIterator;
/*    */ import org.apache.http.HttpResponse;
/*    */ import org.apache.http.util.Args;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HttpOptions
/*    */   extends HttpRequestBase
/*    */ {
/*    */   public static final String METHOD_NAME = "OPTIONS";
/*    */   
/*    */   public HttpOptions() {}
/*    */   
/*    */   public HttpOptions(URI paramURI) {
/* 67 */     setURI(paramURI);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public HttpOptions(String paramString) {
/* 75 */     setURI(URI.create(paramString));
/*    */   }
/*    */ 
/*    */   
/*    */   public String getMethod() {
/* 80 */     return "OPTIONS";
/*    */   }
/*    */   
/*    */   public Set<String> getAllowedMethods(HttpResponse paramHttpResponse) {
/* 84 */     Args.notNull(paramHttpResponse, "HTTP response");
/*    */     
/* 86 */     HeaderIterator headerIterator = paramHttpResponse.headerIterator("Allow");
/* 87 */     HashSet<String> hashSet = new HashSet();
/* 88 */     while (headerIterator.hasNext()) {
/* 89 */       Header header = headerIterator.nextHeader();
/* 90 */       HeaderElement[] arrayOfHeaderElement = header.getElements();
/* 91 */       for (HeaderElement headerElement : arrayOfHeaderElement) {
/* 92 */         hashSet.add(headerElement.getName());
/*    */       }
/*    */     } 
/* 95 */     return hashSet;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\client\methods\HttpOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */