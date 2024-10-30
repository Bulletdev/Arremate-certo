/*     */ package org.h2.store.fs;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.io.SequenceInputStream;
/*     */ import java.nio.channels.FileChannel;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.h2.engine.SysProperties;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.util.New;
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
/*     */ public class FilePathSplit
/*     */   extends FilePathWrapper
/*     */ {
/*     */   private static final String PART_SUFFIX = ".part";
/*     */   
/*     */   protected String getPrefix() {
/*  32 */     return getScheme() + ":" + parse(this.name)[0] + ":";
/*     */   }
/*     */ 
/*     */   
/*     */   public FilePath unwrap(String paramString) {
/*  37 */     return FilePath.get(parse(paramString)[1]);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean setReadOnly() {
/*  42 */     boolean bool = false;
/*  43 */     byte b = 0; while (true) {
/*  44 */       FilePath filePath = getBase(b);
/*  45 */       if (filePath.exists()) {
/*  46 */         bool = filePath.setReadOnly();
/*     */         b++;
/*     */       } 
/*     */       break;
/*     */     } 
/*  51 */     return bool;
/*     */   }
/*     */ 
/*     */   
/*     */   public void delete() {
/*  56 */     byte b = 0; while (true) {
/*  57 */       FilePath filePath = getBase(b);
/*  58 */       if (filePath.exists()) {
/*  59 */         filePath.delete();
/*     */         b++;
/*     */       } 
/*     */       break;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public long lastModified() {
/*  68 */     long l = 0L;
/*  69 */     byte b = 0; while (true) {
/*  70 */       FilePath filePath = getBase(b);
/*  71 */       if (filePath.exists()) {
/*  72 */         long l1 = filePath.lastModified();
/*  73 */         l = Math.max(l, l1);
/*     */         b++;
/*     */       } 
/*     */       break;
/*     */     } 
/*  78 */     return l;
/*     */   }
/*     */ 
/*     */   
/*     */   public long size() {
/*  83 */     long l = 0L;
/*  84 */     byte b = 0; while (true) {
/*  85 */       FilePath filePath = getBase(b);
/*  86 */       if (filePath.exists()) {
/*  87 */         l += filePath.size();
/*     */         b++;
/*     */       } 
/*     */       break;
/*     */     } 
/*  92 */     return l;
/*     */   }
/*     */ 
/*     */   
/*     */   public ArrayList<FilePath> newDirectoryStream() {
/*  97 */     List<FilePath> list = getBase().newDirectoryStream();
/*  98 */     ArrayList<FilePathWrapper> arrayList = New.arrayList(); byte b; int i;
/*  99 */     for (b = 0, i = list.size(); b < i; b++) {
/* 100 */       FilePath filePath = list.get(b);
/* 101 */       if (!filePath.getName().endsWith(".part")) {
/* 102 */         arrayList.add(wrap(filePath));
/*     */       }
/*     */     } 
/* 105 */     return (ArrayList)arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public InputStream newInputStream() throws IOException {
/* 110 */     InputStream inputStream = getBase().newInputStream();
/* 111 */     byte b = 1; while (true) {
/* 112 */       FilePath filePath = getBase(b);
/* 113 */       if (filePath.exists()) {
/* 114 */         InputStream inputStream1 = filePath.newInputStream();
/* 115 */         inputStream = new SequenceInputStream(inputStream, inputStream1);
/*     */         b++;
/*     */       } 
/*     */       break;
/*     */     } 
/* 120 */     return inputStream;
/*     */   }
/*     */ 
/*     */   
/*     */   public FileChannel open(String paramString) throws IOException {
/* 125 */     ArrayList<FileChannel> arrayList = New.arrayList();
/* 126 */     arrayList.add(getBase().open(paramString));
/* 127 */     byte b = 1; while (true) {
/* 128 */       FilePath filePath = getBase(b);
/* 129 */       if (filePath.exists()) {
/* 130 */         arrayList.add(filePath.open(paramString));
/*     */         b++;
/*     */       } 
/*     */       break;
/*     */     } 
/* 135 */     FileChannel[] arrayOfFileChannel = new FileChannel[arrayList.size()];
/* 136 */     arrayList.toArray(arrayOfFileChannel);
/* 137 */     long l1 = arrayOfFileChannel[0].size();
/* 138 */     long l2 = l1;
/* 139 */     if (arrayOfFileChannel.length == 1) {
/* 140 */       long l = getDefaultMaxLength();
/* 141 */       if (l1 < l) {
/* 142 */         l1 = l;
/*     */       }
/*     */     } else {
/* 145 */       if (l1 == 0L) {
/* 146 */         closeAndThrow(0, arrayOfFileChannel, arrayOfFileChannel[0], l1);
/*     */       }
/* 148 */       for (byte b1 = 1; b1 < arrayOfFileChannel.length - 1; b1++) {
/* 149 */         FileChannel fileChannel1 = arrayOfFileChannel[b1];
/* 150 */         long l3 = fileChannel1.size();
/* 151 */         l2 += l3;
/* 152 */         if (l3 != l1) {
/* 153 */           closeAndThrow(b1, arrayOfFileChannel, fileChannel1, l1);
/*     */         }
/*     */       } 
/* 156 */       FileChannel fileChannel = arrayOfFileChannel[arrayOfFileChannel.length - 1];
/* 157 */       long l = fileChannel.size();
/* 158 */       l2 += l;
/* 159 */       if (l > l1) {
/* 160 */         closeAndThrow(arrayOfFileChannel.length - 1, arrayOfFileChannel, fileChannel, l1);
/*     */       }
/*     */     } 
/* 163 */     return new FileSplit(this, paramString, arrayOfFileChannel, l2, l1);
/*     */   }
/*     */   
/*     */   private long getDefaultMaxLength() {
/* 167 */     return 1L << Integer.decode(parse(this.name)[0]).intValue();
/*     */   }
/*     */ 
/*     */   
/*     */   private void closeAndThrow(int paramInt, FileChannel[] paramArrayOfFileChannel, FileChannel paramFileChannel, long paramLong) throws IOException {
/* 172 */     String str = "Expected file length: " + paramLong + " got: " + paramFileChannel.size() + " for " + getName(paramInt);
/*     */     
/* 174 */     for (FileChannel fileChannel : paramArrayOfFileChannel) {
/* 175 */       fileChannel.close();
/*     */     }
/* 177 */     throw new IOException(str);
/*     */   }
/*     */ 
/*     */   
/*     */   public OutputStream newOutputStream(boolean paramBoolean) throws IOException {
/* 182 */     return new FileChannelOutputStream(open("rw"), paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public void moveTo(FilePath paramFilePath, boolean paramBoolean) {
/* 187 */     FilePathSplit filePathSplit = (FilePathSplit)paramFilePath;
/* 188 */     byte b = 0; while (true) {
/* 189 */       FilePath filePath = getBase(b);
/* 190 */       if (filePath.exists()) {
/* 191 */         filePath.moveTo(filePathSplit.getBase(b), paramBoolean);
/*     */         b++;
/*     */       } 
/*     */       break;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String[] parse(String paramString) {
/*     */     String str;
/* 205 */     if (!paramString.startsWith(getScheme())) {
/* 206 */       DbException.throwInternalError(paramString + " doesn't start with " + getScheme());
/*     */     }
/* 208 */     paramString = paramString.substring(getScheme().length() + 1);
/*     */     
/* 210 */     if (paramString.length() > 0 && Character.isDigit(paramString.charAt(0))) {
/* 211 */       int i = paramString.indexOf(':');
/* 212 */       str = paramString.substring(0, i);
/*     */       try {
/* 214 */         paramString = paramString.substring(i + 1);
/* 215 */       } catch (NumberFormatException numberFormatException) {}
/*     */     }
/*     */     else {
/*     */       
/* 219 */       str = Long.toString(SysProperties.SPLIT_FILE_SIZE_SHIFT);
/*     */     } 
/* 221 */     return new String[] { str, paramString };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   FilePath getBase(int paramInt) {
/* 231 */     return FilePath.get(getName(paramInt));
/*     */   }
/*     */   
/*     */   private String getName(int paramInt) {
/* 235 */     return (paramInt > 0) ? ((getBase()).name + "." + paramInt + ".part") : (getBase()).name;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getScheme() {
/* 240 */     return "split";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\store\fs\FilePathSplit.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */