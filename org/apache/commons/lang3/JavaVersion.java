/*     */ package org.apache.commons.lang3;
/*     */ 
/*     */ import org.apache.commons.lang3.math.NumberUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public enum JavaVersion
/*     */ {
/*  33 */   JAVA_0_9(1.5F, "0.9"),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  38 */   JAVA_1_1(1.1F, "1.1"),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  43 */   JAVA_1_2(1.2F, "1.2"),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  48 */   JAVA_1_3(1.3F, "1.3"),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  53 */   JAVA_1_4(1.4F, "1.4"),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  58 */   JAVA_1_5(1.5F, "1.5"),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  63 */   JAVA_1_6(1.6F, "1.6"),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  68 */   JAVA_1_7(1.7F, "1.7"),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  73 */   JAVA_1_8(1.8F, "1.8"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  80 */   JAVA_1_9(9.0F, "9"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  88 */   JAVA_9(9.0F, "9"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  95 */   JAVA_10(10.0F, "10"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 102 */   JAVA_11(11.0F, "11"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 109 */   JAVA_12(12.0F, "12"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 116 */   JAVA_13(13.0F, "13"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 123 */   JAVA_14(14.0F, "14"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 130 */   JAVA_15(15.0F, "15"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 137 */   JAVA_16(16.0F, "16"),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 142 */   JAVA_RECENT(maxVersion(), Float.toString(maxVersion()));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final float value;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final String name;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   JavaVersion(float paramFloat, String paramString1) {
/* 161 */     this.value = paramFloat;
/* 162 */     this.name = paramString1;
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
/*     */   
/*     */   public boolean atLeast(JavaVersion paramJavaVersion) {
/* 176 */     return (this.value >= paramJavaVersion.value);
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
/*     */ 
/*     */   
/*     */   public boolean atMost(JavaVersion paramJavaVersion) {
/* 191 */     return (this.value <= paramJavaVersion.value);
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
/*     */   
/*     */   static JavaVersion getJavaVersion(String paramString) {
/* 205 */     return get(paramString);
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
/*     */   static JavaVersion get(String paramString) {
/* 218 */     if (paramString == null)
/* 219 */       return null; 
/* 220 */     if ("0.9".equals(paramString))
/* 221 */       return JAVA_0_9; 
/* 222 */     if ("1.1".equals(paramString))
/* 223 */       return JAVA_1_1; 
/* 224 */     if ("1.2".equals(paramString))
/* 225 */       return JAVA_1_2; 
/* 226 */     if ("1.3".equals(paramString))
/* 227 */       return JAVA_1_3; 
/* 228 */     if ("1.4".equals(paramString))
/* 229 */       return JAVA_1_4; 
/* 230 */     if ("1.5".equals(paramString))
/* 231 */       return JAVA_1_5; 
/* 232 */     if ("1.6".equals(paramString))
/* 233 */       return JAVA_1_6; 
/* 234 */     if ("1.7".equals(paramString))
/* 235 */       return JAVA_1_7; 
/* 236 */     if ("1.8".equals(paramString))
/* 237 */       return JAVA_1_8; 
/* 238 */     if ("9".equals(paramString))
/* 239 */       return JAVA_9; 
/* 240 */     if ("10".equals(paramString))
/* 241 */       return JAVA_10; 
/* 242 */     if ("11".equals(paramString))
/* 243 */       return JAVA_11; 
/* 244 */     if ("12".equals(paramString))
/* 245 */       return JAVA_12; 
/* 246 */     if ("13".equals(paramString))
/* 247 */       return JAVA_13; 
/* 248 */     if ("14".equals(paramString))
/* 249 */       return JAVA_14; 
/* 250 */     if ("15".equals(paramString))
/* 251 */       return JAVA_15; 
/* 252 */     if ("16".equals(paramString)) {
/* 253 */       return JAVA_16;
/*     */     }
/* 255 */     float f = toFloatVersion(paramString);
/* 256 */     if (f - 1.0D < 1.0D) {
/* 257 */       int i = Math.max(paramString.indexOf('.'), paramString.indexOf(','));
/* 258 */       int j = Math.max(paramString.length(), paramString.indexOf(',', i));
/* 259 */       if (Float.parseFloat(paramString.substring(i + 1, j)) > 0.9F) {
/* 260 */         return JAVA_RECENT;
/*     */       }
/* 262 */     } else if (f > 10.0F) {
/* 263 */       return JAVA_RECENT;
/*     */     } 
/* 265 */     return null;
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
/*     */   public String toString() {
/* 278 */     return this.name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static float maxVersion() {
/* 287 */     float f = toFloatVersion(System.getProperty("java.specification.version", "99.0"));
/* 288 */     if (f > 0.0F) {
/* 289 */       return f;
/*     */     }
/* 291 */     return 99.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static float toFloatVersion(String paramString) {
/* 301 */     byte b = -1;
/* 302 */     if (paramString.contains(".")) {
/* 303 */       String[] arrayOfString = paramString.split("\\.");
/* 304 */       if (arrayOfString.length >= 2) {
/* 305 */         return NumberUtils.toFloat(arrayOfString[0] + '.' + arrayOfString[1], -1.0F);
/*     */       }
/*     */     } else {
/* 308 */       return NumberUtils.toFloat(paramString, -1.0F);
/*     */     } 
/* 310 */     return -1.0F;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\JavaVersion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */