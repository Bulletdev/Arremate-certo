/*    */ package br.com.arremate.m;
/*    */ 
/*    */ import br.com.arremate.l.d;
/*    */ import br.com.arremate.l.n;
/*    */ import java.awt.Color;
/*    */ import java.awt.Component;
/*    */ import javax.swing.JTable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class u
/*    */   extends r
/*    */ {
/*    */   public u(int paramInt) {
/* 17 */     super(paramInt);
/*    */   }
/*    */ 
/*    */   
/*    */   public Component getTableCellRendererComponent(JTable paramJTable, Object paramObject, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2) {
/* 22 */     Component component = super.getTableCellRendererComponent(paramJTable, paramObject, paramBoolean1, paramBoolean2, paramInt1, paramInt2);
/*    */ 
/*    */     
/* 25 */     component.setForeground(Color.BLACK);
/*    */     
/* 27 */     Object object1 = paramJTable.getValueAt(paramInt1, 7);
/* 28 */     Object object2 = paramJTable.getValueAt(paramInt1, 1);
/* 29 */     Object object3 = paramJTable.getValueAt(paramInt1, 6);
/*    */     
/* 31 */     if (object1 != null && !((Boolean)object1).booleanValue()) {
/* 32 */       component.setForeground(y.f());
/* 33 */     } else if (object2 != null && object3 != null) {
/*    */       try {
/* 35 */         long l = Long.parseLong(y.V(String.valueOf(object2)));
/* 36 */         int i = ((Integer)object3).intValue();
/* 37 */         n n = l.a().a(i);
/*    */         
/* 39 */         if (n != null) {
/* 40 */           d d = g.a(n, l);
/*    */           
/* 42 */           if (d != null && d.bw() != null && !d.bw().isEmpty()) {
/* 43 */             component.setForeground(y.e());
/* 44 */             setToolTipText("Possui certificado digital");
/*    */           } else {
/* 46 */             setToolTipText("");
/*    */           } 
/*    */         } 
/* 49 */       } catch (Exception exception) {}
/*    */     } 
/*    */ 
/*    */     
/* 53 */     return component;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\\\u.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */