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
/*     */ @XmlType(name = "CT_Point3D", namespace = "http://schemas.openxmlformats.org/drawingml/2006/main")
/*     */ public class CTPoint3D
/*     */ {
/*     */   @XmlAttribute(required = true)
/*     */   protected long x;
/*     */   @XmlAttribute(required = true)
/*     */   protected long y;
/*     */   @XmlAttribute(required = true)
/*     */   protected long z;
/*     */   
/*     */   public long getX() {
/*  61 */     return this.x;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setX(long paramLong) {
/*  69 */     this.x = paramLong;
/*     */   }
/*     */   
/*     */   public boolean isSetX() {
/*  73 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getY() {
/*  81 */     return this.y;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setY(long paramLong) {
/*  89 */     this.y = paramLong;
/*     */   }
/*     */   
/*     */   public boolean isSetY() {
/*  93 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getZ() {
/* 101 */     return this.z;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setZ(long paramLong) {
/* 109 */     this.z = paramLong;
/*     */   }
/*     */   
/*     */   public boolean isSetZ() {
/* 113 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\binding\CTPoint3D.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */