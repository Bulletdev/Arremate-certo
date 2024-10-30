/*    */ package br.com.arremate.d.a;
/*    */ 
/*    */ import br.com.arremate.j.d.c;
/*    */ import br.com.arremate.l.q.b.e;
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import org.e.f;
/*    */ import org.e.i;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class b
/*    */ {
/* 19 */   protected static final Logger a = LoggerFactory.getLogger(b.class);
/*    */   
/*    */   private final i a;
/*    */   
/*    */   private final c a;
/*    */   private final Map<e, i> e;
/*    */   private long h;
/*    */   
/*    */   public b(i parami) {
/* 28 */     this.a = (c)parami;
/* 29 */     this.a = parami.a();
/* 30 */     this.e = new HashMap<>();
/* 31 */     this.h = 0L;
/*    */   }
/*    */   
/*    */   Map<e, i> d() {
/* 35 */     this.e.clear();
/*    */     
/* 37 */     long l = this.a.n();
/* 38 */     if (this.h >= l) {
/* 39 */       return this.e;
/*    */     }
/*    */     
/* 42 */     this.h = l;
/*    */     
/* 44 */     i i1 = this.a.p();
/* 45 */     if (!f(i1)) {
/* 46 */       e(i1);
/*    */     }
/*    */     
/* 49 */     this.a.e(this.a.o());
/*    */     
/* 51 */     return this.e;
/*    */   }
/*    */   
/*    */   private boolean e(i parami) {
/* 55 */     if (!parami.has("disputas")) {
/* 56 */       return false;
/*    */     }
/*    */     
/* 59 */     f f = parami.c("disputas");
/* 60 */     for (byte b1 = 0; b1 < f.length(); b1++) {
/* 61 */       i i1 = f.b(b1);
/* 62 */       int j = i1.getInt("codigoLicitacaoDisputaLote");
/* 63 */       int k = i1.getInt("codigoLoteDisputaLote");
/* 64 */       e e = this.a.a(k);
/*    */ 
/*    */       
/* 67 */       if (j == this.a.a().v() && e != null)
/*    */       {
/*    */ 
/*    */         
/* 71 */         this.e.put(e, i1);
/*    */       }
/*    */     } 
/* 74 */     return true;
/*    */   }
/*    */   
/*    */   private boolean f(i parami) {
/* 78 */     if (!parami.has("licitacoes")) {
/* 79 */       return false;
/*    */     }
/*    */     
/* 82 */     f f = parami.c("licitacoes");
/* 83 */     for (byte b1 = 0; b1 < f.length(); b1++) {
/* 84 */       i i1 = f.b(b1);
/* 85 */       int j = i1.getInt("codigoLicitacaoDisputaLicitacao");
/* 86 */       i i2 = i1.j("lotes");
/*    */       
/* 88 */       if (j == this.a.a().v()) {
/* 89 */         for (Iterator<String> iterator = i2.o(); iterator.hasNext(); ) {
/* 90 */           String str = iterator.next();
/* 91 */           e e = this.a.a(str);
/* 92 */           i i3 = i2.j(str);
/*    */           
/* 94 */           this.e.put(e, i3);
/*    */         } 
/*    */       }
/*    */     } 
/*    */     
/* 99 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\a\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */