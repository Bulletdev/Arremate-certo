/*     */ package org.apache.poi.sl.draw.binding;
/*     */ 
/*     */ import javax.xml.bind.annotation.XmlEnum;
/*     */ import javax.xml.bind.annotation.XmlEnumValue;
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
/*     */ @XmlType(name = "ST_BlackWhiteMode", namespace = "http://schemas.openxmlformats.org/drawingml/2006/main")
/*     */ @XmlEnum
/*     */ public enum STBlackWhiteMode
/*     */ {
/*  58 */   CLR("clr"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  65 */   AUTO("auto"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  72 */   GRAY("gray"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  79 */   LT_GRAY("ltGray"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  86 */   INV_GRAY("invGray"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  93 */   GRAY_WHITE("grayWhite"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 100 */   BLACK_GRAY("blackGray"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 107 */   BLACK_WHITE("blackWhite"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 114 */   BLACK("black"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 121 */   WHITE("white"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 128 */   HIDDEN("hidden");
/*     */   
/*     */   private final String value;
/*     */   
/*     */   STBlackWhiteMode(String paramString1) {
/* 133 */     this.value = paramString1;
/*     */   }
/*     */   
/*     */   public String value() {
/* 137 */     return this.value;
/*     */   }
/*     */   
/*     */   public static STBlackWhiteMode fromValue(String paramString) {
/* 141 */     for (STBlackWhiteMode sTBlackWhiteMode : values()) {
/* 142 */       if (sTBlackWhiteMode.value.equals(paramString)) {
/* 143 */         return sTBlackWhiteMode;
/*     */       }
/*     */     } 
/* 146 */     throw new IllegalArgumentException(paramString);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\binding\STBlackWhiteMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */