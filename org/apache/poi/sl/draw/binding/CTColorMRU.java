/*     */ package org.apache.poi.sl.draw.binding;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlElement;
/*     */ import javax.xml.bind.annotation.XmlElements;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ @XmlType(name = "CT_ColorMRU", namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", propOrder = {"egColorChoice"})
/*     */ public class CTColorMRU
/*     */ {
/*     */   @XmlElements({@XmlElement(name = "prstClr", namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", type = CTPresetColor.class), @XmlElement(name = "sysClr", namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", type = CTSystemColor.class), @XmlElement(name = "hslClr", namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", type = CTHslColor.class), @XmlElement(name = "srgbClr", namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", type = CTSRgbColor.class), @XmlElement(name = "scrgbClr", namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", type = CTScRgbColor.class), @XmlElement(name = "schemeClr", namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", type = CTSchemeColor.class)})
/*     */   protected List<Object> egColorChoice;
/*     */   
/*     */   public List<Object> getEGColorChoice() {
/*  92 */     if (this.egColorChoice == null) {
/*  93 */       this.egColorChoice = new ArrayList();
/*     */     }
/*  95 */     return this.egColorChoice;
/*     */   }
/*     */   
/*     */   public boolean isSetEGColorChoice() {
/*  99 */     return (this.egColorChoice != null && !this.egColorChoice.isEmpty());
/*     */   }
/*     */   
/*     */   public void unsetEGColorChoice() {
/* 103 */     this.egColorChoice = null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\binding\CTColorMRU.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */