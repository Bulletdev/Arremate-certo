/*    */ package br.com.arremate.m;
/*    */ 
/*    */ import br.com.arremate.f.j;
/*    */ import br.com.arremate.f.s;
/*    */ import java.awt.Component;
/*    */ import java.net.URL;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JTable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class v
/*    */   extends r
/*    */ {
/* 19 */   JLabel K = new JLabel();
/*    */   
/*    */   public v(String paramString) {
/* 22 */     this();
/* 23 */     setToolTipText(paramString);
/*    */   }
/*    */   
/*    */   public v() {
/* 27 */     super(0);
/*    */   }
/*    */ 
/*    */   
/*    */   public Component getTableCellRendererComponent(JTable paramJTable, Object paramObject, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2) {
/* 32 */     JLabel jLabel = (JLabel)super.getTableCellRendererComponent(paramJTable, paramObject, paramBoolean1, paramBoolean2, paramInt1, paramInt2);
/* 33 */     String str = "";
/*    */     
/* 35 */     if (paramObject != null) {
/* 36 */       if (paramObject instanceof s) {
/* 37 */         paramObject = ((s)paramObject).O();
/* 38 */       } else if (paramObject instanceof br.com.arremate.f.r) {
/*    */         
/* 40 */         paramObject = getText();
/*    */       } 
/*    */       
/* 43 */       if (paramObject instanceof j) {
/* 44 */         switch (null.b[((j)paramObject).ordinal()]) {
/*    */           case 1:
/* 46 */             str = j.a.K();
/* 47 */             paramObject = "/img/hammer.png";
/*    */             break;
/*    */           case 2:
/* 50 */             str = j.g.K();
/* 51 */             paramObject = "/img/hammer_closed.png";
/*    */             break;
/*    */           default:
/* 54 */             str = ((j)paramObject).K();
/* 55 */             paramObject = "/img/date.png";
/*    */             break;
/*    */         } 
/*    */       
/*    */       }
/* 60 */       if (paramObject instanceof String) {
/* 61 */         String str1 = String.valueOf(paramObject);
/*    */         
/* 63 */         if (!str1.isEmpty()) {
/* 64 */           URL uRL = getClass().getResource(str1);
/*    */           
/* 66 */           if (uRL != null) {
/* 67 */             jLabel.setIcon(new ImageIcon(uRL));
/*    */           }
/*    */           
/* 70 */           if (paramObject.equals("/img/play.png")) {
/* 71 */             setToolTipText("Iniciar disputa do item");
/* 72 */           } else if (paramObject.equals("/img/pause.png")) {
/* 73 */             setToolTipText("Parar disputa do item");
/* 74 */           } else if (paramObject.equals("/img/config_edit.png")) {
/* 75 */             setToolTipText("Item com configurações próprias");
/* 76 */           } else if (paramObject.equals("/img/config_edit_warn.png")) {
/* 77 */             setToolTipText("Variação não está de acordo com o definido pelo portal");
/* 78 */           } else if (paramObject.equals("/img/config.png")) {
/* 79 */             setToolTipText(null);
/*    */           } 
/*    */         } 
/*    */       } 
/*    */     } 
/*    */     
/* 85 */     jLabel.setText("");
/* 86 */     jLabel.setHorizontalAlignment(0);
/*    */     
/* 88 */     if (!str.isEmpty()) {
/* 89 */       jLabel.setToolTipText(str);
/*    */     }
/*    */     
/* 92 */     return jLabel;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\m\v.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */