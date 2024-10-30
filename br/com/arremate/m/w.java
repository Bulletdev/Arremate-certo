/*    */ package br.com.arremate.m;
/*    */ 
/*    */ import java.awt.Component;
/*    */ import java.net.URL;
/*    */ import javax.swing.Icon;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JTable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class w
/*    */   extends r
/*    */ {
/* 16 */   JLabel K = new JLabel();
/*    */   
/*    */   public w(String paramString) {
/* 19 */     this();
/* 20 */     setToolTipText(paramString);
/*    */   }
/*    */   
/*    */   public w() {
/* 24 */     super(0);
/*    */   }
/*    */ 
/*    */   
/*    */   public Component getTableCellRendererComponent(JTable paramJTable, Object paramObject, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2) {
/* 29 */     Component component = super.getTableCellRendererComponent(paramJTable, paramObject, paramBoolean1, paramBoolean2, paramInt1, paramInt2);
/*    */     
/* 31 */     if (paramObject != null && !String.valueOf(paramObject).isEmpty()) {
/* 32 */       String[] arrayOfString = String.valueOf(paramObject).split("#@#");
/* 33 */       JLabel jLabel = (JLabel)component;
/*    */       
/* 35 */       if (arrayOfString.length > 1) {
/* 36 */         String str = arrayOfString[1];
/*    */         
/* 38 */         if (!str.isEmpty()) {
/* 39 */           URL uRL = getClass().getResource(str);
/*    */           
/* 41 */           if (uRL != null) {
/* 42 */             jLabel.setIcon(new ImageIcon(uRL));
/*    */           }
/*    */         } 
/*    */       } else {
/* 46 */         jLabel.setIcon((Icon)null);
/*    */       } 
/* 48 */       jLabel.setText(arrayOfString[0]);
/* 49 */       jLabel.setHorizontalAlignment(2);
/*    */     } 
/* 51 */     return component;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\m\w.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */