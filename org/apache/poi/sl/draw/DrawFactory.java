/*     */ package org.apache.poi.sl.draw;
/*     */ 
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.font.TextLayout;
/*     */ import java.awt.geom.AffineTransform;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import java.text.AttributedString;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.apache.poi.sl.usermodel.Background;
/*     */ import org.apache.poi.sl.usermodel.ConnectorShape;
/*     */ import org.apache.poi.sl.usermodel.FreeformShape;
/*     */ import org.apache.poi.sl.usermodel.GraphicalFrame;
/*     */ import org.apache.poi.sl.usermodel.GroupShape;
/*     */ import org.apache.poi.sl.usermodel.MasterSheet;
/*     */ import org.apache.poi.sl.usermodel.PictureShape;
/*     */ import org.apache.poi.sl.usermodel.PlaceableShape;
/*     */ import org.apache.poi.sl.usermodel.Shape;
/*     */ import org.apache.poi.sl.usermodel.Sheet;
/*     */ import org.apache.poi.sl.usermodel.Slide;
/*     */ import org.apache.poi.sl.usermodel.TableShape;
/*     */ import org.apache.poi.sl.usermodel.TextBox;
/*     */ import org.apache.poi.sl.usermodel.TextParagraph;
/*     */ import org.apache.poi.sl.usermodel.TextShape;
/*     */ import org.apache.poi.util.JvmBugs;
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
/*     */ 
/*     */ public class DrawFactory
/*     */ {
/*  46 */   protected static final ThreadLocal<DrawFactory> defaultFactory = new ThreadLocal<DrawFactory>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setDefaultFactory(DrawFactory paramDrawFactory) {
/*  56 */     defaultFactory.set(paramDrawFactory);
/*     */   }
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
/*     */   public static DrawFactory getInstance(Graphics2D paramGraphics2D) {
/*  69 */     DrawFactory drawFactory = null;
/*  70 */     boolean bool = false;
/*  71 */     if (paramGraphics2D != null) {
/*  72 */       drawFactory = (DrawFactory)paramGraphics2D.getRenderingHint(Drawable.DRAW_FACTORY);
/*  73 */       bool = (drawFactory != null) ? true : false;
/*     */     } 
/*     */     
/*  76 */     if (drawFactory == null) {
/*  77 */       drawFactory = defaultFactory.get();
/*     */     }
/*     */     
/*  80 */     if (drawFactory == null) {
/*  81 */       drawFactory = new DrawFactory();
/*     */     }
/*  83 */     if (paramGraphics2D != null && !bool) {
/*  84 */       paramGraphics2D.setRenderingHint(Drawable.DRAW_FACTORY, drawFactory);
/*     */     }
/*  86 */     return drawFactory;
/*     */   }
/*     */   
/*     */   public Drawable getDrawable(Shape<?, ?> paramShape) {
/*  90 */     if (paramShape instanceof TextBox)
/*  91 */       return getDrawable((TextBox<?, ?>)paramShape); 
/*  92 */     if (paramShape instanceof FreeformShape)
/*  93 */       return getDrawable((FreeformShape<?, ?>)paramShape); 
/*  94 */     if (paramShape instanceof TextShape)
/*  95 */       return getDrawable((TextShape<?, ?>)paramShape); 
/*  96 */     if (paramShape instanceof TableShape)
/*  97 */       return getDrawable((TableShape<?, ?>)paramShape); 
/*  98 */     if (paramShape instanceof GroupShape)
/*  99 */       return getDrawable((GroupShape<?, ?>)paramShape); 
/* 100 */     if (paramShape instanceof PictureShape)
/* 101 */       return getDrawable((PictureShape<?, ?>)paramShape); 
/* 102 */     if (paramShape instanceof GraphicalFrame)
/* 103 */       return getDrawable((GraphicalFrame<?, ?>)paramShape); 
/* 104 */     if (paramShape instanceof Background)
/* 105 */       return getDrawable((Background<?, ?>)paramShape); 
/* 106 */     if (paramShape instanceof ConnectorShape)
/* 107 */       return getDrawable((ConnectorShape<?, ?>)paramShape); 
/* 108 */     if (paramShape instanceof Slide)
/* 109 */       return getDrawable((Slide<?, ?>)paramShape); 
/* 110 */     if (paramShape instanceof MasterSheet)
/* 111 */       return getDrawable((MasterSheet<?, ?>)paramShape); 
/* 112 */     if (paramShape instanceof Sheet)
/* 113 */       return getDrawable((Sheet<?, ?>)paramShape); 
/* 114 */     if (paramShape.getClass().isAnnotationPresent((Class)DrawNotImplemented.class)) {
/* 115 */       return new DrawNothing(paramShape);
/*     */     }
/*     */     
/* 118 */     throw new IllegalArgumentException("Unsupported shape type: " + paramShape.getClass());
/*     */   }
/*     */   
/*     */   public DrawSlide getDrawable(Slide<?, ?> paramSlide) {
/* 122 */     return new DrawSlide(paramSlide);
/*     */   }
/*     */   
/*     */   public DrawSheet getDrawable(Sheet<?, ?> paramSheet) {
/* 126 */     return new DrawSheet(paramSheet);
/*     */   }
/*     */   
/*     */   public DrawMasterSheet getDrawable(MasterSheet<?, ?> paramMasterSheet) {
/* 130 */     return new DrawMasterSheet(paramMasterSheet);
/*     */   }
/*     */   
/*     */   public DrawTextBox getDrawable(TextBox<?, ?> paramTextBox) {
/* 134 */     return new DrawTextBox(paramTextBox);
/*     */   }
/*     */   
/*     */   public DrawFreeformShape getDrawable(FreeformShape<?, ?> paramFreeformShape) {
/* 138 */     return new DrawFreeformShape(paramFreeformShape);
/*     */   }
/*     */   
/*     */   public DrawConnectorShape getDrawable(ConnectorShape<?, ?> paramConnectorShape) {
/* 142 */     return new DrawConnectorShape(paramConnectorShape);
/*     */   }
/*     */   
/*     */   public DrawTableShape getDrawable(TableShape<?, ?> paramTableShape) {
/* 146 */     return new DrawTableShape(paramTableShape);
/*     */   }
/*     */   
/*     */   public DrawTextShape getDrawable(TextShape<?, ?> paramTextShape) {
/* 150 */     return new DrawTextShape(paramTextShape);
/*     */   }
/*     */   
/*     */   public DrawGroupShape getDrawable(GroupShape<?, ?> paramGroupShape) {
/* 154 */     return new DrawGroupShape(paramGroupShape);
/*     */   }
/*     */   
/*     */   public DrawPictureShape getDrawable(PictureShape<?, ?> paramPictureShape) {
/* 158 */     return new DrawPictureShape(paramPictureShape);
/*     */   }
/*     */   
/*     */   public DrawGraphicalFrame getDrawable(GraphicalFrame<?, ?> paramGraphicalFrame) {
/* 162 */     return new DrawGraphicalFrame(paramGraphicalFrame);
/*     */   }
/*     */   
/*     */   public DrawTextParagraph getDrawable(TextParagraph<?, ?, ?> paramTextParagraph) {
/* 166 */     return new DrawTextParagraph(paramTextParagraph);
/*     */   }
/*     */   
/*     */   public DrawBackground getDrawable(Background<?, ?> paramBackground) {
/* 170 */     return new DrawBackground(paramBackground);
/*     */   }
/*     */   
/*     */   public DrawTextFragment getTextFragment(TextLayout paramTextLayout, AttributedString paramAttributedString) {
/* 174 */     return new DrawTextFragment(paramTextLayout, paramAttributedString);
/*     */   }
/*     */   
/*     */   public DrawPaint getPaint(PlaceableShape<?, ?> paramPlaceableShape) {
/* 178 */     return new DrawPaint(paramPlaceableShape);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawShape(Graphics2D paramGraphics2D, Shape<?, ?> paramShape, Rectangle2D paramRectangle2D) {
/* 190 */     Rectangle2D rectangle2D = paramShape.getAnchor();
/* 191 */     if (rectangle2D.isEmpty() || (paramRectangle2D != null && paramRectangle2D.isEmpty())) {
/*     */       return;
/*     */     }
/*     */     
/* 195 */     AffineTransform affineTransform1 = (AffineTransform)paramGraphics2D.getRenderingHint(Drawable.GROUP_TRANSFORM);
/* 196 */     AffineTransform affineTransform2 = new AffineTransform();
/*     */     try {
/* 198 */       if (paramRectangle2D != null) {
/* 199 */         double d1 = paramRectangle2D.getWidth() / rectangle2D.getWidth();
/* 200 */         double d2 = paramRectangle2D.getHeight() / rectangle2D.getHeight();
/* 201 */         affineTransform2.translate(paramRectangle2D.getCenterX(), paramRectangle2D.getCenterY());
/* 202 */         affineTransform2.scale(d1, d2);
/* 203 */         affineTransform2.translate(-rectangle2D.getCenterX(), -rectangle2D.getCenterY());
/*     */       } 
/* 205 */       paramGraphics2D.setRenderingHint(Drawable.GROUP_TRANSFORM, affineTransform2);
/*     */       
/* 207 */       Drawable drawable = getDrawable(paramShape);
/* 208 */       drawable.applyTransform(paramGraphics2D);
/* 209 */       drawable.draw(paramGraphics2D);
/*     */     } finally {
/* 211 */       paramGraphics2D.setRenderingHint(Drawable.GROUP_TRANSFORM, affineTransform1);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void fixFonts(Graphics2D paramGraphics2D) {
/* 223 */     if (!JvmBugs.hasLineBreakMeasurerBug())
/*     */       return; 
/* 225 */     Map<Object, Object> map = (Map)paramGraphics2D.getRenderingHint(Drawable.FONT_MAP);
/* 226 */     if (map == null) {
/* 227 */       map = new HashMap<Object, Object>();
/* 228 */       paramGraphics2D.setRenderingHint(Drawable.FONT_MAP, map);
/*     */     } 
/*     */     
/* 231 */     String[][] arrayOfString = { { "Calibri", "Lucida Sans" }, { "Cambria", "Lucida Bright" } };
/*     */     
/* 233 */     for (String[] arrayOfString1 : arrayOfString) {
/* 234 */       if (!map.containsKey(arrayOfString1[0]))
/* 235 */         map.put(arrayOfString1[0], arrayOfString1[1]); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\DrawFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */