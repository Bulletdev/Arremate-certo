/*    */ package br.com.arremate.m;
/*    */ 
/*    */ import java.awt.Component;
/*    */ import java.awt.Image;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JList;
/*    */ import javax.swing.ListCellRenderer;
/*    */ 
/*    */ 
/*    */ public class c
/*    */   extends JLabel
/*    */   implements ListCellRenderer
/*    */ {
/*    */   public c() {
/* 16 */     setOpaque(true);
/* 17 */     setHorizontalAlignment(10);
/* 18 */     setVerticalAlignment(0);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Component getListCellRendererComponent(JList paramJList, Object paramObject, int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
/* 24 */     if (paramBoolean1) {
/* 25 */       setBackground(paramJList.getSelectionBackground());
/* 26 */       setForeground(paramJList.getSelectionForeground());
/*    */     } else {
/* 28 */       setBackground(paramJList.getBackground());
/* 29 */       setForeground(paramJList.getForeground());
/*    */     } 
/*    */     
/* 32 */     ImageIcon imageIcon = (ImageIcon)paramObject;
/*    */     
/* 34 */     Image image = imageIcon.getImage();
/*    */     
/* 36 */     setText(imageIcon.getDescription());
/* 37 */     setIcon(new ImageIcon(image));
/* 38 */     return this;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\m\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */