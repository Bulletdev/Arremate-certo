/*    */ package br.com.arremate.m;
/*    */ 
/*    */ import br.com.arremate.f.h;
/*    */ import java.awt.Color;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class b
/*    */ {
/*    */   private long value;
/*    */   private String text;
/*    */   private Color textColor;
/*    */   
/*    */   public b(h paramh) {
/* 18 */     this(paramh.v(), paramh.K());
/*    */   }
/*    */   
/*    */   public b(long paramLong, String paramString) {
/* 22 */     this.value = paramLong;
/* 23 */     this.text = paramString;
/* 24 */     this.textColor = null;
/*    */   }
/*    */   
/*    */   public long getValue() {
/* 28 */     return this.value;
/*    */   }
/*    */   
/*    */   public void setValue(long paramLong) {
/* 32 */     this.value = paramLong;
/*    */   }
/*    */   
/*    */   public String getText() {
/* 36 */     return this.text;
/*    */   }
/*    */   
/*    */   public void setText(String paramString) {
/* 40 */     this.text = paramString;
/*    */   }
/*    */   
/*    */   public Color b() {
/* 44 */     return this.textColor;
/*    */   }
/*    */   
/*    */   public void a(Color paramColor) {
/* 48 */     this.textColor = paramColor;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 53 */     if (b() != null)
/* 54 */       return "<html><font color=red>" + getText() + "</font>"; 
/* 55 */     if (getValue() == 0L) {
/* 56 */       return "<html><font color=blue>" + getText() + "</font>";
/*    */     }
/* 58 */     return getText();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\m\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */