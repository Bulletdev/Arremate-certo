/*     */ package org.apache.xmlbeans.impl.jam.annotation;
/*     */ 
/*     */ import com.sun.javadoc.SourcePosition;
/*     */ import com.sun.javadoc.Tag;
/*     */ import org.apache.xmlbeans.impl.jam.JClass;
/*     */ import org.apache.xmlbeans.impl.jam.internal.elements.ElementContext;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MAnnotatedElement;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MAnnotation;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MSourcePosition;
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
/*     */ public abstract class JavadocTagParser
/*     */ {
/*  36 */   private JamServiceContext mContext = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean mAddSingleValueMembers = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAddSingleValueMembers(boolean paramBoolean) {
/*  54 */     this.mAddSingleValueMembers = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void init(JamServiceContext paramJamServiceContext) {
/*  62 */     if (paramJamServiceContext == null) throw new IllegalArgumentException("null logger"); 
/*  63 */     if (this.mContext != null) throw new IllegalStateException("JavadocTagParser.init() called twice");
/*     */     
/*  65 */     this.mContext = paramJamServiceContext;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void parse(MAnnotatedElement paramMAnnotatedElement, Tag paramTag);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected MAnnotation[] createAnnotations(MAnnotatedElement paramMAnnotatedElement, Tag paramTag) {
/*  77 */     String str = paramTag.name().trim().substring(1);
/*     */     
/*  79 */     MAnnotation mAnnotation1 = paramMAnnotatedElement.getMutableAnnotation(str);
/*  80 */     if (mAnnotation1 == null) {
/*  81 */       mAnnotation1 = paramMAnnotatedElement.findOrCreateAnnotation(str);
/*  82 */       setPosition(mAnnotation1, paramTag);
/*     */     } 
/*  84 */     MAnnotation mAnnotation2 = paramMAnnotatedElement.addLiteralAnnotation(str);
/*  85 */     setPosition(mAnnotation2, paramTag);
/*  86 */     MAnnotation[] arrayOfMAnnotation = { mAnnotation2, mAnnotation1 };
/*  87 */     if (this.mAddSingleValueMembers) setSingleValueText(arrayOfMAnnotation, paramTag); 
/*  88 */     return arrayOfMAnnotation;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setValue(MAnnotation[] paramArrayOfMAnnotation, String paramString1, String paramString2) {
/*  97 */     paramString2 = paramString2.trim();
/*  98 */     paramString1 = paramString1.trim();
/*  99 */     for (byte b = 0; b < paramArrayOfMAnnotation.length; b++) {
/* 100 */       if (paramArrayOfMAnnotation[b].getValue(paramString1) == null)
/*     */       {
/* 102 */         paramArrayOfMAnnotation[b].setSimpleValue(paramString1, paramString2, getStringType()); } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected JamLogger getLogger() {
/* 107 */     return this.mContext.getLogger();
/*     */   }
/*     */   protected JClass getStringType() {
/* 110 */     return ((ElementContext)this.mContext).getClassLoader().loadClass("java.lang.String");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setSingleValueText(MAnnotation[] paramArrayOfMAnnotation, Tag paramTag) {
/* 118 */     String str = paramTag.text();
/* 119 */     for (byte b = 0; b < paramArrayOfMAnnotation.length; b++) {
/* 120 */       paramArrayOfMAnnotation[b].setSimpleValue("value", str, getStringType());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setPosition(MAnnotation paramMAnnotation, Tag paramTag) {
/* 130 */     SourcePosition sourcePosition = paramTag.position();
/* 131 */     if (sourcePosition != null) {
/* 132 */       MSourcePosition mSourcePosition = paramMAnnotation.createSourcePosition();
/* 133 */       mSourcePosition.setLine(sourcePosition.line());
/* 134 */       mSourcePosition.setColumn(sourcePosition.column());
/* 135 */       if (sourcePosition.file() != null) mSourcePosition.setSourceURI(sourcePosition.file().toURI()); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\annotation\JavadocTagParser.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */