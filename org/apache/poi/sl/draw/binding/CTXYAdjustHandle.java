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
/*     */ @XmlType(name = "CT_XYAdjustHandle", namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", propOrder = {"pos"})
/*     */ public class CTXYAdjustHandle
/*     */ {
/*     */   @XmlElement(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", required = true)
/*     */   protected CTAdjPoint2D pos;
/*     */   @XmlAttribute
/*     */   @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
/*     */   protected String gdRefX;
/*     */   @XmlAttribute
/*     */   protected String minX;
/*     */   @XmlAttribute
/*     */   protected String maxX;
/*     */   @XmlAttribute
/*     */   @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
/*     */   protected String gdRefY;
/*     */   @XmlAttribute
/*     */   protected String minY;
/*     */   @XmlAttribute
/*     */   protected String maxY;
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
/*     */   public String getGdRefX() {
/* 114 */     return this.gdRefX;
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
/*     */   public void setGdRefX(String paramString) {
/* 126 */     this.gdRefX = paramString;
/*     */   }
/*     */   
/*     */   public boolean isSetGdRefX() {
/* 130 */     return (this.gdRefX != null);
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
/*     */   public String getMinX() {
/* 142 */     return this.minX;
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
/*     */   public void setMinX(String paramString) {
/* 154 */     this.minX = paramString;
/*     */   }
/*     */   
/*     */   public boolean isSetMinX() {
/* 158 */     return (this.minX != null);
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
/*     */   public String getMaxX() {
/* 170 */     return this.maxX;
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
/*     */   public void setMaxX(String paramString) {
/* 182 */     this.maxX = paramString;
/*     */   }
/*     */   
/*     */   public boolean isSetMaxX() {
/* 186 */     return (this.maxX != null);
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
/*     */   public String getGdRefY() {
/* 198 */     return this.gdRefY;
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
/*     */   public void setGdRefY(String paramString) {
/* 210 */     this.gdRefY = paramString;
/*     */   }
/*     */   
/*     */   public boolean isSetGdRefY() {
/* 214 */     return (this.gdRefY != null);
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
/*     */   public String getMinY() {
/* 226 */     return this.minY;
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
/*     */   public void setMinY(String paramString) {
/* 238 */     this.minY = paramString;
/*     */   }
/*     */   
/*     */   public boolean isSetMinY() {
/* 242 */     return (this.minY != null);
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
/*     */   public String getMaxY() {
/* 254 */     return this.maxY;
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
/*     */   public void setMaxY(String paramString) {
/* 266 */     this.maxY = paramString;
/*     */   }
/*     */   
/*     */   public boolean isSetMaxY() {
/* 270 */     return (this.maxY != null);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\binding\CTXYAdjustHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */