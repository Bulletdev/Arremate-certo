/*     */ package oshi.util;
/*     */ 
/*     */ import java.util.Properties;
/*     */ import oshi.annotation.concurrent.NotThreadSafe;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @NotThreadSafe
/*     */ public final class GlobalConfig
/*     */ {
/*     */   private static final String OSHI_PROPERTIES = "oshi.properties";
/*  44 */   private static final Properties CONFIG = FileUtil.readPropertiesFromFilename("oshi.properties");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String get(String paramString1, String paramString2) {
/*  59 */     return CONFIG.getProperty(paramString1, paramString2);
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
/*     */   public static int get(String paramString, int paramInt) {
/*  72 */     String str = CONFIG.getProperty(paramString);
/*  73 */     return (str == null) ? paramInt : ParseUtil.parseIntOrDefault(str, paramInt);
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
/*     */   public static double get(String paramString, double paramDouble) {
/*  86 */     String str = CONFIG.getProperty(paramString);
/*  87 */     return (str == null) ? paramDouble : ParseUtil.parseDoubleOrDefault(str, paramDouble);
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
/*     */   public static boolean get(String paramString, boolean paramBoolean) {
/* 100 */     String str = CONFIG.getProperty(paramString);
/* 101 */     return (str == null) ? paramBoolean : Boolean.parseBoolean(str);
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
/*     */   public static void set(String paramString, Object paramObject) {
/* 114 */     if (paramObject == null) {
/* 115 */       CONFIG.remove(paramString);
/*     */     } else {
/* 117 */       CONFIG.setProperty(paramString, paramObject.toString());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void remove(String paramString) {
/* 128 */     CONFIG.remove(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void clear() {
/* 135 */     CONFIG.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void load(Properties paramProperties) {
/* 145 */     CONFIG.putAll(paramProperties);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class PropertyException
/*     */     extends RuntimeException
/*     */   {
/*     */     private static final long serialVersionUID = -7482581936621748005L;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public PropertyException(String param1String) {
/* 160 */       super("Invalid property: \"" + param1String + "\" = " + GlobalConfig.get(param1String, (String)null));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public PropertyException(String param1String1, String param1String2) {
/* 170 */       super("Invalid property \"" + param1String1 + "\": " + param1String2);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\osh\\util\GlobalConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */