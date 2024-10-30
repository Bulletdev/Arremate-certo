/*     */ package org.apache.poi.sl.draw.binding;
/*     */ 
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlAttribute;
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
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name = "CT_PresetTextShape", namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", propOrder = {"avLst"})
/*     */ public class CTPresetTextShape
/*     */ {
/*     */   @XmlElement(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main")
/*     */   protected CTGeomGuideList avLst;
/*     */   @XmlAttribute(required = true)
/*     */   protected STTextShapeType prst;
/*     */   
/*     */   public CTGeomGuideList getAvLst() {
/*  67 */     return this.avLst;
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
/*  79 */     this.avLst = paramCTGeomGuideList;
/*     */   }
/*     */   
/*     */   public boolean isSetAvLst() {
/*  83 */     return (this.avLst != null);
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
/*     */   public STTextShapeType getPrst() {
/*  95 */     return this.prst;
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
/*     */   public void setPrst(STTextShapeType paramSTTextShapeType) {
/* 107 */     this.prst = paramSTTextShapeType;
/*     */   }
/*     */   
/*     */   public boolean isSetPrst() {
/* 111 */     return (this.prst != null);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\binding\CTPresetTextShape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */