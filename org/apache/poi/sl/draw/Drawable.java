/*     */ package org.apache.poi.sl.draw;
/*     */ 
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.RenderingHints;
/*     */ import org.apache.poi.util.Internal;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface Drawable
/*     */ {
/*     */   public static class DrawableHint
/*     */     extends RenderingHints.Key
/*     */   {
/*     */     protected DrawableHint(int param1Int) {
/*  29 */       super(param1Int);
/*     */     }
/*     */     
/*     */     public boolean isCompatibleValue(Object param1Object) {
/*  33 */       return true;
/*     */     }
/*     */     
/*     */     public String toString() {
/*  37 */       switch (intKey()) { case 1:
/*  38 */           return "DRAW_FACTORY";
/*  39 */         case 2: return "GROUP_TRANSFORM";
/*  40 */         case 3: return "IMAGE_RENDERER";
/*  41 */         case 4: return "TEXT_RENDERING_MODE";
/*  42 */         case 5: return "GRADIENT_SHAPE";
/*  43 */         case 6: return "PRESET_GEOMETRY_CACHE";
/*  44 */         case 7: return "FONT_HANDLER";
/*  45 */         case 8: return "FONT_FALLBACK";
/*  46 */         case 9: return "FONT_MAP";
/*  47 */         case 10: return "GSAVE";
/*  48 */         case 11: return "GRESTORE"; }
/*  49 */        return "UNKNOWN_ID " + intKey();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  57 */   public static final DrawableHint DRAW_FACTORY = new DrawableHint(1);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal
/*  63 */   public static final DrawableHint GROUP_TRANSFORM = new DrawableHint(2);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  68 */   public static final DrawableHint IMAGE_RENDERER = new DrawableHint(3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  84 */   public static final DrawableHint TEXT_RENDERING_MODE = new DrawableHint(4);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  90 */   public static final DrawableHint GRADIENT_SHAPE = new DrawableHint(5);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  96 */   public static final DrawableHint PRESET_GEOMETRY_CACHE = new DrawableHint(6);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int TEXT_AS_CHARACTERS = 1;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int TEXT_AS_SHAPES = 2;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 111 */   public static final DrawableHint FONT_HANDLER = new DrawableHint(7);
/* 112 */   public static final DrawableHint FONT_FALLBACK = new DrawableHint(8);
/* 113 */   public static final DrawableHint FONT_MAP = new DrawableHint(9);
/*     */   
/* 115 */   public static final DrawableHint GSAVE = new DrawableHint(10);
/* 116 */   public static final DrawableHint GRESTORE = new DrawableHint(11);
/*     */   
/*     */   void applyTransform(Graphics2D paramGraphics2D);
/*     */   
/*     */   void draw(Graphics2D paramGraphics2D);
/*     */   
/*     */   void drawContent(Graphics2D paramGraphics2D);
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\Drawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */