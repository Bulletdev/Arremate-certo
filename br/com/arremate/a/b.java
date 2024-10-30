/*    */ package br.com.arremate.a;
/*    */ 
/*    */ import br.com.arremate.h.g;
/*    */ import com.google.a.o.a.af;
/*    */ import java.nio.charset.StandardCharsets;
/*    */ import org.e.i;
/*    */ 
/*    */ public class b
/*    */ {
/* 10 */   private static final b a = new b();
/* 11 */   private final l a = (l)af.a(10.0D); private final af a;
/*    */   
/*    */   public static b a() {
/* 14 */     return (b)a;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private b() {
/* 20 */     this
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 26 */       .a = new l(g.c().c(15000).b(30000).d(50).e(50).a(StandardCharsets.UTF_8).a());
/*    */   }
/*    */   
/*    */   public i a() {
/* 30 */     this.a.N();
/* 31 */     long l1 = System.currentTimeMillis();
/* 32 */     i i = this.a.f("arremate/bec/get-token");
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


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\a\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */