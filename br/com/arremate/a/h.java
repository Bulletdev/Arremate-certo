/*    */ package br.com.arremate.a;
/*    */ 
/*    */ import br.com.arremate.h.g;
/*    */ import com.google.a.o.a.af;
/*    */ import java.nio.charset.StandardCharsets;
/*    */ import org.e.i;
/*    */ 
/*    */ public class h
/*    */ {
/* 10 */   private static final h a = new h();
/* 11 */   private final l a = (l)af.a(10.0D); private final af a;
/*    */   
/*    */   public static h a() {
/* 14 */     return (h)a;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private h() {
/* 20 */     this
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 26 */       .a = new l(g.c().c(15000).b(30000).d(300).e(300).a(StandardCharsets.UTF_8).a());
/*    */   }
/*    */   
/*    */   public i a() {
/* 30 */     this.a.N();
/* 31 */     long l1 = System.currentTimeMillis();
/* 32 */     i i = this.a.f("arremate/sc/get-token");
/* 33 */     l1 = System.currentTimeMillis() - l1;
/*    */     
/* 35 */     if (i == null) {
/* 36 */       i = new i();
/*    */     }
/*    */     
/* 39 */     i.a("latency", l1);
/* 40 */     return i;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\a\h.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */