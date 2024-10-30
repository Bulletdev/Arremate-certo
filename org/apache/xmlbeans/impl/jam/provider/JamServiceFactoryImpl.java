/*     */ package org.apache.xmlbeans.impl.jam.provider;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.net.URL;
/*     */ import java.net.URLClassLoader;
/*     */ import java.util.ArrayList;
/*     */ import org.apache.xmlbeans.impl.jam.JamClassLoader;
/*     */ import org.apache.xmlbeans.impl.jam.JamService;
/*     */ import org.apache.xmlbeans.impl.jam.JamServiceFactory;
/*     */ import org.apache.xmlbeans.impl.jam.JamServiceParams;
/*     */ import org.apache.xmlbeans.impl.jam.internal.JamClassLoaderImpl;
/*     */ import org.apache.xmlbeans.impl.jam.internal.JamServiceContextImpl;
/*     */ import org.apache.xmlbeans.impl.jam.internal.JamServiceImpl;
/*     */ import org.apache.xmlbeans.impl.jam.internal.elements.ElementContext;
/*     */ import org.apache.xmlbeans.impl.jam.internal.javadoc.JavadocClassBuilder;
/*     */ import org.apache.xmlbeans.impl.jam.internal.parser.ParserClassBuilder;
/*     */ import org.apache.xmlbeans.impl.jam.internal.reflect.ReflectClassBuilder;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JamServiceFactoryImpl
/*     */   extends JamServiceFactory
/*     */ {
/*     */   public static final String USE_NEW_PARSER = "JamServiceFactoryImpl.use-new-parser";
/*     */   private static final String PREFIX = "[JamServiceFactoryImpl]";
/*     */   
/*     */   public JamServiceParams createServiceParams() {
/*  67 */     return (JamServiceParams)new JamServiceContextImpl();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public JamService createService(JamServiceParams paramJamServiceParams) throws IOException {
/*  73 */     if (!(paramJamServiceParams instanceof JamServiceContextImpl)) {
/*  74 */       throw new IllegalArgumentException("JamServiceParams must be instantiated by this JamServiceFactory.");
/*     */     }
/*     */ 
/*     */     
/*  78 */     JamClassLoader jamClassLoader = createClassLoader((JamServiceContext)paramJamServiceParams);
/*     */ 
/*     */     
/*  81 */     ((JamServiceContextImpl)paramJamServiceParams).setClassLoader(jamClassLoader);
/*     */     
/*  83 */     return (JamService)new JamServiceImpl((ElementContext)paramJamServiceParams, getSpecifiedClasses((JamServiceContext)paramJamServiceParams));
/*     */   }
/*     */ 
/*     */   
/*     */   public JamClassLoader createSystemJamClassLoader() {
/*  88 */     JamServiceParams jamServiceParams = createServiceParams();
/*  89 */     jamServiceParams.setUseSystemClasspath(true);
/*     */     try {
/*  91 */       JamService jamService = createService(jamServiceParams);
/*  92 */       return jamService.getClassLoader();
/*  93 */     } catch (IOException iOException) {
/*  94 */       iOException.printStackTrace();
/*  95 */       throw new IllegalStateException(iOException.getMessage());
/*     */     } 
/*     */   }
/*     */   
/*     */   public JamClassLoader createJamClassLoader(ClassLoader paramClassLoader) {
/* 100 */     JamServiceParams jamServiceParams = createServiceParams();
/* 101 */     jamServiceParams.setUseSystemClasspath(false);
/* 102 */     jamServiceParams.setPropertyInitializer(null);
/* 103 */     jamServiceParams.addClassLoader(paramClassLoader);
/*     */     try {
/* 105 */       JamService jamService = createService(jamServiceParams);
/* 106 */       return jamService.getClassLoader();
/* 107 */     } catch (IOException iOException) {
/* 108 */       iOException.printStackTrace();
/* 109 */       throw new IllegalStateException(iOException.getMessage());
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
/*     */ 
/*     */ 
/*     */   
/*     */   protected String[] getSpecifiedClasses(JamServiceContext paramJamServiceContext) throws IOException {
/* 125 */     return paramJamServiceContext.getAllClassnames();
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
/*     */   protected JamClassLoader createClassLoader(JamServiceContext paramJamServiceContext) throws IOException {
/* 137 */     JamClassBuilder jamClassBuilder = createBuilder(paramJamServiceContext);
/* 138 */     return (JamClassLoader)new JamClassLoaderImpl((ElementContext)paramJamServiceContext, jamClassBuilder, paramJamServiceContext.getInitializer());
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
/*     */   protected JamClassBuilder createBuilder(JamServiceContext paramJamServiceContext) throws IOException {
/* 152 */     JamLogger jamLogger = paramJamServiceContext.getLogger();
/* 153 */     ArrayList arrayList = new ArrayList();
/*     */     
/* 155 */     JamClassBuilder jamClassBuilder = paramJamServiceContext.getBaseBuilder();
/* 156 */     if (jamClassBuilder != null) arrayList.add(jamClassBuilder);
/*     */     
/* 158 */     jamClassBuilder = createSourceBuilder(paramJamServiceContext);
/* 159 */     if (jamLogger.isVerbose(this)) {
/* 160 */       jamLogger.verbose("added classbuilder for sources");
/*     */     }
/* 162 */     if (jamClassBuilder != null) arrayList.add(jamClassBuilder); 
/* 163 */     jamClassBuilder = createClassfileBuilder(paramJamServiceContext);
/* 164 */     if (jamLogger.isVerbose(this)) {
/* 165 */       jamLogger.verbose("added classbuilder for custom classpath");
/*     */     }
/* 167 */     if (jamClassBuilder != null) arrayList.add(jamClassBuilder); 
/* 168 */     ClassLoader[] arrayOfClassLoader = paramJamServiceContext.getReflectionClassLoaders();
/* 169 */     for (byte b = 0; b < arrayOfClassLoader.length; b++) {
/* 170 */       if (jamLogger.isVerbose(this)) {
/* 171 */         jamLogger.verbose("added classbuilder for classloader " + arrayOfClassLoader[b].getClass());
/*     */       }
/* 173 */       arrayList.add(new ReflectClassBuilder(arrayOfClassLoader[b]));
/*     */     } 
/* 175 */     JamClassBuilder[] arrayOfJamClassBuilder = new JamClassBuilder[arrayList.size()];
/* 176 */     arrayList.toArray(arrayOfJamClassBuilder);
/* 177 */     CompositeJamClassBuilder compositeJamClassBuilder = new CompositeJamClassBuilder(arrayOfJamClassBuilder);
/* 178 */     compositeJamClassBuilder.init((ElementContext)paramJamServiceContext);
/* 179 */     if (jamLogger.isVerbose(this)) {
/* 180 */       jamLogger.verbose("returning a composite of " + arrayOfJamClassBuilder.length + " class builders.");
/* 181 */       MClass mClass = compositeJamClassBuilder.build("java.lang", "Object");
/* 182 */       mClass = compositeJamClassBuilder.build("javax.ejb", "SessionBean");
/*     */     } 
/* 184 */     return compositeJamClassBuilder;
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
/*     */   protected JamClassBuilder createSourceBuilder(JamServiceContext paramJamServiceContext) throws IOException {
/* 196 */     File[] arrayOfFile = paramJamServiceContext.getSourceFiles();
/* 197 */     if (arrayOfFile == null || arrayOfFile.length == 0) {
/* 198 */       if (paramJamServiceContext.isVerbose(this)) {
/* 199 */         paramJamServiceContext.verbose("[JamServiceFactoryImpl]no source files present, skipping source ClassBuilder");
/*     */       }
/*     */       
/* 202 */       return null;
/*     */     } 
/* 204 */     if (paramJamServiceContext.getProperty("JamServiceFactoryImpl.use-new-parser") == null) {
/* 205 */       return (JamClassBuilder)new JavadocClassBuilder();
/*     */     }
/* 207 */     return (JamClassBuilder)new ParserClassBuilder(paramJamServiceContext);
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
/*     */   protected JamClassBuilder createClassfileBuilder(JamServiceContext paramJamServiceContext) throws IOException {
/* 222 */     ResourcePath resourcePath = paramJamServiceContext.getInputClasspath();
/* 223 */     if (resourcePath == null) {
/* 224 */       return null;
/*     */     }
/* 226 */     URL[] arrayOfURL = resourcePath.toUrlPath();
/* 227 */     URLClassLoader uRLClassLoader = new URLClassLoader(arrayOfURL);
/* 228 */     return (JamClassBuilder)new ReflectClassBuilder(uRLClassLoader);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\provider\JamServiceFactoryImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */