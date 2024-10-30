/*    */ package br.com.arremate.c.a;
/*    */ 
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Image;
/*    */ import java.io.IOException;
/*    */ import java.net.URL;
/*    */ import javax.imageio.ImageIO;
/*    */ import javax.swing.GroupLayout;
/*    */ import javax.swing.JPanel;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ 
/*    */ 
/*    */ public class a
/*    */   extends JPanel
/*    */ {
/* 17 */   private static final Logger a = LoggerFactory.getLogger(a.class);
/*    */ 
/*    */   
/*    */   private Image b;
/*    */ 
/*    */   
/*    */   public a() {
/* 24 */     k();
/*    */   }
/*    */   
/*    */   public a(String paramString) {
/*    */     try {
/* 29 */       URL uRL = getClass().getResource(paramString);
/* 30 */       this.b = ImageIO.read(uRL);
/* 31 */     } catch (IOException iOException) {
/* 32 */       a.warn("Não foi possível carregar imagem do background", iOException);
/* 33 */       iOException.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void paintComponent(Graphics paramGraphics) {
/* 39 */     super.paintComponent(paramGraphics);
/*    */ 
/*    */     
/* 42 */     paramGraphics.drawImage(this.b, 0, 0, this);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void k() {
/* 55 */     GroupLayout groupLayout = new GroupLayout(this);
/* 56 */     setLayout(groupLayout);
/* 57 */     groupLayout.setHorizontalGroup(groupLayout
/* 58 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 59 */         .addGap(0, 400, 32767));
/*    */     
/* 61 */     groupLayout.setVerticalGroup(groupLayout
/* 62 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 63 */         .addGap(0, 300, 32767));
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\c\a\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */