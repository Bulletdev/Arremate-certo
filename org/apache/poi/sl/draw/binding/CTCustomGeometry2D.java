/*     */ package org.apache.poi.sl.draw.binding;
/*     */ 
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlElement;
/*     */ import javax.xml.bind.annotation.XmlType;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name = "CT_CustomGeometry2D", namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", propOrder = {"avLst", "gdLst", "ahLst", "cxnLst", "rect", "pathLst"})
/*     */ public class CTCustomGeometry2D
/*     */ {
/*     */   @XmlElement(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main")
/*     */   protected CTGeomGuideList avLst;
/*     */   @XmlElement(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main")
/*     */   protected CTGeomGuideList gdLst;
/*     */   @XmlElement(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main")
/*     */   protected CTAdjustHandleList ahLst;
/*     */   @XmlElement(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main")
/*     */   protected CTConnectionSiteList cxnLst;
/*     */   @XmlElement(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main")
/*     */   protected CTGeomRect rect;
/*     */   @XmlElement(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", required = true)
/*     */   protected CTPath2DList pathLst;
/*     */   
/*     */   public CTGeomGuideList getAvLst() {
/*  83 */     return this.avLst;
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
/*     */   public void setAvLst(CTGeomGuideList paramCTGeomGuideList) {
/*  95 */     this.avLst = paramCTGeomGuideList;
/*     */   }
/*     */   
/*     */   public boolean isSetAvLst() {
/*  99 */     return (this.avLst != null);
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
/*     */   public CTGeomGuideList getGdLst() {
/* 111 */     return this.gdLst;
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
/*     */   public void setGdLst(CTGeomGuideList paramCTGeomGuideList) {
/* 123 */     this.gdLst = paramCTGeomGuideList;
/*     */   }
/*     */   
/*     */   public boolean isSetGdLst() {
/* 127 */     return (this.gdLst != null);
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
/*     */   public CTAdjustHandleList getAhLst() {
/* 139 */     return this.ahLst;
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
/*     */   public void setAhLst(CTAdjustHandleList paramCTAdjustHandleList) {
/* 151 */     this.ahLst = paramCTAdjustHandleList;
/*     */   }
/*     */   
/*     */   public boolean isSetAhLst() {
/* 155 */     return (this.ahLst != null);
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
/*     */   public CTConnectionSiteList getCxnLst() {
/* 167 */     return this.cxnLst;
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
/*     */   public void setCxnLst(CTConnectionSiteList paramCTConnectionSiteList) {
/* 179 */     this.cxnLst = paramCTConnectionSiteList;
/*     */   }
/*     */   
/*     */   public boolean isSetCxnLst() {
/* 183 */     return (this.cxnLst != null);
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
/*     */   public CTGeomRect getRect() {
/* 195 */     return this.rect;
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
/*     */   public void setRect(CTGeomRect paramCTGeomRect) {
/* 207 */     this.rect = paramCTGeomRect;
/*     */   }
/*     */   
/*     */   public boolean isSetRect() {
/* 211 */     return (this.rect != null);
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
/*     */   public CTPath2DList getPathLst() {
/* 223 */     return this.pathLst;
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
/*     */   public void setPathLst(CTPath2DList paramCTPath2DList) {
/* 235 */     this.pathLst = paramCTPath2DList;
/*     */   }
/*     */   
/*     */   public boolean isSetPathLst() {
/* 239 */     return (this.pathLst != null);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\binding\CTCustomGeometry2D.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */