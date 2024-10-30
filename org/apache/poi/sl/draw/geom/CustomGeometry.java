/*    */ package org.apache.poi.sl.draw.geom;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import org.apache.poi.sl.draw.binding.CTCustomGeometry2D;
/*    */ import org.apache.poi.sl.draw.binding.CTGeomGuide;
/*    */ import org.apache.poi.sl.draw.binding.CTGeomGuideList;
/*    */ import org.apache.poi.sl.draw.binding.CTGeomRect;
/*    */ import org.apache.poi.sl.draw.binding.CTPath2D;
/*    */ import org.apache.poi.sl.draw.binding.CTPath2DList;
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
/*    */ public class CustomGeometry
/*    */   implements Iterable<Path>
/*    */ {
/* 32 */   List<Guide> adjusts = new ArrayList<Guide>();
/* 33 */   List<Guide> guides = new ArrayList<Guide>();
/* 34 */   List<Path> paths = new ArrayList<Path>();
/*    */   Path textBounds;
/*    */   
/*    */   public CustomGeometry(CTCustomGeometry2D paramCTCustomGeometry2D) {
/* 38 */     CTGeomGuideList cTGeomGuideList1 = paramCTCustomGeometry2D.getAvLst();
/* 39 */     if (cTGeomGuideList1 != null) {
/* 40 */       for (CTGeomGuide cTGeomGuide : cTGeomGuideList1.getGd()) {
/* 41 */         this.adjusts.add(new AdjustValue(cTGeomGuide));
/*    */       }
/*    */     }
/*    */     
/* 45 */     CTGeomGuideList cTGeomGuideList2 = paramCTCustomGeometry2D.getGdLst();
/* 46 */     if (cTGeomGuideList2 != null) {
/* 47 */       for (CTGeomGuide cTGeomGuide : cTGeomGuideList2.getGd()) {
/* 48 */         this.guides.add(new Guide(cTGeomGuide));
/*    */       }
/*    */     }
/*    */     
/* 52 */     CTPath2DList cTPath2DList = paramCTCustomGeometry2D.getPathLst();
/* 53 */     if (cTPath2DList != null) {
/* 54 */       for (CTPath2D cTPath2D : cTPath2DList.getPath()) {
/* 55 */         this.paths.add(new Path(cTPath2D));
/*    */       }
/*    */     }
/*    */     
/* 59 */     CTGeomRect cTGeomRect = paramCTCustomGeometry2D.getRect();
/* 60 */     if (cTGeomRect != null) {
/* 61 */       this.textBounds = new Path();
/* 62 */       this.textBounds.addCommand(new MoveToCommand(cTGeomRect.getL().toString(), cTGeomRect.getT().toString()));
/*    */       
/* 64 */       this.textBounds.addCommand(new LineToCommand(cTGeomRect.getR().toString(), cTGeomRect.getT().toString()));
/*    */       
/* 66 */       this.textBounds.addCommand(new LineToCommand(cTGeomRect.getR().toString(), cTGeomRect.getB().toString()));
/*    */       
/* 68 */       this.textBounds.addCommand(new LineToCommand(cTGeomRect.getL().toString(), cTGeomRect.getB().toString()));
/*    */       
/* 70 */       this.textBounds.addCommand(new ClosePathCommand());
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public Iterator<Path> iterator() {
/* 76 */     return this.paths.iterator();
/*    */   }
/*    */   
/*    */   public Path getTextBounds() {
/* 80 */     return this.textBounds;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\geom\CustomGeometry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */