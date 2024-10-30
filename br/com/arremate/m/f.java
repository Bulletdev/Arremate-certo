/*     */ package br.com.arremate.m;
/*     */ 
/*     */ import java.awt.event.FocusAdapter;
/*     */ import java.awt.event.FocusEvent;
/*     */ import java.awt.event.KeyAdapter;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import javax.swing.JFormattedTextField;
/*     */ import javax.swing.SwingUtilities;
/*     */ import javax.swing.event.CaretEvent;
/*     */ 
/*     */ public class f
/*     */   extends JFormattedTextField {
/*  15 */   private int cJ = 2;
/*     */   
/*     */   public f() {
/*  18 */     addCaretListener(paramCaretEvent -> SwingUtilities.invokeLater(()));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  27 */     addFocusListener(new FocusAdapter(this)
/*     */         {
/*     */           public void focusGained(FocusEvent param1FocusEvent) {
/*  30 */             f.a(this.a);
/*     */           }
/*     */         });
/*     */     
/*  34 */     addMouseListener(new MouseAdapter(this)
/*     */         {
/*     */           public void mouseClicked(MouseEvent param1MouseEvent) {
/*  37 */             f.a(this.a);
/*     */           }
/*     */ 
/*     */           
/*     */           public void mousePressed(MouseEvent param1MouseEvent) {
/*  42 */             f.a(this.a);
/*     */           }
/*     */         });
/*     */ 
/*     */     
/*  47 */     addKeyListener(new KeyAdapter(this)
/*     */         {
/*     */           public void keyReleased(KeyEvent param1KeyEvent) {
/*  50 */             f.b(this.a);
/*     */           }
/*     */ 
/*     */           
/*     */           public void keyPressed(KeyEvent param1KeyEvent) {
/*  55 */             f.b(this.a);
/*     */           }
/*     */ 
/*     */           
/*     */           public void keyTyped(KeyEvent param1KeyEvent) {
/*  60 */             f.b(this.a);
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   private void cI() {
/*  66 */     String str = getText().replaceAll("\\D", "");
/*  67 */     int i = str.length();
/*     */     
/*  69 */     if (h(i)) {
/*  70 */       str = g(str, i);
/*     */     }
/*     */     
/*  73 */     int j = i - Y();
/*     */     
/*  75 */     if (i(j)) {
/*  76 */       if (Y() > 0) {
/*  77 */         str = f(str, j);
/*     */       }
/*  79 */       str = O(str);
/*     */     } 
/*     */     
/*  82 */     str = P(str);
/*  83 */     setText(str);
/*     */   }
/*     */   
/*     */   private String O(String paramString) {
/*  87 */     for (byte b = 19; b > 3; b -= 3) {
/*  88 */       paramString = paramString.replaceAll(n(b), "$1.$2");
/*     */     }
/*  90 */     return paramString;
/*     */   }
/*     */   
/*     */   private String n(int paramInt) {
/*  94 */     int i = paramInt;
/*  95 */     if (Y() > 0) {
/*  96 */       i += Y();
/*     */     } else {
/*  98 */       i--;
/*     */     } 
/* 100 */     return "([0-9,]{1})([0-9,]{" + i + "})$";
/*     */   }
/*     */   
/*     */   private String f(String paramString, int paramInt) {
/* 104 */     return paramString.replaceAll("([0-9]{" + paramInt + "})([0-9]{" + Y() + "})$", "$1,$2");
/*     */   }
/*     */   
/*     */   private String g(String paramString, int paramInt) {
/* 108 */     return a(paramInt, (paramString.matches("0+") || paramString.isEmpty())) + paramString;
/*     */   }
/*     */   
/*     */   private String P(String paramString) {
/* 112 */     if (paramString.equals("0")) {
/* 113 */       return "0";
/*     */     }
/* 115 */     return paramString.replaceAll("^0+(?![.,])", "");
/*     */   }
/*     */   
/*     */   private boolean h(int paramInt) {
/* 119 */     return (paramInt < Y() + 1);
/*     */   }
/*     */   
/*     */   private boolean i(int paramInt) {
/* 123 */     return (paramInt > 0);
/*     */   }
/*     */   
/*     */   private String a(int paramInt, boolean paramBoolean) {
/* 127 */     String str = "";
/* 128 */     if (Y() > 0) {
/* 129 */       str = "0,";
/*     */     } else {
/* 131 */       return "0";
/*     */     } 
/*     */     
/* 134 */     for (byte b = paramBoolean ? 0 : 1; b < Y() - paramInt; b++) {
/* 135 */       str = str + "0";
/*     */     }
/*     */     
/* 138 */     return str;
/*     */   }
/*     */   
/*     */   private void cJ() {
/* 142 */     String str = getText();
/* 143 */     setCaretPosition(str.length());
/*     */   }
/*     */   
/*     */   public int Y() {
/* 147 */     return this.cJ;
/*     */   }
/*     */   
/*     */   public void aq(int paramInt) {
/* 151 */     this.cJ = paramInt;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\m\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */