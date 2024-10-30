/*     */ package org.apache.xmlbeans.impl.jam.internal;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintWriter;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Properties;
/*     */ import org.apache.xmlbeans.impl.jam.JamClassLoader;
/*     */ import org.apache.xmlbeans.impl.jam.JamServiceParams;
/*     */ import org.apache.xmlbeans.impl.jam.annotation.AnnotationProxy;
/*     */ import org.apache.xmlbeans.impl.jam.annotation.DefaultAnnotationProxy;
/*     */ import org.apache.xmlbeans.impl.jam.annotation.JavadocTagParser;
/*     */ import org.apache.xmlbeans.impl.jam.annotation.WhitespaceDelimitedTagParser;
/*     */ import org.apache.xmlbeans.impl.jam.internal.elements.ElementContext;
/*     */ import org.apache.xmlbeans.impl.jam.provider.CompositeJamClassBuilder;
/*     */ import org.apache.xmlbeans.impl.jam.provider.JamClassBuilder;
/*     */ import org.apache.xmlbeans.impl.jam.provider.JamLogger;
/*     */ import org.apache.xmlbeans.impl.jam.provider.JamServiceContext;
/*     */ import org.apache.xmlbeans.impl.jam.provider.ResourcePath;
/*     */ import org.apache.xmlbeans.impl.jam.visitor.CompositeMVisitor;
/*     */ import org.apache.xmlbeans.impl.jam.visitor.MVisitor;
/*     */ import org.apache.xmlbeans.impl.jam.visitor.PropertyInitializer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JamServiceContextImpl
/*     */   extends JamLoggerImpl
/*     */   implements JamServiceParams, ElementContext, JamServiceContext
/*     */ {
/*     */   private static final char INNER_CLASS_SEPARATOR = '$';
/*     */   private boolean m14WarningsEnabled = false;
/*  66 */   private Properties mProperties = null;
/*  67 */   private Map mSourceRoot2Scanner = null;
/*  68 */   private Map mClassRoot2Scanner = null;
/*     */ 
/*     */   
/*  71 */   private List mClasspath = null;
/*  72 */   private List mSourcepath = null;
/*  73 */   private List mToolClasspath = null;
/*     */   
/*  75 */   private List mIncludeClasses = null;
/*  76 */   private List mExcludeClasses = null;
/*     */ 
/*     */   
/*     */   private boolean mUseSystemClasspath = true;
/*     */ 
/*     */   
/*  82 */   private JavadocTagParser mTagParser = null;
/*  83 */   private MVisitor mCommentInitializer = null;
/*  84 */   private MVisitor mPropertyInitializer = (MVisitor)new PropertyInitializer();
/*  85 */   private List mOtherInitializers = null;
/*  86 */   private List mUnstructuredSourceFiles = null;
/*  87 */   private List mClassLoaders = null;
/*  88 */   private List mBaseBuilders = null;
/*     */   
/*  90 */   private JamClassLoader mLoader = null;
/*     */   
/*     */   private static final String PREFIX = "[JamServiceContextImpl] ";
/*     */ 
/*     */   
/*     */   public void setClassLoader(JamClassLoader paramJamClassLoader) {
/*  96 */     this.mLoader = paramJamClassLoader;
/*     */   }
/*     */   
/*     */   public JamClassBuilder getBaseBuilder() {
/* 100 */     if (this.mBaseBuilders == null || this.mBaseBuilders.size() == 0) {
/* 101 */       return null;
/*     */     }
/* 103 */     if (this.mBaseBuilders.size() == 1) {
/* 104 */       return this.mBaseBuilders.get(0);
/*     */     }
/* 106 */     JamClassBuilder[] arrayOfJamClassBuilder = new JamClassBuilder[this.mBaseBuilders.size()];
/* 107 */     this.mBaseBuilders.toArray((Object[])arrayOfJamClassBuilder);
/* 108 */     return (JamClassBuilder)new CompositeJamClassBuilder(arrayOfJamClassBuilder);
/*     */   }
/*     */   
/*     */   public JavadocTagParser getTagParser() {
/* 112 */     if (this.mTagParser == null) {
/* 113 */       this.mTagParser = (JavadocTagParser)new WhitespaceDelimitedTagParser();
/* 114 */       this.mTagParser.init(this);
/*     */     } 
/* 116 */     return this.mTagParser;
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
/*     */   public String[] getAllClassnames() throws IOException {
/* 133 */     HashSet hashSet = new HashSet();
/* 134 */     if (this.mIncludeClasses != null) hashSet.addAll(this.mIncludeClasses); 
/* 135 */     for (Iterator iterator = getAllDirectoryScanners(); iterator.hasNext(); ) {
/* 136 */       DirectoryScanner directoryScanner = iterator.next();
/* 137 */       String[] arrayOfString1 = directoryScanner.getIncludedFiles();
/* 138 */       for (byte b = 0; b < arrayOfString1.length; b++) {
/*     */ 
/*     */ 
/*     */         
/* 142 */         if (arrayOfString1[b].indexOf('$') == -1) {
/* 143 */           hashSet.add(filename2classname(arrayOfString1[b]));
/*     */         }
/*     */       } 
/*     */     } 
/* 147 */     if (this.mExcludeClasses != null) hashSet.removeAll(this.mExcludeClasses); 
/* 148 */     String[] arrayOfString = new String[hashSet.size()];
/* 149 */     hashSet.toArray(arrayOfString);
/* 150 */     return arrayOfString;
/*     */   }
/*     */   public JamLogger getLogger() {
/* 153 */     return this;
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
/*     */   public File[] getSourceFiles() throws IOException {
/* 172 */     HashSet hashSet = new HashSet();
/* 173 */     if (this.mSourceRoot2Scanner != null) {
/* 174 */       for (DirectoryScanner directoryScanner : this.mSourceRoot2Scanner.values()) {
/*     */         
/* 176 */         if (isVerbose(this)) {
/* 177 */           verbose("[JamServiceContextImpl]  checking scanner for dir" + directoryScanner.getRoot());
/*     */         }
/* 179 */         String[] arrayOfString = directoryScanner.getIncludedFiles();
/* 180 */         for (byte b = 0; b < arrayOfString.length; b++) {
/* 181 */           if (isVerbose(this)) {
/* 182 */             verbose("[JamServiceContextImpl]  ...including a source file " + arrayOfString[b]);
/*     */           }
/* 184 */           hashSet.add(new File(directoryScanner.getRoot(), arrayOfString[b]));
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 191 */     if (this.mUnstructuredSourceFiles != null) {
/* 192 */       if (isVerbose(this)) verbose("[JamServiceContextImpl] adding " + this.mUnstructuredSourceFiles.size() + " other source files");
/*     */       
/* 194 */       hashSet.addAll(this.mUnstructuredSourceFiles);
/*     */     } 
/* 196 */     File[] arrayOfFile = new File[hashSet.size()];
/* 197 */     hashSet.toArray(arrayOfFile);
/* 198 */     return arrayOfFile;
/*     */   }
/*     */   
/*     */   public File[] getUnstructuredSourceFiles() {
/* 202 */     if (this.mUnstructuredSourceFiles == null) return null; 
/* 203 */     File[] arrayOfFile = new File[this.mUnstructuredSourceFiles.size()];
/* 204 */     this.mUnstructuredSourceFiles.toArray((Object[])arrayOfFile);
/* 205 */     return arrayOfFile;
/*     */   }
/*     */   
/*     */   public ResourcePath getInputClasspath() {
/* 209 */     return createJPath(this.mClasspath);
/*     */   } public ResourcePath getInputSourcepath() {
/* 211 */     return createJPath(this.mSourcepath);
/*     */   } public ResourcePath getToolClasspath() {
/* 213 */     return createJPath(this.mToolClasspath);
/*     */   }
/*     */   public String getProperty(String paramString) {
/* 216 */     return (this.mProperties == null) ? null : this.mProperties.getProperty(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public MVisitor getInitializer() {
/* 221 */     ArrayList arrayList = new ArrayList();
/*     */ 
/*     */     
/* 224 */     if (this.mCommentInitializer != null) arrayList.add(this.mCommentInitializer);
/*     */ 
/*     */     
/* 227 */     if (this.mPropertyInitializer != null) arrayList.add(this.mPropertyInitializer); 
/* 228 */     if (this.mOtherInitializers != null) arrayList.addAll(this.mOtherInitializers);
/*     */     
/* 230 */     MVisitor[] arrayOfMVisitor = new MVisitor[arrayList.size()];
/* 231 */     arrayList.toArray(arrayOfMVisitor);
/* 232 */     return (MVisitor)new CompositeMVisitor(arrayOfMVisitor);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addClassBuilder(JamClassBuilder paramJamClassBuilder) {
/* 239 */     if (this.mBaseBuilders == null) this.mBaseBuilders = new ArrayList(); 
/* 240 */     this.mBaseBuilders.add(paramJamClassBuilder);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setCommentInitializer(MVisitor paramMVisitor) {
/* 245 */     this.mCommentInitializer = paramMVisitor;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPropertyInitializer(MVisitor paramMVisitor) {
/* 250 */     this.mPropertyInitializer = paramMVisitor;
/*     */   }
/*     */ 
/*     */   
/*     */   public void addInitializer(MVisitor paramMVisitor) {
/* 255 */     if (this.mOtherInitializers == null) this.mOtherInitializers = new ArrayList(); 
/* 256 */     this.mOtherInitializers.add(paramMVisitor);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setJavadocTagParser(JavadocTagParser paramJavadocTagParser) {
/* 261 */     this.mTagParser = paramJavadocTagParser;
/* 262 */     paramJavadocTagParser.init(this);
/*     */   }
/*     */   
/*     */   public void includeSourceFile(File paramFile) {
/* 266 */     if (paramFile == null) throw new IllegalArgumentException("null file"); 
/* 267 */     paramFile = paramFile.getAbsoluteFile();
/* 268 */     if (isVerbose(this)) verbose("[JamServiceContextImpl] adding source "); 
/* 269 */     if (!paramFile.exists()) throw new IllegalArgumentException(paramFile + " does not exist"); 
/* 270 */     if (paramFile.isDirectory()) throw new IllegalArgumentException(paramFile + " cannot be included as a source file because it is a directory.");
/*     */     
/* 272 */     if (this.mUnstructuredSourceFiles == null) {
/* 273 */       this.mUnstructuredSourceFiles = new ArrayList();
/*     */     }
/* 275 */     this.mUnstructuredSourceFiles.add(paramFile.getAbsoluteFile());
/*     */   }
/*     */   
/*     */   public void includeSourcePattern(File[] paramArrayOfFile, String paramString) {
/* 279 */     if (paramArrayOfFile == null) throw new IllegalArgumentException("null sourcepath"); 
/* 280 */     if (paramArrayOfFile.length == 0) throw new IllegalArgumentException("empty sourcepath"); 
/* 281 */     if (paramString == null) throw new IllegalArgumentException("null pattern"); 
/* 282 */     paramString = paramString.trim();
/* 283 */     if (paramString.length() == 0) throw new IllegalArgumentException("empty pattern"); 
/* 284 */     for (byte b = 0; b < paramArrayOfFile.length; b++) {
/* 285 */       if (isVerbose(this)) verbose("[JamServiceContextImpl] including '" + paramString + "' under " + paramArrayOfFile[b]); 
/* 286 */       addSourcepath(paramArrayOfFile[b]);
/* 287 */       getSourceScanner(paramArrayOfFile[b]).include(paramString);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void includeClassPattern(File[] paramArrayOfFile, String paramString) {
/* 292 */     if (paramArrayOfFile == null) throw new IllegalArgumentException("null classpath"); 
/* 293 */     if (paramArrayOfFile.length == 0) throw new IllegalArgumentException("empty classpath"); 
/* 294 */     if (paramString == null) throw new IllegalArgumentException("null pattern"); 
/* 295 */     paramString = paramString.trim();
/* 296 */     if (paramString.length() == 0) throw new IllegalArgumentException("empty pattern"); 
/* 297 */     for (byte b = 0; b < paramArrayOfFile.length; b++) {
/* 298 */       if (isVerbose(this)) verbose("[JamServiceContextImpl] including '" + paramString + "' under " + paramArrayOfFile[b]); 
/* 299 */       addClasspath(paramArrayOfFile[b]);
/* 300 */       getClassScanner(paramArrayOfFile[b]).include(paramString);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void excludeSourcePattern(File[] paramArrayOfFile, String paramString) {
/* 305 */     if (paramArrayOfFile == null) throw new IllegalArgumentException("null sourcepath"); 
/* 306 */     if (paramArrayOfFile.length == 0) throw new IllegalArgumentException("empty sourcepath"); 
/* 307 */     if (paramString == null) throw new IllegalArgumentException("null pattern"); 
/* 308 */     paramString = paramString.trim();
/* 309 */     if (paramString.length() == 0) throw new IllegalArgumentException("empty pattern"); 
/* 310 */     for (byte b = 0; b < paramArrayOfFile.length; b++) {
/* 311 */       if (isVerbose(this)) verbose("[JamServiceContextImpl] EXCLUDING '" + paramString + "' under " + paramArrayOfFile[b]); 
/* 312 */       addSourcepath(paramArrayOfFile[b]);
/* 313 */       getSourceScanner(paramArrayOfFile[b]).exclude(paramString);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void excludeClassPattern(File[] paramArrayOfFile, String paramString) {
/* 318 */     if (paramArrayOfFile == null) throw new IllegalArgumentException("null classpath"); 
/* 319 */     if (paramArrayOfFile.length == 0) throw new IllegalArgumentException("empty classpath"); 
/* 320 */     if (paramString == null) throw new IllegalArgumentException("null pattern"); 
/* 321 */     paramString = paramString.trim();
/* 322 */     if (paramString.length() == 0) throw new IllegalArgumentException("empty pattern"); 
/* 323 */     for (byte b = 0; b < paramArrayOfFile.length; b++) {
/* 324 */       if (isVerbose(this)) verbose("[JamServiceContextImpl] EXCLUDING '" + paramString + "' under " + paramArrayOfFile[b]); 
/* 325 */       addClasspath(paramArrayOfFile[b]);
/* 326 */       getClassScanner(paramArrayOfFile[b]).exclude(paramString);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void includeSourceFile(File[] paramArrayOfFile, File paramFile) {
/* 331 */     File file = getPathRootForFile(paramArrayOfFile, paramFile);
/* 332 */     includeSourcePattern(new File[] { file }, source2pattern(file, paramFile));
/*     */   }
/*     */   
/*     */   public void excludeSourceFile(File[] paramArrayOfFile, File paramFile) {
/* 336 */     File file = getPathRootForFile(paramArrayOfFile, paramFile);
/* 337 */     excludeSourcePattern(new File[] { file }, source2pattern(file, paramFile));
/*     */   }
/*     */   
/*     */   public void includeClassFile(File[] paramArrayOfFile, File paramFile) {
/* 341 */     File file = getPathRootForFile(paramArrayOfFile, paramFile);
/* 342 */     includeClassPattern(new File[] { file }, source2pattern(file, paramFile));
/*     */   }
/*     */   
/*     */   public void excludeClassFile(File[] paramArrayOfFile, File paramFile) {
/* 346 */     File file = getPathRootForFile(paramArrayOfFile, paramFile);
/* 347 */     excludeClassPattern(new File[] { file }, source2pattern(file, paramFile));
/*     */   }
/*     */   
/*     */   public void includeClass(String paramString) {
/* 351 */     if (this.mIncludeClasses == null) this.mIncludeClasses = new ArrayList(); 
/* 352 */     this.mIncludeClasses.add(paramString);
/*     */   }
/*     */   
/*     */   public void excludeClass(String paramString) {
/* 356 */     if (this.mExcludeClasses == null) this.mExcludeClasses = new ArrayList(); 
/* 357 */     this.mExcludeClasses.add(paramString);
/*     */   }
/*     */   
/*     */   public void addClasspath(File paramFile) {
/* 361 */     if (this.mClasspath == null) {
/* 362 */       this.mClasspath = new ArrayList();
/*     */     }
/* 364 */     else if (this.mClasspath.contains(paramFile)) {
/*     */       return;
/* 366 */     }  this.mClasspath.add(paramFile);
/*     */   }
/*     */   
/*     */   public void setLoggerWriter(PrintWriter paramPrintWriter) {
/* 370 */     setOut(paramPrintWriter);
/*     */   }
/*     */   
/*     */   public void setJamLogger(JamLogger paramJamLogger) {
/* 374 */     throw new IllegalStateException("NYI");
/*     */   }
/*     */ 
/*     */   
/*     */   public void addSourcepath(File paramFile) {
/* 379 */     if (this.mSourcepath == null) {
/* 380 */       this.mSourcepath = new ArrayList();
/*     */     }
/* 382 */     else if (this.mSourcepath.contains(paramFile)) {
/*     */       return;
/* 384 */     }  this.mSourcepath.add(paramFile);
/*     */   }
/*     */   
/*     */   public void addToolClasspath(File paramFile) {
/* 388 */     if (this.mToolClasspath == null) {
/* 389 */       this.mToolClasspath = new ArrayList();
/*     */     }
/* 391 */     else if (this.mToolClasspath.contains(paramFile)) {
/*     */       return;
/* 393 */     }  this.mToolClasspath.add(paramFile);
/*     */   }
/*     */   
/*     */   public void setProperty(String paramString1, String paramString2) {
/* 397 */     if (this.mProperties == null) this.mProperties = new Properties(); 
/* 398 */     this.mProperties.setProperty(paramString1, paramString2);
/*     */   }
/*     */   
/*     */   public void set14WarningsEnabled(boolean paramBoolean) {
/* 402 */     this.m14WarningsEnabled = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParentClassLoader(JamClassLoader paramJamClassLoader) {
/* 410 */     throw new IllegalStateException("NYI");
/*     */   }
/*     */   
/*     */   public void setUseSystemClasspath(boolean paramBoolean) {
/* 414 */     this.mUseSystemClasspath = paramBoolean;
/*     */   }
/*     */   
/*     */   public void addClassLoader(ClassLoader paramClassLoader) {
/* 418 */     if (this.mClassLoaders == null) this.mClassLoaders = new ArrayList(); 
/* 419 */     this.mClassLoaders.add(paramClassLoader);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ClassLoader[] getReflectionClassLoaders() {
/* 428 */     if (this.mClassLoaders == null) {
/* 429 */       if (this.mUseSystemClasspath) {
/* 430 */         return new ClassLoader[] { ClassLoader.getSystemClassLoader() };
/*     */       }
/* 432 */       return new ClassLoader[0];
/*     */     } 
/*     */     
/* 435 */     ClassLoader[] arrayOfClassLoader = new ClassLoader[this.mClassLoaders.size() + (this.mUseSystemClasspath ? 1 : 0)];
/*     */     
/* 437 */     for (byte b = 0; b < this.mClassLoaders.size(); b++) {
/* 438 */       arrayOfClassLoader[b] = this.mClassLoaders.get(b);
/*     */     }
/* 440 */     if (this.mUseSystemClasspath) {
/* 441 */       arrayOfClassLoader[arrayOfClassLoader.length - 1] = ClassLoader.getSystemClassLoader();
/*     */     }
/* 443 */     return arrayOfClassLoader;
/*     */   }
/*     */   
/*     */   public boolean is14WarningsEnabled() {
/* 447 */     return this.m14WarningsEnabled;
/*     */   }
/*     */ 
/*     */   
/*     */   public JamClassLoader getClassLoader() {
/* 452 */     return this.mLoader;
/*     */   }
/*     */   public AnnotationProxy createAnnotationProxy(String paramString) {
/* 455 */     DefaultAnnotationProxy defaultAnnotationProxy = new DefaultAnnotationProxy();
/* 456 */     defaultAnnotationProxy.init(this);
/* 457 */     return (AnnotationProxy)defaultAnnotationProxy;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private File getPathRootForFile(File[] paramArrayOfFile, File paramFile) {
/* 466 */     if (paramArrayOfFile == null) throw new IllegalArgumentException("null sourcepath"); 
/* 467 */     if (paramArrayOfFile.length == 0) throw new IllegalArgumentException("empty sourcepath"); 
/* 468 */     if (paramFile == null) throw new IllegalArgumentException("null sourceFile"); 
/* 469 */     paramFile = paramFile.getAbsoluteFile();
/* 470 */     if (isVerbose(this)) verbose("[JamServiceContextImpl] Getting root for " + paramFile + "..."); 
/* 471 */     for (byte b = 0; b < paramArrayOfFile.length; b++) {
/* 472 */       if (isVerbose(this)) verbose("[JamServiceContextImpl] ...looking in " + paramArrayOfFile[b]); 
/* 473 */       if (isContainingDir(paramArrayOfFile[b].getAbsoluteFile(), paramFile)) {
/* 474 */         if (isVerbose(this)) verbose("[JamServiceContextImpl] ...found it!"); 
/* 475 */         return paramArrayOfFile[b].getAbsoluteFile();
/*     */       } 
/*     */     } 
/* 478 */     throw new IllegalArgumentException(paramFile + " is not in the given path.");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isContainingDir(File paramFile1, File paramFile2) {
/* 485 */     if (isVerbose(this)) verbose("[JamServiceContextImpl] ... ...isContainingDir " + paramFile1 + "  " + paramFile2); 
/* 486 */     if (paramFile2 == null) return false; 
/* 487 */     if (paramFile1.equals(paramFile2)) {
/* 488 */       if (isVerbose(this)) verbose("[JamServiceContextImpl] ... ...yes!"); 
/* 489 */       return true;
/*     */     } 
/* 491 */     return isContainingDir(paramFile1, paramFile2.getParentFile());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String source2pattern(File paramFile1, File paramFile2) {
/* 499 */     if (isVerbose(this)) verbose("[JamServiceContextImpl] source2pattern " + paramFile1 + "  " + paramFile2);
/*     */     
/* 501 */     String str1 = paramFile1.getAbsolutePath();
/* 502 */     String str2 = paramFile2.getAbsolutePath();
/* 503 */     if (isVerbose(this)) {
/* 504 */       verbose("[JamServiceContextImpl] source2pattern returning " + str2.substring(str1.length() + 1));
/*     */     }
/* 506 */     return str2.substring(str1.length() + 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String filename2classname(String paramString) {
/* 515 */     int i = paramString.lastIndexOf('.');
/* 516 */     if (i != -1) paramString = paramString.substring(0, i); 
/* 517 */     paramString = paramString.replace('/', '.');
/* 518 */     paramString = paramString.replace('\\', '.');
/* 519 */     return paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Iterator getAllDirectoryScanners() {
/* 527 */     ArrayList arrayList = new ArrayList();
/* 528 */     if (this.mSourceRoot2Scanner != null) {
/* 529 */       arrayList.addAll(this.mSourceRoot2Scanner.values());
/*     */     }
/* 531 */     if (this.mClassRoot2Scanner != null) {
/* 532 */       arrayList.addAll(this.mClassRoot2Scanner.values());
/*     */     }
/* 534 */     return arrayList.iterator();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static ResourcePath createJPath(Collection paramCollection) {
/* 542 */     if (paramCollection == null || paramCollection.size() == 0) return null; 
/* 543 */     File[] arrayOfFile = new File[paramCollection.size()];
/* 544 */     paramCollection.toArray((Object[])arrayOfFile);
/* 545 */     return ResourcePath.forFiles(arrayOfFile);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private DirectoryScanner getSourceScanner(File paramFile) {
/* 553 */     if (this.mSourceRoot2Scanner == null) this.mSourceRoot2Scanner = new HashMap(); 
/* 554 */     DirectoryScanner directoryScanner = (DirectoryScanner)this.mSourceRoot2Scanner.get(paramFile);
/* 555 */     if (directoryScanner == null) {
/* 556 */       this.mSourceRoot2Scanner.put(paramFile, directoryScanner = new DirectoryScanner(paramFile, this));
/*     */     }
/* 558 */     return directoryScanner;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private DirectoryScanner getClassScanner(File paramFile) {
/* 566 */     if (this.mClassRoot2Scanner == null) this.mClassRoot2Scanner = new HashMap(); 
/* 567 */     DirectoryScanner directoryScanner = (DirectoryScanner)this.mClassRoot2Scanner.get(paramFile);
/* 568 */     if (directoryScanner == null) {
/* 569 */       this.mClassRoot2Scanner.put(paramFile, directoryScanner = new DirectoryScanner(paramFile, this));
/*     */     }
/* 571 */     return directoryScanner;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\internal\JamServiceContextImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */