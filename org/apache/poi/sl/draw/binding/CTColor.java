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
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name = "CT_Color", namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", propOrder = {"scrgbClr", "srgbClr", "hslClr", "sysClr", "schemeClr", "prstClr"})
/*     */ public class CTColor
/*     */ {
/*     */   @XmlElement(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main")
/*     */   protected CTScRgbColor scrgbClr;
/*     */   @XmlElement(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main")
/*     */   protected CTSRgbColor srgbClr;
/*     */   @XmlElement(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main")
/*     */   protected CTHslColor hslClr;
/*     */   @XmlElement(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main")
/*     */   protected CTSystemColor sysClr;
/*     */   @XmlElement(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main")
/*     */   protected CTSchemeColor schemeClr;
/*     */   @XmlElement(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main")
/*     */   protected CTPresetColor prstClr;
/*     */   
/*     */   public CTScRgbColor getScrgbClr() {
/*  78 */     return this.scrgbClr;
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
/*     */   public void setScrgbClr(CTScRgbColor paramCTScRgbColor) {
/*  90 */     this.scrgbClr = paramCTScRgbColor;
/*     */   }
/*     */   
/*     */   public boolean isSetScrgbClr() {
/*  94 */     return (this.scrgbClr != null);
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
/*     */   public CTSRgbColor getSrgbClr() {
/* 106 */     return this.srgbClr;
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
/*     */   public void setSrgbClr(CTSRgbColor paramCTSRgbColor) {
/* 118 */     this.srgbClr = paramCTSRgbColor;
/*     */   }
/*     */   
/*     */   public boolean isSetSrgbClr() {
/* 122 */     return (this.srgbClr != null);
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
/*     */   public CTHslColor getHslClr() {
/* 134 */     return this.hslClr;
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
/*     */   public void setHslClr(CTHslColor paramCTHslColor) {
/* 146 */     this.hslClr = paramCTHslColor;
/*     */   }
/*     */   
/*     */   public boolean isSetHslClr() {
/* 150 */     return (this.hslClr != null);
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
/*     */   public CTSystemColor getSysClr() {
/* 162 */     return this.sysClr;
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
/*     */   public void setSysClr(CTSystemColor paramCTSystemColor) {
/* 174 */     this.sysClr = paramCTSystemColor;
/*     */   }
/*     */   
/*     */   public boolean isSetSysClr() {
/* 178 */     return (this.sysClr != null);
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
/*     */   public CTSchemeColor getSchemeClr() {
/* 190 */     return this.schemeClr;
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
/*     */   public void setSchemeClr(CTSchemeColor paramCTSchemeColor) {
/* 202 */     this.schemeClr = paramCTSchemeColor;
/*     */   }
/*     */   
/*     */   public boolean isSetSchemeClr() {
/* 206 */     return (this.schemeClr != null);
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
/*     */   public CTPresetColor getPrstClr() {
/* 218 */     return this.prstClr;
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
/*     */   public void setPrstClr(CTPresetColor paramCTPresetColor) {
/* 230 */     this.prstClr = paramCTPresetColor;
/*     */   }
/*     */   
/*     */   public boolean isSetPrstClr() {
/* 234 */     return (this.prstClr != null);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\binding\CTColor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */