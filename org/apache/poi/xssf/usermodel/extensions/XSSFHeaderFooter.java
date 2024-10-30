/*     */ package org.apache.poi.xssf.usermodel.extensions;
/*     */ 
/*     */ import org.apache.poi.hssf.usermodel.HeaderFooter;
/*     */ import org.apache.poi.ss.usermodel.HeaderFooter;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.poi.xssf.usermodel.helpers.HeaderFooterHelper;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHeaderFooter;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class XSSFHeaderFooter
/*     */   implements HeaderFooter
/*     */ {
/*     */   private HeaderFooterHelper helper;
/*     */   private CTHeaderFooter headerFooter;
/*     */   private boolean stripFields = false;
/*     */   
/*     */   public XSSFHeaderFooter(CTHeaderFooter paramCTHeaderFooter) {
/* 135 */     this.headerFooter = paramCTHeaderFooter;
/* 136 */     this.helper = new HeaderFooterHelper();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal
/*     */   public CTHeaderFooter getHeaderFooter() {
/* 146 */     return this.headerFooter;
/*     */   }
/*     */   
/*     */   public String getValue() {
/* 150 */     String str = getText();
/* 151 */     if (str == null)
/* 152 */       return ""; 
/* 153 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean areFieldsStripped() {
/* 161 */     return this.stripFields;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAreFieldsStripped(boolean paramBoolean) {
/* 171 */     this.stripFields = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String stripFields(String paramString) {
/* 180 */     return HeaderFooter.stripFields(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public abstract String getText();
/*     */ 
/*     */   
/*     */   protected abstract void setText(String paramString);
/*     */ 
/*     */   
/*     */   public String getCenter() {
/* 191 */     String str = this.helper.getCenterSection(getText());
/* 192 */     if (this.stripFields)
/* 193 */       return stripFields(str); 
/* 194 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLeft() {
/* 201 */     String str = this.helper.getLeftSection(getText());
/* 202 */     if (this.stripFields)
/* 203 */       return stripFields(str); 
/* 204 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRight() {
/* 211 */     String str = this.helper.getRightSection(getText());
/* 212 */     if (this.stripFields)
/* 213 */       return stripFields(str); 
/* 214 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCenter(String paramString) {
/* 221 */     setText(this.helper.setCenterSection(getText(), paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLeft(String paramString) {
/* 228 */     setText(this.helper.setLeftSection(getText(), paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRight(String paramString) {
/* 235 */     setText(this.helper.setRightSection(getText(), paramString));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\extensions\XSSFHeaderFooter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */