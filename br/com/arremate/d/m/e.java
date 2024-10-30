/*    */ package br.com.arremate.d.m;
/*    */ 
/*    */ import br.com.arremate.d.g;
/*    */ import br.com.arremate.l.g;
/*    */ import java.util.Timer;
/*    */ import java.util.TimerTask;
/*    */ 
/*    */ public class e
/*    */   extends d
/*    */ {
/*    */   private Timer a;
/*    */   
/*    */   public e(g paramg) {
/* 14 */     super(paramg);
/* 15 */     an();
/*    */   }
/*    */   
/*    */   private void an() {
/* 19 */     this.a = new Timer("CountdownTimer");
/* 20 */     this.a.schedule(a(), 1000L, 1000L);
/*    */   }
/*    */   
/*    */   private TimerTask a() {
/* 24 */     return new TimerTask(this)
/*    */       {
/*    */         public void run() {
/* 27 */           this.a.a()
/* 28 */             .B()
/* 29 */             .forEach(param1g -> {
/*    */                 long l = param1g.z();
/*    */                 if (l <= 0L) {
/*    */                   return;
/*    */                 }
/*    */                 if (param1g.aM() || param1g.au()) {
/*    */                   param1g.x(l - 1000L);
/*    */                   this.a.a().fireTableCellUpdated(this.a.a().indexOf(param1g.v()), 14);
/*    */                 } 
/*    */               });
/*    */         }
/*    */       };
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void ah() {
/* 48 */     super.ah();
/*    */     
/* 50 */     if (this.a != null) {
/* 51 */       this.a.cancel();
/* 52 */       this.a = null;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\m\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */