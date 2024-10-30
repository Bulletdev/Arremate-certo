/*     */ package org.apache.commons.text.lookup;
/*     */ 
/*     */ import java.util.MissingResourceException;
/*     */ import java.util.ResourceBundle;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class ResourceBundleStringLookup
/*     */   extends AbstractStringLookup
/*     */ {
/*  40 */   static final ResourceBundleStringLookup INSTANCE = new ResourceBundleStringLookup();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final String bundleName;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ResourceBundleStringLookup() {
/*  53 */     this(null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ResourceBundleStringLookup(String paramString) {
/*  63 */     this.bundleName = paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   ResourceBundle getBundle(String paramString) {
/*  68 */     return ResourceBundle.getBundle(paramString);
/*     */   }
/*     */   
/*     */   String getString(String paramString1, String paramString2) {
/*  72 */     return getBundle(paramString1).getString(paramString2);
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
/*     */   public String lookup(String paramString) {
/*  88 */     if (paramString == null) {
/*  89 */       return null;
/*     */     }
/*  91 */     String[] arrayOfString = paramString.split(SPLIT_STR);
/*  92 */     int i = arrayOfString.length;
/*  93 */     boolean bool = (this.bundleName == null) ? true : false;
/*  94 */     if (bool && i != 2)
/*     */     {
/*  96 */       throw IllegalArgumentExceptions.format("Bad resource bundle key format [%s]; expected format is BundleName:KeyName.", new Object[] { paramString }); } 
/*  97 */     if (this.bundleName != null && i != 1) {
/*  98 */       throw IllegalArgumentExceptions.format("Bad resource bundle key format [%s]; expected format is KeyName.", new Object[] { paramString });
/*     */     }
/*     */     
/* 101 */     String str1 = bool ? arrayOfString[0] : this.bundleName;
/* 102 */     String str2 = bool ? arrayOfString[1] : arrayOfString[0];
/*     */     try {
/* 104 */       return getString(str1, str2);
/* 105 */     } catch (MissingResourceException missingResourceException) {
/*     */       
/* 107 */       return null;
/* 108 */     } catch (Exception exception) {
/*     */       
/* 110 */       throw IllegalArgumentExceptions.format(exception, "Error looking up resource bundle [%s] and key [%s].", new Object[] { str1, str2 });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 117 */     return super.toString() + " [bundleName=" + this.bundleName + "]";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\lookup\ResourceBundleStringLookup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */