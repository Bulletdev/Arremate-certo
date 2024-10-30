/*    */ package br.com.arremate.m;
/*    */ 
/*    */ import java.awt.Component;
/*    */ import javax.swing.JCheckBox;
/*    */ import javax.swing.JTable;
/*    */ import javax.swing.UIManager;
/*    */ import javax.swing.border.Border;
/*    */ import javax.swing.border.EmptyBorder;
/*    */ import javax.swing.plaf.UIResource;
/*    */ import javax.swing.table.DefaultTableCellRenderer;
/*    */ import javax.swing.table.TableCellRenderer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class t
/*    */   extends JCheckBox
/*    */   implements UIResource, TableCellRenderer
/*    */ {
/* 20 */   private static final Border a = new EmptyBorder(1, 1, 1, 1);
/*    */   private String eD;
/* 22 */   private final DefaultTableCellRenderer a = new DefaultTableCellRenderer();
/*    */ 
/*    */   
/*    */   public t(String paramString) {
/* 26 */     setHorizontalAlignment(0);
/* 27 */     setBorderPainted(true);
/* 28 */     setOpaque(true);
/*    */     
/* 30 */     this.eD = paramString;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Component getTableCellRendererComponent(JTable paramJTable, Object paramObject, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2) {
/* 36 */     boolean bool = true;
/*    */     
/* 38 */     switch (this.eD) {
/*    */       case "JDAddPregao":
/* 40 */         if (paramObject != null && ((Boolean)paramObject).booleanValue() == true) {
/* 41 */           bool = false;
/*    */         }
/*    */         break;
/*    */       
/*    */       case "JPDisputa":
/* 46 */         if (paramBoolean1) {
/* 47 */           bool = false;
/*    */         }
/*    */         break;
/*    */     } 
/*    */     
/* 52 */     if (bool) {
/* 53 */       y.a(this, paramInt1);
/*    */     } else {
/* 55 */       y.a(this);
/*    */     } 
/*    */     
/* 58 */     setSelected((paramObject != null && ((Boolean)paramObject).booleanValue()));
/*    */     
/* 60 */     if (paramBoolean2) {
/* 61 */       setBorder(UIManager.getBorder("Table.focusCellHighlightBorder"));
/*    */     } else {
/* 63 */       setBorder((Border)a);
/*    */     } 
/*    */     
/* 66 */     return this;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\m\t.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */