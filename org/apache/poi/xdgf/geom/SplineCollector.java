/*    */ package org.apache.poi.xdgf.geom;
/*    */ 
/*    */ import com.a.a.f;
/*    */ import com.a.a.p;
/*    */ import com.a.a.r;
/*    */ import com.a.a.t;
/*    */ import com.a.b.d;
/*    */ import java.awt.Shape;
/*    */ import java.awt.geom.Path2D;
/*    */ import java.awt.geom.Point2D;
/*    */ import java.util.ArrayList;
/*    */ import org.apache.poi.xdgf.usermodel.XDGFShape;
/*    */ import org.apache.poi.xdgf.usermodel.section.geometry.SplineKnot;
/*    */ import org.apache.poi.xdgf.usermodel.section.geometry.SplineStart;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SplineCollector
/*    */ {
/*    */   SplineStart _start;
/* 35 */   ArrayList<SplineKnot> _knots = new ArrayList<SplineKnot>();
/*    */   
/*    */   public SplineCollector(SplineStart paramSplineStart) {
/* 38 */     this._start = paramSplineStart;
/*    */   }
/*    */   
/*    */   public void addKnot(SplineKnot paramSplineKnot) {
/* 42 */     if (!paramSplineKnot.getDel()) {
/* 43 */       this._knots.add(paramSplineKnot);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void addToPath(Path2D.Double paramDouble, XDGFShape paramXDGFShape) {
/* 49 */     Point2D point2D = paramDouble.getCurrentPoint();
/*    */ 
/*    */     
/* 52 */     f f = new f();
/* 53 */     t t = new t(this._knots.size() + 3);
/*    */     
/* 55 */     double d1 = this._start.getB().doubleValue();
/* 56 */     double d2 = this._start.getC().doubleValue();
/* 57 */     int i = this._start.getD().intValue();
/*    */ 
/*    */     
/* 60 */     t.add(d1);
/* 61 */     t.add(this._start.getA().doubleValue());
/*    */ 
/*    */     
/* 64 */     f.a((p)d.a(point2D.getX(), point2D.getY()));
/* 65 */     f.a((p)d.a(this._start.getX().doubleValue(), this._start.getY().doubleValue()));
/*    */ 
/*    */     
/* 68 */     for (SplineKnot splineKnot : this._knots) {
/* 69 */       t.add(splineKnot.getA().doubleValue());
/* 70 */       f.a((p)d.a(splineKnot.getX().doubleValue(), splineKnot.getY().doubleValue()));
/*    */     } 
/*    */ 
/*    */     
/* 74 */     t.add(d2);
/*    */     
/* 76 */     r r = SplineRenderer.createNurbsSpline(f, t, null, i);
/* 77 */     paramDouble.append((Shape)r, true);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xdgf\geom\SplineCollector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */