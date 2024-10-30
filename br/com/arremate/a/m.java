/*    */ package br.com.arremate.a;
/*    */ 
/*    */ import br.com.arremate.h.b;
/*    */ import br.com.arremate.h.e;
/*    */ import br.com.arremate.h.f;
/*    */ import br.com.arremate.h.g;
/*    */ import java.nio.charset.StandardCharsets;
/*    */ import org.e.i;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ 
/*    */ 
/*    */ public final class m
/*    */ {
/* 15 */   private static final Logger a = LoggerFactory.getLogger(m.class);
/*    */   
/*    */   private static final String o = "https://webhook.licitanet.effecti.com.br/";
/* 18 */   private static final String p = String.join("", new CharSequence[] { "https://webhook.licitanet.effecti.com.br/", "biddings/" });
/*    */   
/*    */   private final b a;
/*    */   
/*    */   public m() {
/* 23 */     this
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 29 */       .a = g.c().c(15000).b(180000).d(5).e(25).a(StandardCharsets.UTF_8).a();
/*    */   }
/*    */   
/*    */   protected m(b paramb) {
/* 33 */     this.a = paramb;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public e a(int paramInt, String paramString) {
/* 41 */     f f = g.c().a(p).a(paramInt).a("/messages").a("afterId", paramString);
/*    */     
/* 43 */     return this.a.a(f);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public e b(int paramInt, String paramString) {
/* 49 */     i i = (new i()).a("system", 15).c("apiKey", paramString);
/* 50 */     return this.a.a(
/* 51 */         g.e()
/* 52 */         .a(p)
/* 53 */         .a(paramInt)
/* 54 */         .a("/subscribe")
/* 55 */         .a(i));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public e c(int paramInt, String paramString) {
/* 62 */     i i = (new i()).a("system", 15).c("apiKey", paramString);
/* 63 */     return this.a.a(
/* 64 */         g.e()
/* 65 */         .a(p)
/* 66 */         .a(paramInt)
/* 67 */         .a("/unsubscribe")
/* 68 */         .a(i));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public e a(int paramInt) {
/* 76 */     f f = g.c().a(p).a(paramInt).a("/lastBid");
/*    */     
/* 78 */     return this.a.a(f);
/*    */   }
/*    */   
/*    */   public void b() {
/*    */     try {
/* 83 */       if (this.a != null) {
/* 84 */         this.a.b();
/*    */       }
/* 86 */     } catch (Exception exception) {
/* 87 */       a.warn("Erro ao finalizar httpclient", exception);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\a\m.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */