/*     */ package org.apache.xmlbeans.impl.jam.provider;
/*     */ 
/*     */ import org.apache.xmlbeans.impl.jam.internal.elements.ClassImpl;
/*     */ import org.apache.xmlbeans.impl.jam.internal.elements.ElementContext;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MClass;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class JamClassBuilder
/*     */ {
/*  34 */   private ElementContext mContext = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void init(ElementContext paramElementContext) {
/*  47 */     if (this.mContext != null) {
/*  48 */       throw new IllegalStateException("init called more than once");
/*     */     }
/*  50 */     if (paramElementContext == null) throw new IllegalArgumentException("null ctx"); 
/*  51 */     this.mContext = paramElementContext;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract MClass build(String paramString1, String paramString2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected MClass createClassToBuild(String paramString1, String paramString2, String[] paramArrayOfString, JamClassPopulator paramJamClassPopulator) {
/* 100 */     if (this.mContext == null) throw new IllegalStateException("init not called"); 
/* 101 */     if (paramString1 == null) throw new IllegalArgumentException("null pkg"); 
/* 102 */     if (paramString2 == null) throw new IllegalArgumentException("null class"); 
/* 103 */     if (paramJamClassPopulator == null) throw new IllegalArgumentException("null pop"); 
/* 104 */     assertInitialized();
/* 105 */     paramString2 = paramString2.replace('.', '$');
/* 106 */     return (MClass)new ClassImpl(paramString1, paramString2, this.mContext, paramArrayOfString, paramJamClassPopulator);
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
/*     */   protected MClass createClassToBuild(String paramString1, String paramString2, String[] paramArrayOfString) {
/* 127 */     if (this.mContext == null) throw new IllegalStateException("init not called"); 
/* 128 */     if (paramString1 == null) throw new IllegalArgumentException("null pkg"); 
/* 129 */     if (paramString2 == null) throw new IllegalArgumentException("null class"); 
/* 130 */     assertInitialized();
/* 131 */     paramString2 = paramString2.replace('.', '$');
/* 132 */     return (MClass)new ClassImpl(paramString1, paramString2, this.mContext, paramArrayOfString);
/*     */   }
/*     */   
/*     */   protected JamLogger getLogger() {
/* 136 */     return (JamLogger)this.mContext;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void assertInitialized() {
/* 143 */     if (this.mContext == null)
/* 144 */       throw new IllegalStateException(this + " not yet initialized."); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\provider\JamClassBuilder.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */