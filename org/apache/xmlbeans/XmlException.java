/*     */ package org.apache.xmlbeans;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XmlException
/*     */   extends Exception
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private List _errors;
/*     */   
/*     */   public XmlException(String paramString) {
/*  38 */     super(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public XmlException(String paramString, Throwable paramThrowable) {
/*  43 */     super(paramString, paramThrowable);
/*     */   }
/*     */ 
/*     */   
/*     */   public XmlException(Throwable paramThrowable) {
/*  48 */     super(paramThrowable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlException(XmlError paramXmlError) {
/*  55 */     this(paramXmlError.toString(), (Throwable)null, paramXmlError);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlException(String paramString, Throwable paramThrowable, XmlError paramXmlError) {
/*  63 */     this(paramString, paramThrowable, Collections.singletonList(paramXmlError));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlException(String paramString, Throwable paramThrowable, Collection paramCollection) {
/*  71 */     super(paramString, paramThrowable);
/*     */     
/*  73 */     if (paramCollection != null) {
/*  74 */       this._errors = Collections.unmodifiableList(new ArrayList(paramCollection));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlException(XmlRuntimeException paramXmlRuntimeException) {
/*  82 */     super(paramXmlRuntimeException.getMessage(), paramXmlRuntimeException.getCause());
/*     */ 
/*     */     
/*  85 */     Collection collection = paramXmlRuntimeException.getErrors();
/*     */     
/*  87 */     if (collection != null) {
/*  88 */       this._errors = Collections.unmodifiableList(new ArrayList(collection));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlError getError() {
/*  96 */     if (this._errors == null || this._errors.size() == 0) {
/*  97 */       return null;
/*     */     }
/*  99 */     return this._errors.get(0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Collection getErrors() {
/* 107 */     return this._errors;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlException.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */