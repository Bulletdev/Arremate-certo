/*     */ package org.apache.xmlbeans.impl.tool;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileFilter;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
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
/*     */ public class SchemaResourceManager
/*     */   extends BaseSchemaResourceManager
/*     */ {
/*     */   private File _directory;
/*     */   
/*     */   public static void printUsage() {
/*  37 */     System.out.println("Maintains \"xsdownload.xml\", an index of locally downloaded .xsd files");
/*  38 */     System.out.println("usage: sdownload [-dir directory] [-refresh] [-recurse] [-sync] [url/file...]");
/*  39 */     System.out.println("");
/*  40 */     System.out.println("URLs that are specified are downloaded if they aren't already cached.");
/*  41 */     System.out.println("In addition:");
/*  42 */     System.out.println("  -dir specifies the directory for the xsdownload.xml file (default .).");
/*  43 */     System.out.println("  -sync synchronizes the index to any local .xsd files in the tree.");
/*  44 */     System.out.println("  -recurse recursively downloads imported and included .xsd files.");
/*  45 */     System.out.println("  -refresh redownloads all indexed .xsd files.");
/*  46 */     System.out.println("If no files or URLs are specified, all indexed files are relevant.");
/*     */   }
/*     */   
/*     */   public static void main(String[] paramArrayOfString) throws IOException {
/*     */     SchemaResourceManager schemaResourceManager;
/*  51 */     if (paramArrayOfString.length == 0) {
/*     */       
/*  53 */       printUsage();
/*  54 */       System.exit(0);
/*     */       
/*     */       return;
/*     */     } 
/*  58 */     HashSet hashSet1 = new HashSet();
/*  59 */     hashSet1.add("h");
/*  60 */     hashSet1.add("help");
/*  61 */     hashSet1.add("usage");
/*  62 */     hashSet1.add("license");
/*  63 */     hashSet1.add("version");
/*  64 */     hashSet1.add("sync");
/*  65 */     hashSet1.add("refresh");
/*  66 */     hashSet1.add("recurse");
/*     */     
/*  68 */     HashSet hashSet2 = new HashSet();
/*  69 */     hashSet2.add("dir");
/*  70 */     CommandLine commandLine = new CommandLine(paramArrayOfString, hashSet1, hashSet2);
/*  71 */     if (commandLine.getOpt("h") != null || commandLine.getOpt("help") != null || commandLine.getOpt("usage") != null) {
/*     */       
/*  73 */       printUsage();
/*  74 */       System.exit(0);
/*     */       
/*     */       return;
/*     */     } 
/*  78 */     String[] arrayOfString1 = commandLine.getBadOpts();
/*  79 */     if (arrayOfString1.length > 0) {
/*     */       
/*  81 */       for (byte b1 = 0; b1 < arrayOfString1.length; b1++)
/*  82 */         System.out.println("Unrecognized option: " + arrayOfString1[b1]); 
/*  83 */       printUsage();
/*  84 */       System.exit(0);
/*     */       
/*     */       return;
/*     */     } 
/*  88 */     if (commandLine.getOpt("license") != null) {
/*     */       
/*  90 */       CommandLine.printLicense();
/*  91 */       System.exit(0);
/*     */       
/*     */       return;
/*     */     } 
/*  95 */     if (commandLine.getOpt("version") != null) {
/*     */       
/*  97 */       CommandLine.printVersion();
/*  98 */       System.exit(0);
/*     */       
/*     */       return;
/*     */     } 
/* 102 */     paramArrayOfString = commandLine.args();
/*     */     
/* 104 */     boolean bool1 = (commandLine.getOpt("sync") != null) ? true : false;
/* 105 */     boolean bool2 = (commandLine.getOpt("refresh") != null) ? true : false;
/* 106 */     boolean bool3 = (commandLine.getOpt("recurse") != null) ? true : false;
/* 107 */     String str = commandLine.getOpt("dir");
/* 108 */     if (str == null)
/* 109 */       str = "."; 
/* 110 */     File file = new File(str);
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 115 */       schemaResourceManager = new SchemaResourceManager(file);
/*     */     }
/* 117 */     catch (IllegalStateException illegalStateException) {
/*     */       
/* 119 */       if (illegalStateException.getMessage() != null) {
/* 120 */         System.out.println(illegalStateException.getMessage());
/*     */       } else {
/* 122 */         illegalStateException.printStackTrace();
/* 123 */       }  System.exit(1);
/*     */       
/*     */       return;
/*     */     } 
/* 127 */     ArrayList arrayList = new ArrayList();
/* 128 */     ArrayList arrayList1 = new ArrayList();
/* 129 */     for (byte b = 0; b < paramArrayOfString.length; b++) {
/*     */       
/* 131 */       if (looksLikeURL(paramArrayOfString[b])) {
/*     */         
/* 133 */         arrayList.add(paramArrayOfString[b]);
/*     */       }
/*     */       else {
/*     */         
/* 137 */         arrayList1.add(new File(file, paramArrayOfString[b]));
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 142 */     for (Iterator iterator = arrayList1.iterator(); iterator.hasNext(); ) {
/*     */       
/* 144 */       File file1 = iterator.next();
/* 145 */       if (!isInDirectory(file1, file)) {
/*     */         
/* 147 */         System.err.println("File not within directory: " + file1);
/* 148 */         iterator.remove();
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 153 */     List list = collectXSDFiles(arrayList1.<File>toArray(new File[0]));
/*     */     
/* 155 */     String[] arrayOfString2 = arrayList.<String>toArray(new String[0]);
/* 156 */     File[] arrayOfFile = (File[])list.toArray((Object[])new File[0]);
/* 157 */     String[] arrayOfString3 = relativeFilenames(arrayOfFile, file);
/*     */     
/* 159 */     if (arrayOfString2.length + arrayOfString3.length > 0) {
/*     */       
/* 161 */       schemaResourceManager.process(arrayOfString2, arrayOfString3, bool1, bool2, bool3);
/*     */     }
/*     */     else {
/*     */       
/* 165 */       schemaResourceManager.processAll(bool1, bool2, bool3);
/*     */     } 
/*     */     
/* 168 */     schemaResourceManager.writeCache();
/* 169 */     System.exit(0);
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean looksLikeURL(String paramString) {
/* 174 */     return (paramString.startsWith("http:") || paramString.startsWith("https:") || paramString.startsWith("ftp:") || paramString.startsWith("file:"));
/*     */   }
/*     */ 
/*     */   
/*     */   private static String relativeFilename(File paramFile1, File paramFile2) {
/* 179 */     if (paramFile1 == null || paramFile1.equals(paramFile2))
/* 180 */       return "."; 
/* 181 */     return relativeFilename(paramFile1.getParentFile(), paramFile2) + "/" + paramFile1.getName();
/*     */   }
/*     */ 
/*     */   
/*     */   private static String[] relativeFilenames(File[] paramArrayOfFile, File paramFile) {
/* 186 */     String[] arrayOfString = new String[paramArrayOfFile.length];
/* 187 */     for (byte b = 0; b < paramArrayOfFile.length; b++)
/*     */     {
/* 189 */       arrayOfString[b] = relativeFilename(paramArrayOfFile[b], paramFile);
/*     */     }
/* 191 */     return arrayOfString;
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean isInDirectory(File paramFile1, File paramFile2) {
/* 196 */     if (paramFile1 == null)
/* 197 */       return false; 
/* 198 */     if (paramFile1.equals(paramFile2))
/* 199 */       return true; 
/* 200 */     return isInDirectory(paramFile1.getParentFile(), paramFile2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SchemaResourceManager(File paramFile) {
/* 209 */     this._directory = paramFile;
/* 210 */     init();
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
/*     */   protected void warning(String paramString) {
/* 223 */     System.out.println(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean fileExists(String paramString) {
/* 233 */     return (new File(this._directory, paramString)).exists();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected InputStream inputStreamForFile(String paramString) throws IOException {
/* 241 */     return new FileInputStream(new File(this._directory, paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void writeInputStreamToFile(InputStream paramInputStream, String paramString) throws IOException {
/* 250 */     File file1 = new File(this._directory, paramString);
/*     */     
/* 252 */     File file2 = file1.getParentFile();
/* 253 */     if (!file2.exists())
/* 254 */       file2.mkdirs(); 
/* 255 */     FileOutputStream fileOutputStream = new FileOutputStream(file1);
/* 256 */     IOUtil.copyCompletely(paramInputStream, fileOutputStream);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void deleteFile(String paramString) {
/* 267 */     (new File(this._directory, paramString)).delete();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String[] getAllXSDFilenames() {
/* 275 */     File[] arrayOfFile = (File[])collectXSDFiles(new File[] { this._directory }).toArray((Object[])new File[0]);
/* 276 */     return relativeFilenames(arrayOfFile, this._directory);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static List collectXSDFiles(File[] paramArrayOfFile) {
/* 284 */     ArrayList arrayList = new ArrayList();
/* 285 */     for (byte b = 0; b < paramArrayOfFile.length; b++) {
/*     */       
/* 287 */       File file = paramArrayOfFile[b];
/* 288 */       if (!file.isDirectory()) {
/*     */         
/* 290 */         arrayList.add(file);
/*     */       }
/*     */       else {
/*     */         
/* 294 */         arrayList.addAll(collectXSDFiles(file.listFiles(new FileFilter()
/*     */                 {
/*     */                   public boolean accept(File param1File)
/*     */                   {
/* 298 */                     return (param1File.isDirectory() || (param1File.isFile() && param1File.getName().endsWith(".xsd")));
/*     */                   }
/*     */                 })));
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 305 */     return arrayList;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\tool\SchemaResourceManager.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */