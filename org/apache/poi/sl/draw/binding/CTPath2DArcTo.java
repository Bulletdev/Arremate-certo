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
/*     */ @XmlType(name = "CT_Path2DArcTo", namespace = "http://schemas.openxmlformats.org/drawingml/2006/main")
/*     */ public class CTPath2DArcTo
/*     */ {
/*     */   @XmlAttribute(name = "wR", required = true)
/*     */   protected String wr;
/*     */   @XmlAttribute(name = "hR", required = true)
/*     */   protected String hr;
/*     */   @XmlAttribute(required = true)
/*     */   protected String stAng;
/*     */   @XmlAttribute(required = true)
/*     */   protected String swAng;
/*     */   
/*     */   public String getWR() {
/*  68 */     return this.wr;
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
/*     */   public void setWR(String paramString) {
/*  80 */     this.wr = paramString;
/*     */   }
/*     */   
/*     */   public boolean isSetWR() {
/*  84 */     return (this.wr != null);
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
/*     */   public String getHR() {
/*  96 */     return this.hr;
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
/*     */   public void setHR(String paramString) {
/* 108 */     this.hr = paramString;
/*     */   }
/*     */   
/*     */   public boolean isSetHR() {
/* 112 */     return (this.hr != null);
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
/*     */   public String getStAng() {
/* 124 */     return this.stAng;
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
/*     */   public void setStAng(String paramString) {
/* 136 */     this.stAng = paramString;
/*     */   }
/*     */   
/*     */   public boolean isSetStAng() {
/* 140 */     return (this.stAng != null);
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
/*     */   public String getSwAng() {
/* 152 */     return this.swAng;
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
/*     */   public void setSwAng(String paramString) {
/* 164 */     this.swAng = paramString;
/*     */   }
/*     */   
/*     */   public boolean isSetSwAng() {
/* 168 */     return (this.swAng != null);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\binding\CTPath2DArcTo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */