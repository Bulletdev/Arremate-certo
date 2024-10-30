/*    */ package br.com.arremate.j.c;
/*    */ 
/*    */ import br.com.arremate.a.e;
/*    */ import br.com.arremate.h.e;
/*    */ import br.com.arremate.l.p.j;
/*    */ import org.e.g;
/*    */ import org.e.i;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class a
/*    */ {
/* 18 */   private static final Logger a = LoggerFactory.getLogger(a.class);
/*    */   
/*    */   e a(a parama) {
/* 21 */     e e = new e();
/*    */     
/*    */     try {
/* 24 */       i i = e.a().b();
/* 25 */       long l = i.getLong("latency");
/*    */       
/* 27 */       if (!i.has("token")) {
/* 28 */         j.a().a("getTokenByQueue", false, l);
/*    */       } else {
/* 30 */         e = parama.request(i.getString("token"));
/* 31 */         long l1 = e.k();
/*    */         
/* 33 */         String str1 = "";
/* 34 */         if (i.has("client-host")) {
/* 35 */           str1 = i.getString("client-host");
/*    */         }
/*    */         
/* 38 */         String str2 = d(e);
/* 39 */         int j = e.getStatusCode();
/* 40 */         if (j == 204) {
/* 41 */           a.warn("Falha ao quebrar hCaptcha no CN");
/* 42 */           j.a().a(str1, str2, false, l, l1, j);
/*    */         } else {
/* 44 */           j.a().a(str1, str2, true, l, l1, j);
/*    */         } 
/*    */       } 
/* 47 */     } catch (g g) {
/* 48 */       a.warn("Falha ao quebrar hCaptcha no CN", (Throwable)g);
/*    */     } 
/*    */     
/* 51 */     return e;
/*    */   }
/*    */   
/*    */   private String d(e parame) {
/* 55 */     String str = parame.getUri().toString();
/* 56 */     if (str.contains("?")) {
/* 57 */       return str.split("\\?")[0];
/*    */     }
/*    */     
/* 60 */     return str;
/*    */   }
/*    */   
/*    */   static interface a {
/*    */     e request(String param1String);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\j\c\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */