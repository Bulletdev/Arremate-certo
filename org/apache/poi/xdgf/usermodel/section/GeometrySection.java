/*     */ package org.apache.poi.xdgf.usermodel.section;
/*     */ 
/*     */ import com.microsoft.schemas.office.visio.x2012.main.RowType;
/*     */ import com.microsoft.schemas.office.visio.x2012.main.SectionType;
/*     */ import java.awt.geom.Path2D;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.SortedMap;
/*     */ import java.util.TreeMap;
/*     */ import org.apache.poi.POIXMLException;
/*     */ import org.apache.poi.xdgf.geom.SplineCollector;
/*     */ import org.apache.poi.xdgf.usermodel.XDGFCell;
/*     */ import org.apache.poi.xdgf.usermodel.XDGFShape;
/*     */ import org.apache.poi.xdgf.usermodel.XDGFSheet;
/*     */ import org.apache.poi.xdgf.usermodel.section.geometry.Ellipse;
/*     */ import org.apache.poi.xdgf.usermodel.section.geometry.GeometryRow;
/*     */ import org.apache.poi.xdgf.usermodel.section.geometry.GeometryRowFactory;
/*     */ import org.apache.poi.xdgf.usermodel.section.geometry.InfiniteLine;
/*     */ import org.apache.poi.xdgf.usermodel.section.geometry.SplineKnot;
/*     */ import org.apache.poi.xdgf.usermodel.section.geometry.SplineStart;
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
/*     */ public class GeometrySection
/*     */   extends XDGFSection
/*     */ {
/*  43 */   GeometrySection _master = null;
/*     */ 
/*     */   
/*  46 */   SortedMap<Long, GeometryRow> _rows = new TreeMap<Long, GeometryRow>();
/*     */   
/*     */   public GeometrySection(SectionType paramSectionType, XDGFSheet paramXDGFSheet) {
/*  49 */     super(paramSectionType, paramXDGFSheet);
/*     */     
/*  51 */     for (RowType rowType : paramSectionType.getRowArray()) {
/*  52 */       if (this._rows.containsKey(Long.valueOf(rowType.getIX()))) {
/*  53 */         throw new POIXMLException("Index element '" + rowType.getIX() + "' already exists");
/*     */       }
/*  55 */       this._rows.put(Long.valueOf(rowType.getIX()), GeometryRowFactory.load(rowType));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setupMaster(XDGFSection paramXDGFSection) {
/*  62 */     this._master = (GeometrySection)paramXDGFSection;
/*     */     
/*  64 */     for (Map.Entry<Long, GeometryRow> entry : this._rows.entrySet()) {
/*  65 */       GeometryRow geometryRow = this._master._rows.get(entry.getKey());
/*  66 */       if (geometryRow != null) {
/*     */         try {
/*  68 */           ((GeometryRow)entry.getValue()).setupMaster(geometryRow);
/*  69 */         } catch (ClassCastException classCastException) {}
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Boolean getNoShow() {
/*  80 */     Boolean bool = XDGFCell.maybeGetBoolean(this._cells, "NoShow");
/*  81 */     if (bool == null) {
/*  82 */       if (this._master != null) {
/*  83 */         return this._master.getNoShow();
/*     */       }
/*  85 */       return Boolean.valueOf(false);
/*     */     } 
/*     */     
/*  88 */     return bool;
/*     */   }
/*     */   
/*     */   public Iterable<GeometryRow> getCombinedRows() {
/*  92 */     return new CombinedIterable<GeometryRow>(this._rows, (this._master == null) ? null : this._master._rows);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Path2D.Double getPath(XDGFShape paramXDGFShape) {
/*  98 */     Iterator<GeometryRow> iterator = getCombinedRows().iterator();
/*     */ 
/*     */     
/* 101 */     GeometryRow geometryRow = iterator.next();
/*     */     
/* 103 */     if (geometryRow instanceof Ellipse)
/* 104 */       return ((Ellipse)geometryRow).getPath(); 
/* 105 */     if (geometryRow instanceof InfiniteLine)
/* 106 */       return ((InfiniteLine)geometryRow).getPath(); 
/* 107 */     if (geometryRow instanceof SplineStart) {
/* 108 */       throw new POIXMLException("SplineStart must be preceded by another type");
/*     */     }
/*     */ 
/*     */     
/* 112 */     Path2D.Double double_ = new Path2D.Double();
/*     */ 
/*     */     
/* 115 */     SplineCollector splineCollector = null;
/*     */     
/*     */     while (true) {
/*     */       GeometryRow geometryRow1;
/*     */       
/* 120 */       if (geometryRow != null) {
/* 121 */         geometryRow1 = geometryRow;
/* 122 */         geometryRow = null;
/*     */       } else {
/* 124 */         if (!iterator.hasNext())
/*     */           break; 
/* 126 */         geometryRow1 = iterator.next();
/*     */       } 
/*     */       
/* 129 */       if (geometryRow1 instanceof SplineStart) {
/* 130 */         if (splineCollector != null)
/* 131 */           throw new POIXMLException("SplineStart found multiple times!"); 
/* 132 */         splineCollector = new SplineCollector((SplineStart)geometryRow1); continue;
/* 133 */       }  if (geometryRow1 instanceof SplineKnot) {
/* 134 */         if (splineCollector == null)
/* 135 */           throw new POIXMLException("SplineKnot found without SplineStart!"); 
/* 136 */         splineCollector.addKnot((SplineKnot)geometryRow1); continue;
/*     */       } 
/* 138 */       if (splineCollector != null) {
/* 139 */         splineCollector.addToPath(double_, paramXDGFShape);
/* 140 */         splineCollector = null;
/*     */       } 
/*     */       
/* 143 */       geometryRow1.addToPath(double_, paramXDGFShape);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 148 */     if (splineCollector != null) {
/* 149 */       splineCollector.addToPath(double_, paramXDGFShape);
/*     */     }
/* 151 */     return double_;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xdg\\usermodel\section\GeometrySection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */