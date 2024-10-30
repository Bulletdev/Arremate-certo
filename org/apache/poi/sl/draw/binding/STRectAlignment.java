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
/*     */ @XmlType(name = "ST_RectAlignment", namespace = "http://schemas.openxmlformats.org/drawingml/2006/main")
/*     */ @XmlEnum
/*     */ public enum STRectAlignment
/*     */ {
/*  56 */   TL("tl"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  63 */   T("t"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  70 */   TR("tr"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  77 */   L("l"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  84 */   CTR("ctr"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  91 */   R("r"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  98 */   BL("bl"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 105 */   B("b"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 112 */   BR("br");
/*     */   
/*     */   private final String value;
/*     */   
/*     */   STRectAlignment(String paramString1) {
/* 117 */     this.value = paramString1;
/*     */   }
/*     */   
/*     */   public String value() {
/* 121 */     return this.value;
/*     */   }
/*     */   
/*     */   public static STRectAlignment fromValue(String paramString) {
/* 125 */     for (STRectAlignment sTRectAlignment : values()) {
/* 126 */       if (sTRectAlignment.value.equals(paramString)) {
/* 127 */         return sTRectAlignment;
/*     */       }
/*     */     } 
/* 130 */     throw new IllegalArgumentException(paramString);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\binding\STRectAlignment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */