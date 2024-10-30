/*      */ package org.apache.xmlbeans.impl.tool;
/*      */ 
/*      */ import java.io.File;
/*      */ import java.io.IOException;
/*      */ import java.net.URI;
/*      */ import java.net.URL;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import java.util.StringTokenizer;
/*      */ import org.apache.xmlbeans.Filer;
/*      */ import org.apache.xmlbeans.ResourceLoader;
/*      */ import org.apache.xmlbeans.SchemaCodePrinter;
/*      */ import org.apache.xmlbeans.SchemaTypeLoader;
/*      */ import org.apache.xmlbeans.SchemaTypeSystem;
/*      */ import org.apache.xmlbeans.SimpleValue;
/*      */ import org.apache.xmlbeans.SystemProperties;
/*      */ import org.apache.xmlbeans.XmlBeans;
/*      */ import org.apache.xmlbeans.XmlException;
/*      */ import org.apache.xmlbeans.XmlObject;
/*      */ import org.apache.xmlbeans.XmlOptions;
/*      */ import org.apache.xmlbeans.impl.common.IOUtil;
/*      */ import org.apache.xmlbeans.impl.common.JarHelper;
/*      */ import org.apache.xmlbeans.impl.common.ResolverUtil;
/*      */ import org.apache.xmlbeans.impl.common.XmlErrorPrinter;
/*      */ import org.apache.xmlbeans.impl.common.XmlErrorWatcher;
/*      */ import org.apache.xmlbeans.impl.config.BindingConfigImpl;
/*      */ import org.apache.xmlbeans.impl.schema.PathResourceLoader;
/*      */ import org.apache.xmlbeans.impl.schema.SchemaTypeLoaderImpl;
/*      */ import org.apache.xmlbeans.impl.schema.SchemaTypeSystemCompiler;
/*      */ import org.apache.xmlbeans.impl.schema.SchemaTypeSystemImpl;
/*      */ import org.apache.xmlbeans.impl.schema.StscState;
/*      */ import org.apache.xmlbeans.impl.util.FilerImpl;
/*      */ import org.apache.xmlbeans.impl.values.XmlListImpl;
/*      */ import org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument;
/*      */ import org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;
/*      */ import org.xml.sax.EntityResolver;
/*      */ import repackage.a;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class SchemaCompiler
/*      */ {
/*      */   private static final String CONFIG_URI = "http://xml.apache.org/xmlbeans/2004/02/xbean/config";
/*      */   private static final String COMPATIBILITY_CONFIG_URI = "http://www.bea.com/2002/09/xbean/config";
/*      */   
/*      */   public static void printUsage() {
/*   68 */     System.out.println("Compiles a schema into XML Bean classes and metadata.");
/*   69 */     System.out.println("Usage: scomp [opts] [dirs]* [schema.xsd]* [service.wsdl]* [config.xsdconfig]*");
/*   70 */     System.out.println("Options include:");
/*   71 */     System.out.println("    -cp [a;b;c] - classpath");
/*   72 */     System.out.println("    -d [dir] - target binary directory for .class and .xsb files");
/*   73 */     System.out.println("    -src [dir] - target directory for generated .java files");
/*   74 */     System.out.println("    -srconly - do not compile .java files or jar the output.");
/*   75 */     System.out.println("    -out [xmltypes.jar] - the name of the output jar");
/*   76 */     System.out.println("    -dl - permit network downloads for imports and includes (default is off)");
/*   77 */     System.out.println("    -noupa - do not enforce the unique particle attribution rule");
/*   78 */     System.out.println("    -nopvr - do not enforce the particle valid (restriction) rule");
/*   79 */     System.out.println("    -noann - ignore annotations");
/*   80 */     System.out.println("    -novdoc - do not validate contents of <documentation>");
/*   81 */     System.out.println("    -noext - ignore all extension (Pre/Post and Interface) found in .xsdconfig files");
/*   82 */     System.out.println("    -compiler - path to external java compiler");
/*   83 */     System.out.println("    -javasource [version] - generate java source compatible for a Java version (1.4 or 1.5)");
/*   84 */     System.out.println("    -ms - initial memory for external java compiler (default '" + CodeGenUtil.DEFAULT_MEM_START + "')");
/*   85 */     System.out.println("    -mx - maximum memory for external java compiler (default '" + CodeGenUtil.DEFAULT_MEM_MAX + "')");
/*   86 */     System.out.println("    -debug - compile with debug symbols");
/*   87 */     System.out.println("    -quiet - print fewer informational messages");
/*   88 */     System.out.println("    -verbose - print more informational messages");
/*   89 */     System.out.println("    -version - prints version information");
/*   90 */     System.out.println("    -license - prints license information");
/*   91 */     System.out.println("    -allowmdef \"[ns] [ns] [ns]\" - ignores multiple defs in given namespaces (use ##local for no-namespace)");
/*   92 */     System.out.println("    -catalog [file] -  catalog file for org.apache.xml.resolver.tools.CatalogResolver. (Note: needs resolver.jar from http://xml.apache.org/commons/components/resolver/index.html)");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*   99 */     System.out.println();
/*      */   }
/*      */ 
/*      */   
/*      */   public static void main(String[] paramArrayOfString) {
/*  104 */     if (paramArrayOfString.length == 0) {
/*      */       
/*  106 */       printUsage();
/*  107 */       System.exit(0);
/*      */       
/*      */       return;
/*      */     } 
/*  111 */     HashSet hashSet1 = new HashSet();
/*  112 */     hashSet1.add("h");
/*  113 */     hashSet1.add("help");
/*  114 */     hashSet1.add("usage");
/*  115 */     hashSet1.add("license");
/*  116 */     hashSet1.add("quiet");
/*  117 */     hashSet1.add("verbose");
/*  118 */     hashSet1.add("version");
/*  119 */     hashSet1.add("dl");
/*  120 */     hashSet1.add("noupa");
/*  121 */     hashSet1.add("nopvr");
/*  122 */     hashSet1.add("noann");
/*  123 */     hashSet1.add("novdoc");
/*  124 */     hashSet1.add("noext");
/*  125 */     hashSet1.add("srconly");
/*  126 */     hashSet1.add("debug");
/*      */     
/*  128 */     HashSet hashSet2 = new HashSet();
/*  129 */     hashSet2.add("out");
/*  130 */     hashSet2.add("name");
/*  131 */     hashSet2.add("src");
/*  132 */     hashSet2.add("d");
/*  133 */     hashSet2.add("cp");
/*  134 */     hashSet2.add("compiler");
/*  135 */     hashSet2.add("javasource");
/*  136 */     hashSet2.add("jar");
/*  137 */     hashSet2.add("ms");
/*  138 */     hashSet2.add("mx");
/*  139 */     hashSet2.add("repackage");
/*  140 */     hashSet2.add("schemaCodePrinter");
/*  141 */     hashSet2.add("extension");
/*  142 */     hashSet2.add("extensionParms");
/*  143 */     hashSet2.add("allowmdef");
/*  144 */     hashSet2.add("catalog");
/*  145 */     CommandLine commandLine = new CommandLine(paramArrayOfString, hashSet1, hashSet2);
/*      */     
/*  147 */     if (commandLine.getOpt("h") != null || commandLine.getOpt("help") != null || commandLine.getOpt("usage") != null) {
/*      */       
/*  149 */       printUsage();
/*  150 */       System.exit(0);
/*      */       
/*      */       return;
/*      */     } 
/*  154 */     String[] arrayOfString = commandLine.getBadOpts();
/*  155 */     if (arrayOfString.length > 0) {
/*      */       
/*  157 */       for (byte b = 0; b < arrayOfString.length; b++)
/*  158 */         System.out.println("Unrecognized option: " + arrayOfString[b]); 
/*  159 */       printUsage();
/*  160 */       System.exit(0);
/*      */       
/*      */       return;
/*      */     } 
/*  164 */     if (commandLine.getOpt("license") != null) {
/*      */       
/*  166 */       CommandLine.printLicense();
/*  167 */       System.exit(0);
/*      */       
/*      */       return;
/*      */     } 
/*  171 */     if (commandLine.getOpt("version") != null) {
/*      */       
/*  173 */       CommandLine.printVersion();
/*  174 */       System.exit(0);
/*      */       
/*      */       return;
/*      */     } 
/*  178 */     paramArrayOfString = commandLine.args();
/*  179 */     boolean bool1 = (commandLine.getOpt("verbose") != null) ? true : false;
/*  180 */     boolean bool2 = (commandLine.getOpt("quiet") != null) ? true : false;
/*  181 */     if (bool1) {
/*  182 */       bool2 = false;
/*      */     }
/*  184 */     if (bool1) {
/*  185 */       CommandLine.printVersion();
/*      */     }
/*  187 */     String str1 = commandLine.getOpt("out");
/*      */     
/*  189 */     String str2 = commandLine.getOpt("repackage");
/*      */     
/*  191 */     String str3 = commandLine.getOpt("schemaCodePrinter");
/*  192 */     SchemaCodePrinter schemaCodePrinter = null;
/*  193 */     if (str3 != null) {
/*      */       
/*      */       try {
/*      */         
/*  197 */         schemaCodePrinter = (SchemaCodePrinter)Class.forName(str3).newInstance();
/*      */       
/*      */       }
/*  200 */       catch (Exception exception) {
/*      */         
/*  202 */         System.err.println("Failed to load SchemaCodePrinter class " + str3 + "; proceeding with default printer");
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  208 */     String str4 = commandLine.getOpt("name");
/*      */     
/*  210 */     boolean bool3 = (commandLine.getOpt("dl") != null) ? true : false;
/*  211 */     boolean bool4 = (commandLine.getOpt("noupa") != null) ? true : false;
/*  212 */     boolean bool5 = (commandLine.getOpt("nopvr") != null) ? true : false;
/*  213 */     boolean bool6 = (commandLine.getOpt("noann") != null) ? true : false;
/*  214 */     boolean bool7 = (commandLine.getOpt("novdoc") != null) ? true : false;
/*  215 */     boolean bool8 = (commandLine.getOpt("noext") != null) ? true : false;
/*  216 */     boolean bool9 = (commandLine.getOpt("srconly") != null) ? true : false;
/*  217 */     boolean bool10 = (commandLine.getOpt("debug") != null) ? true : false;
/*      */     
/*  219 */     String str5 = commandLine.getOpt("allowmdef");
/*  220 */     Set set = (str5 == null) ? Collections.EMPTY_SET : new HashSet(Arrays.asList((Object[])XmlListImpl.split_list(str5)));
/*      */ 
/*      */     
/*  223 */     ArrayList arrayList = new ArrayList();
/*  224 */     if (commandLine.getOpt("extension") != null) {
/*      */       try {
/*  226 */         Extension extension = new Extension();
/*  227 */         extension.setClassName(Class.forName(commandLine.getOpt("extension"), false, Thread.currentThread().getContextClassLoader()));
/*  228 */         arrayList.add(extension);
/*  229 */       } catch (ClassNotFoundException classNotFoundException) {
/*  230 */         System.err.println("Could not find extension class: " + commandLine.getOpt("extension") + "  Is it on your classpath?");
/*  231 */         System.exit(1);
/*      */       } 
/*      */     }
/*      */     
/*  235 */     if (arrayList.size() > 0)
/*      */     {
/*      */       
/*  238 */       if (commandLine.getOpt("extensionParms") != null) {
/*  239 */         Extension extension = arrayList.get(0);
/*      */         
/*  241 */         StringTokenizer stringTokenizer = new StringTokenizer(commandLine.getOpt("extensionParms"), ";");
/*  242 */         while (stringTokenizer.hasMoreTokens()) {
/*      */           
/*  244 */           String str15 = stringTokenizer.nextToken();
/*  245 */           int i = str15.indexOf('=');
/*  246 */           if (i < 0) {
/*      */             
/*  248 */             System.err.println("extensionParms should be name=value;name=value");
/*  249 */             System.exit(1);
/*      */           } 
/*  251 */           String str16 = str15.substring(0, i);
/*  252 */           String str17 = str15.substring(i + 1);
/*  253 */           Extension.Param param = extension.createParam();
/*  254 */           param.setName(str16);
/*  255 */           param.setValue(str17);
/*      */         } 
/*      */       } 
/*      */     }
/*      */     
/*  260 */     String str6 = commandLine.getOpt("d");
/*  261 */     File file1 = null;
/*  262 */     if (str6 != null) {
/*  263 */       file1 = new File(str6);
/*      */     }
/*  265 */     String str7 = commandLine.getOpt("src");
/*  266 */     File file2 = null;
/*  267 */     if (str7 != null)
/*  268 */       file2 = new File(str7); 
/*  269 */     if (bool9 && str7 == null && file1 != null) {
/*  270 */       file2 = file1;
/*      */     }
/*      */     
/*  273 */     File file3 = null;
/*  274 */     if (file2 == null || file1 == null) {
/*      */       
/*      */       try {
/*      */         
/*  278 */         file3 = SchemaCodeGenerator.createTempDir();
/*      */       }
/*  280 */       catch (IOException iOException) {
/*      */         
/*  282 */         System.err.println("Error creating temp dir " + iOException);
/*  283 */         System.exit(1);
/*      */       } 
/*      */     }
/*      */     
/*  287 */     File file4 = null;
/*  288 */     if (str1 == null && file1 == null && !bool9)
/*  289 */       str1 = "xmltypes.jar"; 
/*  290 */     if (str1 != null) {
/*  291 */       file4 = new File(str1);
/*      */     }
/*  293 */     if (file2 == null)
/*  294 */       file2 = IOUtil.createDir(file3, "src"); 
/*  295 */     if (file1 == null) {
/*  296 */       file1 = IOUtil.createDir(file3, "classes");
/*      */     }
/*  298 */     File[] arrayOfFile1 = null;
/*  299 */     String str8 = commandLine.getOpt("cp");
/*  300 */     if (str8 != null) {
/*      */       
/*  302 */       String[] arrayOfString1 = str8.split(File.pathSeparator);
/*  303 */       ArrayList arrayList1 = new ArrayList();
/*  304 */       for (byte b = 0; b < arrayOfString1.length; b++)
/*  305 */         arrayList1.add(new File(arrayOfString1[b])); 
/*  306 */       arrayOfFile1 = arrayList1.<File>toArray(new File[arrayList1.size()]);
/*      */     }
/*      */     else {
/*      */       
/*  310 */       arrayOfFile1 = CodeGenUtil.systemClasspath();
/*      */     } 
/*      */     
/*  313 */     String str9 = commandLine.getOpt("javasource");
/*  314 */     String str10 = commandLine.getOpt("compiler");
/*  315 */     String str11 = commandLine.getOpt("jar");
/*  316 */     if (bool1 && str11 != null) {
/*  317 */       System.out.println("The 'jar' option is no longer supported.");
/*      */     }
/*  319 */     String str12 = commandLine.getOpt("ms");
/*  320 */     String str13 = commandLine.getOpt("mx");
/*      */     
/*  322 */     File[] arrayOfFile2 = commandLine.filesEndingWith(".xsd");
/*  323 */     File[] arrayOfFile3 = commandLine.filesEndingWith(".wsdl");
/*  324 */     File[] arrayOfFile4 = commandLine.filesEndingWith(".java");
/*  325 */     File[] arrayOfFile5 = commandLine.filesEndingWith(".xsdconfig");
/*  326 */     URL[] arrayOfURL = commandLine.getURLs();
/*      */     
/*  328 */     if (arrayOfFile2.length + arrayOfFile3.length + arrayOfURL.length == 0) {
/*      */       
/*  330 */       System.out.println("Could not find any xsd or wsdl files to process.");
/*  331 */       System.exit(0);
/*      */     } 
/*  333 */     File file5 = commandLine.getBaseDir();
/*  334 */     URI uRI = (file5 == null) ? null : file5.toURI();
/*      */     
/*  336 */     XmlErrorPrinter xmlErrorPrinter = new XmlErrorPrinter(bool1, uRI);
/*      */     
/*  338 */     String str14 = commandLine.getOpt("catalog");
/*      */     
/*  340 */     Parameters parameters = new Parameters();
/*  341 */     parameters.setBaseDir(file5);
/*  342 */     parameters.setXsdFiles(arrayOfFile2);
/*  343 */     parameters.setWsdlFiles(arrayOfFile3);
/*  344 */     parameters.setJavaFiles(arrayOfFile4);
/*  345 */     parameters.setConfigFiles(arrayOfFile5);
/*  346 */     parameters.setUrlFiles(arrayOfURL);
/*  347 */     parameters.setClasspath(arrayOfFile1);
/*  348 */     parameters.setOutputJar(file4);
/*  349 */     parameters.setName(str4);
/*  350 */     parameters.setSrcDir(file2);
/*  351 */     parameters.setClassesDir(file1);
/*  352 */     parameters.setCompiler(str10);
/*  353 */     parameters.setJavaSource(str9);
/*  354 */     parameters.setMemoryInitialSize(str12);
/*  355 */     parameters.setMemoryMaximumSize(str13);
/*  356 */     parameters.setNojavac(bool9);
/*  357 */     parameters.setQuiet(bool2);
/*  358 */     parameters.setVerbose(bool1);
/*  359 */     parameters.setDownload(bool3);
/*  360 */     parameters.setNoUpa(bool4);
/*  361 */     parameters.setNoPvr(bool5);
/*  362 */     parameters.setNoAnn(bool6);
/*  363 */     parameters.setNoVDoc(bool7);
/*  364 */     parameters.setNoExt(bool8);
/*  365 */     parameters.setDebug(bool10);
/*  366 */     parameters.setErrorListener((Collection)xmlErrorPrinter);
/*  367 */     parameters.setRepackage(str2);
/*  368 */     parameters.setExtensions(arrayList);
/*  369 */     parameters.setMdefNamespaces(set);
/*  370 */     parameters.setCatalogFile(str14);
/*  371 */     parameters.setSchemaCodePrinter(schemaCodePrinter);
/*      */     
/*  373 */     boolean bool = compile(parameters);
/*      */     
/*  375 */     if (file3 != null) {
/*  376 */       SchemaCodeGenerator.tryHardToDelete(file3);
/*      */     }
/*  378 */     if (!bool) {
/*  379 */       System.exit(1);
/*      */     }
/*  381 */     System.exit(0);
/*      */   }
/*      */   
/*      */   public static class Parameters
/*      */   {
/*      */     private File baseDir;
/*      */     private File[] xsdFiles;
/*      */     private File[] wsdlFiles;
/*      */     private File[] javaFiles;
/*      */     private File[] configFiles;
/*      */     private URL[] urlFiles;
/*      */     private File[] classpath;
/*      */     private File outputJar;
/*      */     private String name;
/*      */     private File srcDir;
/*      */     private File classesDir;
/*      */     private String memoryInitialSize;
/*      */     private String memoryMaximumSize;
/*      */     private String compiler;
/*      */     private String javasource;
/*      */     private boolean nojavac;
/*      */     private boolean quiet;
/*      */     private boolean verbose;
/*      */     private boolean download;
/*      */     private Collection errorListener;
/*      */     private boolean noUpa;
/*      */     private boolean noPvr;
/*      */     private boolean noAnn;
/*      */     private boolean noVDoc;
/*      */     private boolean noExt;
/*      */     private boolean debug;
/*      */     private boolean incrementalSrcGen;
/*      */     private String repackage;
/*  414 */     private List extensions = Collections.EMPTY_LIST;
/*  415 */     private Set mdefNamespaces = Collections.EMPTY_SET;
/*      */     
/*      */     private String catalogFile;
/*      */     private SchemaCodePrinter schemaCodePrinter;
/*      */     private EntityResolver entityResolver;
/*      */     
/*      */     public File getBaseDir() {
/*  422 */       return this.baseDir;
/*      */     }
/*      */ 
/*      */     
/*      */     public void setBaseDir(File param1File) {
/*  427 */       this.baseDir = param1File;
/*      */     }
/*      */ 
/*      */     
/*      */     public File[] getXsdFiles() {
/*  432 */       return this.xsdFiles;
/*      */     }
/*      */ 
/*      */     
/*      */     public void setXsdFiles(File[] param1ArrayOfFile) {
/*  437 */       this.xsdFiles = param1ArrayOfFile;
/*      */     }
/*      */ 
/*      */     
/*      */     public File[] getWsdlFiles() {
/*  442 */       return this.wsdlFiles;
/*      */     }
/*      */ 
/*      */     
/*      */     public void setWsdlFiles(File[] param1ArrayOfFile) {
/*  447 */       this.wsdlFiles = param1ArrayOfFile;
/*      */     }
/*      */ 
/*      */     
/*      */     public File[] getJavaFiles() {
/*  452 */       return this.javaFiles;
/*      */     }
/*      */ 
/*      */     
/*      */     public void setJavaFiles(File[] param1ArrayOfFile) {
/*  457 */       this.javaFiles = param1ArrayOfFile;
/*      */     }
/*      */ 
/*      */     
/*      */     public File[] getConfigFiles() {
/*  462 */       return this.configFiles;
/*      */     }
/*      */ 
/*      */     
/*      */     public void setConfigFiles(File[] param1ArrayOfFile) {
/*  467 */       this.configFiles = param1ArrayOfFile;
/*      */     }
/*      */ 
/*      */     
/*      */     public URL[] getUrlFiles() {
/*  472 */       return this.urlFiles;
/*      */     }
/*      */ 
/*      */     
/*      */     public void setUrlFiles(URL[] param1ArrayOfURL) {
/*  477 */       this.urlFiles = param1ArrayOfURL;
/*      */     }
/*      */ 
/*      */     
/*      */     public File[] getClasspath() {
/*  482 */       return this.classpath;
/*      */     }
/*      */ 
/*      */     
/*      */     public void setClasspath(File[] param1ArrayOfFile) {
/*  487 */       this.classpath = param1ArrayOfFile;
/*      */     }
/*      */ 
/*      */     
/*      */     public File getOutputJar() {
/*  492 */       return this.outputJar;
/*      */     }
/*      */ 
/*      */     
/*      */     public void setOutputJar(File param1File) {
/*  497 */       this.outputJar = param1File;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getName() {
/*  502 */       return this.name;
/*      */     }
/*      */ 
/*      */     
/*      */     public void setName(String param1String) {
/*  507 */       this.name = param1String;
/*      */     }
/*      */ 
/*      */     
/*      */     public File getSrcDir() {
/*  512 */       return this.srcDir;
/*      */     }
/*      */ 
/*      */     
/*      */     public void setSrcDir(File param1File) {
/*  517 */       this.srcDir = param1File;
/*      */     }
/*      */ 
/*      */     
/*      */     public File getClassesDir() {
/*  522 */       return this.classesDir;
/*      */     }
/*      */ 
/*      */     
/*      */     public void setClassesDir(File param1File) {
/*  527 */       this.classesDir = param1File;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isNojavac() {
/*  532 */       return this.nojavac;
/*      */     }
/*      */ 
/*      */     
/*      */     public void setNojavac(boolean param1Boolean) {
/*  537 */       this.nojavac = param1Boolean;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isQuiet() {
/*  542 */       return this.quiet;
/*      */     }
/*      */ 
/*      */     
/*      */     public void setQuiet(boolean param1Boolean) {
/*  547 */       this.quiet = param1Boolean;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isVerbose() {
/*  552 */       return this.verbose;
/*      */     }
/*      */ 
/*      */     
/*      */     public void setVerbose(boolean param1Boolean) {
/*  557 */       this.verbose = param1Boolean;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isDownload() {
/*  562 */       return this.download;
/*      */     }
/*      */ 
/*      */     
/*      */     public void setDownload(boolean param1Boolean) {
/*  567 */       this.download = param1Boolean;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isNoUpa() {
/*  572 */       return this.noUpa;
/*      */     }
/*      */ 
/*      */     
/*      */     public void setNoUpa(boolean param1Boolean) {
/*  577 */       this.noUpa = param1Boolean;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isNoPvr() {
/*  582 */       return this.noPvr;
/*      */     }
/*      */ 
/*      */     
/*      */     public void setNoPvr(boolean param1Boolean) {
/*  587 */       this.noPvr = param1Boolean;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isNoAnn() {
/*  592 */       return this.noAnn;
/*      */     }
/*      */ 
/*      */     
/*      */     public void setNoAnn(boolean param1Boolean) {
/*  597 */       this.noAnn = param1Boolean;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isNoVDoc() {
/*  602 */       return this.noVDoc;
/*      */     }
/*      */ 
/*      */     
/*      */     public void setNoVDoc(boolean param1Boolean) {
/*  607 */       this.noVDoc = param1Boolean;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isNoExt() {
/*  612 */       return this.noExt;
/*      */     }
/*      */ 
/*      */     
/*      */     public void setNoExt(boolean param1Boolean) {
/*  617 */       this.noExt = param1Boolean;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isIncrementalSrcGen() {
/*  622 */       return this.incrementalSrcGen;
/*      */     }
/*      */ 
/*      */     
/*      */     public void setIncrementalSrcGen(boolean param1Boolean) {
/*  627 */       this.incrementalSrcGen = param1Boolean;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isDebug() {
/*  632 */       return this.debug;
/*      */     }
/*      */ 
/*      */     
/*      */     public void setDebug(boolean param1Boolean) {
/*  637 */       this.debug = param1Boolean;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getMemoryInitialSize() {
/*  642 */       return this.memoryInitialSize;
/*      */     }
/*      */ 
/*      */     
/*      */     public void setMemoryInitialSize(String param1String) {
/*  647 */       this.memoryInitialSize = param1String;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getMemoryMaximumSize() {
/*  652 */       return this.memoryMaximumSize;
/*      */     }
/*      */ 
/*      */     
/*      */     public void setMemoryMaximumSize(String param1String) {
/*  657 */       this.memoryMaximumSize = param1String;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getCompiler() {
/*  662 */       return this.compiler;
/*      */     }
/*      */ 
/*      */     
/*      */     public void setCompiler(String param1String) {
/*  667 */       this.compiler = param1String;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getJavaSource() {
/*  672 */       return this.javasource;
/*      */     }
/*      */ 
/*      */     
/*      */     public void setJavaSource(String param1String) {
/*  677 */       this.javasource = param1String;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public String getJar() {
/*  683 */       return null;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setJar(String param1String) {}
/*      */ 
/*      */ 
/*      */     
/*      */     public Collection getErrorListener() {
/*  694 */       return this.errorListener;
/*      */     }
/*      */ 
/*      */     
/*      */     public void setErrorListener(Collection param1Collection) {
/*  699 */       this.errorListener = param1Collection;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getRepackage() {
/*  704 */       return this.repackage;
/*      */     }
/*      */ 
/*      */     
/*      */     public void setRepackage(String param1String) {
/*  709 */       this.repackage = param1String;
/*      */     }
/*      */     
/*      */     public List getExtensions() {
/*  713 */       return this.extensions;
/*      */     }
/*      */     
/*      */     public void setExtensions(List param1List) {
/*  717 */       this.extensions = param1List;
/*      */     }
/*      */ 
/*      */     
/*      */     public Set getMdefNamespaces() {
/*  722 */       return this.mdefNamespaces;
/*      */     }
/*      */ 
/*      */     
/*      */     public void setMdefNamespaces(Set param1Set) {
/*  727 */       this.mdefNamespaces = param1Set;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getCatalogFile() {
/*  732 */       return this.catalogFile;
/*      */     }
/*      */ 
/*      */     
/*      */     public void setCatalogFile(String param1String) {
/*  737 */       this.catalogFile = param1String;
/*      */     }
/*      */ 
/*      */     
/*      */     public SchemaCodePrinter getSchemaCodePrinter() {
/*  742 */       return this.schemaCodePrinter;
/*      */     }
/*      */ 
/*      */     
/*      */     public void setSchemaCodePrinter(SchemaCodePrinter param1SchemaCodePrinter) {
/*  747 */       this.schemaCodePrinter = param1SchemaCodePrinter;
/*      */     }
/*      */     
/*      */     public EntityResolver getEntityResolver() {
/*  751 */       return this.entityResolver;
/*      */     }
/*      */     
/*      */     public void setEntityResolver(EntityResolver param1EntityResolver) {
/*  755 */       this.entityResolver = param1EntityResolver;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static SchemaTypeSystem loadTypeSystem(String paramString1, File[] paramArrayOfFile1, File[] paramArrayOfFile2, URL[] paramArrayOfURL, File[] paramArrayOfFile3, File[] paramArrayOfFile4, ResourceLoader paramResourceLoader, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, Set paramSet, File paramFile1, Map paramMap, Collection paramCollection, File paramFile2, EntityResolver paramEntityResolver, File[] paramArrayOfFile5, String paramString2) {
/*  765 */     XmlErrorWatcher xmlErrorWatcher = new XmlErrorWatcher(paramCollection);
/*      */ 
/*      */     
/*  768 */     StscState stscState = StscState.start();
/*  769 */     stscState.setErrorListener((Collection)xmlErrorWatcher);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  777 */     SchemaTypeLoader schemaTypeLoader1 = XmlBeans.typeLoaderForClassLoader(SchemaDocument.class.getClassLoader());
/*      */ 
/*      */     
/*  780 */     ArrayList arrayList = new ArrayList();
/*  781 */     if (paramArrayOfFile1 != null)
/*      */     {
/*  783 */       for (byte b = 0; b < paramArrayOfFile1.length; b++) {
/*      */ 
/*      */         
/*      */         try {
/*  787 */           XmlOptions xmlOptions1 = new XmlOptions();
/*  788 */           xmlOptions1.setLoadLineNumbers();
/*  789 */           xmlOptions1.setLoadMessageDigest();
/*  790 */           xmlOptions1.setEntityResolver(paramEntityResolver);
/*      */           
/*  792 */           XmlObject xmlObject = schemaTypeLoader1.parse(paramArrayOfFile1[b], null, xmlOptions1);
/*  793 */           if (!(xmlObject instanceof SchemaDocument))
/*      */           {
/*  795 */             StscState.addError((Collection)xmlErrorWatcher, "invalid.document.type", new Object[] { paramArrayOfFile1[b], "schema" }, xmlObject);
/*      */           
/*      */           }
/*      */           else
/*      */           {
/*  800 */             addSchema(paramArrayOfFile1[b].toString(), (SchemaDocument)xmlObject, xmlErrorWatcher, paramBoolean5, arrayList);
/*      */           }
/*      */         
/*      */         }
/*  804 */         catch (XmlException xmlException) {
/*      */           
/*  806 */           xmlErrorWatcher.add(xmlException.getError());
/*      */         }
/*  808 */         catch (Exception exception) {
/*      */           
/*  810 */           StscState.addError((Collection)xmlErrorWatcher, "cannot.load.file", new Object[] { "xsd", paramArrayOfFile1[b], exception.getMessage() }, paramArrayOfFile1[b]);
/*      */         } 
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  817 */     if (paramArrayOfFile2 != null)
/*      */     {
/*  819 */       for (byte b = 0; b < paramArrayOfFile2.length; b++) {
/*      */ 
/*      */         
/*      */         try {
/*  823 */           XmlOptions xmlOptions1 = new XmlOptions();
/*  824 */           xmlOptions1.setLoadLineNumbers();
/*  825 */           xmlOptions1.setLoadSubstituteNamespaces(Collections.singletonMap("http://schemas.xmlsoap.org/wsdl/", "http://www.apache.org/internal/xmlbeans/wsdlsubst"));
/*      */ 
/*      */           
/*  828 */           xmlOptions1.setEntityResolver(paramEntityResolver);
/*      */           
/*  830 */           XmlObject xmlObject = schemaTypeLoader1.parse(paramArrayOfFile2[b], null, xmlOptions1);
/*      */           
/*  832 */           if (!(xmlObject instanceof DefinitionsDocument)) {
/*  833 */             StscState.addError((Collection)xmlErrorWatcher, "invalid.document.type", new Object[] { paramArrayOfFile2[b], "wsdl" }, xmlObject);
/*      */           }
/*      */           else {
/*      */             
/*  837 */             addWsdlSchemas(paramArrayOfFile2[b].toString(), (DefinitionsDocument)xmlObject, xmlErrorWatcher, paramBoolean5, arrayList);
/*      */           }
/*      */         
/*  840 */         } catch (XmlException xmlException) {
/*      */           
/*  842 */           xmlErrorWatcher.add(xmlException.getError());
/*      */         }
/*  844 */         catch (Exception exception) {
/*      */           
/*  846 */           StscState.addError((Collection)xmlErrorWatcher, "cannot.load.file", new Object[] { "wsdl", paramArrayOfFile2[b], exception.getMessage() }, paramArrayOfFile2[b]);
/*      */         } 
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  854 */     if (paramArrayOfURL != null)
/*      */     {
/*  856 */       for (byte b = 0; b < paramArrayOfURL.length; b++) {
/*      */ 
/*      */         
/*      */         try {
/*  860 */           XmlOptions xmlOptions1 = new XmlOptions();
/*  861 */           xmlOptions1.setLoadLineNumbers();
/*  862 */           xmlOptions1.setLoadSubstituteNamespaces(Collections.singletonMap("http://schemas.xmlsoap.org/wsdl/", "http://www.apache.org/internal/xmlbeans/wsdlsubst"));
/*  863 */           xmlOptions1.setEntityResolver(paramEntityResolver);
/*      */           
/*  865 */           XmlObject xmlObject = schemaTypeLoader1.parse(paramArrayOfURL[b], null, xmlOptions1);
/*      */           
/*  867 */           if (xmlObject instanceof DefinitionsDocument)
/*      */           {
/*  869 */             addWsdlSchemas(paramArrayOfURL[b].toString(), (DefinitionsDocument)xmlObject, xmlErrorWatcher, paramBoolean5, arrayList);
/*      */           }
/*  871 */           else if (xmlObject instanceof SchemaDocument)
/*      */           {
/*  873 */             addSchema(paramArrayOfURL[b].toString(), (SchemaDocument)xmlObject, xmlErrorWatcher, paramBoolean5, arrayList);
/*      */           
/*      */           }
/*      */           else
/*      */           {
/*  878 */             StscState.addError((Collection)xmlErrorWatcher, "invalid.document.type", new Object[] { paramArrayOfURL[b], "wsdl or schema" }, xmlObject);
/*      */           
/*      */           }
/*      */         
/*      */         }
/*  883 */         catch (XmlException xmlException) {
/*      */           
/*  885 */           xmlErrorWatcher.add(xmlException.getError());
/*      */         }
/*  887 */         catch (Exception exception) {
/*      */           
/*  889 */           StscState.addError((Collection)xmlErrorWatcher, "cannot.load.file", new Object[] { "url", paramArrayOfURL[b], exception.getMessage() }, paramArrayOfURL[b]);
/*      */         } 
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*  895 */     SchemaDocument.Schema[] arrayOfSchema = (SchemaDocument.Schema[])arrayList.toArray((Object[])new SchemaDocument.Schema[arrayList.size()]);
/*      */ 
/*      */     
/*  898 */     ArrayList arrayList1 = new ArrayList();
/*  899 */     if (paramArrayOfFile3 != null) {
/*      */       
/*  901 */       if (paramBoolean6) {
/*  902 */         System.out.println("Pre/Post and Interface extensions will be ignored.");
/*      */       }
/*  904 */       for (byte b = 0; b < paramArrayOfFile3.length; b++) {
/*      */ 
/*      */         
/*      */         try {
/*  908 */           XmlOptions xmlOptions1 = new XmlOptions();
/*  909 */           xmlOptions1.put("LOAD_LINE_NUMBERS");
/*  910 */           xmlOptions1.setEntityResolver(paramEntityResolver);
/*  911 */           xmlOptions1.setLoadSubstituteNamespaces(MAP_COMPATIBILITY_CONFIG_URIS);
/*      */           
/*  913 */           XmlObject xmlObject = schemaTypeLoader1.parse(paramArrayOfFile3[b], null, xmlOptions1);
/*  914 */           if (!(xmlObject instanceof ConfigDocument)) {
/*  915 */             StscState.addError((Collection)xmlErrorWatcher, "invalid.document.type", new Object[] { paramArrayOfFile3[b], "xsd config" }, xmlObject);
/*      */           }
/*      */           else {
/*      */             
/*  919 */             StscState.addInfo((Collection)xmlErrorWatcher, "Loading config file " + paramArrayOfFile3[b]);
/*  920 */             if (xmlObject.validate((new XmlOptions()).setErrorListener((Collection)xmlErrorWatcher)))
/*      */             {
/*  922 */               ConfigDocument.Config config = ((ConfigDocument)xmlObject).getConfig();
/*  923 */               arrayList1.add(config);
/*  924 */               if (paramBoolean6)
/*      */               {
/*      */                 
/*  927 */                 config.setExtensionArray(new org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig[0]);
/*      */               }
/*      */             }
/*      */           
/*      */           } 
/*  932 */         } catch (XmlException xmlException) {
/*      */           
/*  934 */           xmlErrorWatcher.add(xmlException.getError());
/*      */         }
/*  936 */         catch (Exception exception) {
/*      */           
/*  938 */           StscState.addError((Collection)xmlErrorWatcher, "cannot.load.file", new Object[] { "xsd config", paramArrayOfFile3[b], exception.getMessage() }, paramArrayOfFile3[b]);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  943 */     ConfigDocument.Config[] arrayOfConfig = arrayList1.<ConfigDocument.Config>toArray(new ConfigDocument.Config[arrayList1.size()]);
/*      */     
/*  945 */     SchemaTypeLoader schemaTypeLoader2 = SchemaTypeLoaderImpl.build(null, paramResourceLoader, null);
/*      */     
/*  947 */     URI uRI = null;
/*  948 */     if (paramFile1 != null) {
/*  949 */       uRI = paramFile1.toURI();
/*      */     }
/*  951 */     XmlOptions xmlOptions = new XmlOptions();
/*  952 */     if (paramBoolean1)
/*  953 */       xmlOptions.setCompileDownloadUrls(); 
/*  954 */     if (paramBoolean2)
/*  955 */       xmlOptions.setCompileNoUpaRule(); 
/*  956 */     if (paramBoolean3)
/*  957 */       xmlOptions.setCompileNoPvrRule(); 
/*  958 */     if (paramBoolean4)
/*  959 */       xmlOptions.setCompileNoAnnotations(); 
/*  960 */     if (paramSet != null)
/*  961 */       xmlOptions.setCompileMdefNamespaces(paramSet); 
/*  962 */     xmlOptions.setCompileNoValidation();
/*  963 */     xmlOptions.setEntityResolver(paramEntityResolver);
/*  964 */     if (paramString2 != null) {
/*  965 */       xmlOptions.setGenerateJavaVersion(paramString2);
/*      */     }
/*      */     
/*  968 */     SchemaTypeSystemCompiler.Parameters parameters = new SchemaTypeSystemCompiler.Parameters();
/*  969 */     parameters.setName(paramString1);
/*  970 */     parameters.setSchemas(arrayOfSchema);
/*  971 */     parameters.setConfig(BindingConfigImpl.forConfigDocuments(arrayOfConfig, paramArrayOfFile4, paramArrayOfFile5));
/*  972 */     parameters.setLinkTo(schemaTypeLoader2);
/*  973 */     parameters.setOptions(xmlOptions);
/*  974 */     parameters.setErrorListener((Collection)xmlErrorWatcher);
/*  975 */     parameters.setJavaize(true);
/*  976 */     parameters.setBaseURI(uRI);
/*  977 */     parameters.setSourcesToCopyMap(paramMap);
/*  978 */     parameters.setSchemasDir(paramFile2);
/*  979 */     return SchemaTypeSystemCompiler.compile(parameters);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static void addSchema(String paramString, SchemaDocument paramSchemaDocument, XmlErrorWatcher paramXmlErrorWatcher, boolean paramBoolean, List paramList) {
/*  985 */     StscState.addInfo((Collection)paramXmlErrorWatcher, "Loading schema file " + paramString);
/*  986 */     XmlOptions xmlOptions = (new XmlOptions()).setErrorListener((Collection)paramXmlErrorWatcher);
/*  987 */     if (paramBoolean)
/*  988 */       xmlOptions.setValidateTreatLaxAsSkip(); 
/*  989 */     if (paramSchemaDocument.validate(xmlOptions)) {
/*  990 */       paramList.add(paramSchemaDocument.getSchema());
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static void addWsdlSchemas(String paramString, DefinitionsDocument paramDefinitionsDocument, XmlErrorWatcher paramXmlErrorWatcher, boolean paramBoolean, List paramList) {
/*  997 */     if (wsdlContainsEncoded((XmlObject)paramDefinitionsDocument))
/*  998 */       StscState.addWarning((Collection)paramXmlErrorWatcher, "The WSDL " + paramString + " uses SOAP encoding. SOAP encoding is not compatible with literal XML Schema.", 60, (XmlObject)paramDefinitionsDocument); 
/*  999 */     StscState.addInfo((Collection)paramXmlErrorWatcher, "Loading wsdl file " + paramString);
/* 1000 */     XmlOptions xmlOptions = (new XmlOptions()).setErrorListener((Collection)paramXmlErrorWatcher);
/* 1001 */     if (paramBoolean)
/* 1002 */       xmlOptions.setValidateTreatLaxAsSkip(); 
/* 1003 */     XmlObject[] arrayOfXmlObject = paramDefinitionsDocument.getDefinitions().getTypesArray();
/* 1004 */     byte b1 = 0;
/* 1005 */     for (byte b2 = 0; b2 < arrayOfXmlObject.length; b2++) {
/*      */       
/* 1007 */       XmlObject[] arrayOfXmlObject1 = arrayOfXmlObject[b2].selectPath("declare namespace xs=\"http://www.w3.org/2001/XMLSchema\" xs:schema");
/* 1008 */       if (arrayOfXmlObject1.length == 0) {
/*      */         
/* 1010 */         StscState.addWarning((Collection)paramXmlErrorWatcher, "The WSDL " + paramString + " did not have any schema documents in namespace 'http://www.w3.org/2001/XMLSchema'", 60, (XmlObject)paramDefinitionsDocument);
/*      */       }
/*      */       else {
/*      */         
/* 1014 */         for (byte b = 0; b < arrayOfXmlObject1.length; b++) {
/*      */           
/* 1016 */           if (arrayOfXmlObject1[b] instanceof SchemaDocument.Schema && arrayOfXmlObject1[b].validate(xmlOptions)) {
/*      */ 
/*      */             
/* 1019 */             b1++;
/* 1020 */             paramList.add(arrayOfXmlObject1[b]);
/*      */           } 
/*      */         } 
/*      */       } 
/* 1024 */     }  StscState.addInfo((Collection)paramXmlErrorWatcher, "Processing " + b1 + " schema(s) in " + paramString);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean compile(Parameters paramParameters) {
/* 1029 */     File file1 = paramParameters.getBaseDir();
/* 1030 */     File[] arrayOfFile1 = paramParameters.getXsdFiles();
/* 1031 */     File[] arrayOfFile2 = paramParameters.getWsdlFiles();
/* 1032 */     URL[] arrayOfURL = paramParameters.getUrlFiles();
/* 1033 */     File[] arrayOfFile3 = paramParameters.getJavaFiles();
/* 1034 */     File[] arrayOfFile4 = paramParameters.getConfigFiles();
/* 1035 */     File[] arrayOfFile5 = paramParameters.getClasspath();
/* 1036 */     File file2 = paramParameters.getOutputJar();
/* 1037 */     String str1 = paramParameters.getName();
/* 1038 */     File file3 = paramParameters.getSrcDir();
/* 1039 */     File file4 = paramParameters.getClassesDir();
/* 1040 */     String str2 = paramParameters.getCompiler();
/* 1041 */     String str3 = paramParameters.getJavaSource();
/* 1042 */     String str4 = paramParameters.getMemoryInitialSize();
/* 1043 */     String str5 = paramParameters.getMemoryMaximumSize();
/* 1044 */     boolean bool1 = paramParameters.isNojavac();
/* 1045 */     boolean bool2 = paramParameters.isDebug();
/* 1046 */     boolean bool3 = paramParameters.isVerbose();
/* 1047 */     boolean bool4 = paramParameters.isQuiet();
/* 1048 */     boolean bool5 = paramParameters.isDownload();
/* 1049 */     boolean bool6 = paramParameters.isNoUpa();
/* 1050 */     boolean bool7 = paramParameters.isNoPvr();
/* 1051 */     boolean bool8 = paramParameters.isNoAnn();
/* 1052 */     boolean bool9 = paramParameters.isNoVDoc();
/* 1053 */     boolean bool10 = paramParameters.isNoExt();
/* 1054 */     boolean bool11 = paramParameters.isIncrementalSrcGen();
/* 1055 */     Collection collection = paramParameters.getErrorListener();
/*      */     
/* 1057 */     String str6 = paramParameters.getRepackage();
/*      */     
/* 1059 */     if (str6 != null) {
/*      */       
/* 1061 */       SchemaTypeLoaderImpl.METADATA_PACKAGE_LOAD = SchemaTypeSystemImpl.METADATA_PACKAGE_GEN;
/*      */       
/* 1063 */       String str = SchemaTypeSystem.class.getPackage().getName();
/* 1064 */       a a = new a(str6);
/*      */       
/* 1066 */       SchemaTypeSystemImpl.METADATA_PACKAGE_GEN = a.a(new StringBuffer(str)).toString().replace('.', '_');
/*      */       
/* 1068 */       System.out.println("\n\n\n" + str + ".SchemaCompiler  Metadata LOAD:" + SchemaTypeLoaderImpl.METADATA_PACKAGE_LOAD + " GEN:" + SchemaTypeSystemImpl.METADATA_PACKAGE_GEN);
/*      */     } 
/*      */     
/* 1071 */     SchemaCodePrinter schemaCodePrinter = paramParameters.getSchemaCodePrinter();
/* 1072 */     List list = paramParameters.getExtensions();
/* 1073 */     Set set = paramParameters.getMdefNamespaces();
/*      */     
/* 1075 */     EntityResolver entityResolver = (paramParameters.getEntityResolver() == null) ? ResolverUtil.resolverForCatalog(paramParameters.getCatalogFile()) : paramParameters.getEntityResolver();
/*      */ 
/*      */     
/* 1078 */     if (file3 == null || file4 == null) {
/* 1079 */       throw new IllegalArgumentException("src and class gen directories may not be null.");
/*      */     }
/* 1081 */     long l1 = System.currentTimeMillis();
/*      */ 
/*      */     
/* 1084 */     if (file1 == null) {
/* 1085 */       file1 = new File(SystemProperties.getProperty("user.dir"));
/*      */     }
/* 1087 */     PathResourceLoader pathResourceLoader = null;
/*      */     
/* 1089 */     HashMap hashMap = new HashMap();
/*      */     
/* 1091 */     if (arrayOfFile5 != null) {
/* 1092 */       pathResourceLoader = new PathResourceLoader(arrayOfFile5);
/*      */     }
/* 1094 */     boolean bool12 = true;
/*      */     
/* 1096 */     File file5 = IOUtil.createDir(file4, "schema" + SchemaTypeSystemImpl.METADATA_PACKAGE_GEN + "/src");
/*      */ 
/*      */     
/* 1099 */     XmlErrorWatcher xmlErrorWatcher = new XmlErrorWatcher(collection);
/* 1100 */     SchemaTypeSystem schemaTypeSystem = loadTypeSystem(str1, arrayOfFile1, arrayOfFile2, arrayOfURL, arrayOfFile4, arrayOfFile3, (ResourceLoader)pathResourceLoader, bool5, bool6, bool7, bool8, bool9, bool10, set, file1, hashMap, (Collection)xmlErrorWatcher, file5, entityResolver, arrayOfFile5, str3);
/*      */ 
/*      */     
/* 1103 */     if (xmlErrorWatcher.hasError())
/* 1104 */       bool12 = false; 
/* 1105 */     long l2 = System.currentTimeMillis();
/* 1106 */     if (!bool4) {
/* 1107 */       System.out.println("Time to build schema type system: " + ((l2 - l1) / 1000.0D) + " seconds");
/*      */     }
/*      */     
/* 1110 */     if (bool12 && schemaTypeSystem != null) {
/*      */       
/* 1112 */       l1 = System.currentTimeMillis();
/*      */ 
/*      */       
/* 1115 */       a a = (str6 == null) ? null : new a(str6);
/* 1116 */       FilerImpl filerImpl = new FilerImpl(file4, file3, a, bool3, bool11);
/*      */ 
/*      */       
/* 1119 */       XmlOptions xmlOptions = new XmlOptions();
/* 1120 */       if (schemaCodePrinter != null)
/* 1121 */         xmlOptions.setSchemaCodePrinter(schemaCodePrinter); 
/* 1122 */       if (str3 != null) {
/* 1123 */         xmlOptions.setGenerateJavaVersion(str3);
/*      */       }
/*      */       
/* 1126 */       schemaTypeSystem.save((Filer)filerImpl);
/*      */ 
/*      */       
/* 1129 */       bool12 &= SchemaTypeSystemCompiler.generateTypes(schemaTypeSystem, (Filer)filerImpl, xmlOptions);
/*      */       
/* 1131 */       if (bool11)
/*      */       {
/*      */         
/* 1134 */         SchemaCodeGenerator.deleteObsoleteFiles(file3, file3, new HashSet(filerImpl.getSourceFiles()));
/*      */       }
/*      */ 
/*      */       
/* 1138 */       if (bool12) {
/*      */         
/* 1140 */         l2 = System.currentTimeMillis();
/* 1141 */         if (!bool4) {
/* 1142 */           System.out.println("Time to generate code: " + ((l2 - l1) / 1000.0D) + " seconds");
/*      */         }
/*      */       } 
/*      */       
/* 1146 */       if (bool12 && !bool1) {
/*      */         
/* 1148 */         l1 = System.currentTimeMillis();
/*      */         
/* 1150 */         List list1 = filerImpl.getSourceFiles();
/*      */         
/* 1152 */         if (arrayOfFile3 != null)
/* 1153 */           list1.addAll(Arrays.asList(arrayOfFile3)); 
/* 1154 */         if (!CodeGenUtil.externalCompile(list1, file4, arrayOfFile5, bool2, str2, str3, str4, str5, bool4, bool3)) {
/* 1155 */           bool12 = false;
/*      */         }
/* 1157 */         l2 = System.currentTimeMillis();
/* 1158 */         if (bool12 && !paramParameters.isQuiet()) {
/* 1159 */           System.out.println("Time to compile code: " + ((l2 - l1) / 1000.0D) + " seconds");
/*      */         }
/*      */         
/* 1162 */         if (bool12 && file2 != null) {
/*      */ 
/*      */           
/*      */           try {
/* 1166 */             (new JarHelper()).jarDir(file4, file2);
/*      */           }
/* 1168 */           catch (IOException iOException) {
/*      */             
/* 1170 */             System.err.println("IO Error " + iOException);
/* 1171 */             bool12 = false;
/*      */           } 
/*      */           
/* 1174 */           if (bool12 && !paramParameters.isQuiet()) {
/* 1175 */             System.out.println("Compiled types to: " + file2);
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/* 1180 */     if (!bool12 && !bool4) {
/*      */       
/* 1182 */       System.out.println("BUILD FAILED");
/*      */     }
/*      */     else {
/*      */       
/* 1186 */       runExtensions(list, schemaTypeSystem, file4);
/*      */     } 
/*      */     
/* 1189 */     if (pathResourceLoader != null)
/* 1190 */       pathResourceLoader.close(); 
/* 1191 */     return bool12;
/*      */   }
/*      */ 
/*      */   
/*      */   private static void runExtensions(List paramList, SchemaTypeSystem paramSchemaTypeSystem, File paramFile) {
/* 1196 */     if (paramList != null && paramList.size() > 0) {
/*      */       
/* 1198 */       SchemaCompilerExtension schemaCompilerExtension = null;
/* 1199 */       Iterator iterator = paramList.iterator();
/* 1200 */       HashMap hashMap = null;
/* 1201 */       String str = null;
/*      */       
/*      */       try {
/* 1204 */         str = paramFile.getCanonicalPath();
/*      */       }
/* 1206 */       catch (IOException iOException) {
/*      */         
/* 1208 */         System.out.println("WARNING: Unable to get the path for schema jar file");
/* 1209 */         str = paramFile.getAbsolutePath();
/*      */       } 
/*      */       
/* 1212 */       while (iterator.hasNext()) {
/*      */         
/* 1214 */         Extension extension = iterator.next();
/*      */         
/*      */         try {
/* 1217 */           schemaCompilerExtension = extension.getClassName().newInstance();
/*      */         }
/* 1219 */         catch (InstantiationException instantiationException) {
/*      */           
/* 1221 */           System.out.println("UNABLE to instantiate schema compiler extension:" + extension.getClassName().getName());
/* 1222 */           System.out.println("EXTENSION Class was not run");
/*      */           
/*      */           break;
/* 1225 */         } catch (IllegalAccessException illegalAccessException) {
/*      */           
/* 1227 */           System.out.println("ILLEGAL ACCESS Exception when attempting to instantiate schema compiler extension: " + extension.getClassName().getName());
/* 1228 */           System.out.println("EXTENSION Class was not run");
/*      */           
/*      */           break;
/*      */         } 
/* 1232 */         System.out.println("Running Extension: " + schemaCompilerExtension.getExtensionName());
/* 1233 */         hashMap = new HashMap();
/* 1234 */         Iterator iterator1 = extension.getParams().iterator();
/* 1235 */         while (iterator1.hasNext()) {
/*      */           
/* 1237 */           Extension.Param param = iterator1.next();
/* 1238 */           hashMap.put(param.getName(), param.getValue());
/*      */         } 
/* 1240 */         hashMap.put("classesDir", str);
/* 1241 */         schemaCompilerExtension.schemaCompilerExtension(paramSchemaTypeSystem, hashMap);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean wsdlContainsEncoded(XmlObject paramXmlObject) {
/* 1250 */     XmlObject[] arrayOfXmlObject = paramXmlObject.selectPath("declare namespace soap='http://schemas.xmlsoap.org/wsdl/soap/' .//soap:body/@use|.//soap:header/@use|.//soap:fault/@use");
/*      */ 
/*      */     
/* 1253 */     for (byte b = 0; b < arrayOfXmlObject.length; b++) {
/*      */       
/* 1255 */       if ("encoded".equals(((SimpleValue)arrayOfXmlObject[b]).getStringValue()))
/* 1256 */         return true; 
/*      */     } 
/* 1258 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1266 */   private static final Map MAP_COMPATIBILITY_CONFIG_URIS = new HashMap(); static {
/* 1267 */     MAP_COMPATIBILITY_CONFIG_URIS.put("http://www.bea.com/2002/09/xbean/config", "http://xml.apache.org/xmlbeans/2004/02/xbean/config");
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\tool\SchemaCompiler.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */