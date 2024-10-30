/*    */ package br.com.arremate.h;
/*    */ 
/*    */ import java.net.URI;
/*    */ import org.apache.http.Header;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class e
/*    */ {
/*    */   private String data;
/*    */   private Header[] a;
/*    */   private int statusCode;
/*    */   private long t;
/*    */   private boolean w;
/*    */   private String aM;
/*    */   private URI uri;
/*    */   
/*    */   public e() {
/* 21 */     this(0L, -1);
/*    */   }
/*    */   
/*    */   public e(long paramLong, int paramInt) {
/* 25 */     this.data = "";
/* 26 */     this.a = new Header[0];
/* 27 */     this.t = paramLong;
/* 28 */     this.statusCode = paramInt;
/* 29 */     this.w = false;
/* 30 */     this.aM = "";
/*    */   }
/*    */   
/*    */   public String getData() {
/* 34 */     return this.data;
/*    */   }
/*    */   
/*    */   public void setData(String paramString) {
/* 38 */     this.data = paramString;
/*    */   }
/*    */   
/*    */   public Header[] a() {
/* 42 */     return this.a;
/*    */   }
/*    */   
/*    */   public void setHeaders(Header[] paramArrayOfHeader) {
/* 46 */     this.a = paramArrayOfHeader;
/*    */   }
/*    */   
/*    */   public long k() {
/* 50 */     return this.t;
/*    */   }
/*    */   
/*    */   public void q(long paramLong) {
/* 54 */     this.t = paramLong;
/*    */   }
/*    */   
/*    */   public int getStatusCode() {
/* 58 */     return this.statusCode;
/*    */   }
/*    */   
/*    */   public String Q() {
/* 62 */     return Integer.toString(this.statusCode);
/*    */   }
/*    */   
/*    */   public void setStatusCode(int paramInt) {
/* 66 */     this.statusCode = paramInt;
/*    */   }
/*    */   
/*    */   public boolean O() {
/* 70 */     return this.w;
/*    */   }
/*    */   
/*    */   public void h(boolean paramBoolean) {
/* 74 */     this.w = paramBoolean;
/*    */   }
/*    */   
/*    */   public boolean P() {
/* 78 */     return !this.aM.isEmpty();
/*    */   }
/*    */   
/*    */   public String R() {
/* 82 */     return this.aM;
/*    */   }
/*    */   
/*    */   public void a(Exception paramException) {
/* 86 */     this.aM = paramException.getClass().getSimpleName();
/*    */   }
/*    */   
/*    */   public URI getUri() {
/* 90 */     return this.uri;
/*    */   }
/*    */   
/*    */   public void a(URI paramURI) {
/* 94 */     this.uri = paramURI;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\h\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */