/*    */ package br.com.arremate.l.p;
/*    */ 
/*    */ import br.com.arremate.l.q.b.e;
/*    */ import br.com.arremate.m.y;
/*    */ import java.text.DecimalFormat;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ 
/*    */ public class a
/*    */ {
/*    */   private boolean ag;
/*    */   private long R;
/*    */   private final e c;
/* 13 */   private final DecimalFormat df = y.a("###,###,##0.0000");
/*    */   
/*    */   public a(e parame) {
/* 16 */     this.c = parame;
/* 17 */     this.ag = true;
/*    */   }
/*    */   
/*    */   public boolean bm() {
/* 21 */     return (this.ag && this.c.z() > 0L && this.c.z() < TimeUnit.SECONDS.toMillis(15L));
/*    */   }
/*    */   
/*    */   public boolean bn() {
/* 25 */     return (!this.ag && this.c.z() > 0L && this.c.z() > this.R);
/*    */   }
/*    */   
/*    */   public void cq() {
/* 29 */     this.ag = true;
/*    */   }
/*    */   
/*    */   public void cr() {
/* 33 */     this.ag = false;
/* 34 */     this.R = this.c.z();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String ch() {
/* 42 */     StringBuilder stringBuilder = (new StringBuilder("Restam ")).append(TimeUnit.MILLISECONDS.toSeconds(this.R)).append(" segundo(s) para encerrar a fase \"").append(this.c.bB()).append("\" do item ").append(this.c.bo()).append(" | Melhor Lance: ").append(this.df.format(this.c.f().m())).append(" | Último Lance: ").append(this.df.format(this.c.f())).append(" | Valor Limite: ").append(this.df.format(this.c.l()));
/*    */     
/* 44 */     if (this.c.bv()) {
/* 45 */       stringBuilder.append(" | Lance Fechado: ").append(this.df.format(this.c.y()));
/*    */     }
/*    */     
/* 48 */     return stringBuilder.toString();
/*    */   }
/*    */   
/*    */   public boolean bo() {
/* 52 */     return this.ag;
/*    */   }
/*    */   
/*    */   public void M(boolean paramBoolean) {
/* 56 */     this.ag = paramBoolean;
/*    */   }
/*    */   
/*    */   public long E() {
/* 60 */     return this.R;
/*    */   }
/*    */   
/*    */   public void B(long paramLong) {
/* 64 */     this.R = paramLong;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\p\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */