/*    */ package br.com.arremate.a;
/*    */ 
/*    */ import br.com.arremate.f.y;
/*    */ import br.com.arremate.h.b;
/*    */ import br.com.arremate.h.g;
/*    */ import java.nio.charset.StandardCharsets;
/*    */ import org.e.f;
/*    */ 
/*    */ 
/*    */ public class i
/*    */ {
/* 12 */   private static final String DOMAIN = y.d.getUrl();
/*    */   
/*    */   private final b a;
/*    */   
/*    */   public static i a() {
/* 17 */     return a.b();
/*    */   }
/*    */   
/*    */   private i() {
/* 21 */     this
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 27 */       .a = g.c().c(30000).b(180000).d(5).e(25).a(StandardCharsets.UTF_8).a();
/*    */   }
/*    */   
/*    */   public org.e.i g() {
/* 31 */     String str = this.a.a(g.c().a(DOMAIN).a("components/groups/4")).getData();
/* 32 */     if (str.isEmpty()) {
/* 33 */       return null;
/*    */     }
/*    */     
/* 36 */     org.e.i i1 = new org.e.i(str);
/* 37 */     return i1.j("data");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public f a(int paramInt1, int paramInt2) {
/* 46 */     String str = this.a.a(g.c().a(DOMAIN).a("incidents").a("component_id", paramInt1).a("status", paramInt2)).getData();
/*    */     
/* 48 */     if (str.isEmpty()) {
/* 49 */       return null;
/*    */     }
/*    */     
/* 52 */     org.e.i i1 = new org.e.i(str);
/* 53 */     return i1.c("data");
/*    */   }
/*    */   
/*    */   private static class a
/*    */   {
/* 58 */     private static final i a = new i();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\a\i.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */