/*     */ package org.apache.poi.sl.draw.binding;
/*     */ 
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlAttribute;
/*     */ import javax.xml.bind.annotation.XmlElement;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
/*     */ import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ @XmlType(name = "CT_PolarAdjustHandle", namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", propOrder = {"pos"})
/*     */ public class CTPolarAdjustHandle
/*     */ {
/*     */   @XmlElement(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", required = true)
/*     */   protected CTAdjPoint2D pos;
/*     */   @XmlAttribute
/*     */   @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
/*     */   protected String gdRefR;
/*     */   @XmlAttribute
/*     */   protected String minR;
/*     */   @XmlAttribute
/*     */   protected String maxR;
/*     */   @XmlAttribute
/*     */   @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
/*     */   protected String gdRefAng;
/*     */   @XmlAttribute
/*     */   protected String minAng;
/*     */   @XmlAttribute
/*     */   protected String maxAng;
/*     */   
/*     */   public CTAdjPoint2D getPos() {
/*  86 */     return this.pos;
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
/*     */   public void setPos(CTAdjPoint2D paramCTAdjPoint2D) {
/*  98 */     this.pos = paramCTAdjPoint2D;
/*     */   }
/*     */   
/*     */   public boolean isSetPos() {
/* 102 */     return (this.pos != null);
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
/*     */   public String getGdRefR() {
/* 114 */     return this.gdRefR;
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
/*     */   public void setGdRefR(String paramString) {
/* 126 */     this.gdRefR = paramString;
/*     */   }
/*     */   
/*     */   public boolean isSetGdRefR() {
/* 130 */     return (this.gdRefR != null);
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
/*     */   public String getMinR() {
/* 142 */     return this.minR;
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
/*     */   public void setMinR(String paramString) {
/* 154 */     this.minR = paramString;
/*     */   }
/*     */   
/*     */   public boolean isSetMinR() {
/* 158 */     return (this.minR != null);
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
/*     */   public String getMaxR() {
/* 170 */     return this.maxR;
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
/*     */   public void setMaxR(String paramString) {
/* 182 */     this.maxR = paramString;
/*     */   }
/*     */   
/*     */   public boolean isSetMaxR() {
/* 186 */     return (this.maxR != null);
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
/*     */   public String getGdRefAng() {
/* 198 */     return this.gdRefAng;
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
/*     */   public void setGdRefAng(String paramString) {
/* 210 */     this.gdRefAng = paramString;
/*     */   }
/*     */   
/*     */   public boolean isSetGdRefAng() {
/* 214 */     return (this.gdRefAng != null);
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
/*     */   public String getMinAng() {
/* 226 */     return this.minAng;
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
/*     */   public void setMinAng(String paramString) {
/* 238 */     this.minAng = paramString;
/*     */   }
/*     */   
/*     */   public boolean isSetMinAng() {
/* 242 */     return (this.minAng != null);
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
/*     */   public String getMaxAng() {
/* 254 */     return this.maxAng;
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
/*     */   public void setMaxAng(String paramString) {
/* 266 */     this.maxAng = paramString;
/*     */   }
/*     */   
/*     */   public boolean isSetMaxAng() {
/* 270 */     return (this.maxAng != null);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\binding\CTPolarAdjustHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */