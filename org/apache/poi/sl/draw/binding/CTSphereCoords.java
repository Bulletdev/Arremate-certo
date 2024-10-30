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
/*     */ @XmlType(name = "CT_SphereCoords", namespace = "http://schemas.openxmlformats.org/drawingml/2006/main")
/*     */ public class CTSphereCoords
/*     */ {
/*     */   @XmlAttribute(required = true)
/*     */   protected int lat;
/*     */   @XmlAttribute(required = true)
/*     */   protected int lon;
/*     */   @XmlAttribute(required = true)
/*     */   protected int rev;
/*     */   
/*     */   public int getLat() {
/*  61 */     return this.lat;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLat(int paramInt) {
/*  69 */     this.lat = paramInt;
/*     */   }
/*     */   
/*     */   public boolean isSetLat() {
/*  73 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLon() {
/*  81 */     return this.lon;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLon(int paramInt) {
/*  89 */     this.lon = paramInt;
/*     */   }
/*     */   
/*     */   public boolean isSetLon() {
/*  93 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRev() {
/* 101 */     return this.rev;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRev(int paramInt) {
/* 109 */     this.rev = paramInt;
/*     */   }
/*     */   
/*     */   public boolean isSetRev() {
/* 113 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\binding\CTSphereCoords.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */