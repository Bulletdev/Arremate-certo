/*    */ package br.com.arremate.d.d;
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
/*    */ public class a
/*    */ {
/*    */   static String a(String paramString, e parame) {
/* 17 */     if (paramString.equals("DISPUTA")) {
/* 18 */       paramString = g.y.getValue();
/* 19 */       j j = parame.a();
/*    */       
/* 21 */       if (j.a().equals(m.b) && parame.z() > 0L && parame
/* 22 */         .z() <= TimeUnit.MINUTES.toMillis(j.M())) {
/* 23 */         paramString = g.I.getValue();
/*    */       }
/* 25 */     } else if (paramString.contains("FECHADO")) {
/* 26 */       br.com.arremate.l.d.a a1 = (br.com.arremate.l.d.a)parame.a();
/* 27 */       paramString = g.p.getValue();
/*    */       
/* 29 */       if (a1.aS()) {
/* 30 */         paramString = g.i.getValue();
/* 31 */       } else if (a1.aR() && a1.aB()) {
/* 32 */         paramString = g.h.getValue();
/*    */       } 
/* 34 */     } else if (paramString.contains("RECURSOS") || paramString.contains("CONTRA RAZÃO")) {
/* 35 */       paramString = g.aS.getValue();
/*    */     } 
/*    */     
/* 38 */     return paramString.toUpperCase();
/*    */   }
/*    */   
/*    */   static i g(String paramString) {
/* 42 */     if (paramString.isEmpty() || paramString.contains("\"modal\":\"error\"")) {
/* 43 */       return null;
/*    */     }
/*    */     
/* 46 */     i i = new i(paramString);
/* 47 */     if (i.getString("html").trim().isEmpty()) {
/* 48 */       return null;
/*    */     }
/*    */     
/* 51 */     return i;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\d\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */