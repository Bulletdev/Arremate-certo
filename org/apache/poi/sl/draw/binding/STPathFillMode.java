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
/*     */ @XmlType(name = "ST_PathFillMode", namespace = "http://schemas.openxmlformats.org/drawingml/2006/main")
/*     */ @XmlEnum
/*     */ public enum STPathFillMode
/*     */ {
/*  53 */   NONE("none"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  60 */   NORM("norm"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  67 */   LIGHTEN("lighten"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  74 */   LIGHTEN_LESS("lightenLess"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  81 */   DARKEN("darken"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  88 */   DARKEN_LESS("darkenLess");
/*     */   
/*     */   private final String value;
/*     */   
/*     */   STPathFillMode(String paramString1) {
/*  93 */     this.value = paramString1;
/*     */   }
/*     */   
/*     */   public String value() {
/*  97 */     return this.value;
/*     */   }
/*     */   
/*     */   public static STPathFillMode fromValue(String paramString) {
/* 101 */     for (STPathFillMode sTPathFillMode : values()) {
/* 102 */       if (sTPathFillMode.value.equals(paramString)) {
/* 103 */         return sTPathFillMode;
/*     */       }
/*     */     } 
/* 106 */     throw new IllegalArgumentException(paramString);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\binding\STPathFillMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */