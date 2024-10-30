/*     */ package org.apache.xmlbeans.impl.tool;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintWriter;
/*     */ import java.io.StringWriter;
/*     */ import java.net.URI;
/*     */ import java.util.AbstractCollection;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import java.util.StringTokenizer;
/*     */ import org.apache.tools.ant.BuildException;
/*     */ import org.apache.tools.ant.DirectoryScanner;
/*     */ import org.apache.tools.ant.Project;
/*     */ import org.apache.tools.ant.taskdefs.Jar;
/*     */ import org.apache.tools.ant.taskdefs.Javac;
/*     */ import org.apache.tools.ant.taskdefs.MatchingTask;
/*     */ import org.apache.tools.ant.types.FileSet;
/*     */ import org.apache.tools.ant.types.Path;
/*     */ import org.apache.tools.ant.types.Reference;
/*     */ import org.apache.xmlbeans.XmlError;
/*     */ import org.apache.xmlbeans.impl.common.IOUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XMLBean
/*     */   extends MatchingTask
/*     */ {
/*  51 */   private ArrayList schemas = new ArrayList();
/*     */   
/*     */   private Set mdefnamespaces;
/*     */   
/*     */   private Path classpath;
/*     */   
/*     */   private File destfile;
/*     */   
/*     */   private File schema;
/*     */   
/*     */   private File srcgendir;
/*     */   
/*     */   private File classgendir;
/*     */   private boolean quiet;
/*     */   private boolean verbose;
/*     */   private boolean debug;
/*     */   private boolean optimize;
/*     */   private boolean download;
/*     */   private boolean srconly;
/*     */   private boolean noupa;
/*     */   private boolean nopvr;
/*     */   private boolean noann;
/*     */   private boolean novdoc;
/*     */   private boolean noext = false;
/*     */   private boolean failonerror = true;
/*     */   private boolean fork = true;
/*     */   private boolean includeAntRuntime = true;
/*     */   private boolean noSrcRegen;
/*     */   private boolean includeJavaRuntime = false;
/*     */   private String typesystemname;
/*     */   private String forkedExecutable;
/*     */   private String compiler;
/*     */   private String debugLevel;
/*     */   private String memoryInitialSize;
/*     */   private String memoryMaximumSize;
/*     */   private String catalog;
/*     */   private String javasource;
/*  88 */   private List extensions = new ArrayList();
/*     */   
/*  90 */   private HashMap _extRouter = new HashMap(5);
/*     */   
/*     */   private static final String XSD = ".xsd";
/*     */   
/*     */   private static final String WSDL = ".wsdl";
/*     */   
/*     */   private static final String JAVA = ".java";
/*     */   
/*     */   private static final String XSDCONFIG = ".xsdconfig";
/*     */ 
/*     */   
/*     */   public void execute() throws BuildException {
/* 102 */     if (this.schemas.size() == 0 && this.schema == null && this.fileset.getDir(this.project) == null) {
/*     */ 
/*     */ 
/*     */       
/* 106 */       String str = "The 'schema' or 'dir' attribute or a nested fileset is required.";
/* 107 */       if (this.failonerror) {
/* 108 */         throw new BuildException(str);
/*     */       }
/*     */       
/* 111 */       log(str, 0);
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 116 */     this._extRouter.put(".xsd", new HashSet());
/* 117 */     this._extRouter.put(".wsdl", new HashSet());
/* 118 */     this._extRouter.put(".java", new HashSet());
/* 119 */     this._extRouter.put(".xsdconfig", new HashSet());
/*     */     
/* 121 */     File file = this.schema;
/*     */     
/* 123 */     if (this.schema != null)
/*     */     {
/* 125 */       if (this.schema.isDirectory()) {
/*     */         
/* 127 */         DirectoryScanner directoryScanner = getDirectoryScanner(this.schema);
/* 128 */         String[] arrayOfString = directoryScanner.getIncludedFiles();
/* 129 */         processPaths(arrayOfString, directoryScanner.getBasedir());
/*     */       }
/*     */       else {
/*     */         
/* 133 */         file = this.schema.getParentFile();
/* 134 */         processPaths(new String[] { this.schema.getName() }, file);
/*     */       } 
/*     */     }
/*     */     
/* 138 */     if (this.fileset.getDir(this.project) != null) {
/* 139 */       this.schemas.add(this.fileset);
/*     */     }
/* 141 */     Iterator iterator = this.schemas.iterator();
/* 142 */     while (iterator.hasNext()) {
/*     */       
/* 144 */       FileSet fileSet = iterator.next();
/* 145 */       DirectoryScanner directoryScanner = fileSet.getDirectoryScanner(this.project);
/* 146 */       File file1 = directoryScanner.getBasedir();
/* 147 */       String[] arrayOfString = directoryScanner.getIncludedFiles();
/*     */       
/* 149 */       processPaths(arrayOfString, file1);
/*     */     } 
/*     */     
/* 152 */     Set set1 = (Set)this._extRouter.get(".xsd");
/* 153 */     Set set2 = (Set)this._extRouter.get(".wsdl");
/*     */     
/* 155 */     if (set1.size() + set2.size() == 0) {
/*     */       
/* 157 */       log("Could not find any xsd or wsdl files to process.", 1);
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 162 */     Set set3 = (Set)this._extRouter.get(".java");
/* 163 */     Set set4 = (Set)this._extRouter.get(".xsdconfig");
/*     */     
/* 165 */     if (this.srcgendir == null && this.srconly) {
/* 166 */       this.srcgendir = this.classgendir;
/*     */     }
/* 168 */     if (this.destfile == null && this.classgendir == null && !this.srconly) {
/* 169 */       this.destfile = new File("xmltypes.jar");
/*     */     }
/* 171 */     if (this.verbose) {
/* 172 */       this.quiet = false;
/*     */     }
/*     */ 
/*     */     
/* 176 */     File[] arrayOfFile1 = (File[])set1.toArray((Object[])new File[set1.size()]);
/* 177 */     File[] arrayOfFile2 = (File[])set2.toArray((Object[])new File[set2.size()]);
/* 178 */     File[] arrayOfFile3 = (File[])set3.toArray((Object[])new File[set3.size()]);
/* 179 */     File[] arrayOfFile4 = (File[])set4.toArray((Object[])new File[set4.size()]);
/* 180 */     ErrorLogger errorLogger = new ErrorLogger(this.verbose);
/*     */     
/* 182 */     boolean bool = false;
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 187 */       File file1 = null;
/* 188 */       if (this.srcgendir == null || this.classgendir == null)
/*     */       {
/* 190 */         file1 = SchemaCodeGenerator.createTempDir();
/*     */       }
/* 192 */       if (this.srcgendir == null)
/* 193 */         this.srcgendir = IOUtil.createDir(file1, "src"); 
/* 194 */       if (this.classgendir == null) {
/* 195 */         this.classgendir = IOUtil.createDir(file1, "classes");
/*     */       }
/*     */       
/* 198 */       if (this.classpath == null) {
/*     */         
/* 200 */         this.classpath = new Path(this.project);
/* 201 */         this.classpath.concatSystemClasspath();
/*     */       } 
/*     */ 
/*     */       
/* 205 */       Path.PathElement pathElement = this.classpath.createPathElement();
/* 206 */       pathElement.setLocation(this.classgendir);
/*     */       
/* 208 */       String[] arrayOfString = this.classpath.list();
/* 209 */       File[] arrayOfFile = new File[arrayOfString.length];
/* 210 */       for (byte b = 0; b < arrayOfString.length; b++) {
/* 211 */         arrayOfFile[b] = new File(arrayOfString[b]);
/*     */       }
/*     */       
/* 214 */       SchemaCompiler.Parameters parameters = new SchemaCompiler.Parameters();
/* 215 */       parameters.setBaseDir(file);
/* 216 */       parameters.setXsdFiles(arrayOfFile1);
/* 217 */       parameters.setWsdlFiles(arrayOfFile2);
/* 218 */       parameters.setJavaFiles(arrayOfFile3);
/* 219 */       parameters.setConfigFiles(arrayOfFile4);
/* 220 */       parameters.setClasspath(arrayOfFile);
/* 221 */       parameters.setName(this.typesystemname);
/* 222 */       parameters.setSrcDir(this.srcgendir);
/* 223 */       parameters.setClassesDir(this.classgendir);
/* 224 */       parameters.setNojavac(true);
/* 225 */       parameters.setDebug(this.debug);
/* 226 */       parameters.setVerbose(this.verbose);
/* 227 */       parameters.setQuiet(this.quiet);
/* 228 */       parameters.setDownload(this.download);
/* 229 */       parameters.setExtensions(this.extensions);
/* 230 */       parameters.setErrorListener(errorLogger);
/* 231 */       parameters.setCatalogFile(this.catalog);
/* 232 */       parameters.setIncrementalSrcGen(this.noSrcRegen);
/* 233 */       parameters.setMdefNamespaces(this.mdefnamespaces);
/* 234 */       parameters.setNoUpa(this.noupa);
/* 235 */       parameters.setNoPvr(this.nopvr);
/* 236 */       parameters.setNoAnn(this.noann);
/* 237 */       parameters.setNoVDoc(this.novdoc);
/* 238 */       parameters.setNoExt(this.noext);
/* 239 */       parameters.setJavaSource(this.javasource);
/* 240 */       bool = SchemaCompiler.compile(parameters);
/*     */       
/* 242 */       if (bool && !this.srconly) {
/* 243 */         long l1 = System.currentTimeMillis();
/*     */ 
/*     */         
/* 246 */         Javac javac = new Javac();
/* 247 */         javac.setProject(this.project);
/* 248 */         javac.setTaskName(getTaskName());
/* 249 */         javac.setClasspath(this.classpath);
/* 250 */         if (this.compiler != null) javac.setCompiler(this.compiler); 
/* 251 */         javac.setDebug(this.debug);
/* 252 */         if (this.debugLevel != null) javac.setDebugLevel(this.debugLevel); 
/* 253 */         javac.setDestdir(this.classgendir);
/* 254 */         javac.setExecutable(this.forkedExecutable);
/* 255 */         javac.setFailonerror(this.failonerror);
/* 256 */         javac.setFork(this.fork);
/* 257 */         if (this.javasource != null) {
/*     */           
/* 259 */           javac.setSource(this.javasource);
/* 260 */           javac.setTarget(this.javasource);
/*     */         }
/*     */         else {
/*     */           
/* 264 */           javac.setSource("1.4");
/* 265 */           javac.setTarget("1.4");
/*     */         } 
/* 267 */         javac.setIncludeantruntime(this.includeAntRuntime);
/* 268 */         javac.setIncludejavaruntime(this.includeJavaRuntime);
/* 269 */         javac.setSrcdir(new Path(this.project, this.srcgendir.getAbsolutePath()));
/* 270 */         if (this.memoryInitialSize != null) javac.setMemoryInitialSize(this.memoryInitialSize); 
/* 271 */         if (this.memoryMaximumSize != null) javac.setMemoryMaximumSize(this.memoryMaximumSize); 
/* 272 */         javac.setOptimize(this.optimize);
/* 273 */         javac.setVerbose(this.verbose);
/* 274 */         javac.execute();
/*     */         
/* 276 */         long l2 = System.currentTimeMillis();
/* 277 */         if (!this.quiet) {
/* 278 */           log("Time to compile code: " + ((l2 - l1) / 1000.0D) + " seconds");
/*     */         }
/* 280 */         if (this.destfile != null) {
/*     */ 
/*     */           
/* 283 */           Jar jar = new Jar();
/* 284 */           jar.setProject(this.project);
/* 285 */           jar.setTaskName(getTaskName());
/* 286 */           jar.setBasedir(this.classgendir);
/* 287 */           jar.setDestFile(this.destfile);
/* 288 */           jar.execute();
/*     */         } 
/*     */       } 
/*     */       
/* 292 */       if (file1 != null) {
/* 293 */         SchemaCodeGenerator.tryHardToDelete(file1);
/*     */       }
/*     */     }
/* 296 */     catch (BuildException buildException) {
/*     */ 
/*     */       
/* 299 */       throw buildException;
/*     */     }
/* 301 */     catch (Throwable throwable) {
/*     */ 
/*     */       
/* 304 */       if (throwable instanceof InterruptedException || this.failonerror) {
/* 305 */         throw new BuildException(throwable);
/*     */       }
/* 307 */       log("Exception while building schemas: " + throwable.getMessage(), 0);
/* 308 */       StringWriter stringWriter = new StringWriter();
/* 309 */       throwable.printStackTrace(new PrintWriter(stringWriter));
/* 310 */       log(stringWriter.toString(), 3);
/*     */     } 
/*     */     
/* 313 */     if (!bool && this.failonerror) {
/* 314 */       throw new BuildException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void processPaths(String[] paramArrayOfString, File paramFile) {
/* 319 */     for (byte b = 0; b < paramArrayOfString.length; b++) {
/*     */       
/* 321 */       int i = paramArrayOfString[b].lastIndexOf('.');
/* 322 */       if (i > -1) {
/*     */         
/* 324 */         String str1 = paramArrayOfString[b];
/* 325 */         String str2 = str1.substring(i).toLowerCase();
/* 326 */         Set set = (Set)this._extRouter.get(str2);
/*     */         
/* 328 */         if (set != null) {
/* 329 */           set.add(new File(paramFile, str1));
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addFileset(FileSet paramFileSet) {
/* 336 */     this.schemas.add(paramFileSet);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public File getSchema() {
/* 343 */     return this.schema;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSchema(File paramFile) {
/* 354 */     this.schema = paramFile;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setClasspath(Path paramPath) {
/* 365 */     if (this.classpath != null) {
/* 366 */       this.classpath.append(paramPath);
/*     */     } else {
/* 368 */       this.classpath = paramPath;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Path createClasspath() {
/* 375 */     if (this.classpath == null) {
/* 376 */       this.classpath = new Path(this.project);
/*     */     }
/* 378 */     return this.classpath.createPath();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setClasspathRef(Reference paramReference) {
/* 387 */     if (this.classpath == null) {
/* 388 */       this.classpath = new Path(this.project);
/*     */     }
/* 390 */     this.classpath.createPath().setRefid(paramReference);
/*     */   }
/*     */ 
/*     */   
/*     */   public Path getClasspath() {
/* 395 */     return this.classpath;
/*     */   }
/*     */ 
/*     */   
/*     */   public File getDestfile() {
/* 400 */     return this.destfile;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDestfile(File paramFile) {
/* 411 */     this.destfile = paramFile;
/*     */   }
/*     */ 
/*     */   
/*     */   public File getSrcgendir() {
/* 416 */     return this.srcgendir;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSrcgendir(File paramFile) {
/* 426 */     this.srcgendir = paramFile;
/*     */   }
/*     */ 
/*     */   
/*     */   public File getClassgendir() {
/* 431 */     return this.classgendir;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setClassgendir(File paramFile) {
/* 441 */     this.classgendir = paramFile;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCompiler(String paramString) {
/* 451 */     this.compiler = paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDownload() {
/* 456 */     return this.download;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDownload(boolean paramBoolean) {
/* 467 */     this.download = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOptimize(boolean paramBoolean) {
/* 474 */     this.optimize = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getOptimize() {
/* 479 */     return this.optimize;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isVerbose() {
/* 484 */     return this.verbose;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVerbose(boolean paramBoolean) {
/* 493 */     this.verbose = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isQuiet() {
/* 498 */     return this.quiet;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setQuiet(boolean paramBoolean) {
/* 507 */     this.quiet = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDebug() {
/* 512 */     return this.debug;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDebugLevel() {
/* 520 */     return this.debugLevel;
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
/*     */   public void setDebugLevel(String paramString) {
/* 536 */     this.debugLevel = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDebug(boolean paramBoolean) {
/* 545 */     this.debug = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFork(boolean paramBoolean) {
/* 554 */     this.fork = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setExecutable(String paramString) {
/* 564 */     this.forkedExecutable = paramString;
/*     */   }
/*     */   
/*     */   public String getExecutable() {
/* 568 */     return this.forkedExecutable;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isSrconly() {
/* 573 */     return this.srconly;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSrconly(boolean paramBoolean) {
/* 583 */     this.srconly = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getTypesystemname() {
/* 588 */     return this.typesystemname;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Extension createExtension() {
/* 596 */     Extension extension = new Extension();
/* 597 */     this.extensions.add(extension);
/* 598 */     return extension;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIgnoreDuplicatesInNamespaces(String paramString) {
/* 606 */     this.mdefnamespaces = new HashSet();
/* 607 */     StringTokenizer stringTokenizer = new StringTokenizer(paramString, ",");
/* 608 */     while (stringTokenizer.hasMoreTokens()) {
/*     */       
/* 610 */       String str = stringTokenizer.nextToken().trim();
/* 611 */       this.mdefnamespaces.add(str);
/*     */     } 
/*     */   }
/*     */   
/*     */   public String getIgnoreDuplicatesInNamespaces() {
/* 616 */     if (this.mdefnamespaces == null) {
/* 617 */       return null;
/*     */     }
/* 619 */     StringBuffer stringBuffer = new StringBuffer();
/* 620 */     Iterator iterator = this.mdefnamespaces.iterator();
/* 621 */     while (iterator.hasNext()) {
/* 622 */       stringBuffer.append(iterator.next());
/* 623 */       if (iterator.hasNext()) {
/* 624 */         stringBuffer.append(",");
/*     */       }
/*     */     } 
/* 627 */     return stringBuffer.toString();
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
/*     */   public void setTypesystemname(String paramString) {
/* 639 */     this.typesystemname = paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isFailonerror() {
/* 644 */     return this.failonerror;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFailonerror(boolean paramBoolean) {
/* 654 */     this.failonerror = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isIncludeAntRuntime() {
/* 659 */     return this.includeAntRuntime;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setIncludeAntRuntime(boolean paramBoolean) {
/* 664 */     this.includeAntRuntime = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isIncludeJavaRuntime() {
/* 669 */     return this.includeJavaRuntime;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setIncludeJavaRuntime(boolean paramBoolean) {
/* 674 */     this.includeJavaRuntime = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isNoSrcRegen() {
/* 679 */     return this.noSrcRegen;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setNoSrcRegen(boolean paramBoolean) {
/* 684 */     this.noSrcRegen = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMemoryInitialSize() {
/* 692 */     return this.memoryInitialSize;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setMemoryInitialSize(String paramString) {
/* 697 */     this.memoryInitialSize = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMemoryMaximumSize() {
/* 705 */     return this.memoryMaximumSize;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setMemoryMaximumSize(String paramString) {
/* 710 */     this.memoryMaximumSize = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNoUpa(boolean paramBoolean) {
/* 718 */     this.noupa = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isNoUpa() {
/* 723 */     return this.noupa;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNoPvr(boolean paramBoolean) {
/* 731 */     this.nopvr = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isNoPvr() {
/* 736 */     return this.nopvr;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNoAnnotations(boolean paramBoolean) {
/* 744 */     this.noann = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isNoAnnotations() {
/* 749 */     return this.noann;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNoValidateDoc(boolean paramBoolean) {
/* 757 */     this.novdoc = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isNoValidateDoc() {
/* 762 */     return this.novdoc;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNoExt(boolean paramBoolean) {
/* 771 */     this.noext = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isNoExt() {
/* 776 */     return this.noext;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setJavaSource(String paramString) {
/* 785 */     this.javasource = paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getJavaSource() {
/* 790 */     return this.javasource;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 796 */   private String source = null; public void setSource(String paramString) {
/* 797 */     this.source = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCatalog() {
/* 804 */     return this.catalog;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCatalog(String paramString) {
/* 812 */     this.catalog = paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   private static URI uriFromFile(File paramFile) {
/* 817 */     if (paramFile == null) {
/* 818 */       return null;
/*     */     }
/*     */     
/*     */     try {
/* 822 */       return paramFile.getCanonicalFile().toURI();
/*     */     }
/* 824 */     catch (IOException iOException) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 830 */       return paramFile.getAbsoluteFile().toURI();
/*     */     } 
/*     */   }
/*     */   
/*     */   public class ErrorLogger
/*     */     extends AbstractCollection {
/*     */     private boolean _noisy;
/*     */     private URI _baseURI;
/*     */     private final XMLBean this$0;
/*     */     
/*     */     public ErrorLogger(boolean param1Boolean) {
/* 841 */       this._noisy = param1Boolean;
/* 842 */       this._baseURI = XMLBean.uriFromFile(XMLBean.this.project.getBaseDir());
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean add(Object param1Object) {
/* 847 */       if (param1Object instanceof XmlError) {
/*     */         
/* 849 */         XmlError xmlError = (XmlError)param1Object;
/* 850 */         if (xmlError.getSeverity() == 0) {
/* 851 */           XMLBean.this.log(xmlError.toString(this._baseURI), 0);
/* 852 */         } else if (xmlError.getSeverity() == 1) {
/* 853 */           XMLBean.this.log(xmlError.toString(this._baseURI), 1);
/* 854 */         } else if (this._noisy) {
/* 855 */           XMLBean.this.log(xmlError.toString(this._baseURI), 2);
/*     */         } 
/* 857 */       }  return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public Iterator iterator() {
/* 862 */       return Collections.EMPTY_LIST.iterator();
/*     */     }
/*     */ 
/*     */     
/*     */     public int size() {
/* 867 */       return 0;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\tool\XMLBean.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */