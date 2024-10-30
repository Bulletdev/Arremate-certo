/*      */ package org.apache.xmlbeans.impl.tool;
/*      */ import java.io.DataInputStream;
/*      */ import java.io.File;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.io.PrintStream;
/*      */ import java.math.BigInteger;
/*      */ import java.util.HashSet;
/*      */ import java.util.zip.ZipEntry;
/*      */ import javax.xml.namespace.b;
/*      */ import org.apache.xmlbeans.QNameSet;
/*      */ import org.apache.xmlbeans.soap.SOAPArrayType;
/*      */ 
/*      */ public class XsbDumper {
/*      */   private String _indent;
/*      */   private PrintStream _out;
/*      */   public static final int DATA_BABE = -629491010;
/*      */   public static final int MAJOR_VERSION = 2;
/*      */   public static final int MINOR_VERSION = 24;
/*      */   public static final int FILETYPE_SCHEMAINDEX = 1;
/*      */   public static final int FILETYPE_SCHEMATYPE = 2;
/*      */   public static final int FILETYPE_SCHEMAELEMENT = 3;
/*      */   public static final int FILETYPE_SCHEMAATTRIBUTE = 4;
/*      */   public static final int FILETYPE_SCHEMAPOINTER = 5;
/*      */   public static final int FILETYPE_SCHEMAMODELGROUP = 6;
/*      */   public static final int FILETYPE_SCHEMAATTRIBUTEGROUP = 7;
/*      */   public static final int FLAG_PART_SKIPPABLE = 1;
/*      */   public static final int FLAG_PART_FIXED = 4;
/*      */   public static final int FLAG_PART_NILLABLE = 8;
/*      */   public static final int FLAG_PART_BLOCKEXT = 16;
/*      */   public static final int FLAG_PART_BLOCKREST = 32;
/*      */   public static final int FLAG_PART_BLOCKSUBST = 64;
/*      */   public static final int FLAG_PART_ABSTRACT = 128;
/*      */   public static final int FLAG_PART_FINALEXT = 256;
/*      */   public static final int FLAG_PART_FINALREST = 512;
/*      */   public static final int FLAG_PROP_ISATTR = 1;
/*      */   public static final int FLAG_PROP_JAVASINGLETON = 2;
/*      */   public static final int FLAG_PROP_JAVAOPTIONAL = 4;
/*      */   public static final int FLAG_PROP_JAVAARRAY = 8;
/*      */   
/*      */   public static void printUsage() {
/*   42 */     System.out.println("Prints the contents of an XSB file in human-readable form.");
/*   43 */     System.out.println("An XSB file contains schema meta information needed to ");
/*   44 */     System.out.println("perform tasks such as binding and validation.");
/*   45 */     System.out.println("Usage: dumpxsb myfile.xsb");
/*   46 */     System.out.println("    myfile.xsb - Path to an XSB file.");
/*   47 */     System.out.println();
/*      */   }
/*      */   public static final int FIELD_NONE = 0; public static final int FIELD_GLOBAL = 1; public static final int FIELD_LOCALATTR = 2; public static final int FIELD_LOCALELT = 3; static final int FLAG_SIMPLE_TYPE = 1; static final int FLAG_DOCUMENT_TYPE = 2; static final int FLAG_ORDERED = 4; static final int FLAG_BOUNDED = 8; static final int FLAG_FINITE = 16; static final int FLAG_NUMERIC = 32; static final int FLAG_STRINGENUM = 64; static final int FLAG_UNION_OF_LISTS = 128; static final int FLAG_HAS_PATTERN = 256; static final int FLAG_ORDER_SENSITIVE = 512; static final int FLAG_TOTAL_ORDER = 1024; static final int FLAG_COMPILED = 2048; static final int FLAG_BLOCK_EXT = 4096; static final int FLAG_BLOCK_REST = 8192; static final int FLAG_FINAL_EXT = 16384; static final int FLAG_FINAL_REST = 32768; static final int FLAG_FINAL_UNION = 65536; static final int FLAG_FINAL_LIST = 131072; static final int FLAG_ABSTRACT = 262144; static final int FLAG_ATTRIBUTE_TYPE = 524288; DataInputStream _input; StringPool _stringPool;
/*      */   
/*      */   public static void main(String[] paramArrayOfString) {
/*   52 */     if (paramArrayOfString.length == 0) {
/*   53 */       printUsage();
/*   54 */       System.exit(0);
/*      */       
/*      */       return;
/*      */     } 
/*   58 */     for (byte b = 0; b < paramArrayOfString.length; b++)
/*      */     {
/*   60 */       dump(new File(paramArrayOfString[b]), true);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private static void dump(File paramFile, boolean paramBoolean) {
/*   66 */     if (paramFile.isDirectory()) {
/*      */       
/*   68 */       File[] arrayOfFile = paramFile.listFiles(new FileFilter()
/*      */           {
/*      */             public boolean accept(File param1File)
/*      */             {
/*   72 */               return (param1File.isDirectory() || (param1File.isFile() && param1File.getName().endsWith(".xsb")));
/*      */             }
/*      */           });
/*   75 */       for (byte b = 0; b < arrayOfFile.length; b++)
/*      */       {
/*   77 */         dump(arrayOfFile[b], false);
/*      */       }
/*      */     }
/*   80 */     else if (paramFile.getName().endsWith(".jar") || paramFile.getName().endsWith(".zip")) {
/*      */       
/*   82 */       dumpZip(paramFile);
/*      */     }
/*   84 */     else if (paramBoolean || paramFile.getName().endsWith(".xsb")) {
/*      */ 
/*      */       
/*      */       try {
/*   88 */         System.out.println(paramFile.toString());
/*   89 */         dump(new FileInputStream(paramFile), "  ");
/*   90 */         System.out.println();
/*      */       }
/*   92 */       catch (FileNotFoundException fileNotFoundException) {
/*      */         
/*   94 */         System.out.println(fileNotFoundException.toString());
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static void dumpZip(File paramFile) {
/*      */     try {
/*  103 */       ZipFile zipFile = new ZipFile(paramFile);
/*  104 */       Enumeration enumeration = zipFile.entries();
/*  105 */       while (enumeration.hasMoreElements()) {
/*      */         
/*  107 */         ZipEntry zipEntry = enumeration.nextElement();
/*  108 */         if (zipEntry.getName().endsWith(".xsb"))
/*      */         {
/*  110 */           System.out.println(zipEntry.getName());
/*  111 */           dump(zipFile.getInputStream(zipEntry), "  ");
/*  112 */           System.out.println();
/*      */         }
/*      */       
/*      */       } 
/*  116 */     } catch (IOException iOException) {
/*      */       
/*  118 */       System.out.println(iOException.toString());
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static void dump(InputStream paramInputStream) {
/*  124 */     dump(paramInputStream, "", System.out);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void dump(InputStream paramInputStream, String paramString) {
/*  129 */     dump(paramInputStream, paramString, System.out);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void dump(InputStream paramInputStream, String paramString, PrintStream paramPrintStream) {
/*  134 */     XsbDumper xsbDumper = new XsbDumper(paramInputStream, paramString, paramPrintStream);
/*  135 */     xsbDumper.dumpAll();
/*      */   }
/*      */ 
/*      */   
/*      */   private XsbDumper(InputStream paramInputStream, String paramString, PrintStream paramPrintStream) {
/*  140 */     this._input = new DataInputStream(paramInputStream);
/*  141 */     this._indent = paramString;
/*  142 */     this._out = paramPrintStream;
/*      */   }
/*      */   
/*  145 */   void flush() { this._out.flush(); }
/*  146 */   void emit(String paramString) { this._out.println(this._indent + paramString); flush(); }
/*  147 */   void emit() { this._out.println(); flush(); }
/*  148 */   void error(Exception paramException) { this._out.println(paramException.toString()); flush(); IllegalStateException illegalStateException = new IllegalStateException(paramException.getMessage()); illegalStateException.initCause(paramException); throw illegalStateException; } void error(String paramString) {
/*  149 */     this._out.println(paramString); flush(); IllegalStateException illegalStateException = new IllegalStateException(paramString); throw illegalStateException;
/*      */   }
/*      */   
/*  152 */   void indent() { this._indent += "  "; } void outdent() {
/*  153 */     this._indent = this._indent.substring(0, this._indent.length() - 2);
/*      */   }
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
/*      */   static String filetypeString(int paramInt) {
/*  169 */     switch (paramInt) {
/*      */       case 1:
/*  171 */         return "FILETYPE_SCHEMAINDEX";
/*  172 */       case 2: return "FILETYPE_SCHEMATYPE";
/*  173 */       case 3: return "FILETYPE_SCHEMAELEMENT";
/*  174 */       case 4: return "FILETYPE_SCHEMAATTRIBUTE";
/*  175 */       case 5: return "FILETYPE_SCHEMAPOINTER";
/*  176 */       case 6: return "FILETYPE_SCHEMAMODELGROUP";
/*  177 */       case 7: return "FILETYPE_SCHEMAATTRIBUTEGROUP";
/*      */     } 
/*  179 */     return "Unknown FILETYPE (" + paramInt + ")";
/*      */   }
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
/*      */   static String particleflagsString(int paramInt) {
/*  195 */     StringBuffer stringBuffer = new StringBuffer();
/*  196 */     if ((paramInt & 0x1) != 0) stringBuffer.append("FLAG_PART_SKIPPABLE | "); 
/*  197 */     if ((paramInt & 0x4) != 0) stringBuffer.append("FLAG_PART_FIXED | "); 
/*  198 */     if ((paramInt & 0x8) != 0) stringBuffer.append("FLAG_PART_NILLABLE | "); 
/*  199 */     if ((paramInt & 0x10) != 0) stringBuffer.append("FLAG_PART_BLOCKEXT | "); 
/*  200 */     if ((paramInt & 0x20) != 0) stringBuffer.append("FLAG_PART_BLOCKREST | "); 
/*  201 */     if ((paramInt & 0x40) != 0) stringBuffer.append("FLAG_PART_BLOCKSUBST | "); 
/*  202 */     if ((paramInt & 0x80) != 0) stringBuffer.append("FLAG_PART_ABSTRACT | "); 
/*  203 */     if ((paramInt & 0x100) != 0) stringBuffer.append("FLAG_PART_FINALEXT | "); 
/*  204 */     if ((paramInt & 0x200) != 0) stringBuffer.append("FLAG_PART_FINALREST | "); 
/*  205 */     if (stringBuffer.length() == 0) stringBuffer.append("0 | "); 
/*  206 */     return stringBuffer.substring(0, stringBuffer.length() - 3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static String propertyflagsString(int paramInt) {
/*  216 */     StringBuffer stringBuffer = new StringBuffer();
/*  217 */     if ((paramInt & 0x1) != 0) stringBuffer.append("FLAG_PROP_ISATTR | "); 
/*  218 */     if ((paramInt & 0x2) != 0) stringBuffer.append("FLAG_PROP_JAVASINGLETON | "); 
/*  219 */     if ((paramInt & 0x4) != 0) stringBuffer.append("FLAG_PROP_JAVAOPTIONAL | "); 
/*  220 */     if ((paramInt & 0x8) != 0) stringBuffer.append("FLAG_PROP_JAVAARRAY | "); 
/*  221 */     if (stringBuffer.length() == 0) stringBuffer.append("0 | "); 
/*  222 */     return stringBuffer.substring(0, stringBuffer.length() - 3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static String containerfieldTypeString(int paramInt) {
/*  232 */     switch (paramInt) {
/*      */       case 0:
/*  234 */         return "FIELD_NONE";
/*  235 */       case 1: return "FIELD_GLOBAL";
/*  236 */       case 2: return "FIELD_LOCALATTR";
/*  237 */       case 3: return "FIELD_LOCALELT";
/*      */     } 
/*  239 */     return "Unknown container field type (" + paramInt + ")";
/*      */   }
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
/*      */   static String typeflagsString(int paramInt) {
/*  267 */     StringBuffer stringBuffer = new StringBuffer();
/*  268 */     if ((paramInt & 0x1) != 0) stringBuffer.append("FLAG_SIMPLE_TYPE | "); 
/*  269 */     if ((paramInt & 0x2) != 0) stringBuffer.append("FLAG_DOCUMENT_TYPE | "); 
/*  270 */     if ((paramInt & 0x80000) != 0) stringBuffer.append("FLAG_ATTRIBUTE_TYPE | "); 
/*  271 */     if ((paramInt & 0x4) != 0) stringBuffer.append("FLAG_ORDERED | "); 
/*  272 */     if ((paramInt & 0x8) != 0) stringBuffer.append("FLAG_BOUNDED | "); 
/*  273 */     if ((paramInt & 0x10) != 0) stringBuffer.append("FLAG_FINITE | "); 
/*  274 */     if ((paramInt & 0x20) != 0) stringBuffer.append("FLAG_NUMERIC | "); 
/*  275 */     if ((paramInt & 0x40) != 0) stringBuffer.append("FLAG_STRINGENUM | "); 
/*  276 */     if ((paramInt & 0x80) != 0) stringBuffer.append("FLAG_UNION_OF_LISTS | "); 
/*  277 */     if ((paramInt & 0x100) != 0) stringBuffer.append("FLAG_HAS_PATTERN | "); 
/*  278 */     if ((paramInt & 0x400) != 0) stringBuffer.append("FLAG_TOTAL_ORDER | "); 
/*  279 */     if ((paramInt & 0x800) != 0) stringBuffer.append("FLAG_COMPILED | "); 
/*  280 */     if ((paramInt & 0x1000) != 0) stringBuffer.append("FLAG_BLOCK_EXT | "); 
/*  281 */     if ((paramInt & 0x2000) != 0) stringBuffer.append("FLAG_BLOCK_REST | "); 
/*  282 */     if ((paramInt & 0x4000) != 0) stringBuffer.append("FLAG_FINAL_EXT | "); 
/*  283 */     if ((paramInt & 0x8000) != 0) stringBuffer.append("FLAG_FINAL_REST | "); 
/*  284 */     if ((paramInt & 0x10000) != 0) stringBuffer.append("FLAG_FINAL_UNION | "); 
/*  285 */     if ((paramInt & 0x20000) != 0) stringBuffer.append("FLAG_FINAL_LIST | "); 
/*  286 */     if ((paramInt & 0x40000) != 0) stringBuffer.append("FLAG_ABSTRACT | "); 
/*  287 */     if (stringBuffer.length() == 0) stringBuffer.append("0 | "); 
/*  288 */     return stringBuffer.substring(0, stringBuffer.length() - 3);
/*      */   }
/*      */ 
/*      */   
/*      */   void dumpAll() {
/*  293 */     int i = dumpHeader();
/*  294 */     switch (i) {
/*      */       
/*      */       case 1:
/*  297 */         dumpIndexData();
/*      */         return;
/*      */       case 2:
/*  300 */         dumpTypeFileData();
/*      */         break;
/*      */       case 3:
/*  303 */         dumpParticleData(true);
/*      */         break;
/*      */       case 4:
/*  306 */         dumpAttributeData(true);
/*      */         break;
/*      */       case 5:
/*  309 */         dumpPointerData();
/*      */         break;
/*      */       case 6:
/*  312 */         dumpModelGroupData();
/*      */         break;
/*      */       case 7:
/*  315 */         dumpAttributeGroupData();
/*      */         break;
/*      */     } 
/*  318 */     readEnd();
/*      */   }
/*      */ 
/*      */   
/*      */   static String hex32String(int paramInt) {
/*  323 */     return Integer.toHexString(paramInt);
/*      */   }
/*      */ 
/*      */   
/*      */   protected int dumpHeader() {
/*  328 */     int i = readInt();
/*  329 */     emit("Magic cookie: " + hex32String(i));
/*      */     
/*  331 */     if (i != -629491010) {
/*      */       
/*  333 */       emit("Wrong magic cookie.");
/*  334 */       return 0;
/*      */     } 
/*      */     
/*  337 */     this._majorver = readShort();
/*  338 */     this._minorver = readShort();
/*  339 */     if (atLeast(2, 18, 0)) {
/*  340 */       this._releaseno = readShort();
/*      */     }
/*  342 */     emit("Major version: " + this._majorver);
/*  343 */     emit("Minor version: " + this._minorver);
/*  344 */     emit("Release number: " + this._releaseno);
/*      */     
/*  346 */     if (this._majorver != 2 || this._minorver > 24) {
/*      */       
/*  348 */       emit("Incompatible version.");
/*  349 */       return 0;
/*      */     } 
/*      */     
/*  352 */     int j = readShort();
/*  353 */     emit("Filetype: " + filetypeString(j));
/*      */     
/*  355 */     this._stringPool = new StringPool();
/*  356 */     this._stringPool.readFrom(this._input);
/*      */     
/*  358 */     return j;
/*      */   }
/*      */ 
/*      */   
/*      */   void dumpPointerData() {
/*  363 */     emit("Type system: " + readString());
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void dumpIndexData() {
/*  369 */     int i = readShort();
/*  370 */     emit("Handle pool (" + i + "):");
/*  371 */     indent();
/*  372 */     for (byte b = 0; b < i; b++) {
/*      */       
/*  374 */       String str = readString();
/*  375 */       int j = readShort();
/*  376 */       emit(str + " (" + filetypeString(j) + ")");
/*      */     } 
/*  378 */     outdent();
/*      */     
/*  380 */     dumpQNameMap("Global elements");
/*      */ 
/*      */     
/*  383 */     dumpQNameMap("Global attributes");
/*      */ 
/*      */     
/*  386 */     dumpQNameMap("Model groups");
/*  387 */     dumpQNameMap("Attribute groups");
/*      */     
/*  389 */     dumpQNameMap("Identity constraints");
/*      */ 
/*      */     
/*  392 */     dumpQNameMap("Global types");
/*      */ 
/*      */     
/*  395 */     dumpQNameMap("Document types");
/*      */ 
/*      */     
/*  398 */     dumpQNameMap("Attribute types");
/*      */ 
/*      */     
/*  401 */     dumpClassnameIndex("All types by classname");
/*      */ 
/*      */     
/*  404 */     dumpStringArray("Defined namespaces");
/*      */ 
/*      */     
/*  407 */     if (atLeast(2, 15, 0)) {
/*      */       
/*  409 */       dumpQNameMap("Redefined global types");
/*  410 */       dumpQNameMap("Redfined model groups");
/*  411 */       dumpQNameMap("Redfined attribute groups");
/*      */     } 
/*      */ 
/*      */     
/*  415 */     if (atLeast(2, 19, 0)) {
/*  416 */       dumpAnnotations();
/*      */     }
/*  418 */     readEnd();
/*      */   }
/*      */ 
/*      */   
/*      */   class StringPool
/*      */   {
/*  424 */     private List intsToStrings = new ArrayList();
/*  425 */     private Map stringsToInts = new HashMap();
/*      */     private final XsbDumper this$0;
/*      */     
/*      */     StringPool() {
/*  429 */       this.intsToStrings.add(null);
/*      */     }
/*      */ 
/*      */     
/*      */     String stringForCode(int param1Int) {
/*  434 */       if (param1Int == 0)
/*  435 */         return null; 
/*  436 */       return this.intsToStrings.get(param1Int);
/*      */     }
/*      */ 
/*      */     
/*      */     int codeForString(String param1String) {
/*  441 */       if (param1String == null)
/*  442 */         return 0; 
/*  443 */       Integer integer = (Integer)this.stringsToInts.get(param1String);
/*  444 */       if (integer == null) {
/*      */         
/*  446 */         integer = new Integer(this.intsToStrings.size());
/*  447 */         this.intsToStrings.add(param1String);
/*  448 */         this.stringsToInts.put(param1String, integer);
/*      */       } 
/*  450 */       return integer.intValue();
/*      */     }
/*      */ 
/*      */     
/*      */     void readFrom(DataInputStream param1DataInputStream) {
/*  455 */       if (this.intsToStrings.size() != 1 || this.stringsToInts.size() != 0) {
/*  456 */         throw new IllegalStateException();
/*      */       }
/*      */       
/*      */       try {
/*  460 */         short s = param1DataInputStream.readShort();
/*  461 */         XsbDumper.this.emit("String pool (" + s + "):");
/*  462 */         XsbDumper.this.indent();
/*  463 */         for (byte b = 1; b < s; b++) {
/*      */           
/*  465 */           String str = param1DataInputStream.readUTF();
/*  466 */           int i = codeForString(str);
/*  467 */           if (i != b)
/*  468 */             throw new IllegalStateException(); 
/*  469 */           XsbDumper.this.emit(i + " = \"" + str + "\"");
/*      */         } 
/*  471 */         XsbDumper.this.outdent();
/*      */       }
/*  473 */       catch (IOException iOException) {
/*      */         
/*  475 */         XsbDumper.this.emit(iOException.toString());
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   int readShort() {
/*      */     try {
/*  488 */       return this._input.readUnsignedShort();
/*      */     }
/*  490 */     catch (IOException iOException) {
/*      */       
/*  492 */       error(iOException);
/*  493 */       return 0;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   int readInt() {
/*      */     try {
/*  501 */       return this._input.readInt();
/*      */     }
/*  503 */     catch (IOException iOException) {
/*      */       
/*  505 */       error(iOException);
/*  506 */       return 0;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   String readString() {
/*  512 */     return this._stringPool.stringForCode(readShort());
/*      */   }
/*      */ 
/*      */   
/*      */   b readQName() {
/*  517 */     String str1 = readString();
/*  518 */     String str2 = readString();
/*  519 */     if (str2 == null)
/*  520 */       return null; 
/*  521 */     return new b(str1, str2);
/*      */   }
/*      */ 
/*      */   
/*      */   String readHandle() {
/*  526 */     return readString();
/*      */   }
/*      */ 
/*      */   
/*      */   String readType() {
/*  531 */     return readHandle();
/*      */   }
/*      */ 
/*      */   
/*      */   static String qnameString(b paramb) {
/*  536 */     if (paramb == null)
/*  537 */       return "(null)"; 
/*  538 */     if (paramb.getNamespaceURI() != null) {
/*  539 */       return paramb.dT() + "@" + paramb.getNamespaceURI();
/*      */     }
/*  541 */     return paramb.dT();
/*      */   }
/*      */ 
/*      */   
/*      */   static String qnameSetString(QNameSet paramQNameSet) {
/*  546 */     return paramQNameSet.toString();
/*      */   }
/*      */ 
/*      */   
/*      */   void dumpQNameMap(String paramString) {
/*  551 */     int i = readShort();
/*  552 */     emit(paramString + " (" + i + "):");
/*  553 */     indent();
/*  554 */     for (byte b = 0; b < i; b++)
/*      */     {
/*  556 */       emit(qnameString(readQName()) + " = " + readHandle());
/*      */     }
/*  558 */     outdent();
/*      */   }
/*      */ 
/*      */   
/*      */   void dumpTypeArray(String paramString) {
/*  563 */     int i = readShort();
/*  564 */     emit(paramString + " (" + i + "):");
/*  565 */     indent();
/*  566 */     for (byte b = 0; b < i; b++)
/*      */     {
/*  568 */       emit(b + " = " + readType());
/*      */     }
/*  570 */     outdent();
/*      */   }
/*      */ 
/*      */   
/*      */   void dumpClassnameIndex(String paramString) {
/*  575 */     int i = readShort();
/*  576 */     emit(paramString + " (" + i + "):");
/*  577 */     indent();
/*  578 */     for (byte b = 0; b < i; b++)
/*      */     {
/*  580 */       emit(readString() + " = " + readType());
/*      */     }
/*  582 */     outdent();
/*      */   }
/*      */ 
/*      */   
/*      */   void dumpStringArray(String paramString) {
/*  587 */     int i = readShort();
/*  588 */     emit(paramString + " (" + i + "):");
/*  589 */     indent();
/*  590 */     for (byte b = 0; b < i; b++)
/*      */     {
/*  592 */       emit(readString());
/*      */     }
/*  594 */     outdent();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   void readEnd() {
/*      */     try {
/*  601 */       this._input.close();
/*      */     }
/*  603 */     catch (IOException iOException) {}
/*      */ 
/*      */ 
/*      */     
/*  607 */     this._input = null;
/*  608 */     this._stringPool = null;
/*      */   }
/*      */ 
/*      */   
/*      */   static String particleTypeString(int paramInt) {
/*  613 */     switch (paramInt) {
/*      */       case 1:
/*  615 */         return "ALL";
/*  616 */       case 2: return "CHOICE";
/*  617 */       case 4: return "ELEMENT";
/*  618 */       case 3: return "SEQUENCE";
/*  619 */       case 5: return "WILDCARD";
/*      */     } 
/*  621 */     return "Unknown particle type (" + paramInt + ")";
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   static String bigIntegerString(BigInteger paramBigInteger) {
/*  627 */     if (paramBigInteger == null)
/*  628 */       return "(null)"; 
/*  629 */     return paramBigInteger.toString();
/*      */   }
/*      */ 
/*      */   
/*      */   static String wcprocessString(int paramInt) {
/*  634 */     switch (paramInt) {
/*      */       case 1:
/*  636 */         return "STRICT";
/*  637 */       case 3: return "SKIP";
/*  638 */       case 2: return "LAX";
/*  639 */       case 0: return "NOT_WILDCARD";
/*      */     } 
/*  641 */     return "Unknown process type (" + paramInt + ")";
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   void dumpAnnotation() {
/*  647 */     if (!atLeast(2, 19, 0)) {
/*      */       return;
/*      */     }
/*  650 */     int i = readInt();
/*  651 */     if (i == -1)
/*      */       return; 
/*  653 */     emit("Annotation");
/*  654 */     boolean bool = true;
/*  655 */     indent();
/*  656 */     if (i > 0) {
/*      */       
/*  658 */       emit("Attributes (" + i + "):");
/*  659 */       indent();
/*  660 */       for (byte b = 0; b < i; b++) {
/*      */         
/*  662 */         if (atLeast(2, 24, 0)) {
/*  663 */           emit("Name: " + qnameString(readQName()) + ", Value: " + readString() + ", ValueURI: " + readString());
/*      */         }
/*      */         else {
/*      */           
/*  667 */           emit("Name: " + qnameString(readQName()) + ", Value: " + readString());
/*      */         } 
/*      */       } 
/*  670 */       outdent();
/*  671 */       bool = false;
/*      */     } 
/*      */     
/*  674 */     i = readInt();
/*  675 */     if (i > 0) {
/*      */       
/*  677 */       emit("Documentation elements (" + i + "):");
/*  678 */       indent();
/*  679 */       for (byte b = 0; b < i; b++)
/*  680 */         emit(readString()); 
/*  681 */       outdent();
/*  682 */       bool = false;
/*      */     } 
/*      */     
/*  685 */     i = readInt();
/*  686 */     if (i > 0) {
/*      */       
/*  688 */       emit("Appinfo elements (" + i + "):");
/*  689 */       indent();
/*  690 */       for (byte b = 0; b < i; b++)
/*  691 */         emit(readString()); 
/*  692 */       outdent();
/*  693 */       bool = false;
/*      */     } 
/*  695 */     if (bool)
/*  696 */       emit("<empty>"); 
/*  697 */     outdent();
/*      */   }
/*      */ 
/*      */   
/*      */   void dumpAnnotations() {
/*  702 */     int i = readInt();
/*  703 */     if (i > 0) {
/*      */       
/*  705 */       emit("Top-level annotations (" + i + "):");
/*  706 */       indent();
/*  707 */       for (byte b = 0; b < i; b++)
/*  708 */         dumpAnnotation(); 
/*  709 */       outdent();
/*      */     } 
/*      */   }
/*      */   void dumpParticleData(boolean paramBoolean) {
/*      */     int k;
/*      */     byte b;
/*  715 */     int i = readShort();
/*  716 */     emit(particleTypeString(i) + ":");
/*  717 */     indent();
/*  718 */     int j = readShort();
/*  719 */     emit("Flags: " + particleflagsString(j));
/*      */     
/*  721 */     emit("MinOccurs: " + bigIntegerString(readBigInteger()));
/*  722 */     emit("MaxOccurs: " + bigIntegerString(readBigInteger()));
/*      */     
/*  724 */     emit("Transition: " + qnameSetString(readQNameSet()));
/*      */     
/*  726 */     switch (i) {
/*      */       
/*      */       case 5:
/*  729 */         emit("Wildcard set: " + qnameSetString(readQNameSet()));
/*  730 */         emit("Wildcard process: " + wcprocessString(readShort()));
/*      */         break;
/*      */       
/*      */       case 4:
/*  734 */         emit("Name: " + qnameString(readQName()));
/*  735 */         emit("Type: " + readType());
/*  736 */         emit("Default: " + readString());
/*  737 */         if (atLeast(2, 16, 0))
/*  738 */           emit("Default value: " + readXmlValueObject()); 
/*  739 */         emit("WsdlArrayType: " + SOAPArrayTypeString(readSOAPArrayType()));
/*  740 */         dumpAnnotation();
/*  741 */         if (paramBoolean) {
/*      */           
/*  743 */           if (atLeast(2, 17, 0))
/*  744 */             emit("Substitution group ref: " + readHandle()); 
/*  745 */           int m = readShort();
/*  746 */           emit("Substitution group members (" + m + ")");
/*  747 */           indent();
/*  748 */           for (byte b1 = 0; b1 < m; b1++)
/*      */           {
/*  750 */             emit(qnameString(readQName()));
/*      */           }
/*  752 */           outdent();
/*      */         } 
/*  754 */         k = readShort();
/*  755 */         emit("Identity constraints (" + k + "):");
/*  756 */         indent();
/*  757 */         for (b = 0; b < k; b++)
/*      */         {
/*  759 */           emit(readHandle());
/*      */         }
/*  761 */         outdent();
/*  762 */         if (paramBoolean) {
/*  763 */           emit("Filename: " + readString());
/*      */         }
/*      */         break;
/*      */       case 1:
/*      */       case 2:
/*      */       case 3:
/*  769 */         dumpParticleArray("Particle children");
/*      */         break;
/*      */       
/*      */       default:
/*  773 */         error("Unrecognized schema particle type"); break;
/*      */     } 
/*  775 */     outdent();
/*      */   }
/*      */ 
/*      */   
/*      */   void dumpParticleArray(String paramString) {
/*  780 */     int i = readShort();
/*  781 */     emit(paramString + "(" + i + "):");
/*  782 */     indent();
/*  783 */     for (byte b = 0; b < i; b++)
/*  784 */       dumpParticleData(false); 
/*  785 */     outdent();
/*      */   }
/*      */ 
/*      */   
/*      */   static String complexVarietyString(int paramInt) {
/*  790 */     switch (paramInt) {
/*      */       case 1:
/*  792 */         return "EMPTY_CONTENT";
/*  793 */       case 2: return "SIMPLE_CONTENT";
/*  794 */       case 3: return "ELEMENT_CONTENT";
/*  795 */       case 4: return "MIXED_CONTENT";
/*      */     } 
/*  797 */     return "Unknown complex variety (" + paramInt + ")";
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   static String simpleVarietyString(int paramInt) {
/*  803 */     switch (paramInt) {
/*      */       case 1:
/*  805 */         return "ATOMIC";
/*  806 */       case 3: return "LIST";
/*  807 */       case 2: return "UNION";
/*      */     } 
/*  809 */     return "Unknown simple variety (" + paramInt + ")";
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   String facetCodeString(int paramInt) {
/*  815 */     switch (paramInt) {
/*      */       case 0:
/*  817 */         return "FACET_LENGTH";
/*  818 */       case 1: return "FACET_MIN_LENGTH";
/*  819 */       case 2: return "FACET_MAX_LENGTH";
/*  820 */       case 3: return "FACET_MIN_EXCLUSIVE";
/*  821 */       case 4: return "FACET_MIN_INCLUSIVE";
/*  822 */       case 5: return "FACET_MAX_INCLUSIVE";
/*  823 */       case 6: return "FACET_MAX_EXCLUSIVE";
/*  824 */       case 7: return "FACET_TOTAL_DIGITS";
/*  825 */       case 8: return "FACET_FRACTION_DIGITS";
/*      */     } 
/*  827 */     return "Unknown facet code (" + paramInt + ")";
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   String whitespaceCodeString(int paramInt) {
/*  833 */     switch (paramInt) {
/*      */       case 3:
/*  835 */         return "WS_COLLAPSE";
/*  836 */       case 1: return "WS_PRESERVE";
/*  837 */       case 2: return "WS_REPLACE";
/*  838 */       case 0: return "WS_UNSPECIFIED";
/*      */     } 
/*  840 */     return "Unknown whitespace code (" + paramInt + ")";
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   String derivationTypeString(int paramInt) {
/*  846 */     switch (paramInt) {
/*      */       case 0:
/*  848 */         return "DT_NOT_DERIVED";
/*  849 */       case 1: return "DT_RESTRICTION";
/*  850 */       case 2: return "DT_EXTENSION";
/*      */     } 
/*  852 */     return "Unknown derivation code (" + paramInt + ")";
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   void dumpTypeFileData() {
/*  858 */     emit("Name: " + qnameString(readQName()));
/*  859 */     emit("Outer type: " + readType());
/*  860 */     emit("Depth: " + readShort());
/*  861 */     emit("Base type: " + readType());
/*  862 */     emit("Derivation type: " + derivationTypeString(readShort()));
/*  863 */     dumpAnnotation();
/*      */     
/*  865 */     emit("Container field:");
/*  866 */     indent();
/*  867 */     int i = readShort();
/*  868 */     emit("Reftype: " + containerfieldTypeString(i));
/*  869 */     switch (i) {
/*      */       
/*      */       case 1:
/*  872 */         emit("Handle: " + readHandle());
/*      */         break;
/*      */       case 2:
/*  875 */         emit("Index: " + readShort());
/*      */         break;
/*      */       case 3:
/*  878 */         emit("Index: " + readShort());
/*      */         break;
/*      */     } 
/*  881 */     outdent();
/*  882 */     emit("Java class name: " + readString());
/*  883 */     emit("Java impl class name: " + readString());
/*      */     
/*  885 */     dumpTypeArray("Anonymous types");
/*      */     
/*  887 */     emit("Anonymous union member ordinal: " + readShort());
/*      */ 
/*      */     
/*  890 */     int j = readInt();
/*  891 */     emit("Flags: " + typeflagsString(j));
/*  892 */     boolean bool = ((j & 0x1) == 0) ? true : false;
/*      */     
/*  894 */     int k = 0;
/*  895 */     if (bool) {
/*      */       
/*  897 */       k = readShort();
/*  898 */       emit("Complex variety: " + complexVarietyString(k));
/*      */       
/*  900 */       if (atLeast(2, 23, 0)) {
/*  901 */         emit("Content based on type: " + readType());
/*      */       }
/*  903 */       int m = readShort();
/*  904 */       emit("Attribute model (" + m + "):");
/*  905 */       indent(); int n;
/*  906 */       for (n = 0; n < m; n++) {
/*  907 */         dumpAttributeData(false);
/*      */       }
/*  909 */       emit("Wildcard set: " + qnameSetString(readQNameSet()));
/*  910 */       emit("Wildcard process: " + wcprocessString(readShort()));
/*  911 */       outdent();
/*      */ 
/*      */       
/*  914 */       n = readShort();
/*  915 */       emit("Attribute properties (" + n + "):");
/*  916 */       indent(); int i1;
/*  917 */       for (i1 = 0; i1 < n; i1++)
/*      */       {
/*  919 */         dumpPropertyData();
/*      */       }
/*  921 */       outdent();
/*      */       
/*  923 */       if (k == 3 || k == 4) {
/*      */         
/*  925 */         emit("IsAll: " + readShort());
/*      */ 
/*      */         
/*  928 */         dumpParticleArray("Content model");
/*      */ 
/*      */         
/*  931 */         i1 = readShort();
/*  932 */         emit("Element properties (" + i1 + "):");
/*  933 */         indent();
/*  934 */         for (byte b = 0; b < i1; b++)
/*      */         {
/*  936 */           dumpPropertyData();
/*      */         }
/*  938 */         outdent();
/*      */       } 
/*      */     } 
/*      */     
/*  942 */     if (!bool || k == 2) {
/*      */       
/*  944 */       int m = readShort();
/*  945 */       emit("Simple type variety: " + simpleVarietyString(m));
/*      */       
/*  947 */       boolean bool1 = ((j & 0x40) != 0) ? true : false;
/*      */       
/*  949 */       int n = readShort();
/*  950 */       emit("Facets (" + n + "):");
/*  951 */       indent(); int i1;
/*  952 */       for (i1 = 0; i1 < n; i1++) {
/*      */         
/*  954 */         emit(facetCodeString(readShort()));
/*  955 */         emit("Value: " + readXmlValueObject());
/*  956 */         emit("Fixed: " + readShort());
/*      */       } 
/*  958 */       outdent();
/*      */       
/*  960 */       emit("Whitespace rule: " + whitespaceCodeString(readShort()));
/*      */       
/*  962 */       i1 = readShort();
/*  963 */       emit("Patterns (" + i1 + "):");
/*  964 */       indent(); int i2;
/*  965 */       for (i2 = 0; i2 < i1; i2++)
/*      */       {
/*  967 */         emit(readString());
/*      */       }
/*  969 */       outdent();
/*      */       
/*  971 */       i2 = readShort();
/*  972 */       emit("Enumeration values (" + i2 + "):");
/*  973 */       indent(); int i3;
/*  974 */       for (i3 = 0; i3 < i2; i3++)
/*      */       {
/*  976 */         emit(readXmlValueObject());
/*      */       }
/*  978 */       outdent();
/*      */       
/*  980 */       emit("Base enum type: " + readType());
/*  981 */       if (bool1) {
/*      */         
/*  983 */         i3 = readShort();
/*  984 */         emit("String enum entries (" + i3 + "):");
/*  985 */         indent();
/*  986 */         for (byte b = 0; b < i3; b++)
/*      */         {
/*  988 */           emit("\"" + readString() + "\" -> " + readShort() + " = " + readString());
/*      */         }
/*  990 */         outdent();
/*      */       } 
/*      */       
/*  993 */       switch (m) {
/*      */         
/*      */         case 1:
/*  996 */           emit("Primitive type: " + readType());
/*  997 */           emit("Decimal size: " + readInt());
/*      */           break;
/*      */         
/*      */         case 3:
/* 1001 */           emit("List item type: " + readType());
/*      */           break;
/*      */         
/*      */         case 2:
/* 1005 */           dumpTypeArray("Union members");
/*      */           break;
/*      */         
/*      */         default:
/* 1009 */           error("Unknown simple type variety");
/*      */           break;
/*      */       } 
/*      */     } 
/* 1013 */     emit("Filename: " + readString());
/*      */   }
/*      */ 
/*      */   
/*      */   static String attruseCodeString(int paramInt) {
/* 1018 */     switch (paramInt) {
/*      */       case 2:
/* 1020 */         return "OPTIONAL";
/* 1021 */       case 3: return "REQUIRED";
/* 1022 */       case 1: return "PROHIBITED";
/*      */     } 
/* 1024 */     return "Unknown use code (" + paramInt + ")";
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   void dumpAttributeData(boolean paramBoolean) {
/* 1030 */     emit("Name: " + qnameString(readQName()));
/* 1031 */     emit("Type: " + readType());
/* 1032 */     emit("Use: " + attruseCodeString(readShort()));
/* 1033 */     emit("Default: " + readString());
/* 1034 */     if (atLeast(2, 16, 0))
/* 1035 */       emit("Default value: " + readXmlValueObject()); 
/* 1036 */     emit("Fixed: " + readShort());
/* 1037 */     emit("WsdlArrayType: " + SOAPArrayTypeString(readSOAPArrayType()));
/* 1038 */     dumpAnnotation();
/* 1039 */     if (paramBoolean)
/* 1040 */       emit("Filename: " + readString()); 
/*      */   }
/*      */   
/* 1043 */   private static final XmlOptions prettyOptions = (new XmlOptions()).setSavePrettyPrint();
/*      */ 
/*      */ 
/*      */   
/*      */   void dumpXml() {
/* 1048 */     String str = readString();
/*      */     
/*      */     try {
/* 1051 */       emit(XmlObject.Factory.parse(str).xmlText(prettyOptions));
/*      */     }
/* 1053 */     catch (XmlException xmlException) {
/*      */       
/* 1055 */       emit("!!!!!! BAD XML !!!!!");
/* 1056 */       emit(str);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   void dumpModelGroupData() {
/* 1062 */     emit("Name: " + qnameString(readQName()));
/* 1063 */     emit("Target namespace: " + readString());
/* 1064 */     emit("Chameleon: " + readShort());
/* 1065 */     if (atLeast(2, 22, 0))
/* 1066 */       emit("Element form default: " + readString()); 
/* 1067 */     if (atLeast(2, 22, 0))
/* 1068 */       emit("Attribute form default: " + readString()); 
/* 1069 */     if (atLeast(2, 15, 0))
/* 1070 */       emit("Redefine: " + readShort()); 
/* 1071 */     emit("Model Group Xml: ");
/* 1072 */     dumpXml();
/* 1073 */     dumpAnnotation();
/* 1074 */     if (atLeast(2, 21, 0)) {
/* 1075 */       emit("Filename: " + readString());
/*      */     }
/*      */   }
/*      */   
/*      */   void dumpAttributeGroupData() {
/* 1080 */     emit("Name: " + qnameString(readQName()));
/* 1081 */     emit("Target namespace: " + readString());
/* 1082 */     emit("Chameleon: " + readShort());
/* 1083 */     if (atLeast(2, 22, 0))
/* 1084 */       emit("Form default: " + readString()); 
/* 1085 */     if (atLeast(2, 15, 0))
/* 1086 */       emit("Redefine: " + readShort()); 
/* 1087 */     emit("Attribute Group Xml: ");
/* 1088 */     dumpXml();
/* 1089 */     dumpAnnotation();
/* 1090 */     if (atLeast(2, 21, 0)) {
/* 1091 */       emit("Filename: " + readString());
/*      */     }
/*      */   }
/*      */   
/*      */   static String alwaysString(int paramInt) {
/* 1096 */     switch (paramInt) {
/*      */       case 2:
/* 1098 */         return "CONSISTENTLY";
/* 1099 */       case 0: return "NEVER";
/* 1100 */       case 1: return "VARIABLE";
/*      */     } 
/* 1102 */     return "Unknown frequency code (" + paramInt + ")";
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   static String jtcString(int paramInt) {
/* 1108 */     switch (paramInt) {
/*      */       case 0:
/* 1110 */         return "XML_OBJECT";
/* 1111 */       case 1: return "JAVA_BOOLEAN";
/* 1112 */       case 2: return "JAVA_FLOAT";
/* 1113 */       case 3: return "JAVA_DOUBLE";
/* 1114 */       case 4: return "JAVA_BYTE";
/* 1115 */       case 5: return "JAVA_SHORT";
/* 1116 */       case 6: return "JAVA_INT";
/* 1117 */       case 7: return "JAVA_LONG";
/*      */       case 8:
/* 1119 */         return "JAVA_BIG_DECIMAL";
/* 1120 */       case 9: return "JAVA_BIG_INTEGER";
/* 1121 */       case 10: return "JAVA_STRING";
/* 1122 */       case 11: return "JAVA_BYTE_ARRAY";
/* 1123 */       case 12: return "JAVA_GDATE";
/* 1124 */       case 13: return "JAVA_GDURATION";
/* 1125 */       case 14: return "JAVA_DATE";
/* 1126 */       case 15: return "JAVA_QNAME";
/* 1127 */       case 17: return "JAVA_CALENDAR";
/* 1128 */       case 16: return "JAVA_LIST";
/*      */       case 18:
/* 1130 */         return "JAVA_ENUM";
/* 1131 */       case 19: return "JAVA_OBJECT";
/*      */     } 
/*      */     
/* 1134 */     return "Unknown java type code (" + paramInt + ")";
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   void dumpPropertyData() {
/* 1140 */     emit("Property");
/* 1141 */     indent();
/* 1142 */     emit("Name: " + qnameString(readQName()));
/* 1143 */     emit("Type: " + readType());
/* 1144 */     int i = readShort();
/* 1145 */     emit("Flags: " + propertyflagsString(i));
/* 1146 */     emit("Container type: " + readType());
/* 1147 */     emit("Min occurances: " + bigIntegerString(readBigInteger()));
/* 1148 */     emit("Max occurances: " + bigIntegerString(readBigInteger()));
/* 1149 */     emit("Nillable: " + alwaysString(readShort()));
/* 1150 */     emit("Default: " + alwaysString(readShort()));
/* 1151 */     emit("Fixed: " + alwaysString(readShort()));
/* 1152 */     emit("Default text: " + readString());
/* 1153 */     emit("Java prop name: " + readString());
/* 1154 */     emit("Java type code: " + jtcString(readShort()));
/* 1155 */     emit("Type for java signature: " + readType());
/* 1156 */     if (atMost(2, 19, 0))
/* 1157 */       emit("Java setter delimiter: " + qnameSetString(readQNameSet())); 
/* 1158 */     if (atLeast(2, 16, 0))
/* 1159 */       emit("Default value: " + readXmlValueObject()); 
/* 1160 */     if ((i & 0x1) == 0 && atLeast(2, 17, 0)) {
/*      */       
/* 1162 */       int j = readShort();
/* 1163 */       emit("Accepted substitutions (" + j + "):");
/* 1164 */       for (byte b = 0; b < j; b++)
/* 1165 */         emit("  Accepted name " + readQName()); 
/*      */     } 
/* 1167 */     outdent();
/*      */   }
/*      */ 
/*      */   
/*      */   String readXmlValueObject() {
/* 1172 */     String str1 = readType();
/* 1173 */     if (str1 == null) {
/* 1174 */       return "null";
/*      */     }
/* 1176 */     int i = readShort();
/*      */     
/* 1178 */     switch (i)
/*      */     { default:
/*      */         assert false;
/*      */       
/*      */       case 0:
/* 1183 */         str2 = "nil";
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1222 */         return str2 + " (" + str1 + ": " + i + ")";case 2: case 3: case 6: case 11: case 12: case 13: case 14: case 15: case 16: case 17: case 18: case 19: case 20: case 21: str2 = readString(); return str2 + " (" + str1 + ": " + i + ")";case 4: case 5: str2 = new String(HexBin.encode(readByteArray())); if (str2.length() > 19) str2 = str2.subSequence(0, 16) + "...";  return str2 + " (" + str1 + ": " + i + ")";case 7: case 8: str2 = QNameHelper.pretty(readQName()); return str2 + " (" + str1 + ": " + i + ")";case 9: case 10: break; }  String str2 = Double.toString(readDouble()); return str2 + " (" + str1 + ": " + i + ")";
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   double readDouble() {
/*      */     try {
/* 1229 */       return this._input.readDouble();
/*      */     }
/* 1231 */     catch (IOException iOException) {
/*      */       
/* 1233 */       error(iOException);
/* 1234 */       return 0.0D;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   String SOAPArrayTypeString(SOAPArrayType paramSOAPArrayType) {
/* 1240 */     if (paramSOAPArrayType == null)
/* 1241 */       return "null"; 
/* 1242 */     return QNameHelper.pretty(paramSOAPArrayType.getQName()) + paramSOAPArrayType.soap11DimensionString();
/*      */   }
/*      */ 
/*      */   
/*      */   SOAPArrayType readSOAPArrayType() {
/* 1247 */     b b = readQName();
/* 1248 */     String str = readString();
/* 1249 */     if (b == null)
/* 1250 */       return null; 
/* 1251 */     return new SOAPArrayType(b, str);
/*      */   }
/*      */ 
/*      */   
/*      */   QNameSet readQNameSet() {
/* 1256 */     int i = readShort();
/*      */     
/* 1258 */     HashSet hashSet = new HashSet();
/* 1259 */     int j = readShort();
/* 1260 */     for (byte b1 = 0; b1 < j; b1++) {
/* 1261 */       hashSet.add(readString());
/*      */     }
/* 1263 */     HashSet hashSet1 = new HashSet();
/* 1264 */     int k = readShort();
/* 1265 */     for (byte b2 = 0; b2 < k; b2++) {
/* 1266 */       hashSet1.add(readQName());
/*      */     }
/* 1268 */     HashSet hashSet2 = new HashSet();
/* 1269 */     int m = readShort();
/* 1270 */     for (byte b3 = 0; b3 < m; b3++) {
/* 1271 */       hashSet2.add(readQName());
/*      */     }
/* 1273 */     if (i == 1) {
/* 1274 */       return QNameSet.forSets(hashSet, null, hashSet1, hashSet2);
/*      */     }
/* 1276 */     return QNameSet.forSets(null, hashSet, hashSet2, hashSet1);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   byte[] readByteArray() {
/*      */     try {
/* 1283 */       short s = this._input.readShort();
/* 1284 */       byte[] arrayOfByte = new byte[s];
/* 1285 */       this._input.readFully(arrayOfByte);
/* 1286 */       return arrayOfByte;
/*      */     }
/* 1288 */     catch (IOException iOException) {
/*      */       
/* 1290 */       error(iOException);
/* 1291 */       return null;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   BigInteger readBigInteger() {
/* 1297 */     byte[] arrayOfByte = readByteArray();
/* 1298 */     if (arrayOfByte.length == 0)
/* 1299 */       return null; 
/* 1300 */     if (arrayOfByte.length == 1 && arrayOfByte[0] == 0)
/* 1301 */       return BigInteger.ZERO; 
/* 1302 */     if (arrayOfByte.length == 1 && arrayOfByte[0] == 1)
/* 1303 */       return BigInteger.ONE; 
/* 1304 */     return new BigInteger(arrayOfByte);
/*      */   }
/*      */   
/* 1307 */   static final byte[] SINGLE_ZERO_BYTE = new byte[] { 0 };
/*      */   
/*      */   private int _majorver;
/*      */   
/*      */   private int _minorver;
/*      */   private int _releaseno;
/*      */   static final boolean $assertionsDisabled;
/*      */   
/*      */   protected boolean atLeast(int paramInt1, int paramInt2, int paramInt3) {
/* 1316 */     if (this._majorver > paramInt1)
/* 1317 */       return true; 
/* 1318 */     if (this._majorver < paramInt1)
/* 1319 */       return false; 
/* 1320 */     if (this._minorver > paramInt2)
/* 1321 */       return true; 
/* 1322 */     if (this._minorver < paramInt2)
/* 1323 */       return false; 
/* 1324 */     return (this._releaseno >= paramInt3);
/*      */   }
/*      */ 
/*      */   
/*      */   protected boolean atMost(int paramInt1, int paramInt2, int paramInt3) {
/* 1329 */     if (this._majorver > paramInt1)
/* 1330 */       return false; 
/* 1331 */     if (this._majorver < paramInt1)
/* 1332 */       return true; 
/* 1333 */     if (this._minorver > paramInt2)
/* 1334 */       return false; 
/* 1335 */     if (this._minorver < paramInt2)
/* 1336 */       return true; 
/* 1337 */     return (this._releaseno <= paramInt3);
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\tool\XsbDumper.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */