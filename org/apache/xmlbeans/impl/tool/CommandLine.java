/*     */ package org.apache.xmlbeans.impl.tool;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URI;
/*     */ import java.net.URL;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.xmlbeans.XmlBeans;
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
/*     */ public class CommandLine
/*     */ {
/*     */   private Map _options;
/*     */   private String[] _badopts;
/*     */   private String[] _args;
/*     */   private List _files;
/*     */   private List _urls;
/*     */   private File _baseDir;
/*     */   
/*     */   public CommandLine(String[] paramArrayOfString, Collection paramCollection1, Collection paramCollection2) {
/*  37 */     if (paramCollection1 == null || paramCollection2 == null) {
/*  38 */       throw new IllegalArgumentException("collection required (use Collections.EMPTY_SET if no options)");
/*     */     }
/*  40 */     this._options = new LinkedHashMap();
/*  41 */     ArrayList arrayList1 = new ArrayList();
/*  42 */     ArrayList arrayList2 = new ArrayList();
/*     */     
/*  44 */     for (byte b = 0; b < paramArrayOfString.length; b++) {
/*     */       
/*  46 */       if (paramArrayOfString[b].indexOf('-') == 0) {
/*     */         
/*  48 */         String str1 = paramArrayOfString[b].substring(1);
/*  49 */         String str2 = null;
/*     */         
/*  51 */         if (paramCollection1.contains(str1)) {
/*  52 */           str2 = "";
/*  53 */         } else if (paramCollection2.contains(str1)) {
/*     */           
/*  55 */           if (b + 1 < paramArrayOfString.length) {
/*  56 */             str2 = paramArrayOfString[++b];
/*     */           } else {
/*  58 */             str2 = "";
/*     */           } 
/*     */         } else {
/*  61 */           arrayList1.add(paramArrayOfString[b]);
/*     */         } 
/*  63 */         this._options.put(str1, str2);
/*     */       }
/*     */       else {
/*     */         
/*  67 */         arrayList2.add(paramArrayOfString[b]);
/*     */       } 
/*     */     } 
/*     */     
/*  71 */     this._badopts = arrayList1.<String>toArray(new String[arrayList1.size()]);
/*  72 */     this._args = arrayList2.<String>toArray(new String[arrayList2.size()]);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void printLicense() {
/*     */     try {
/*  79 */       IOUtil.copyCompletely(CommandLine.class.getClassLoader().getResourceAsStream("LICENSE.txt"), System.out);
/*     */     }
/*  81 */     catch (Exception exception) {
/*     */       
/*  83 */       System.out.println("License available in this JAR in LICENSE.txt");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void printVersion() {
/*  89 */     System.out.println(XmlBeans.getVendor() + ", " + XmlBeans.getTitle() + ".XmlBeans version " + XmlBeans.getVersion());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String[] args() {
/*  98 */     String[] arrayOfString = new String[this._args.length];
/*  99 */     System.arraycopy(this._args, 0, arrayOfString, 0, this._args.length);
/* 100 */     return arrayOfString;
/*     */   }
/*     */ 
/*     */   
/*     */   public String[] getBadOpts() {
/* 105 */     return this._badopts;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getOpt(String paramString) {
/* 110 */     return (String)this._options.get(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   private static List collectFiles(File[] paramArrayOfFile) {
/* 115 */     ArrayList arrayList = new ArrayList();
/* 116 */     for (byte b = 0; b < paramArrayOfFile.length; b++) {
/*     */       
/* 118 */       File file = paramArrayOfFile[b];
/* 119 */       if (!file.isDirectory()) {
/*     */         
/* 121 */         arrayList.add(file);
/*     */       }
/*     */       else {
/*     */         
/* 125 */         arrayList.addAll(collectFiles(file.listFiles()));
/*     */       } 
/*     */     } 
/* 128 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 134 */   private static final File[] EMPTY_FILEARRAY = new File[0];
/* 135 */   private static final URL[] EMPTY_URLARRAY = new URL[0];
/*     */ 
/*     */   
/*     */   private List getFileList() {
/* 139 */     if (this._files == null) {
/*     */       
/* 141 */       String[] arrayOfString = args();
/* 142 */       File[] arrayOfFile = new File[arrayOfString.length];
/* 143 */       boolean bool = false;
/* 144 */       for (byte b = 0; b < arrayOfString.length; b++) {
/*     */         
/* 146 */         arrayOfFile[b] = new File(arrayOfString[b]);
/* 147 */         if (!bool && this._baseDir == null) {
/*     */           
/* 149 */           if (arrayOfFile[b].isDirectory()) {
/* 150 */             this._baseDir = arrayOfFile[b];
/*     */           } else {
/* 152 */             this._baseDir = arrayOfFile[b].getParentFile();
/*     */           } 
/*     */         } else {
/*     */           
/* 156 */           URI uRI = arrayOfFile[b].toURI();
/*     */ 
/*     */           
/* 159 */           if (this._baseDir != null && this._baseDir.toURI().relativize(uRI).equals(uRI)) {
/*     */             
/* 161 */             this._baseDir = null;
/* 162 */             bool = true;
/*     */           } 
/*     */         } 
/*     */       } 
/* 166 */       this._files = Collections.unmodifiableList(collectFiles(arrayOfFile));
/*     */     } 
/* 168 */     return this._files;
/*     */   }
/*     */ 
/*     */   
/*     */   private List getUrlList() {
/* 173 */     if (this._urls == null) {
/*     */       
/* 175 */       String[] arrayOfString = args();
/* 176 */       ArrayList arrayList = new ArrayList();
/*     */       
/* 178 */       for (byte b = 0; b < arrayOfString.length; b++) {
/*     */         
/* 180 */         if (looksLikeURL(arrayOfString[b])) {
/*     */           
/*     */           try {
/*     */             
/* 184 */             arrayList.add(new URL(arrayOfString[b]));
/*     */           }
/* 186 */           catch (MalformedURLException malformedURLException) {
/*     */             
/* 188 */             System.err.println("ignoring invalid url: " + arrayOfString[b] + ": " + malformedURLException.getMessage());
/*     */           } 
/*     */         }
/*     */       } 
/*     */       
/* 193 */       this._urls = Collections.unmodifiableList(arrayList);
/*     */     } 
/*     */     
/* 196 */     return this._urls;
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean looksLikeURL(String paramString) {
/* 201 */     return (paramString.startsWith("http:") || paramString.startsWith("https:") || paramString.startsWith("ftp:") || paramString.startsWith("file:"));
/*     */   }
/*     */ 
/*     */   
/*     */   public URL[] getURLs() {
/* 206 */     return (URL[])getUrlList().toArray((Object[])EMPTY_URLARRAY);
/*     */   }
/*     */ 
/*     */   
/*     */   public File[] getFiles() {
/* 211 */     return (File[])getFileList().toArray((Object[])EMPTY_FILEARRAY);
/*     */   }
/*     */ 
/*     */   
/*     */   public File getBaseDir() {
/* 216 */     return this._baseDir;
/*     */   }
/*     */ 
/*     */   
/*     */   public File[] filesEndingWith(String paramString) {
/* 221 */     ArrayList arrayList = new ArrayList();
/* 222 */     for (File file : getFileList()) {
/*     */ 
/*     */       
/* 225 */       if (file.getName().endsWith(paramString) && !looksLikeURL(file.getPath()))
/* 226 */         arrayList.add(file); 
/*     */     } 
/* 228 */     return arrayList.<File>toArray(EMPTY_FILEARRAY);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\tool\CommandLine.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */