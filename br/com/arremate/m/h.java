/*    */ package br.com.arremate.m;
/*    */ 
/*    */ import br.com.arremate.c.a;
/*    */ import br.com.arremate.l.n;
/*    */ import java.awt.Color;
/*    */ import java.awt.Component;
/*    */ import javax.swing.JList;
/*    */ import javax.swing.UIManager;
/*    */ import javax.swing.plaf.basic.BasicComboBoxRenderer;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class h
/*    */   extends BasicComboBoxRenderer
/*    */ {
/*    */   private a b;
/* 17 */   private Color b = Color.lightGray;
/*    */ 
/*    */   
/*    */   public h() {}
/*    */ 
/*    */   
/*    */   public h(a parama) {
/* 24 */     this.b = (Color)parama;
/*    */   }
/*    */   
/*    */   public void a(a parama) {
/* 28 */     this.b = (Color)parama;
/*    */   }
/*    */   
/*    */   public void b(Color paramColor) {
/* 32 */     this.b = paramColor;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Component getListCellRendererComponent(JList paramJList, Object paramObject, int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
/* 39 */     Component component = super.getListCellRendererComponent(paramJList, paramObject, paramInt, paramBoolean1, paramBoolean2);
/*    */ 
/*    */     
/* 42 */     n n = this.b.a(paramInt);
/*    */ 
/*    */     
/* 45 */     if (n == null || n.getStatus() == 0) {
/* 46 */       if (paramBoolean1) {
/* 47 */         component.setBackground(UIManager.getColor("ComboBox.background"));
/*    */       } else {
/* 49 */         component.setBackground(getBackground());
/*    */       } 
/*    */       
/* 52 */       component.setForeground(this.b);
/*    */     } else {
/*    */       
/* 55 */       component.setBackground(getBackground());
/* 56 */       component.setForeground(getForeground());
/*    */     } 
/*    */     
/* 59 */     return component;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\m\h.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */