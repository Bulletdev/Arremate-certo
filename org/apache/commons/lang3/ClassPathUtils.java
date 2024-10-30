/*     */ package org.apache.commons.lang3;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ClassPathUtils
/*     */ {
/*     */   public static String toFullyQualifiedName(Class<?> paramClass, String paramString) {
/*  58 */     Validate.notNull(paramClass, "Parameter '%s' must not be null!", new Object[] { "context" });
/*  59 */     Validate.notNull(paramString, "Parameter '%s' must not be null!", new Object[] { "resourceName" });
/*  60 */     return toFullyQualifiedName(paramClass.getPackage(), paramString);
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
/*     */   public static String toFullyQualifiedName(Package paramPackage, String paramString) {
/*  80 */     Validate.notNull(paramPackage, "Parameter '%s' must not be null!", new Object[] { "context" });
/*  81 */     Validate.notNull(paramString, "Parameter '%s' must not be null!", new Object[] { "resourceName" });
/*  82 */     return paramPackage.getName() + "." + paramString;
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
/*     */   public static String toFullyQualifiedPath(Class<?> paramClass, String paramString) {
/* 102 */     Validate.notNull(paramClass, "Parameter '%s' must not be null!", new Object[] { "context" });
/* 103 */     Validate.notNull(paramString, "Parameter '%s' must not be null!", new Object[] { "resourceName" });
/* 104 */     return toFullyQualifiedPath(paramClass.getPackage(), paramString);
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
/*     */   public static String toFullyQualifiedPath(Package paramPackage, String paramString) {
/* 125 */     Validate.notNull(paramPackage, "Parameter '%s' must not be null!", new Object[] { "context" });
/* 126 */     Validate.notNull(paramString, "Parameter '%s' must not be null!", new Object[] { "resourceName" });
/* 127 */     return paramPackage.getName().replace('.', '/') + "/" + paramString;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\ClassPathUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */