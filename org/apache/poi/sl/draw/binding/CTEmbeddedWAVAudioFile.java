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
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name = "CT_EmbeddedWAVAudioFile", namespace = "http://schemas.openxmlformats.org/drawingml/2006/main")
/*     */ public class CTEmbeddedWAVAudioFile
/*     */ {
/*     */   @XmlAttribute(namespace = "http://schemas.openxmlformats.org/officeDocument/2006/relationships", required = true)
/*     */   protected String embed;
/*     */   @XmlAttribute
/*     */   protected String name;
/*     */   @XmlAttribute
/*     */   protected Boolean builtIn;
/*     */   
/*     */   public String getEmbed() {
/*  65 */     return this.embed;
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
/*     */   public void setEmbed(String paramString) {
/*  77 */     this.embed = paramString;
/*     */   }
/*     */   
/*     */   public boolean isSetEmbed() {
/*  81 */     return (this.embed != null);
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
/*     */   public String getName() {
/*  93 */     if (this.name == null) {
/*  94 */       return "";
/*     */     }
/*  96 */     return this.name;
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
/*     */   
/*     */   public void setName(String paramString) {
/* 109 */     this.name = paramString;
/*     */   }
/*     */   
/*     */   public boolean isSetName() {
/* 113 */     return (this.name != null);
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
/*     */   public boolean isBuiltIn() {
/* 125 */     if (this.builtIn == null) {
/* 126 */       return false;
/*     */     }
/* 128 */     return this.builtIn.booleanValue();
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
/*     */   
/*     */   public void setBuiltIn(boolean paramBoolean) {
/* 141 */     this.builtIn = Boolean.valueOf(paramBoolean);
/*     */   }
/*     */   
/*     */   public boolean isSetBuiltIn() {
/* 145 */     return (this.builtIn != null);
/*     */   }
/*     */   
/*     */   public void unsetBuiltIn() {
/* 149 */     this.builtIn = null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\binding\CTEmbeddedWAVAudioFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */