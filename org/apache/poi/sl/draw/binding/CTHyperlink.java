/*     */ package org.apache.poi.sl.draw.binding;
/*     */ 
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlAttribute;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name = "CT_Hyperlink", namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", propOrder = {"snd", "extLst"})
/*     */ public class CTHyperlink
/*     */ {
/*     */   @XmlElement(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main")
/*     */   protected CTEmbeddedWAVAudioFile snd;
/*     */   @XmlElement(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main")
/*     */   protected CTOfficeArtExtensionList extLst;
/*     */   @XmlAttribute(namespace = "http://schemas.openxmlformats.org/officeDocument/2006/relationships")
/*     */   protected String id;
/*     */   @XmlAttribute
/*     */   protected String invalidUrl;
/*     */   @XmlAttribute
/*     */   protected String action;
/*     */   @XmlAttribute
/*     */   protected String tgtFrame;
/*     */   @XmlAttribute
/*     */   protected String tooltip;
/*     */   @XmlAttribute
/*     */   protected Boolean history;
/*     */   @XmlAttribute
/*     */   protected Boolean highlightClick;
/*     */   @XmlAttribute
/*     */   protected Boolean endSnd;
/*     */   
/*     */   public CTEmbeddedWAVAudioFile getSnd() {
/*  92 */     return this.snd;
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
/*     */   public void setSnd(CTEmbeddedWAVAudioFile paramCTEmbeddedWAVAudioFile) {
/* 104 */     this.snd = paramCTEmbeddedWAVAudioFile;
/*     */   }
/*     */   
/*     */   public boolean isSetSnd() {
/* 108 */     return (this.snd != null);
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
/*     */   public CTOfficeArtExtensionList getExtLst() {
/* 120 */     return this.extLst;
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
/*     */   public void setExtLst(CTOfficeArtExtensionList paramCTOfficeArtExtensionList) {
/* 132 */     this.extLst = paramCTOfficeArtExtensionList;
/*     */   }
/*     */   
/*     */   public boolean isSetExtLst() {
/* 136 */     return (this.extLst != null);
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
/*     */   public String getId() {
/* 148 */     return this.id;
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
/*     */   public void setId(String paramString) {
/* 160 */     this.id = paramString;
/*     */   }
/*     */   
/*     */   public boolean isSetId() {
/* 164 */     return (this.id != null);
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
/*     */   public String getInvalidUrl() {
/* 176 */     if (this.invalidUrl == null) {
/* 177 */       return "";
/*     */     }
/* 179 */     return this.invalidUrl;
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
/*     */   public void setInvalidUrl(String paramString) {
/* 192 */     this.invalidUrl = paramString;
/*     */   }
/*     */   
/*     */   public boolean isSetInvalidUrl() {
/* 196 */     return (this.invalidUrl != null);
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
/*     */   public String getAction() {
/* 208 */     if (this.action == null) {
/* 209 */       return "";
/*     */     }
/* 211 */     return this.action;
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
/*     */   public void setAction(String paramString) {
/* 224 */     this.action = paramString;
/*     */   }
/*     */   
/*     */   public boolean isSetAction() {
/* 228 */     return (this.action != null);
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
/*     */   public String getTgtFrame() {
/* 240 */     if (this.tgtFrame == null) {
/* 241 */       return "";
/*     */     }
/* 243 */     return this.tgtFrame;
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
/*     */   public void setTgtFrame(String paramString) {
/* 256 */     this.tgtFrame = paramString;
/*     */   }
/*     */   
/*     */   public boolean isSetTgtFrame() {
/* 260 */     return (this.tgtFrame != null);
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
/*     */   public String getTooltip() {
/* 272 */     if (this.tooltip == null) {
/* 273 */       return "";
/*     */     }
/* 275 */     return this.tooltip;
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
/*     */   public void setTooltip(String paramString) {
/* 288 */     this.tooltip = paramString;
/*     */   }
/*     */   
/*     */   public boolean isSetTooltip() {
/* 292 */     return (this.tooltip != null);
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
/*     */   public boolean isHistory() {
/* 304 */     if (this.history == null) {
/* 305 */       return true;
/*     */     }
/* 307 */     return this.history.booleanValue();
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
/*     */   public void setHistory(boolean paramBoolean) {
/* 320 */     this.history = Boolean.valueOf(paramBoolean);
/*     */   }
/*     */   
/*     */   public boolean isSetHistory() {
/* 324 */     return (this.history != null);
/*     */   }
/*     */   
/*     */   public void unsetHistory() {
/* 328 */     this.history = null;
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
/*     */   public boolean isHighlightClick() {
/* 340 */     if (this.highlightClick == null) {
/* 341 */       return false;
/*     */     }
/* 343 */     return this.highlightClick.booleanValue();
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
/*     */   public void setHighlightClick(boolean paramBoolean) {
/* 356 */     this.highlightClick = Boolean.valueOf(paramBoolean);
/*     */   }
/*     */   
/*     */   public boolean isSetHighlightClick() {
/* 360 */     return (this.highlightClick != null);
/*     */   }
/*     */   
/*     */   public void unsetHighlightClick() {
/* 364 */     this.highlightClick = null;
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
/*     */   public boolean isEndSnd() {
/* 376 */     if (this.endSnd == null) {
/* 377 */       return false;
/*     */     }
/* 379 */     return this.endSnd.booleanValue();
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
/*     */   public void setEndSnd(boolean paramBoolean) {
/* 392 */     this.endSnd = Boolean.valueOf(paramBoolean);
/*     */   }
/*     */   
/*     */   public boolean isSetEndSnd() {
/* 396 */     return (this.endSnd != null);
/*     */   }
/*     */   
/*     */   public void unsetEndSnd() {
/* 400 */     this.endSnd = null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\binding\CTHyperlink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */