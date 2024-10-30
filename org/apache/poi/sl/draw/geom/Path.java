/*     */ package org.apache.poi.sl.draw.geom;
/*     */ 
/*     */ import java.awt.geom.Path2D;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.poi.sl.draw.binding.CTAdjPoint2D;
/*     */ import org.apache.poi.sl.draw.binding.CTPath2D;
/*     */ import org.apache.poi.sl.draw.binding.CTPath2DArcTo;
/*     */ import org.apache.poi.sl.draw.binding.CTPath2DCubicBezierTo;
/*     */ import org.apache.poi.sl.draw.binding.CTPath2DLineTo;
/*     */ import org.apache.poi.sl.draw.binding.CTPath2DMoveTo;
/*     */ import org.apache.poi.sl.draw.binding.CTPath2DQuadBezierTo;
/*     */ import org.apache.poi.sl.draw.binding.STPathFillMode;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Path
/*     */ {
/*     */   private final List<PathCommand> commands;
/*     */   boolean _fill;
/*     */   boolean _stroke;
/*     */   long _w;
/*     */   long _h;
/*     */   
/*     */   public Path() {
/*  48 */     this(true, true);
/*     */   }
/*     */   
/*     */   public Path(boolean paramBoolean1, boolean paramBoolean2) {
/*  52 */     this.commands = new ArrayList<PathCommand>();
/*  53 */     this._w = -1L;
/*  54 */     this._h = -1L;
/*  55 */     this._fill = paramBoolean1;
/*  56 */     this._stroke = paramBoolean2;
/*     */   }
/*     */   
/*     */   public Path(CTPath2D paramCTPath2D) {
/*  60 */     this._fill = (paramCTPath2D.getFill() != STPathFillMode.NONE);
/*  61 */     this._stroke = paramCTPath2D.isStroke();
/*  62 */     this._w = paramCTPath2D.isSetW() ? paramCTPath2D.getW() : -1L;
/*  63 */     this._h = paramCTPath2D.isSetH() ? paramCTPath2D.getH() : -1L;
/*     */     
/*  65 */     this.commands = new ArrayList<PathCommand>();
/*     */     
/*  67 */     for (CTPath2DMoveTo cTPath2DMoveTo : paramCTPath2D.getCloseOrMoveToOrLnTo()) {
/*  68 */       if (cTPath2DMoveTo instanceof CTPath2DMoveTo) {
/*  69 */         CTAdjPoint2D cTAdjPoint2D = ((CTPath2DMoveTo)cTPath2DMoveTo).getPt();
/*  70 */         this.commands.add(new MoveToCommand(cTAdjPoint2D)); continue;
/*  71 */       }  if (cTPath2DMoveTo instanceof CTPath2DLineTo) {
/*  72 */         CTAdjPoint2D cTAdjPoint2D = ((CTPath2DLineTo)cTPath2DMoveTo).getPt();
/*  73 */         this.commands.add(new LineToCommand(cTAdjPoint2D)); continue;
/*  74 */       }  if (cTPath2DMoveTo instanceof CTPath2DArcTo) {
/*  75 */         CTPath2DArcTo cTPath2DArcTo = (CTPath2DArcTo)cTPath2DMoveTo;
/*  76 */         this.commands.add(new ArcToCommand(cTPath2DArcTo)); continue;
/*  77 */       }  if (cTPath2DMoveTo instanceof CTPath2DQuadBezierTo) {
/*  78 */         CTPath2DQuadBezierTo cTPath2DQuadBezierTo = (CTPath2DQuadBezierTo)cTPath2DMoveTo;
/*  79 */         CTAdjPoint2D cTAdjPoint2D1 = cTPath2DQuadBezierTo.getPt().get(0);
/*  80 */         CTAdjPoint2D cTAdjPoint2D2 = cTPath2DQuadBezierTo.getPt().get(1);
/*  81 */         this.commands.add(new QuadToCommand(cTAdjPoint2D1, cTAdjPoint2D2)); continue;
/*  82 */       }  if (cTPath2DMoveTo instanceof CTPath2DCubicBezierTo) {
/*  83 */         CTPath2DCubicBezierTo cTPath2DCubicBezierTo = (CTPath2DCubicBezierTo)cTPath2DMoveTo;
/*  84 */         CTAdjPoint2D cTAdjPoint2D1 = cTPath2DCubicBezierTo.getPt().get(0);
/*  85 */         CTAdjPoint2D cTAdjPoint2D2 = cTPath2DCubicBezierTo.getPt().get(1);
/*  86 */         CTAdjPoint2D cTAdjPoint2D3 = cTPath2DCubicBezierTo.getPt().get(2);
/*  87 */         this.commands.add(new CurveToCommand(cTAdjPoint2D1, cTAdjPoint2D2, cTAdjPoint2D3)); continue;
/*  88 */       }  if (cTPath2DMoveTo instanceof org.apache.poi.sl.draw.binding.CTPath2DClose) {
/*  89 */         this.commands.add(new ClosePathCommand()); continue;
/*     */       } 
/*  91 */       throw new IllegalStateException("Unsupported path segment: " + cTPath2DMoveTo);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void addCommand(PathCommand paramPathCommand) {
/*  97 */     this.commands.add(paramPathCommand);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Path2D.Double getPath(Context paramContext) {
/* 104 */     Path2D.Double double_ = new Path2D.Double();
/* 105 */     for (PathCommand pathCommand : this.commands)
/* 106 */       pathCommand.execute(double_, paramContext); 
/* 107 */     return double_;
/*     */   }
/*     */   
/*     */   public boolean isStroked() {
/* 111 */     return this._stroke;
/*     */   }
/*     */   
/*     */   public boolean isFilled() {
/* 115 */     return this._fill;
/*     */   }
/*     */   
/*     */   public long getW() {
/* 119 */     return this._w;
/*     */   }
/*     */   
/*     */   public long getH() {
/* 123 */     return this._h;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\geom\Path.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */