/*     */ package org.apache.poi.hpsf.wellknown;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import org.apache.poi.util.StringUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SectionIDMap
/*     */   extends HashMap
/*     */ {
/*  44 */   public static final byte[] SUMMARY_INFORMATION_ID = new byte[] { -14, -97, -123, -32, 79, -7, 16, 104, -85, -111, 8, 0, 43, 39, -77, -39 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  56 */   public static final byte[][] DOCUMENT_SUMMARY_INFORMATION_ID = new byte[][] { { -43, -51, -43, 2, 46, -100, 16, 27, -109, -105, 8, 0, 43, 44, -7, -82 }, { -43, -51, -43, 5, 46, -100, 16, 27, -109, -105, 8, 0, 43, 44, -7, -82 } };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String UNDEFINED = "[undefined]";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static SectionIDMap defaultMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static SectionIDMap getInstance() {
/*  93 */     if (defaultMap == null) {
/*     */       
/*  95 */       SectionIDMap sectionIDMap = new SectionIDMap();
/*  96 */       sectionIDMap.put(SUMMARY_INFORMATION_ID, PropertyIDMap.getSummaryInformationProperties());
/*     */       
/*  98 */       sectionIDMap.put(DOCUMENT_SUMMARY_INFORMATION_ID[0], PropertyIDMap.getDocumentSummaryInformationProperties());
/*     */       
/* 100 */       defaultMap = sectionIDMap;
/*     */     } 
/* 102 */     return defaultMap;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getPIDString(byte[] paramArrayOfbyte, long paramLong) {
/* 123 */     PropertyIDMap propertyIDMap = getInstance().get(paramArrayOfbyte);
/* 124 */     if (propertyIDMap == null) {
/* 125 */       return "[undefined]";
/*     */     }
/* 127 */     String str = (String)propertyIDMap.get(paramLong);
/* 128 */     if (str == null)
/* 129 */       return "[undefined]"; 
/* 130 */     return str;
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
/*     */   public PropertyIDMap get(byte[] paramArrayOfbyte) {
/* 144 */     return (PropertyIDMap)get(new String(paramArrayOfbyte, StringUtil.UTF8));
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
/*     */   public PropertyIDMap put(byte[] paramArrayOfbyte, PropertyIDMap paramPropertyIDMap) {
/* 158 */     return (PropertyIDMap)put((K)new String(paramArrayOfbyte, StringUtil.UTF8), (V)paramPropertyIDMap);
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
/*     */   protected PropertyIDMap put(String paramString, PropertyIDMap paramPropertyIDMap) {
/* 171 */     return (PropertyIDMap)put((K)paramString, (V)paramPropertyIDMap);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hpsf\wellknown\SectionIDMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */