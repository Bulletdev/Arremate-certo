/*    */ package br.com.arremate.m;
/*    */ 
/*    */ import java.awt.Component;
/*    */ import javax.swing.JTable;
/*    */ import javax.swing.table.DefaultTableCellRenderer;
/*    */ import javax.swing.table.TableCellRenderer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class s
/*    */   implements TableCellRenderer
/*    */ {
/* 14 */   private final DefaultTableCellRenderer a = new DefaultTableCellRenderer();
/*    */   
/*    */   public s(int paramInt) {
/* 17 */     this.a.setHorizontalAlignment(paramInt);
/*    */   }
/*    */ 
/*    */   
/*    */   public Component getTableCellRendererComponent(JTable paramJTable, Object paramObject, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2) {
/* 22 */     Component component = this.a.getTableCellRendererComponent(paramJTable, paramObject, paramBoolean1, paramBoolean2, paramInt1, paramInt2);
/*    */     
/* 24 */     Object object = paramJTable.getValueAt(paramInt1, 0);
/*    */     
/* 26 */     if (object != null && ((Boolean)object).booleanValue()) {
/* 27 */       component = y.a(component);
/*    */     } else {
/* 29 */       component = y.a(component, paramInt1);
/*    */     } 
/*    */     
/* 32 */     paramJTable.repaint();
/*    */     
/* 34 */     return component;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\m\s.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */