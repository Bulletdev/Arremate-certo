/*    */ package br.com.arremate.c;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Font;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Image;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JMenu;
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
/*    */ public class c
/*    */   extends JMenu
/*    */ {
/* 22 */   private final Image a = (new ImageIcon(getClass().getResource("/img/blue-circle.png"))).getImage();
/* 23 */   private int number = 0;
/*    */ 
/*    */ 
/*    */   
/*    */   public void paint(Graphics paramGraphics) {
/* 28 */     super.paint(paramGraphics);
/*    */     
/* 30 */     if (this.number > 0) {
/* 31 */       setText(getText().trim() + "      ");
/*    */       
/* 33 */       paramGraphics.drawImage(this.a, getWidth() - 22, 0, null);
/* 34 */       paramGraphics.setColor(Color.WHITE);
/*    */       
/* 36 */       if (this.number < 10) {
/* 37 */         paramGraphics.setFont(new Font("SansSerif", 1, 11));
/* 38 */         paramGraphics.drawString(Integer.toString(this.number), getWidth() - 15, 12);
/* 39 */       } else if (this.number >= 10) {
/* 40 */         paramGraphics.setFont(new Font("SansSerif", 1, 12));
/* 41 */         paramGraphics.drawString(Integer.toString(this.number), getWidth() - 19, 12);
/*    */       } 
/*    */     } else {
/* 44 */       setText(getText().trim());
/*    */     } 
/*    */   }
/*    */   
/*    */   public void decrement() {
/* 49 */     this.number--;
/* 50 */     repaint();
/*    */   }
/*    */   
/*    */   public void c(int paramInt) {
/* 54 */     this.number = paramInt;
/* 55 */     repaint();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\c\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */