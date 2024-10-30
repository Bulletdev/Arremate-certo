/*     */ package org.apache.poi.sl.draw;
/*     */ 
/*     */ import java.awt.BasicStroke;
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.Paint;
/*     */ import java.awt.Shape;
/*     */ import java.awt.geom.AffineTransform;
/*     */ import java.awt.geom.Ellipse2D;
/*     */ import java.awt.geom.Path2D;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import javax.xml.bind.JAXBContext;
/*     */ import javax.xml.bind.JAXBElement;
/*     */ import javax.xml.bind.Unmarshaller;
/*     */ import javax.xml.stream.EventFilter;
/*     */ import javax.xml.stream.XMLEventReader;
/*     */ import javax.xml.stream.XMLInputFactory;
/*     */ import javax.xml.stream.events.StartElement;
/*     */ import javax.xml.stream.events.XMLEvent;
/*     */ import org.apache.poi.sl.draw.binding.CTCustomGeometry2D;
/*     */ import org.apache.poi.sl.draw.geom.Context;
/*     */ import org.apache.poi.sl.draw.geom.CustomGeometry;
/*     */ import org.apache.poi.sl.draw.geom.IAdjustableShape;
/*     */ import org.apache.poi.sl.draw.geom.Outline;
/*     */ import org.apache.poi.sl.draw.geom.Path;
/*     */ import org.apache.poi.sl.usermodel.LineDecoration;
/*     */ import org.apache.poi.sl.usermodel.PaintStyle;
/*     */ import org.apache.poi.sl.usermodel.PlaceableShape;
/*     */ import org.apache.poi.sl.usermodel.Shadow;
/*     */ import org.apache.poi.sl.usermodel.Shape;
/*     */ import org.apache.poi.sl.usermodel.SimpleShape;
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
/*     */ 
/*     */ 
/*     */ public class DrawSimpleShape
/*     */   extends DrawShape
/*     */ {
/*     */   private static final double DECO_SIZE_POW = 1.5D;
/*     */   
/*     */   public DrawSimpleShape(SimpleShape<?, ?> paramSimpleShape) {
/*  64 */     super((Shape<?, ?>)paramSimpleShape);
/*     */   }
/*     */ 
/*     */   
/*     */   public void draw(Graphics2D paramGraphics2D) {
/*  69 */     DrawPaint drawPaint = DrawFactory.getInstance(paramGraphics2D).getPaint((PlaceableShape<?, ?>)getShape());
/*  70 */     Paint paint1 = drawPaint.getPaint(paramGraphics2D, getShape().getFillStyle().getPaint());
/*  71 */     Paint paint2 = drawPaint.getPaint(paramGraphics2D, getShape().getStrokeStyle().getPaint());
/*  72 */     BasicStroke basicStroke = getStroke();
/*  73 */     paramGraphics2D.setStroke(basicStroke);
/*     */     
/*  75 */     Collection<Outline> collection = computeOutlines(paramGraphics2D);
/*     */ 
/*     */     
/*  78 */     drawShadow(paramGraphics2D, collection, paint1, paint2);
/*     */ 
/*     */     
/*  81 */     if (paint1 != null) {
/*  82 */       paramGraphics2D.setPaint(paint1);
/*  83 */       for (Outline outline : collection) {
/*  84 */         if (outline.getPath().isFilled()) {
/*  85 */           Shape shape = outline.getOutline();
/*  86 */           paramGraphics2D.setRenderingHint(Drawable.GRADIENT_SHAPE, shape);
/*  87 */           paramGraphics2D.fill(shape);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  93 */     drawContent(paramGraphics2D);
/*     */ 
/*     */     
/*  96 */     if (paint2 != null) {
/*  97 */       paramGraphics2D.setPaint(paint2);
/*  98 */       paramGraphics2D.setStroke(basicStroke);
/*  99 */       for (Outline outline : collection) {
/* 100 */         if (outline.getPath().isStroked()) {
/* 101 */           Shape shape = outline.getOutline();
/* 102 */           paramGraphics2D.setRenderingHint(Drawable.GRADIENT_SHAPE, shape);
/* 103 */           paramGraphics2D.draw(shape);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 109 */     drawDecoration(paramGraphics2D, paint2, basicStroke);
/*     */   }
/*     */   
/*     */   protected void drawDecoration(Graphics2D paramGraphics2D, Paint paramPaint, BasicStroke paramBasicStroke) {
/* 113 */     if (paramPaint == null)
/* 114 */       return;  paramGraphics2D.setPaint(paramPaint);
/*     */     
/* 116 */     ArrayList<Outline> arrayList = new ArrayList();
/* 117 */     LineDecoration lineDecoration = getShape().getLineDecoration();
/* 118 */     Outline outline1 = getHeadDecoration(paramGraphics2D, lineDecoration, paramBasicStroke);
/* 119 */     if (outline1 != null) arrayList.add(outline1); 
/* 120 */     Outline outline2 = getTailDecoration(paramGraphics2D, lineDecoration, paramBasicStroke);
/* 121 */     if (outline2 != null) arrayList.add(outline2);
/*     */ 
/*     */     
/* 124 */     for (Outline outline : arrayList) {
/* 125 */       Shape shape = outline.getOutline();
/* 126 */       Path path = outline.getPath();
/* 127 */       paramGraphics2D.setRenderingHint(Drawable.GRADIENT_SHAPE, shape);
/*     */       
/* 129 */       if (path.isFilled()) paramGraphics2D.fill(shape); 
/* 130 */       if (path.isStroked()) paramGraphics2D.draw(shape); 
/*     */     } 
/*     */   } protected Outline getTailDecoration(Graphics2D paramGraphics2D, LineDecoration paramLineDecoration, BasicStroke paramBasicStroke) { Shape shape;
/*     */     Rectangle2D rectangle2D2;
/*     */     Path2D.Double double_1, double_2;
/* 135 */     if (paramLineDecoration == null || paramBasicStroke == null) {
/* 136 */       return null;
/*     */     }
/* 138 */     LineDecoration.DecorationSize decorationSize1 = paramLineDecoration.getTailLength();
/* 139 */     if (decorationSize1 == null) {
/* 140 */       decorationSize1 = LineDecoration.DecorationSize.MEDIUM;
/*     */     }
/* 142 */     LineDecoration.DecorationSize decorationSize2 = paramLineDecoration.getTailWidth();
/* 143 */     if (decorationSize2 == null) {
/* 144 */       decorationSize2 = LineDecoration.DecorationSize.MEDIUM;
/*     */     }
/*     */     
/* 147 */     double d1 = Math.max(2.5D, paramBasicStroke.getLineWidth());
/*     */     
/* 149 */     Rectangle2D rectangle2D1 = getAnchor(paramGraphics2D, (PlaceableShape<?, ?>)getShape());
/* 150 */     double d2 = rectangle2D1.getX() + rectangle2D1.getWidth();
/* 151 */     double d3 = rectangle2D1.getY() + rectangle2D1.getHeight();
/*     */     
/* 153 */     double d4 = Math.atan(rectangle2D1.getHeight() / rectangle2D1.getWidth());
/*     */     
/* 155 */     AffineTransform affineTransform = new AffineTransform();
/* 156 */     Ellipse2D.Double double_ = null;
/* 157 */     Path path = null;
/*     */     
/* 159 */     double d5 = Math.pow(1.5D, (decorationSize2.ordinal() + 1));
/* 160 */     double d6 = Math.pow(1.5D, (decorationSize1.ordinal() + 1));
/*     */     
/* 162 */     LineDecoration.DecorationShape decorationShape = paramLineDecoration.getTailShape();
/*     */     
/* 164 */     if (decorationShape == null) {
/* 165 */       return null;
/*     */     }
/*     */     
/* 168 */     switch (decorationShape) {
/*     */       case OVAL:
/* 170 */         path = new Path();
/* 171 */         double_ = new Ellipse2D.Double(0.0D, 0.0D, d1 * d6, d1 * d5);
/* 172 */         rectangle2D2 = double_.getBounds2D();
/* 173 */         affineTransform.translate(d2 - rectangle2D2.getWidth() / 2.0D, d3 - rectangle2D2.getHeight() / 2.0D);
/* 174 */         affineTransform.rotate(d4, rectangle2D2.getX() + rectangle2D2.getWidth() / 2.0D, rectangle2D2.getY() + rectangle2D2.getHeight() / 2.0D);
/*     */         break;
/*     */       case STEALTH:
/*     */       case ARROW:
/* 178 */         path = new Path(false, true);
/* 179 */         double_1 = new Path2D.Double();
/* 180 */         double_1.moveTo(-d1 * d6, -d1 * d5 / 2.0D);
/* 181 */         double_1.lineTo(0.0D, 0.0D);
/* 182 */         double_1.lineTo(-d1 * d6, d1 * d5 / 2.0D);
/* 183 */         shape = double_1;
/* 184 */         affineTransform.translate(d2, d3);
/* 185 */         affineTransform.rotate(d4);
/*     */         break;
/*     */       case TRIANGLE:
/* 188 */         path = new Path();
/* 189 */         double_2 = new Path2D.Double();
/* 190 */         double_2.moveTo(-d1 * d6, -d1 * d5 / 2.0D);
/* 191 */         double_2.lineTo(0.0D, 0.0D);
/* 192 */         double_2.lineTo(-d1 * d6, d1 * d5 / 2.0D);
/* 193 */         double_2.closePath();
/* 194 */         shape = double_2;
/* 195 */         affineTransform.translate(d2, d3);
/* 196 */         affineTransform.rotate(d4);
/*     */         break;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 202 */     if (shape != null) {
/* 203 */       shape = affineTransform.createTransformedShape(shape);
/*     */     }
/* 205 */     return (shape == null) ? null : new Outline(shape, path); } protected Outline getHeadDecoration(Graphics2D paramGraphics2D, LineDecoration paramLineDecoration, BasicStroke paramBasicStroke) {
/*     */     Shape shape;
/*     */     Rectangle2D rectangle2D2;
/*     */     Path2D.Double double_1, double_2;
/* 209 */     if (paramLineDecoration == null || paramBasicStroke == null) {
/* 210 */       return null;
/*     */     }
/* 212 */     LineDecoration.DecorationSize decorationSize1 = paramLineDecoration.getHeadLength();
/* 213 */     if (decorationSize1 == null) {
/* 214 */       decorationSize1 = LineDecoration.DecorationSize.MEDIUM;
/*     */     }
/* 216 */     LineDecoration.DecorationSize decorationSize2 = paramLineDecoration.getHeadWidth();
/* 217 */     if (decorationSize2 == null) {
/* 218 */       decorationSize2 = LineDecoration.DecorationSize.MEDIUM;
/*     */     }
/*     */     
/* 221 */     double d1 = Math.max(2.5D, paramBasicStroke.getLineWidth());
/*     */     
/* 223 */     Rectangle2D rectangle2D1 = getAnchor(paramGraphics2D, (PlaceableShape<?, ?>)getShape());
/* 224 */     double d2 = rectangle2D1.getX();
/* 225 */     double d3 = rectangle2D1.getY();
/*     */     
/* 227 */     double d4 = Math.atan(rectangle2D1.getHeight() / rectangle2D1.getWidth());
/*     */     
/* 229 */     AffineTransform affineTransform = new AffineTransform();
/* 230 */     Ellipse2D.Double double_ = null;
/* 231 */     Path path = null;
/*     */     
/* 233 */     double d5 = Math.pow(1.5D, (decorationSize2.ordinal() + 1));
/* 234 */     double d6 = Math.pow(1.5D, (decorationSize1.ordinal() + 1));
/* 235 */     LineDecoration.DecorationShape decorationShape = paramLineDecoration.getHeadShape();
/*     */     
/* 237 */     if (decorationShape == null) {
/* 238 */       return null;
/*     */     }
/*     */     
/* 241 */     switch (decorationShape) {
/*     */       case OVAL:
/* 243 */         path = new Path();
/* 244 */         double_ = new Ellipse2D.Double(0.0D, 0.0D, d1 * d6, d1 * d5);
/* 245 */         rectangle2D2 = double_.getBounds2D();
/* 246 */         affineTransform.translate(d2 - rectangle2D2.getWidth() / 2.0D, d3 - rectangle2D2.getHeight() / 2.0D);
/* 247 */         affineTransform.rotate(d4, rectangle2D2.getX() + rectangle2D2.getWidth() / 2.0D, rectangle2D2.getY() + rectangle2D2.getHeight() / 2.0D);
/*     */         break;
/*     */       case STEALTH:
/*     */       case ARROW:
/* 251 */         path = new Path(false, true);
/* 252 */         double_1 = new Path2D.Double();
/* 253 */         double_1.moveTo(d1 * d6, -d1 * d5 / 2.0D);
/* 254 */         double_1.lineTo(0.0D, 0.0D);
/* 255 */         double_1.lineTo(d1 * d6, d1 * d5 / 2.0D);
/* 256 */         shape = double_1;
/* 257 */         affineTransform.translate(d2, d3);
/* 258 */         affineTransform.rotate(d4);
/*     */         break;
/*     */       case TRIANGLE:
/* 261 */         path = new Path();
/* 262 */         double_2 = new Path2D.Double();
/* 263 */         double_2.moveTo(d1 * d6, -d1 * d5 / 2.0D);
/* 264 */         double_2.lineTo(0.0D, 0.0D);
/* 265 */         double_2.lineTo(d1 * d6, d1 * d5 / 2.0D);
/* 266 */         double_2.closePath();
/* 267 */         shape = double_2;
/* 268 */         affineTransform.translate(d2, d3);
/* 269 */         affineTransform.rotate(d4);
/*     */         break;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 275 */     if (shape != null) {
/* 276 */       shape = affineTransform.createTransformedShape(shape);
/*     */     }
/* 278 */     return (shape == null) ? null : new Outline(shape, path);
/*     */   }
/*     */   
/*     */   public BasicStroke getStroke() {
/* 282 */     return getStroke(getShape().getStrokeStyle());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void drawShadow(Graphics2D paramGraphics2D, Collection<Outline> paramCollection, Paint paramPaint1, Paint paramPaint2) {
/* 291 */     Shadow shadow = getShape().getShadow();
/* 292 */     if (shadow == null || (paramPaint1 == null && paramPaint2 == null))
/*     */       return; 
/* 294 */     PaintStyle.SolidPaint solidPaint = shadow.getFillStyle();
/* 295 */     Color color = DrawPaint.applyColorTransform(solidPaint.getSolidColor());
/*     */     
/* 297 */     double d1 = getShape().getRotation();
/* 298 */     if (getShape().getFlipVertical()) {
/* 299 */       d1 += 180.0D;
/*     */     }
/* 301 */     double d2 = shadow.getAngle() - d1;
/* 302 */     double d3 = shadow.getDistance();
/* 303 */     double d4 = d3 * Math.cos(Math.toRadians(d2));
/* 304 */     double d5 = d3 * Math.sin(Math.toRadians(d2));
/*     */     
/* 306 */     paramGraphics2D.translate(d4, d5);
/*     */     
/* 308 */     for (Outline outline : paramCollection) {
/* 309 */       Shape shape = outline.getOutline();
/* 310 */       Path path = outline.getPath();
/* 311 */       paramGraphics2D.setRenderingHint(Drawable.GRADIENT_SHAPE, shape);
/* 312 */       paramGraphics2D.setPaint(color);
/*     */       
/* 314 */       if (paramPaint1 != null && path.isFilled()) {
/* 315 */         paramGraphics2D.fill(shape); continue;
/* 316 */       }  if (paramPaint2 != null && path.isStroked()) {
/* 317 */         paramGraphics2D.draw(shape);
/*     */       }
/*     */     } 
/*     */     
/* 321 */     paramGraphics2D.translate(-d4, -d5);
/*     */   }
/*     */   
/*     */   protected static CustomGeometry getCustomGeometry(String paramString) {
/* 325 */     return getCustomGeometry(paramString, (Graphics2D)null);
/*     */   }
/*     */ 
/*     */   
/*     */   protected static CustomGeometry getCustomGeometry(String paramString, Graphics2D paramGraphics2D) {
/* 330 */     Map<Object, Object> map = (paramGraphics2D == null) ? null : (Map)paramGraphics2D.getRenderingHint(Drawable.PRESET_GEOMETRY_CACHE);
/*     */ 
/*     */ 
/*     */     
/* 334 */     if (map == null) {
/* 335 */       map = new HashMap<Object, Object>();
/* 336 */       if (paramGraphics2D != null) {
/* 337 */         paramGraphics2D.setRenderingHint(Drawable.PRESET_GEOMETRY_CACHE, map);
/*     */       }
/*     */       
/* 340 */       String str = "org.apache.poi.sl.draw.binding";
/* 341 */       InputStream inputStream = Drawable.class.getResourceAsStream("presetShapeDefinitions.xml");
/*     */ 
/*     */       
/* 344 */       EventFilter eventFilter = new EventFilter()
/*     */         {
/*     */           public boolean accept(XMLEvent param1XMLEvent) {
/* 347 */             return param1XMLEvent.isStartElement();
/*     */           }
/*     */         };
/*     */       
/*     */       try {
/* 352 */         XMLInputFactory xMLInputFactory = XMLInputFactory.newInstance();
/* 353 */         XMLEventReader xMLEventReader1 = xMLInputFactory.createXMLEventReader(inputStream);
/* 354 */         XMLEventReader xMLEventReader2 = xMLInputFactory.createFilteredReader(xMLEventReader1, eventFilter);
/*     */         
/* 356 */         xMLEventReader2.nextEvent();
/*     */         
/* 358 */         JAXBContext jAXBContext = JAXBContext.newInstance(str);
/* 359 */         Unmarshaller unmarshaller = jAXBContext.createUnmarshaller();
/*     */         
/* 361 */         while (xMLEventReader2.peek() != null) {
/* 362 */           StartElement startElement = (StartElement)xMLEventReader2.peek();
/* 363 */           String str1 = startElement.getName().dT();
/*     */           
/* 365 */           JAXBElement<CTCustomGeometry2D> jAXBElement = unmarshaller.unmarshal(xMLEventReader1, CTCustomGeometry2D.class);
/* 366 */           CTCustomGeometry2D cTCustomGeometry2D = jAXBElement.getValue();
/*     */           
/* 368 */           map.put(str1, new CustomGeometry(cTCustomGeometry2D));
/*     */         } 
/*     */         
/* 371 */         xMLEventReader2.close();
/* 372 */         xMLEventReader1.close();
/* 373 */       } catch (Exception exception) {
/* 374 */         throw new RuntimeException("Unable to load preset geometries.", exception);
/*     */       } finally {
/*     */         try {
/* 377 */           inputStream.close();
/* 378 */         } catch (IOException iOException) {
/* 379 */           throw new RuntimeException("Unable to load preset geometries.", iOException);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 384 */     return (CustomGeometry)map.get(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   protected Collection<Outline> computeOutlines(Graphics2D paramGraphics2D) {
/* 389 */     ArrayList<Outline> arrayList = new ArrayList();
/* 390 */     CustomGeometry customGeometry = getShape().getGeometry();
/* 391 */     if (customGeometry == null) {
/* 392 */       return arrayList;
/*     */     }
/*     */     
/* 395 */     Rectangle2D rectangle2D = getAnchor(paramGraphics2D, (PlaceableShape<?, ?>)getShape());
/* 396 */     for (Path path : customGeometry) {
/*     */       
/* 398 */       double d3, d4, d1 = (path.getW() == -1L) ? (rectangle2D.getWidth() * 12700.0D) : path.getW();
/* 399 */       double d2 = (path.getH() == -1L) ? (rectangle2D.getHeight() * 12700.0D) : path.getH();
/*     */ 
/*     */ 
/*     */       
/* 403 */       Rectangle2D.Double double_ = new Rectangle2D.Double(0.0D, 0.0D, d1, d2);
/*     */       
/* 405 */       Context context = new Context(customGeometry, double_, (IAdjustableShape)getShape());
/*     */       
/* 407 */       Path2D.Double double_1 = path.getPath(context);
/*     */ 
/*     */       
/* 410 */       AffineTransform affineTransform = new AffineTransform();
/* 411 */       affineTransform.translate(rectangle2D.getX(), rectangle2D.getY());
/*     */ 
/*     */       
/* 414 */       if (path.getW() != -1L) {
/* 415 */         d3 = rectangle2D.getWidth() / path.getW();
/*     */       } else {
/* 417 */         d3 = 7.874015748031496E-5D;
/*     */       } 
/* 419 */       if (path.getH() != -1L) {
/* 420 */         d4 = rectangle2D.getHeight() / path.getH();
/*     */       } else {
/* 422 */         d4 = 7.874015748031496E-5D;
/*     */       } 
/*     */       
/* 425 */       affineTransform.scale(d3, d4);
/*     */       
/* 427 */       Shape shape = affineTransform.createTransformedShape(double_1);
/*     */       
/* 429 */       arrayList.add(new Outline(shape, path));
/*     */     } 
/*     */     
/* 432 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   protected SimpleShape<?, ?> getShape() {
/* 437 */     return (SimpleShape<?, ?>)this.shape;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\DrawSimpleShape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */