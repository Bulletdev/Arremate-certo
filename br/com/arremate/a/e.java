/*    */ package br.com.arremate.a;
/*    */ 
/*    */ import br.com.arremate.h.g;
/*    */ import br.com.arremate.l.d;
/*    */ import br.com.arremate.m.y;
/*    */ import com.google.a.o.a.af;
/*    */ import java.nio.charset.StandardCharsets;
/*    */ import org.e.i;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class e
/*    */ {
/* 16 */   private static final e a = new e(); private final af b;
/* 17 */   private final l b = (l)af.a(1.0D); private final af c;
/* 18 */   private final l c = (l)af.a(5.0D);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private e() {
/* 24 */     this
/*    */ 
/*    */ 
/*    */       
/* 28 */       .b = new l(g.c().c(15000).b(180000).a(StandardCharsets.UTF_8).a());
/*    */     
/* 30 */     this
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 36 */       .c = new l(g.c().c(15000).b(60000).e(75).e(75).a(StandardCharsets.UTF_8).a());
/*    */   }
/*    */   
/*    */   public static e a() {
/* 40 */     return a;
/*    */   }
/*    */   
/*    */   public i a(d paramd) {
/* 44 */     String str1 = paramd.ax();
/* 45 */     String str2 = y.V(paramd.getUser());
/* 46 */     String str3 = paramd.getPassword();
/* 47 */     String str4 = paramd.bw();
/* 48 */     String str5 = paramd.bx();
/*    */     
/* 50 */     i i = (new i()).c("credentials", (new i())
/*    */         
/* 52 */         .c("cnpj", str1).c("username", str2).c("password", str3)
/* 53 */         .c("certificate", str4).c("passwordCert", str5));
/*    */ 
/*    */     
/* 56 */     this.b.N();
/* 57 */     long l1 = System.currentTimeMillis();
/* 58 */     i = this.b.a("arremate/cn/dispute/get-login", i);
/* 59 */     l1 = System.currentTimeMillis() - l1;
/*    */     
/* 61 */     if (i == null) {
/* 62 */       i = new i();
/*    */     }
/*    */     
/* 65 */     i.a("latency", l1);
/* 66 */     return i;
/*    */   }
/*    */   
/*    */   public i b() {
/* 70 */     this.c.N();
/*    */     
/* 72 */     long l1 = System.currentTimeMillis();
/* 73 */     i i = this.c.f("arremate/cn/get-token");
/* 74 */     l1 = System.currentTimeMillis() - l1;
/*    */     
/* 76 */     if (i == null) {
/* 77 */       i = new i();
/*    */     }
/*    */     
/* 80 */     i.a("latency", l1);
/* 81 */     return i;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\a\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */