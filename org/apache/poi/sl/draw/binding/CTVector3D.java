/*     */ package org.apache.poi.sl.draw.binding;
/*     */ 
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlAttribute;
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
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name = "CT_Vector3D", namespace = "http://schemas.openxmlformats.org/drawingml/2006/main")
/*     */ public class CTVector3D
/*     */ {
/*     */   @XmlAttribute(required = true)
/*     */   protected long dx;
/*     */   @XmlAttribute(required = true)
/*     */   protected long dy;
/*     */   @XmlAttribute(required = true)
/*     */   protected long dz;
/*     */   
/*     */   public long getDx() {
/*  61 */     return this.dx;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDx(long paramLong) {
/*  69 */     this.dx = paramLong;
/*     */   }
/*     */   
/*     */   public boolean isSetDx() {
/*  73 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getDy() {
/*  81 */     return this.dy;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDy(long paramLong) {
/*  89 */     this.dy = paramLong;
/*     */   }
/*     */   
/*     */   public boolean isSetDy() {
/*  93 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getDz() {
/* 101 */     return this.dz;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDz(long paramLong) {
/* 109 */     this.dz = paramLong;
/*     */   }
/*     */   
/*     */   public boolean isSetDz() {
/* 113 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\binding\CTVector3D.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */