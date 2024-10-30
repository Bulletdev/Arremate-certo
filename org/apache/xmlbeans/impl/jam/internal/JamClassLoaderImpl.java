/*     */ package org.apache.xmlbeans.impl.jam.internal;
/*     */ 
/*     */ import java.lang.ref.WeakReference;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Stack;
/*     */ import org.apache.xmlbeans.impl.jam.JClass;
/*     */ import org.apache.xmlbeans.impl.jam.JPackage;
/*     */ import org.apache.xmlbeans.impl.jam.JamClassLoader;
/*     */ import org.apache.xmlbeans.impl.jam.internal.elements.ArrayClassImpl;
/*     */ import org.apache.xmlbeans.impl.jam.internal.elements.ClassImpl;
/*     */ import org.apache.xmlbeans.impl.jam.internal.elements.ElementContext;
/*     */ import org.apache.xmlbeans.impl.jam.internal.elements.PackageImpl;
/*     */ import org.apache.xmlbeans.impl.jam.internal.elements.PrimitiveClassImpl;
/*     */ import org.apache.xmlbeans.impl.jam.internal.elements.UnresolvedClassImpl;
/*     */ import org.apache.xmlbeans.impl.jam.internal.elements.VoidClassImpl;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MClass;
/*     */ import org.apache.xmlbeans.impl.jam.provider.JamClassBuilder;
/*     */ import org.apache.xmlbeans.impl.jam.visitor.MVisitor;
/*     */ import org.apache.xmlbeans.impl.jam.visitor.TraversingMVisitor;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JamClassLoaderImpl
/*     */   implements JamClassLoader
/*     */ {
/*  48 */   private Map mName2Package = new HashMap();
/*  49 */   private Map mFd2ClassCache = new HashMap();
/*     */   private JamClassBuilder mBuilder;
/*  51 */   private MVisitor mInitializer = null;
/*     */   private ElementContext mContext;
/*  53 */   private Stack mInitializeStack = new Stack();
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean mAlreadyInitializing = false;
/*     */ 
/*     */ 
/*     */   
/*     */   public JamClassLoaderImpl(ElementContext paramElementContext, JamClassBuilder paramJamClassBuilder, MVisitor paramMVisitor) {
/*  62 */     if (paramJamClassBuilder == null) throw new IllegalArgumentException("null builder"); 
/*  63 */     if (paramElementContext == null) throw new IllegalArgumentException("null builder"); 
/*  64 */     this.mBuilder = paramJamClassBuilder;
/*  65 */     this.mInitializer = (paramMVisitor == null) ? null : (MVisitor)new TraversingMVisitor(paramMVisitor);
/*     */     
/*  67 */     this.mContext = paramElementContext;
/*  68 */     initCache();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final JClass loadClass(String paramString) {
/*     */     UnresolvedClassImpl unresolvedClassImpl;
/*     */     String str1, str2;
/*  76 */     paramString = paramString.trim();
/*  77 */     JClass jClass = cacheGet(paramString);
/*  78 */     if (jClass != null) return jClass; 
/*  79 */     if (paramString.indexOf('[') != -1) {
/*  80 */       String str = ArrayClassImpl.normalizeArrayName(paramString);
/*  81 */       jClass = cacheGet(str);
/*  82 */       if (jClass == null) {
/*  83 */         jClass = ArrayClassImpl.createClassForFD(str, this);
/*  84 */         cachePut(jClass, str);
/*     */       } 
/*  86 */       cachePut(jClass, paramString);
/*  87 */       return jClass;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  93 */     int i = paramString.indexOf('$');
/*  94 */     if (i != -1) {
/*  95 */       str1 = paramString.substring(0, i);
/*  96 */       ((ClassImpl)loadClass(str1)).ensureLoaded();
/*  97 */       jClass = cacheGet(paramString);
/*     */       
/*  99 */       int j = paramString.lastIndexOf('.');
/* 100 */       if (jClass == null) {
/*     */         String str3, str4;
/*     */         
/* 103 */         if (j == -1) {
/* 104 */           str3 = "";
/* 105 */           str4 = paramString;
/*     */         } else {
/* 107 */           str3 = paramString.substring(0, j);
/* 108 */           str4 = paramString.substring(j + 1);
/*     */         } 
/* 110 */         unresolvedClassImpl = new UnresolvedClassImpl(str3, str4, this.mContext);
/* 111 */         this.mContext.warning("failed to resolve class " + paramString);
/* 112 */         cachePut((JClass)unresolvedClassImpl);
/*     */       } 
/* 114 */       return (JClass)unresolvedClassImpl;
/*     */     } 
/*     */ 
/*     */     
/* 118 */     i = paramString.lastIndexOf('.');
/*     */ 
/*     */     
/* 121 */     if (i == -1) {
/* 122 */       str1 = "";
/* 123 */       str2 = paramString;
/*     */     } else {
/* 125 */       str1 = paramString.substring(0, i);
/* 126 */       str2 = paramString.substring(i + 1);
/*     */     } 
/* 128 */     MClass mClass = this.mBuilder.build(str1, str2);
/* 129 */     if (mClass == null) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 134 */       unresolvedClassImpl = new UnresolvedClassImpl(str1, str2, this.mContext);
/* 135 */       this.mContext.warning("failed to resolve class " + paramString);
/* 136 */       cachePut((JClass)unresolvedClassImpl);
/* 137 */       return (JClass)unresolvedClassImpl;
/*     */     } 
/* 139 */     cachePut((JClass)unresolvedClassImpl);
/* 140 */     return (JClass)unresolvedClassImpl;
/*     */   }
/*     */   public JPackage getPackage(String paramString) {
/*     */     PackageImpl packageImpl;
/* 144 */     JPackage jPackage = (JPackage)this.mName2Package.get(paramString);
/* 145 */     if (jPackage == null) {
/* 146 */       packageImpl = new PackageImpl(this.mContext, paramString);
/* 147 */       this.mName2Package.put(paramString, packageImpl);
/*     */     } 
/* 149 */     return (JPackage)packageImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void initCache() {
/* 159 */     PrimitiveClassImpl.mapNameToPrimitive(this.mContext, this.mFd2ClassCache);
/* 160 */     this.mFd2ClassCache.put("void", new VoidClassImpl(this.mContext));
/*     */   }
/*     */   
/*     */   private void cachePut(JClass paramJClass) {
/* 164 */     this.mFd2ClassCache.put(paramJClass.getFieldDescriptor().trim(), new WeakReference(paramJClass));
/*     */   }
/*     */ 
/*     */   
/*     */   private void cachePut(JClass paramJClass, String paramString) {
/* 169 */     this.mFd2ClassCache.put(paramString, new WeakReference(paramJClass));
/*     */   }
/*     */   
/*     */   private JClass cacheGet(String paramString) {
/* 173 */     Object object = this.mFd2ClassCache.get(paramString.trim());
/* 174 */     if (object == null) return null; 
/* 175 */     if (object instanceof JClass) return (JClass)object; 
/* 176 */     if (object instanceof WeakReference) {
/* 177 */       object = ((WeakReference)object).get();
/* 178 */       if (object == null) {
/* 179 */         this.mFd2ClassCache.remove(paramString.trim());
/* 180 */         return null;
/*     */       } 
/* 182 */       return (JClass)object;
/*     */     } 
/*     */     
/* 185 */     throw new IllegalStateException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initialize(ClassImpl paramClassImpl) {
/* 193 */     if (this.mInitializer != null)
/*     */     {
/*     */       
/* 196 */       if (this.mAlreadyInitializing) {
/*     */         
/* 198 */         this.mInitializeStack.push(paramClassImpl);
/*     */       } else {
/* 200 */         paramClassImpl.accept(this.mInitializer);
/* 201 */         while (!this.mInitializeStack.isEmpty()) {
/* 202 */           ClassImpl classImpl = this.mInitializeStack.pop();
/* 203 */           classImpl.accept(this.mInitializer);
/*     */         } 
/* 205 */         this.mAlreadyInitializing = false;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Collection getResolvedClasses() {
/* 215 */     return Collections.unmodifiableCollection(this.mFd2ClassCache.values());
/*     */   }
/*     */ 
/*     */   
/*     */   public void addToCache(JClass paramJClass) {
/* 220 */     cachePut(paramJClass);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\internal\JamClassLoaderImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */