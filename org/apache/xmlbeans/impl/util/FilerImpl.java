/*     */ package org.apache.xmlbeans.impl.util;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.FileReader;
/*     */ import java.io.FileWriter;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.io.OutputStreamWriter;
/*     */ import java.io.StringReader;
/*     */ import java.io.StringWriter;
/*     */ import java.io.Writer;
/*     */ import java.nio.charset.Charset;
/*     */ import java.nio.charset.CharsetEncoder;
/*     */ import java.nio.charset.CodingErrorAction;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import org.apache.xmlbeans.Filer;
/*     */ import repackage.a;
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
/*     */ public class FilerImpl
/*     */   implements Filer
/*     */ {
/*     */   private File classdir;
/*     */   private File srcdir;
/*     */   private a repackager;
/*     */   private boolean verbose;
/*     */   private List sourceFiles;
/*     */   private boolean incrSrcGen;
/*     */   private Set seenTypes;
/*     */   private static final Charset CHARSET;
/*     */   
/*     */   static {
/*  56 */     Charset charset = null;
/*     */     
/*     */     try {
/*  59 */       charset = Charset.forName(System.getProperty("file.encoding"));
/*     */     }
/*  61 */     catch (Exception exception) {}
/*  62 */     CHARSET = charset;
/*     */   }
/*     */ 
/*     */   
/*     */   public FilerImpl(File paramFile1, File paramFile2, a parama, boolean paramBoolean1, boolean paramBoolean2) {
/*  67 */     this.classdir = paramFile1;
/*  68 */     this.srcdir = paramFile2;
/*  69 */     this.repackager = parama;
/*  70 */     this.verbose = paramBoolean1;
/*  71 */     this.sourceFiles = (this.sourceFiles != null) ? this.sourceFiles : new ArrayList();
/*  72 */     this.incrSrcGen = paramBoolean2;
/*  73 */     if (this.incrSrcGen) {
/*  74 */       this.seenTypes = new HashSet();
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
/*     */   public OutputStream createBinaryFile(String paramString) throws IOException {
/*  86 */     if (this.verbose) {
/*  87 */       System.err.println("created binary: " + paramString);
/*     */     }
/*     */     
/*  90 */     File file = new File(this.classdir, paramString);
/*  91 */     file.getParentFile().mkdirs();
/*     */     
/*  93 */     return new FileOutputStream(file);
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
/*     */   public Writer createSourceFile(String paramString) throws IOException {
/* 105 */     if (this.incrSrcGen) {
/* 106 */       this.seenTypes.add(paramString);
/*     */     }
/* 108 */     if (paramString.indexOf('$') > 0)
/*     */     {
/* 110 */       paramString = paramString.substring(0, paramString.lastIndexOf('.')) + "." + paramString.substring(paramString.indexOf('$') + 1);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 115 */     String str = paramString.replace('.', File.separatorChar) + ".java";
/*     */     
/* 117 */     File file = new File(this.srcdir, str);
/* 118 */     file.getParentFile().mkdirs();
/* 119 */     if (this.verbose) {
/* 120 */       System.err.println("created source: " + file.getAbsolutePath());
/*     */     }
/* 122 */     this.sourceFiles.add(file);
/*     */     
/* 124 */     if (this.incrSrcGen && file.exists())
/*     */     {
/*     */ 
/*     */       
/* 128 */       return new IncrFileWriter(file, this.repackager);
/*     */     }
/*     */ 
/*     */     
/* 132 */     return (this.repackager == null) ? writerForFile(file) : new RepackagingWriter(file, this.repackager);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List getSourceFiles() {
/* 140 */     return new ArrayList(this.sourceFiles);
/*     */   }
/*     */ 
/*     */   
/*     */   public a getRepackager() {
/* 145 */     return this.repackager;
/*     */   }
/*     */ 
/*     */   
/*     */   private static final Writer writerForFile(File paramFile) throws IOException {
/* 150 */     if (CHARSET == null) {
/* 151 */       return new FileWriter(paramFile);
/*     */     }
/* 153 */     FileOutputStream fileOutputStream = new FileOutputStream(paramFile);
/* 154 */     CharsetEncoder charsetEncoder = CHARSET.newEncoder();
/* 155 */     charsetEncoder.onUnmappableCharacter(CodingErrorAction.REPORT);
/* 156 */     return new OutputStreamWriter(fileOutputStream, charsetEncoder);
/*     */   }
/*     */   
/*     */   static class IncrFileWriter
/*     */     extends StringWriter
/*     */   {
/*     */     private File _file;
/*     */     private a _repackager;
/*     */     
/*     */     public IncrFileWriter(File param1File, a param1a) {
/* 166 */       this._file = param1File;
/* 167 */       this._repackager = param1a;
/*     */     }
/*     */ 
/*     */     
/*     */     public void close() throws IOException {
/* 172 */       super.close();
/*     */ 
/*     */       
/* 175 */       StringBuffer stringBuffer = (this._repackager != null) ? this._repackager.a(getBuffer()) : getBuffer();
/*     */ 
/*     */       
/* 178 */       String str = stringBuffer.toString();
/* 179 */       ArrayList arrayList = new ArrayList();
/* 180 */       StringReader stringReader = new StringReader(str);
/* 181 */       FileReader fileReader = new FileReader(this._file);
/*     */ 
/*     */       
/*     */       try {
/* 185 */         Diff.readersAsText(stringReader, "<generated>", fileReader, this._file.getName(), arrayList);
/*     */       
/*     */       }
/*     */       finally {
/*     */         
/* 190 */         stringReader.close();
/* 191 */         fileReader.close();
/*     */       } 
/*     */       
/* 194 */       if (arrayList.size() > 0) {
/*     */ 
/*     */ 
/*     */         
/* 198 */         Writer writer = FilerImpl.writerForFile(this._file);
/*     */         try {
/* 200 */           writer.write(str);
/*     */         } finally {
/* 202 */           writer.close();
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   static class RepackagingWriter extends StringWriter {
/*     */     private File _file;
/*     */     private a _repackager;
/*     */     
/*     */     public RepackagingWriter(File param1File, a param1a) {
/* 213 */       this._file = param1File;
/* 214 */       this._repackager = param1a;
/*     */     }
/*     */ 
/*     */     
/*     */     public void close() throws IOException {
/* 219 */       super.close();
/*     */       
/* 221 */       Writer writer = FilerImpl.writerForFile(this._file);
/*     */       try {
/* 223 */         writer.write(this._repackager.a(getBuffer()).toString());
/*     */       } finally {
/* 225 */         writer.close();
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\imp\\util\FilerImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */