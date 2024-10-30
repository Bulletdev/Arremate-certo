/*    */ package org.apache.poi.xdgf.usermodel.section.geometry;
/*    */ 
/*    */ import com.microsoft.schemas.office.visio.x2012.main.RowType;
/*    */ import org.apache.poi.POIXMLException;
/*    */ import org.apache.poi.xdgf.util.ObjectFactory;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GeometryRowFactory
/*    */ {
/* 30 */   static final ObjectFactory<GeometryRow, RowType> _rowTypes = new ObjectFactory(); static {
/*    */     try {
/* 32 */       _rowTypes.put("ArcTo", ArcTo.class, new Class[] { RowType.class });
/* 33 */       _rowTypes.put("Ellipse", Ellipse.class, new Class[] { RowType.class });
/* 34 */       _rowTypes.put("EllipticalArcTo", EllipticalArcTo.class, new Class[] { RowType.class });
/*    */       
/* 36 */       _rowTypes.put("InfiniteLine", InfiniteLine.class, new Class[] { RowType.class });
/* 37 */       _rowTypes.put("LineTo", LineTo.class, new Class[] { RowType.class });
/* 38 */       _rowTypes.put("MoveTo", MoveTo.class, new Class[] { RowType.class });
/* 39 */       _rowTypes.put("NURBSTo", NURBSTo.class, new Class[] { RowType.class });
/* 40 */       _rowTypes.put("PolyLineTo", PolyLineTo.class, new Class[] { RowType.class });
/* 41 */       _rowTypes.put("RelCubBezTo", RelCubBezTo.class, new Class[] { RowType.class });
/* 42 */       _rowTypes.put("RelEllipticalArcTo", RelEllipticalArcTo.class, new Class[] { RowType.class });
/*    */       
/* 44 */       _rowTypes.put("RelLineTo", RelLineTo.class, new Class[] { RowType.class });
/* 45 */       _rowTypes.put("RelMoveTo", RelMoveTo.class, new Class[] { RowType.class });
/* 46 */       _rowTypes.put("RelQuadBezTo", RelQuadBezTo.class, new Class[] { RowType.class });
/* 47 */       _rowTypes.put("SplineKnot", SplineKnot.class, new Class[] { RowType.class });
/* 48 */       _rowTypes.put("SplineStart", SplineStart.class, new Class[] { RowType.class });
/* 49 */     } catch (NoSuchMethodException noSuchMethodException) {
/* 50 */       throw new POIXMLException("Internal error", noSuchMethodException);
/* 51 */     } catch (SecurityException securityException) {
/* 52 */       throw new POIXMLException("Internal error", securityException);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static GeometryRow load(RowType paramRowType) {
/* 58 */     return (GeometryRow)_rowTypes.load(paramRowType.getT(), new Object[] { paramRowType });
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xdg\\usermodel\section\geometry\GeometryRowFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */