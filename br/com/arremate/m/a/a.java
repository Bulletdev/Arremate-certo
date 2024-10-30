/*    */ package br.com.arremate.m.a;
/*    */ 
/*    */ import br.com.arremate.l.n;
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class a
/*    */   implements ActionListener
/*    */ {
/*    */   private final br.com.arremate.c.a b;
/*    */   
/*    */   public a(br.com.arremate.c.a parama) {
/* 16 */     this.b = parama;
/*    */   }
/*    */   
/*    */   public final br.com.arremate.c.a a() {
/* 20 */     return this.b;
/*    */   }
/*    */ 
/*    */   
/*    */   public final void actionPerformed(ActionEvent paramActionEvent) {
/* 25 */     n n = this.b.a();
/*    */     
/* 27 */     if (n == null || n.getStatus() == 0)
/* 28 */       g(); 
/*    */   }
/*    */   
/*    */   public abstract void g();
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\m\a\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */