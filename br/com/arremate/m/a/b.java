/*    */ package br.com.arremate.m.a;
/*    */ 
/*    */ import br.com.arremate.c.a;
/*    */ import br.com.arremate.l.n;
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class b
/*    */   implements ActionListener
/*    */ {
/*    */   private final a b;
/*    */   
/*    */   public b(a parama) {
/* 16 */     this.b = parama;
/*    */   }
/*    */   
/*    */   public final a a() {
/* 20 */     return this.b;
/*    */   }
/*    */ 
/*    */   
/*    */   public final void actionPerformed(ActionEvent paramActionEvent) {
/* 25 */     n n = this.b.a();
/*    */     
/* 27 */     if (n != null && n.getStatus() != 0)
/* 28 */       cQ(); 
/*    */   }
/*    */   
/*    */   public abstract void cQ();
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\m\a\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */