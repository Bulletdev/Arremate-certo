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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @XmlType(name = "ST_TextShapeType", namespace = "http://schemas.openxmlformats.org/drawingml/2006/main")
/*     */ @XmlEnum
/*     */ public enum STTextShapeType
/*     */ {
/*  88 */   TEXT_NO_SHAPE("textNoShape"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  95 */   TEXT_PLAIN("textPlain"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 102 */   TEXT_STOP("textStop"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 109 */   TEXT_TRIANGLE("textTriangle"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 116 */   TEXT_TRIANGLE_INVERTED("textTriangleInverted"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 123 */   TEXT_CHEVRON("textChevron"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 130 */   TEXT_CHEVRON_INVERTED("textChevronInverted"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 137 */   TEXT_RING_INSIDE("textRingInside"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 144 */   TEXT_RING_OUTSIDE("textRingOutside"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 151 */   TEXT_ARCH_UP("textArchUp"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 158 */   TEXT_ARCH_DOWN("textArchDown"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 165 */   TEXT_CIRCLE("textCircle"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 172 */   TEXT_BUTTON("textButton"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 179 */   TEXT_ARCH_UP_POUR("textArchUpPour"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 186 */   TEXT_ARCH_DOWN_POUR("textArchDownPour"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 193 */   TEXT_CIRCLE_POUR("textCirclePour"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 200 */   TEXT_BUTTON_POUR("textButtonPour"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 207 */   TEXT_CURVE_UP("textCurveUp"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 214 */   TEXT_CURVE_DOWN("textCurveDown"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 221 */   TEXT_CAN_UP("textCanUp"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 228 */   TEXT_CAN_DOWN("textCanDown"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 235 */   TEXT_WAVE_1("textWave1"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 242 */   TEXT_WAVE_2("textWave2"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 249 */   TEXT_DOUBLE_WAVE_1("textDoubleWave1"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 256 */   TEXT_WAVE_4("textWave4"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 263 */   TEXT_INFLATE("textInflate"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 270 */   TEXT_DEFLATE("textDeflate"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 277 */   TEXT_INFLATE_BOTTOM("textInflateBottom"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 284 */   TEXT_DEFLATE_BOTTOM("textDeflateBottom"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 291 */   TEXT_INFLATE_TOP("textInflateTop"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 298 */   TEXT_DEFLATE_TOP("textDeflateTop"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 305 */   TEXT_DEFLATE_INFLATE("textDeflateInflate"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 312 */   TEXT_DEFLATE_INFLATE_DEFLATE("textDeflateInflateDeflate"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 319 */   TEXT_FADE_RIGHT("textFadeRight"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 326 */   TEXT_FADE_LEFT("textFadeLeft"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 333 */   TEXT_FADE_UP("textFadeUp"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 340 */   TEXT_FADE_DOWN("textFadeDown"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 347 */   TEXT_SLANT_UP("textSlantUp"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 354 */   TEXT_SLANT_DOWN("textSlantDown"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 361 */   TEXT_CASCADE_UP("textCascadeUp"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 368 */   TEXT_CASCADE_DOWN("textCascadeDown");
/*     */   
/*     */   private final String value;
/*     */   
/*     */   STTextShapeType(String paramString1) {
/* 373 */     this.value = paramString1;
/*     */   }
/*     */   
/*     */   public String value() {
/* 377 */     return this.value;
/*     */   }
/*     */   
/*     */   public static STTextShapeType fromValue(String paramString) {
/* 381 */     for (STTextShapeType sTTextShapeType : values()) {
/* 382 */       if (sTTextShapeType.value.equals(paramString)) {
/* 383 */         return sTTextShapeType;
/*     */       }
/*     */     } 
/* 386 */     throw new IllegalArgumentException(paramString);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\binding\STTextShapeType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */