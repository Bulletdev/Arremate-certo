/*     */ package org.apache.poi.xwpf.usermodel;
/*     */ 
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.STStyleType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XWPFStyle
/*     */ {
/*     */   protected XWPFStyles styles;
/*     */   private CTStyle ctStyle;
/*     */   
/*     */   public XWPFStyle(CTStyle paramCTStyle) {
/*  37 */     this(paramCTStyle, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFStyle(CTStyle paramCTStyle, XWPFStyles paramXWPFStyles) {
/*  47 */     this.ctStyle = paramCTStyle;
/*  48 */     this.styles = paramXWPFStyles;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getStyleId() {
/*  57 */     return this.ctStyle.getStyleId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStyleId(String paramString) {
/*  66 */     this.ctStyle.setStyleId(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public STStyleType.Enum getType() {
/*  75 */     return this.ctStyle.getType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setType(STStyleType.Enum paramEnum) {
/*  84 */     this.ctStyle.setType(paramEnum);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStyle(CTStyle paramCTStyle) {
/*  93 */     this.ctStyle = paramCTStyle;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CTStyle getCTStyle() {
/* 102 */     return this.ctStyle;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFStyles getStyles() {
/* 111 */     return this.styles;
/*     */   }
/*     */   
/*     */   public String getBasisStyleID() {
/* 115 */     if (this.ctStyle.getBasedOn() != null) {
/* 116 */       return this.ctStyle.getBasedOn().getVal();
/*     */     }
/* 118 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLinkStyleID() {
/* 126 */     if (this.ctStyle.getLink() != null) {
/* 127 */       return this.ctStyle.getLink().getVal();
/*     */     }
/* 129 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getNextStyleID() {
/* 136 */     if (this.ctStyle.getNext() != null) {
/* 137 */       return this.ctStyle.getNext().getVal();
/*     */     }
/* 139 */     return null;
/*     */   }
/*     */   
/*     */   public String getName() {
/* 143 */     if (this.ctStyle.isSetName())
/* 144 */       return this.ctStyle.getName().getVal(); 
/* 145 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasSameName(XWPFStyle paramXWPFStyle) {
/* 154 */     CTStyle cTStyle = paramXWPFStyle.getCTStyle();
/* 155 */     String str = cTStyle.getName().getVal();
/* 156 */     return str.equals(this.ctStyle.getName().getVal());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xwp\\usermodel\XWPFStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */