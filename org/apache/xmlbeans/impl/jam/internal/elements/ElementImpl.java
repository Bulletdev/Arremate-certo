/*     */ package org.apache.xmlbeans.impl.jam.internal.elements;
/*     */ 
/*     */ import org.apache.xmlbeans.impl.jam.JElement;
/*     */ import org.apache.xmlbeans.impl.jam.JPackage;
/*     */ import org.apache.xmlbeans.impl.jam.JProperty;
/*     */ import org.apache.xmlbeans.impl.jam.JSourcePosition;
/*     */ import org.apache.xmlbeans.impl.jam.JamClassLoader;
/*     */ import org.apache.xmlbeans.impl.jam.internal.JamServiceContextImpl;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MElement;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MSourcePosition;
/*     */ import org.apache.xmlbeans.impl.jam.provider.JamLogger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class ElementImpl
/*     */   implements Comparable, MElement
/*     */ {
/*  39 */   public static final ElementImpl[] NO_NODE = new ElementImpl[0];
/*  40 */   public static final ClassImpl[] NO_CLASS = new ClassImpl[0];
/*  41 */   public static final FieldImpl[] NO_FIELD = new FieldImpl[0];
/*  42 */   public static final ConstructorImpl[] NO_CONSTRUCTOR = new ConstructorImpl[0];
/*  43 */   public static final MethodImpl[] NO_METHOD = new MethodImpl[0];
/*  44 */   public static final ParameterImpl[] NO_PARAMETER = new ParameterImpl[0];
/*  45 */   public static final JPackage[] NO_PACKAGE = new JPackage[0];
/*  46 */   public static final AnnotationImpl[] NO_ANNOTATION = new AnnotationImpl[0];
/*     */   
/*  48 */   public static final CommentImpl[] NO_COMMENT = new CommentImpl[0];
/*  49 */   public static final JProperty[] NO_PROPERTY = new JProperty[0];
/*     */ 
/*     */   
/*     */   private ElementContext mContext;
/*     */   
/*     */   protected String mSimpleName;
/*     */   
/*  56 */   private MSourcePosition mPosition = null;
/*  57 */   private Object mArtifact = null;
/*     */ 
/*     */   
/*     */   private ElementImpl mParent;
/*     */ 
/*     */   
/*     */   protected ElementImpl(ElementImpl paramElementImpl) {
/*  64 */     if (paramElementImpl == null) throw new IllegalArgumentException("null ctx"); 
/*  65 */     if (paramElementImpl == this) {
/*  66 */       throw new IllegalArgumentException("An element cannot be its own parent");
/*     */     }
/*  68 */     JElement jElement = paramElementImpl.getParent();
/*  69 */     while (jElement != null) {
/*  70 */       if (jElement == this) throw new IllegalArgumentException("cycle detected"); 
/*  71 */       jElement = jElement.getParent();
/*     */     } 
/*  73 */     this.mContext = paramElementImpl.getContext();
/*  74 */     this.mParent = paramElementImpl;
/*     */   }
/*     */   
/*     */   protected ElementImpl(ElementContext paramElementContext) {
/*  78 */     if (paramElementContext == null) throw new IllegalArgumentException("null ctx"); 
/*  79 */     this.mContext = paramElementContext;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final JElement getParent() {
/*  85 */     return (JElement)this.mParent;
/*     */   } public String getSimpleName() {
/*  87 */     return this.mSimpleName;
/*     */   } public JSourcePosition getSourcePosition() {
/*  89 */     return (JSourcePosition)this.mPosition;
/*     */   } public Object getArtifact() {
/*  91 */     return this.mArtifact;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSimpleName(String paramString) {
/*  97 */     if (paramString == null) throw new IllegalArgumentException("null name"); 
/*  98 */     this.mSimpleName = paramString.trim();
/*     */   }
/*     */   
/*     */   public MSourcePosition createSourcePosition() {
/* 102 */     return this.mPosition = new SourcePositionImpl();
/*     */   }
/*     */   
/*     */   public void removeSourcePosition() {
/* 106 */     this.mPosition = null;
/*     */   }
/*     */   
/*     */   public MSourcePosition getMutableSourcePosition() {
/* 110 */     return this.mPosition;
/*     */   }
/*     */   
/*     */   public void setArtifact(Object paramObject) {
/* 114 */     if (paramObject == null);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 119 */     if (this.mArtifact != null) {
/* 120 */       throw new IllegalStateException("artifact already set");
/*     */     }
/* 122 */     this.mArtifact = paramObject;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JamClassLoader getClassLoader() {
/* 129 */     return this.mContext.getClassLoader();
/*     */   }
/*     */   
/*     */   public static String defaultName(int paramInt) {
/* 133 */     return "unnamed_" + paramInt;
/*     */   }
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 137 */     if (this == paramObject) return true; 
/* 138 */     if (!(paramObject instanceof ElementImpl)) return false; 
/* 139 */     ElementImpl elementImpl = (ElementImpl)paramObject;
/* 140 */     String str1 = getQualifiedName();
/* 141 */     if (str1 == null) return false; 
/* 142 */     String str2 = elementImpl.getQualifiedName();
/* 143 */     if (str2 == null) return false; 
/* 144 */     return str1.equals(str2);
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 148 */     String str = getQualifiedName();
/* 149 */     return (str == null) ? 0 : str.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ElementContext getContext() {
/* 155 */     return this.mContext;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 161 */     return getQualifiedName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected JamLogger getLogger() {
/* 168 */     return ((JamServiceContextImpl)this.mContext).getLogger();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int compareTo(Object paramObject) {
/* 175 */     if (!(paramObject instanceof JElement)) {
/* 176 */       return -1;
/*     */     }
/* 178 */     return getQualifiedName().compareTo(((JElement)paramObject).getQualifiedName());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\internal\elements\ElementImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */