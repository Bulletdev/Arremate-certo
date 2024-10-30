/*    */ package br.com.arremate.d.c;
/*    */ 
/*    */ import br.com.arremate.f.g;
/*    */ import br.com.arremate.f.m;
/*    */ import br.com.arremate.l.j;
/*    */ import br.com.arremate.l.q.b.e;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import org.e.i;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class a
/*    */ {
/*    */   static String a(String paramString, e parame) {
/* 21 */     if (paramString.equals("DISPUTA")) {
/* 22 */       paramString = g.y.getValue();
/* 23 */       j j = parame.a();
/*    */       
/* 25 */       if (j.a().equals(m.b) && parame.z() > 0L && parame
/* 26 */         .z() <= TimeUnit.MINUTES.toMillis(j.M())) {
/* 27 */         paramString = g.I.getValue();
/*    */       }
/* 29 */     } else if (paramString.contains("FECHADO")) {
/* 30 */       br.com.arremate.l.c.a a1 = (br.com.arremate.l.c.a)parame.a();
/* 31 */       paramString = g.p.getValue();
/*    */       
/* 33 */       if (a1.aS()) {
/* 34 */         paramString = g.i.getValue();
/* 35 */       } else if (a1.aR() && a1.aB()) {
/* 36 */         paramString = g.h.getValue();
/*    */       } 
/* 38 */     } else if (paramString.contains("RECURSOS") || paramString.contains("CONTRA RAZÃO")) {
/* 39 */       paramString = g.aS.getValue();
/*    */     } 
/*    */     
/* 42 */     return paramString.toUpperCase();
/*    */   }
/*    */   
/*    */   static i g(String paramString) {
/* 46 */     if (paramString.isEmpty() || paramString.contains("\"modal\":\"error\"")) {
/* 47 */       return null;
/*    */     }
/*    */     
/* 50 */     i i = new i(paramString);
/* 51 */     if (i.getString("html").trim().isEmpty()) {
/* 52 */       return null;
/*    */     }
/*    */     
/* 55 */     return i;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\c\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */