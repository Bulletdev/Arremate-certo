/*     */ package org.apache.commons.text;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.ResourceBundle;
/*     */ import org.apache.commons.text.lookup.StringLookup;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Deprecated
/*     */ public abstract class StrLookup<V>
/*     */   implements StringLookup
/*     */ {
/*  47 */   private static final StrLookup<String> NONE_LOOKUP = new MapStrLookup<>(null);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  52 */   private static final StrLookup<String> SYSTEM_PROPERTIES_LOOKUP = new SystemPropertiesStrLookup();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static StrLookup<?> noneLookup() {
/*  61 */     return NONE_LOOKUP;
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
/*     */   public static StrLookup<String> systemPropertiesLookup() {
/*  74 */     return SYSTEM_PROPERTIES_LOOKUP;
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
/*     */   public static <V> StrLookup<V> mapLookup(Map<String, V> paramMap) {
/*  88 */     return new MapStrLookup<>(paramMap);
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
/*     */   public static StrLookup<String> resourceBundleLookup(ResourceBundle paramResourceBundle) {
/* 102 */     return new ResourceBundleLookup(paramResourceBundle);
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
/*     */   static class MapStrLookup<V>
/*     */     extends StrLookup<V>
/*     */   {
/*     */     private final Map<String, V> map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     MapStrLookup(Map<String, V> param1Map) {
/* 130 */       this.map = param1Map;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String lookup(String param1String) {
/* 143 */       if (this.map == null) {
/* 144 */         return null;
/*     */       }
/* 146 */       V v = this.map.get(param1String);
/* 147 */       if (v == null) {
/* 148 */         return null;
/*     */       }
/* 150 */       return v.toString();
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 155 */       return super.toString() + " [map=" + this.map + "]";
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final class ResourceBundleLookup
/*     */     extends StrLookup<String>
/*     */   {
/*     */     private final ResourceBundle resourceBundle;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private ResourceBundleLookup(ResourceBundle param1ResourceBundle) {
/* 174 */       this.resourceBundle = param1ResourceBundle;
/*     */     }
/*     */ 
/*     */     
/*     */     public String lookup(String param1String) {
/* 179 */       if (this.resourceBundle == null || param1String == null || !this.resourceBundle.containsKey(param1String)) {
/* 180 */         return null;
/*     */       }
/* 182 */       return this.resourceBundle.getString(param1String);
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 187 */       return super.toString() + " [resourceBundle=" + this.resourceBundle + "]";
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final class SystemPropertiesStrLookup
/*     */     extends StrLookup<String>
/*     */   {
/*     */     private SystemPropertiesStrLookup() {}
/*     */ 
/*     */ 
/*     */     
/*     */     public String lookup(String param1String) {
/* 202 */       if (param1String.length() > 0) {
/*     */         try {
/* 204 */           return System.getProperty(param1String);
/* 205 */         } catch (SecurityException securityException) {
/*     */           
/* 207 */           return null;
/*     */         } 
/*     */       }
/* 210 */       return null;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\StrLookup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */