/*     */ package org.h2.engine;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.util.Utils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SettingsBase
/*     */ {
/*     */   private final HashMap<String, String> settings;
/*     */   
/*     */   protected SettingsBase(HashMap<String, String> paramHashMap) {
/*  22 */     this.settings = paramHashMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean get(String paramString, boolean paramBoolean) {
/*  33 */     String str = get(paramString, "" + paramBoolean);
/*     */     try {
/*  35 */       return Boolean.parseBoolean(str);
/*  36 */     } catch (NumberFormatException numberFormatException) {
/*  37 */       throw DbException.get(22018, numberFormatException, new String[] { "key:" + paramString + " value:" + str });
/*     */     } 
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
/*     */   protected int get(String paramString, int paramInt) {
/*  50 */     String str = get(paramString, "" + paramInt);
/*     */     try {
/*  52 */       return Integer.decode(str).intValue();
/*  53 */     } catch (NumberFormatException numberFormatException) {
/*  54 */       throw DbException.get(22018, numberFormatException, new String[] { "key:" + paramString + " value:" + str });
/*     */     } 
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
/*     */   protected String get(String paramString1, String paramString2) {
/*  67 */     StringBuilder stringBuilder = new StringBuilder("h2.");
/*  68 */     boolean bool = false;
/*  69 */     for (char c : paramString1.toCharArray()) {
/*  70 */       if (c == '_') {
/*  71 */         bool = true;
/*     */       } else {
/*     */         
/*  74 */         stringBuilder.append(bool ? Character.toUpperCase(c) : Character.toLowerCase(c));
/*  75 */         bool = false;
/*     */       } 
/*     */     } 
/*  78 */     String str1 = stringBuilder.toString();
/*  79 */     String str2 = this.settings.get(paramString1);
/*  80 */     if (str2 == null) {
/*  81 */       str2 = Utils.getProperty(str1, paramString2);
/*  82 */       this.settings.put(paramString1, str2);
/*     */     } 
/*  84 */     return str2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean containsKey(String paramString) {
/*  94 */     return this.settings.containsKey(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HashMap<String, String> getSettings() {
/* 103 */     return this.settings;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\engine\SettingsBase.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */