/*     */ package org.apache.commons.net.ftp;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.ListIterator;
/*     */ import org.apache.commons.net.util.Charsets;
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
/*     */ public class FTPListParseEngine
/*     */ {
/*  78 */   private List<String> entries = new LinkedList<>();
/*  79 */   private ListIterator<String> internalIterator = this.entries.listIterator();
/*     */ 
/*     */   
/*     */   private final FTPFileEntryParser parser;
/*     */ 
/*     */   
/*     */   private final boolean saveUnparseableEntries;
/*     */ 
/*     */   
/*  88 */   private static final FTPFile[] EMPTY_FTP_FILE_ARRAY = new FTPFile[0];
/*     */   
/*     */   public FTPListParseEngine(FTPFileEntryParser paramFTPFileEntryParser) {
/*  91 */     this(paramFTPFileEntryParser, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   FTPListParseEngine(FTPFileEntryParser paramFTPFileEntryParser, FTPClientConfig paramFTPClientConfig) {
/*  99 */     this.parser = paramFTPFileEntryParser;
/* 100 */     if (paramFTPClientConfig != null) {
/* 101 */       this.saveUnparseableEntries = paramFTPClientConfig.getUnparseableEntries();
/*     */     } else {
/* 103 */       this.saveUnparseableEntries = false;
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
/*     */   public void readServerList(InputStream paramInputStream, String paramString) throws IOException {
/* 118 */     this.entries = new LinkedList<>();
/* 119 */     read(paramInputStream, paramString);
/* 120 */     this.parser.preParse(this.entries);
/* 121 */     resetIterator();
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
/*     */   private void read(InputStream paramInputStream, String paramString) throws IOException {
/* 136 */     try (BufferedReader null = new BufferedReader(new InputStreamReader(paramInputStream, 
/* 137 */             Charsets.toCharset(paramString)))) {
/*     */       
/* 139 */       String str = this.parser.readNextEntry(bufferedReader);
/*     */       
/* 141 */       while (str != null) {
/* 142 */         this.entries.add(str);
/* 143 */         str = this.parser.readNextEntry(bufferedReader);
/*     */       } 
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
/*     */   public FTPFile[] getNext(int paramInt) {
/* 172 */     LinkedList<FTPFile> linkedList = new LinkedList();
/* 173 */     int i = paramInt;
/* 174 */     while (i > 0 && this.internalIterator.hasNext()) {
/* 175 */       String str = this.internalIterator.next();
/* 176 */       FTPFile fTPFile = this.parser.parseFTPEntry(str);
/* 177 */       if (fTPFile == null && this.saveUnparseableEntries) {
/* 178 */         fTPFile = new FTPFile(str);
/*     */       }
/* 180 */       linkedList.add(fTPFile);
/* 181 */       i--;
/*     */     } 
/* 183 */     return linkedList.<FTPFile>toArray(EMPTY_FTP_FILE_ARRAY);
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
/*     */   public FTPFile[] getPrevious(int paramInt) {
/* 214 */     LinkedList<FTPFile> linkedList = new LinkedList();
/* 215 */     int i = paramInt;
/* 216 */     while (i > 0 && this.internalIterator.hasPrevious()) {
/* 217 */       String str = this.internalIterator.previous();
/* 218 */       FTPFile fTPFile = this.parser.parseFTPEntry(str);
/* 219 */       if (fTPFile == null && this.saveUnparseableEntries) {
/* 220 */         fTPFile = new FTPFile(str);
/*     */       }
/* 222 */       linkedList.add(0, fTPFile);
/* 223 */       i--;
/*     */     } 
/* 225 */     return linkedList.<FTPFile>toArray(EMPTY_FTP_FILE_ARRAY);
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
/*     */   public FTPFile[] getFiles() throws IOException {
/* 240 */     return getFiles(FTPFileFilters.NON_NULL);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FTPFile[] getFiles(FTPFileFilter paramFTPFileFilter) throws IOException {
/* 264 */     ArrayList<FTPFile> arrayList = new ArrayList();
/* 265 */     Iterator<String> iterator = this.entries.iterator();
/* 266 */     while (iterator.hasNext()) {
/* 267 */       String str = iterator.next();
/* 268 */       FTPFile fTPFile = this.parser.parseFTPEntry(str);
/* 269 */       if (fTPFile == null && this.saveUnparseableEntries) {
/* 270 */         fTPFile = new FTPFile(str);
/*     */       }
/* 272 */       if (paramFTPFileFilter.accept(fTPFile)) {
/* 273 */         arrayList.add(fTPFile);
/*     */       }
/*     */     } 
/* 276 */     return arrayList.<FTPFile>toArray(EMPTY_FTP_FILE_ARRAY);
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
/*     */   public boolean hasNext() {
/* 288 */     return this.internalIterator.hasNext();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasPrevious() {
/* 299 */     return this.internalIterator.hasPrevious();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void resetIterator() {
/* 306 */     this.internalIterator = this.entries.listIterator();
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
/*     */   @Deprecated
/*     */   public void readServerList(InputStream paramInputStream) throws IOException {
/* 319 */     readServerList(paramInputStream, null);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\ftp\FTPListParseEngine.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */