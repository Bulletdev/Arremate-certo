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
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name = "CT_Scale2D", namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", propOrder = {"sx", "sy"})
/*     */ public class CTScale2D
/*     */ {
/*     */   @XmlElement(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", required = true)
/*     */   protected CTRatio sx;
/*     */   @XmlElement(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", required = true)
/*     */   protected CTRatio sy;
/*     */   
/*     */   public CTRatio getSx() {
/*  67 */     return this.sx;
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
/*     */   public void setSx(CTRatio paramCTRatio) {
/*  79 */     this.sx = paramCTRatio;
/*     */   }
/*     */   
/*     */   public boolean isSetSx() {
/*  83 */     return (this.sx != null);
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
/*     */   public CTRatio getSy() {
/*  95 */     return this.sy;
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
/*     */   public void setSy(CTRatio paramCTRatio) {
/* 107 */     this.sy = paramCTRatio;
/*     */   }
/*     */   
/*     */   public boolean isSetSy() {
/* 111 */     return (this.sy != null);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\binding\CTScale2D.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */