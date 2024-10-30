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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name = "CT_GeomRect", namespace = "http://schemas.openxmlformats.org/drawingml/2006/main")
/*     */ public class CTGeomRect
/*     */ {
/*     */   @XmlAttribute(required = true)
/*     */   protected String l;
/*     */   @XmlAttribute(required = true)
/*     */   protected String t;
/*     */   @XmlAttribute(required = true)
/*     */   protected String r;
/*     */   @XmlAttribute(required = true)
/*     */   protected String b;
/*     */   
/*     */   public String getL() {
/*  68 */     return this.l;
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
/*     */   public void setL(String paramString) {
/*  80 */     this.l = paramString;
/*     */   }
/*     */   
/*     */   public boolean isSetL() {
/*  84 */     return (this.l != null);
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
/*     */   public String getT() {
/*  96 */     return this.t;
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
/*     */   public void setT(String paramString) {
/* 108 */     this.t = paramString;
/*     */   }
/*     */   
/*     */   public boolean isSetT() {
/* 112 */     return (this.t != null);
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
/*     */   public String getR() {
/* 124 */     return this.r;
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
/*     */   public void setR(String paramString) {
/* 136 */     this.r = paramString;
/*     */   }
/*     */   
/*     */   public boolean isSetR() {
/* 140 */     return (this.r != null);
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
/*     */   public String getB() {
/* 152 */     return this.b;
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
/*     */   public void setB(String paramString) {
/* 164 */     this.b = paramString;
/*     */   }
/*     */   
/*     */   public boolean isSetB() {
/* 168 */     return (this.b != null);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\binding\CTGeomRect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */