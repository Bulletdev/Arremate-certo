/*    */ package br.com.arremate.h;
/*    */ 
/*    */ import br.com.arremate.j.i;
/*    */ import org.apache.http.client.config.RequestConfig;
/*    */ import org.apache.http.client.protocol.HttpClientContext;
/*    */ import org.apache.http.protocol.HttpContext;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class g
/*    */ {
/*    */   public static f c() {
/* 19 */     return new f(f.a.b);
/*    */   }
/*    */   
/*    */   public static f d() {
/* 23 */     return new f(f.a.e);
/*    */   }
/*    */   
/*    */   public static f e() {
/* 27 */     return new f(f.a.f);
/*    */   }
/*    */   
/*    */   public static f f() {
/* 31 */     return new f(f.a.i);
/*    */   }
/*    */   
/*    */   public static f g() {
/* 35 */     return new f(f.a.h);
/*    */   }
/*    */   
/*    */   public static f h() {
/* 39 */     return new f(f.a.d);
/*    */   }
/*    */   
/*    */   public static f i() {
/* 43 */     return new f(f.a.c);
/*    */   }
/*    */   
/*    */   public static f j() {
/* 47 */     return new f(f.a.g);
/*    */   }
/*    */   
/*    */   public static c c() {
/* 51 */     return new c();
/*    */   }
/*    */   
/*    */   public static b a(i parami, b paramb, h.a parama) {
/* 55 */     return new h(parami, paramb, parama);
/*    */   }
/*    */   
/*    */   public static b a(c paramc) {
/* 59 */     paramc.a(405);
/* 60 */     return new a(paramc.a());
/*    */   }
/*    */   
/*    */   public static HttpContext a(int paramInt) {
/* 64 */     return a(paramInt, paramInt);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static HttpContext a(int paramInt1, int paramInt2) {
/* 71 */     RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(paramInt2).setSocketTimeout(paramInt1).build();
/*    */     
/* 73 */     HttpClientContext httpClientContext = new HttpClientContext();
/* 74 */     httpClientContext.setRequestConfig(requestConfig);
/*    */     
/* 76 */     return (HttpContext)httpClientContext;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\h\g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */