/*     */ package org.apache.xmlbeans.impl.jam.annotation;
/*     */ 
/*     */ import org.apache.xmlbeans.impl.jam.JAnnotationValue;
/*     */ import org.apache.xmlbeans.impl.jam.JClass;
/*     */ import org.apache.xmlbeans.impl.jam.provider.JamLogger;
/*     */ import org.apache.xmlbeans.impl.jam.provider.JamServiceContext;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AnnotationProxy
/*     */ {
/*     */   public static final String SINGLE_MEMBER_NAME = "value";
/*     */   private static final String DEFAULT_NVPAIR_DELIMS = "\n\r";
/*     */   protected JamServiceContext mContext;
/*     */   
/*     */   public void init(JamServiceContext paramJamServiceContext) {
/*  64 */     if (paramJamServiceContext == null) throw new IllegalArgumentException("null logger"); 
/*  65 */     this.mContext = paramJamServiceContext;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void setValue(String paramString, Object paramObject, JClass paramJClass);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract JAnnotationValue[] getValues();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JAnnotationValue getValue(String paramString) {
/*  83 */     if (paramString == null) throw new IllegalArgumentException("null name");
/*     */     
/*  85 */     paramString = paramString.trim();
/*  86 */     JAnnotationValue[] arrayOfJAnnotationValue = getValues();
/*  87 */     for (byte b = 0; b < arrayOfJAnnotationValue.length; b++) {
/*     */       
/*  89 */       if (paramString.equals(arrayOfJAnnotationValue[b].getName())) return arrayOfJAnnotationValue[b]; 
/*     */     } 
/*  91 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected JamLogger getLogger() {
/* 101 */     return this.mContext.getLogger();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\annotation\AnnotationProxy.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */