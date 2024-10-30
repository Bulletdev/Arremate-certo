/*     */ package org.apache.poi.openxml4j.util;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Enumeration;
/*     */ import java.util.Iterator;
/*     */ import java.util.zip.ZipEntry;
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
/*     */ public class ZipInputStreamZipEntrySource
/*     */   implements ZipEntrySource
/*     */ {
/*  48 */   private ArrayList<FakeZipEntry> zipEntries = new ArrayList<FakeZipEntry>();
/*     */   public ZipInputStreamZipEntrySource(ZipSecureFile.ThresholdInputStream paramThresholdInputStream) throws IOException {
/*  50 */     boolean bool = true;
/*  51 */     while (bool) {
/*  52 */       ZipEntry zipEntry = paramThresholdInputStream.getNextEntry();
/*  53 */       if (zipEntry == null) {
/*  54 */         bool = false; continue;
/*     */       } 
/*  56 */       FakeZipEntry fakeZipEntry = new FakeZipEntry(zipEntry, paramThresholdInputStream);
/*  57 */       paramThresholdInputStream.closeEntry();
/*     */       
/*  59 */       this.zipEntries.add(fakeZipEntry);
/*     */     } 
/*     */     
/*  62 */     paramThresholdInputStream.close();
/*     */   }
/*     */   
/*     */   public Enumeration<? extends ZipEntry> getEntries() {
/*  66 */     return new EntryEnumerator();
/*     */   }
/*     */   
/*     */   public InputStream getInputStream(ZipEntry paramZipEntry) {
/*  70 */     assert paramZipEntry instanceof FakeZipEntry;
/*  71 */     FakeZipEntry fakeZipEntry = (FakeZipEntry)paramZipEntry;
/*  72 */     return fakeZipEntry.getInputStream();
/*     */   }
/*     */ 
/*     */   
/*     */   public void close() {
/*  77 */     this.zipEntries = null;
/*     */   }
/*     */   public boolean isClosed() {
/*  80 */     return (this.zipEntries == null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private class EntryEnumerator
/*     */     implements Enumeration<ZipEntry>
/*     */   {
/*  91 */     private Iterator<? extends ZipEntry> iterator = ZipInputStreamZipEntrySource.this.zipEntries.iterator();
/*     */ 
/*     */     
/*     */     public boolean hasMoreElements() {
/*  95 */       return this.iterator.hasNext();
/*     */     }
/*     */     
/*     */     public ZipEntry nextElement() {
/*  99 */       return this.iterator.next();
/*     */     }
/*     */ 
/*     */     
/*     */     private EntryEnumerator() {}
/*     */   }
/*     */ 
/*     */   
/*     */   public static class FakeZipEntry
/*     */     extends ZipEntry
/*     */   {
/*     */     private byte[] data;
/*     */     
/*     */     public FakeZipEntry(ZipEntry param1ZipEntry, InputStream param1InputStream) throws IOException {
/* 113 */       super(param1ZipEntry.getName());
/*     */ 
/*     */       
/*     */       ByteArrayOutputStream byteArrayOutputStream;
/*     */       
/* 118 */       long l = param1ZipEntry.getSize();
/*     */       
/* 120 */       if (l != -1L) {
/* 121 */         if (l >= 2147483647L) {
/* 122 */           throw new IOException("ZIP entry size is too large");
/*     */         }
/*     */         
/* 125 */         byteArrayOutputStream = new ByteArrayOutputStream((int)l);
/*     */       } else {
/* 127 */         byteArrayOutputStream = new ByteArrayOutputStream();
/*     */       } 
/*     */       
/* 130 */       byte[] arrayOfByte = new byte[4096];
/* 131 */       int i = 0;
/* 132 */       while ((i = param1InputStream.read(arrayOfByte)) != -1) {
/* 133 */         byteArrayOutputStream.write(arrayOfByte, 0, i);
/*     */       }
/*     */       
/* 136 */       this.data = byteArrayOutputStream.toByteArray();
/*     */     }
/*     */     
/*     */     public InputStream getInputStream() {
/* 140 */       return new ByteArrayInputStream(this.data);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\openxml4\\util\ZipInputStreamZipEntrySource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */